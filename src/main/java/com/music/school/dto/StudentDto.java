package com.music.school.dto;

import com.music.school.domain.Student;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.*;

@XmlRootElement(name = "student")
public class StudentDto implements Serializable {

private Long id;
private String nationalCode;
private String name;
private String family;
private String emailAddress;
private String cellphone;
private int age;
private String course;
private String teacher;
private String address;
private String classTime;
private String classDay;



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNationalCode() {
	return nationalCode;
}

public void setNationalCode(String nationalCode) {
	this.nationalCode = nationalCode;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getFamily() {
	return family;
}

public void setFamily(String family) {
	this.family = family;
}

public String getEmailAddress() {
	return emailAddress;
}

public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
}

public String getCellphone() {
	return cellphone;
}

public void setCellphone(String cellphone) {
	this.cellphone = cellphone;
}

public String getClassTime() { return classTime; }

public void setClassTime(String classTime) { this.classTime = classTime; }

public int getAge() { return age; }

public void setAge(int age) { this.age = age; }

public String getCourse() { return course; }

public void setCourse(String course) { this.course = course; }

public String getTeacher() { return teacher; }

public void setTeacher(String teacher) { this.teacher = teacher; }

public String getAddress() { return address; }

public void setAddress(String address) { this.address = address; }

public String getClassDay() { return classDay; }

public void setClassDay(String classDay) { this.classDay = classDay; }

public static Optional<StudentDto> studentToStudentDto(Student student) {
	
	if (student != null) {
		StudentDto studentDto = new StudentDto();
		studentDto.setId(student.getId());
		studentDto.setName(student.getName());
		studentDto.setFamily(student.getFamily());
		studentDto.setNationalCode(student.getNationalCode());
		studentDto.setEmailAddress(student.getEmailAddress());
		studentDto.setCellphone(student.getCellphone());
		studentDto.setAddress(student.getAddress());
		studentDto.setAge(student.getAge());
		studentDto.setTeacher(student.getTeacher());
		studentDto.setCourse(student.getCourse());
		studentDto.setClassTime(student.getClassTime());
		studentDto.setClassDay(student.getClassDay());
		return Optional.of(studentDto);
	} else {
		return Optional.empty();
	}
}

public static List<Optional<StudentDto>> studentToStudentDto(Collection<Student> students) {
	if (null != students && students.size() > 0) {
		List<Optional<StudentDto>> studentDtoList = new ArrayList<>(students.size());
		for (Student student : students) {
			studentDtoList.add(studentToStudentDto(student));
		}
		return studentDtoList;
	} else {
		return Collections.EMPTY_LIST;
	}
}
}

