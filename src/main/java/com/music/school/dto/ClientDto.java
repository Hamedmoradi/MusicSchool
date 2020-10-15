package com.music.school.dto;


import com.music.school.domain.EmailNotification;
import com.music.school.domain.SmsNotification;
import com.music.school.domain.Student;
import com.music.school.domain.NotificationMessageType;
import com.music.school.validation.NullIfAnotherFieldHasValue;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@NullIfAnotherFieldHasValue.List({
		@NullIfAnotherFieldHasValue(
				fieldName = "emailChecked",
				fieldValue = "false",
				dependFieldName = "emailAddress"),
		@NullIfAnotherFieldHasValue(
				fieldName = "smsChecked",
				fieldValue = "false",
				dependFieldName = "cellphone")
})
public class ClientDto implements Serializable {

private Long id;

@NotBlank
@NumberFormat(style = NumberFormat.Style.NUMBER)
@Length(min = 10, max = 10, message = "nationalCode must be 10 digit")
private String nationalCode;

@NotBlank
@Size(min = 3, max = 30, message = "name must be between 10 and 30 characters")
private String name;

@NotBlank
@Size(min = 3, max = 30, message = "family must be between 10 and 30 characters")
private String family;

//    @Email(regexp = ".+@.+\\.[a-z]+")
//    @Length(min = 5, max = 50, message = "email must be between 5 to 50 character")
//    @Nullable
private String emailAddress;

//     @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "09378288717")
//    @Length(min = 11, max = 11, message = "cellphone must be 11 number")
//    @Nullable
private String cellphone;

private int age;
private String course;
private String teacher;
private String address;
private String instituteNo;
private int term;
private String season;
private boolean payment;
private String classTime;
private String classDay;

@Temporal(TemporalType.TIMESTAMP)
@CreationTimestamp
private Date emailCreatedOn;

@Temporal(TemporalType.TIMESTAMP)
@CreationTimestamp
private Date smsCreatedOn;

//@NotNull
//@NotEmpty
private String[] messageTitleService;

private boolean emailChecked;
private boolean smsChecked;

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

public Date getEmailCreatedOn() {
	return emailCreatedOn;
}

public void setEmailCreatedOn(Date emailCreatedOn) {
	this.emailCreatedOn = emailCreatedOn;
}

public Date getSmsCreatedOn() {
	return smsCreatedOn;
}

public void setSmsCreatedOn(Date smsCreatedOn) {
	this.smsCreatedOn = smsCreatedOn;
}
//
public String[] getMessageTitleService() {
	return messageTitleService;
}

public void setMessageTitleService(String[] messageTitleService) {
	this.messageTitleService = messageTitleService;
}

public boolean isEmailChecked() {
	return emailChecked;
}

public String getClassDay() {
	return classDay;
}

public void setClassDay(String classDay) {
	this.classDay = classDay;
}

public void setEmailChecked(boolean emailChecked) {
	this.emailChecked = emailChecked;
}

public boolean isSmsChecked() {
	return smsChecked;
}

public void setSmsChecked(boolean smsChecked) {
	this.smsChecked = smsChecked;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getCourse() {
	return course;
}

public void setCourse(String course) {
	this.course = course;
}

public String getTeacher() {
	return teacher;
}

public void setTeacher(String teacher) {
	this.teacher = teacher;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getInstituteNo() {
	return instituteNo;
}

public void setInstituteNo(String instituteNo) {
	this.instituteNo = instituteNo;
}

public int getTerm() {
	return term;
}

public void setTerm(int term) {
	this.term = term;
}

public String getSeason() {
	return season;
}

public void setSeason(String season) {
	this.season = season;
}

public boolean isPayment() {
	return payment;
}

public String getClassTime() {
	return classTime;
}

public void setClassTime(String classTime) {
	this.classTime = classTime;
}

public void setPayment(boolean payment) {
	this.payment = payment;
}

public static ClientDto otherObjectToClientDto(Student student, EmailNotification emailNotification,
                                               SmsNotification smsNotification, NotificationMessageType notificationMessageType) {
	
	ClientDto clientDto = new ClientDto();
	clientDto.setId(student.getId());
	clientDto.setNationalCode(student.getNationalCode());
	clientDto.setName(student.getName());
	clientDto.setFamily(student.getFamily());
	clientDto.setEmailAddress(student.getEmailAddress());
	clientDto.setCellphone(student.getCellphone());
	clientDto.setAge(student.getAge());
	clientDto.setTeacher(student.getTeacher());
	clientDto.setCourse(student.getCourse());
	clientDto.setClassDay(student.getClassDay());
	clientDto.setClassTime(student.getClassTime());
	clientDto.setTerm(student.getTerm());
	clientDto.setSeason(student.getSeason());
	clientDto.setPayment(student.isPayment());
	clientDto.setAddress(student.getAddress());
//	clientDto.setEmailCreatedOn(emailNotification.getCreatedOn());
//	clientDto.setSmsCreatedOn(smsNotification.getCreatedOn());
//	clientDto.setMessageTitleService(notificationMessageType.getMessageTitle());
	return clientDto;
	
}
public static Student clientDtoToStudent(ClientDto clientDto) {
	
	Student student = new Student();
	student.setId(clientDto.getId());
	student.setNationalCode(clientDto.getNationalCode());
	student.setName(clientDto.getName());
	student.setFamily(clientDto.getFamily());
	student.setEmailAddress(clientDto.getEmailAddress());
	student.setCellphone(clientDto.getCellphone());
	student.setAge(clientDto.getAge());
	student.setTeacher(clientDto.getTeacher());
	student.setCourse(clientDto.getCourse());
	student.setClassDay(clientDto.getClassDay());
	student.setClassTime(clientDto.getClassTime());
	student.setTerm(clientDto.getTerm());
	student.setSeason(clientDto.getSeason());
	student.setPayment(clientDto.isPayment());
	student.setAddress(clientDto.getAddress());
//	student.setEmailCreatedOn(emailNotification.getCreatedOn());
//	student.setSmsCreatedOn(smsNotification.getCreatedOn());
//	student.setMessageTitleService(notificationMessageType.getMessageTitle());
	return student;
	
}
}
