package com.harunsefainan.studentcronjob.repositories;

import com.harunsefainan.studentcronjob.entities.StudentCronjobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentCronjobRepository extends JpaRepository<StudentCronjobEntity, String> {
}
