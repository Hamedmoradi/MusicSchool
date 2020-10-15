package com.music.school.service.serviceImpl;

import com.music.school.domain.Student;
import com.music.school.dto.ClientDto;
import com.music.school.dto.StudentDto;
import com.music.school.exception.StudentRegisteredPreviouslyException;
import com.music.school.exception.NotificationTypeNotSelectedException;
import com.music.school.service.SingInStudentService;
import com.music.school.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SingInStudentServiceImpl implements SingInStudentService {


private static final Logger LOGGER = LoggerFactory.getLogger(SingInStudentService.class);

@Autowired
private StudentService studentService;

@Override
public ClientDto singInStudent(ClientDto clientDto) {
	if (checkSelectedItem(clientDto)) {
		throw new NotificationTypeNotSelectedException();
		//TODO log in database
	} else {
		validateNewStudent(clientDto);
//            createNotificationMessage(clientDto, student);
	}
	return clientDto;
}


public Student validateNewStudent(ClientDto clientDto) {
	Student student = new Student();
	try {
		LOGGER.debug("--------------------------student checked that duplicate national Code does not register again--------------------------");
		List<Optional<StudentDto>> allStudents = studentService.getAll();
		if (!isDuplicateStudent(clientDto, allStudents)) {
			createStudent(clientDto, student);
		} else {
			throw new StudentRegisteredPreviouslyException();
			//TODO log in database
		}
	} catch (InvalidDataAccessApiUsageException e) {
		LOGGER.debug("--------------------------InvalidDataAccessApiUsageException-------------------------------------------------------------");
		//TODO log in database
	}
	return student;
}

private boolean isDuplicateStudent(ClientDto clientDto, List<Optional<StudentDto>> allStudents) {
	for (Optional<StudentDto> studentDto : allStudents) {
		if ((studentDto.isPresent() && studentDto.get().getNationalCode().equals(clientDto.getNationalCode()))) {
			return true;
		}
	}
	return false;
}

private void createStudent(ClientDto clientDto, Student student) {
	initStudent(clientDto, student);
	studentService.save(student);
}

private void initStudent(ClientDto clientDto, Student student) {
	student.setName(clientDto.getName());
	student.setFamily(clientDto.getFamily());
	student.setNationalCode(clientDto.getNationalCode());
	student.setEmailAddress(clientDto.getEmailAddress());
	student.setCellphone(clientDto.getCellphone());
	student.setAddress(clientDto.getAddress());
	student.setAge(clientDto.getAge());
	student.setTeacher(clientDto.getTeacher());
	student.setCourse(clientDto.getCourse());
	student.setClassTime(clientDto.getClassTime());
	student.setClassDay(clientDto.getClassDay());
	student.setSeason(clientDto.getSeason());
	student.setTerm(clientDto.getTerm());
	
}

public boolean checkSelectedItem(ClientDto clientDto) {
	return !clientDto.isEmailChecked() && !clientDto.isSmsChecked();
}


}
