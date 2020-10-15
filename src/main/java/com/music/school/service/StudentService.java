package com.music.school.service;

import com.music.school.domain.Student;
import com.music.school.dto.StudentDto;


import java.util.List;
import java.util.Optional;

public interface StudentService {

Optional<StudentDto> getById(String nationalCode);

List<Optional<StudentDto>> getAll();

Optional<Student> getStudentByNationalCode(Student student);

Optional<StudentDto> save(Student student);

void delete(Student student);

Optional<Student> editStudentInformation(Student student);

void paymentAndConfirmation(Student student);

void instituteNoGenerator(Student student);
}
