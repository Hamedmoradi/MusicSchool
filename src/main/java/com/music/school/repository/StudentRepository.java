package com.music.school.repository;

import com.music.school.domain.Student;
import com.music.school.dto.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findStudentByNationalCode(String nationalCode);
    
    
}
