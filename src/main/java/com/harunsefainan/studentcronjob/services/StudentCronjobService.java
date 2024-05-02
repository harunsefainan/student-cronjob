package com.harunsefainan.studentcronjob.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harunsefainan.studentcronjob.entities.StudentCronjobEntity;
import com.harunsefainan.studentcronjob.repositories.IStudentCronjobRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@EnableScheduling
@RequiredArgsConstructor
public class StudentCronjobService {

    private final IStudentCronjobRepository iStudentCronjobRepository;
    private final LogService logService;
    private Logger logger;
    StudentCronjobEntity studentEntity = new StudentCronjobEntity();


    /*
     * Uygulamamız, servisten gelen başlangıç tarihi ve paket süresi bilgilerini kullanarak kalan süreyi hesaplar.
     * Bu hesaplama sonucunda günlük olarak bir kez veritabanını günceller ve kayıt eder.
     */
    @Scheduled(cron = "0 0 0 * * *")// günde 1 defa
    public void setRemainingDay() throws JsonProcessingException {
        String serverUrl = "http://localhost:8080/v1/api/students/getAll";
        String username = "user";
        String password = "user";

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);//kimlik doğrulama
        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(serverUrl, HttpMethod.GET, entity, String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            String response = responseEntity.getBody();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(response);//json formatındaki bir metni jsonNode formatına dönüştürmek için

            JsonNode data = root.get("data");//data kısmına ulaşmak için
            if (data != null && data.isArray()) {
                for (int i = 0; i < data.size(); i++) {
                    JsonNode item = data.get(i);
                    try {
                        String oid = item.get("oid").asText();
                        String optime = item.get("optime").asText();
                        int courseTime = item.get("courseTime").intValue();

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");//Optime'dan başlayarak bitiş tarihini hesaplama
                        LocalDateTime startingDate = LocalDateTime.parse(optime, formatter);
                        LocalDateTime endDate = startingDate.plusMonths(courseTime);//Paket süresini ay olarak ekleyerek bitiş tarihini hesaplama

                        LocalDateTime currentTime = LocalDateTime.now();//Şu anki tarihi alma ve kalan süreyi hesaplama
                        Duration remainingTime = Duration.between(currentTime, endDate);

                        String formattedRemainingTime = "";
                        if (remainingTime.toDays() > 0 || remainingTime.toHoursPart() > 0 || remainingTime.toMinutesPart() > 0) {
                            formattedRemainingTime = String.format("%dd%dh%dm", remainingTime.toDays(), remainingTime.toHoursPart(), remainingTime.toMinutesPart());// Kalan süreyi formatlı olarak yazdır
                        } else {
                            formattedRemainingTime = "0d0h0m";
                        }

                        studentEntity.setOid(oid);
                        studentEntity.setFirstName(item.get("firstName").asText());
                        studentEntity.setLastName(item.get("lastName").asText());
                        studentEntity.setTcNo(item.get("tcNo").asText());
                        studentEntity.setBirthDate(item.get("birthDate").asText());
                        studentEntity.setRegistrationDate(item.get("registrationDate").asText());
                        studentEntity.setRemainingDay(formattedRemainingTime);
                        studentEntity.setCourseTime(courseTime);
                        studentEntity.setOptime(optime);
                        iStudentCronjobRepository.save(studentEntity);
                        logService.generateLog(UUID.randomUUID().toString(), "setRemainingDay", true, studentEntity, "The remaining time has been successfully updated.");
                    } catch (Exception e) {
                        logService.generateLog(UUID.randomUUID().toString(), "setRemainingDay", true, studentEntity, e.toString());
                    }
                }
            } else {
                logger.info("No data string found in JSON response.");
            }
        } else {
            logger.info("API Response Error: " + responseEntity.getStatusCode());
        }
    }
}


