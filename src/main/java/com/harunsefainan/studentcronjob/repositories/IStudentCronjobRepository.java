package com.harunsefainan.studentcronjob.repositories;

import com.harunsefainan.studentcronjob.entities.StudentCronjobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentCronjobRepository extends JpaRepository<StudentCronjobEntity, String> {
}
