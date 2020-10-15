package com.music.school.service.serviceImpl;

import com.music.school.domain.Student;
import com.music.school.dto.StudentDto;
import com.music.school.enums.StudentState;
import com.music.school.event.publisher.CustomEventPublisher;
import com.music.school.exception.StudentNotExistException;
import com.music.school.repository.StudentRepository;
import com.music.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService, ApplicationEventPublisherAware {

@Autowired
private StudentRepository studentRepository;

@Autowired
private ApplicationEventPublisher publisher;

@Autowired
private CustomEventPublisher customEventPublisher;

@Override
public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
	this.publisher = publisher;
}

@EventListener
@Override
public Optional<StudentDto> getById(String nationalCode) {
	Optional<Student> optionalStudent = studentRepository.findById(Long.valueOf(nationalCode));
	if (optionalStudent.isPresent()) {
		return StudentDto.studentToStudentDto(optionalStudent.get());
	} else {
		return Optional.empty();
	}
}

@Override
public List<Optional<StudentDto>> getAll() {
	return StudentDto.studentToStudentDto(studentRepository.findAll());
}

@Override
@Transactional
public Optional<StudentDto> save(Student student) {
	Student savedStudent = studentRepository.save(student);
	System.out.println("Publishing insert student event.");
	publisher.publishEvent(savedStudent);
	customEventPublisher.publish(".......save.......", savedStudent);
	return StudentDto.studentToStudentDto(savedStudent);
}

@Override
public void delete(Student student) {
	studentRepository.delete(student);
}

@Override
public Optional<Student> getStudentByNationalCode(Student student) {
	Optional<Student> studentByNationalCode =
			Optional.ofNullable(studentRepository.findStudentByNationalCode(student.getNationalCode()));
	return studentByNationalCode;
}

@Override
@Transactional
public Optional<Student> editStudentInformation(Student student) {
	Optional<Student> optionalStudentDto = getStudentByNationalCode(student);
	if (optionalStudentDto.isPresent()) {
		System.out.println("Publishing update student event.");
		publisher.publishEvent(student);
		customEventPublisher.publish(".......update.......", student);
		studentRepository.save(student);
		return optionalStudentDto;
	} else {
		throw new StudentNotExistException();
	}
	
}

@Override
public void paymentAndConfirmation(Student student) {
	/*TODO payment prossecing*/
	student.setPayment(true);
	student.setStudentStatus(StudentState.ACTIVE.getStatusCode());
	save(student);
}

@Override
public void instituteNoGenerator(Student student) {
	if (student.isPayment() && student.getStudentStatus().equals(StudentState.ACTIVE.getStatusCode())){
		student.setInstituteNo("13691019");
		save(student);
	}
}


}



