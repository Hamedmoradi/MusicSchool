package com.music.school.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;


@Entity
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class)
@ApiModel(description = "All details about the student. ")
public class Student extends Auditable<String> {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@PrimaryKeyJoinColumn(name = "student_id")
@ApiModelProperty(notes = "The database generated student ID")
private Long id;

@Column(name = "national_code")
@ApiModelProperty(notes = "The student national code.")
private String nationalCode;

@Column(name = "name")
@ApiModelProperty(notes = "The student first name")
private String name;

@Column(name = "family")
@ApiModelProperty(notes = "The student family name.")
private String family;

@Column(name = "email_address", nullable = true)
@ApiModelProperty(notes = "The student EMAIL address.")
private String emailAddress;

@Column(name = "cell_phone", nullable = true)
@ApiModelProperty(notes = "The student cell phone number.")
private String cellphone;
@Column(name = "age")
private int age;
@Column(name = "course")
private String course;
@Column(name = "teacher")
private String teacher ;
@Column(name = "address")
private String address;
@Column(name = "institute_No")
private String instituteNo;
@Column(name = "term")
private int term;
@Column(name = "season")
private String season;
@Column(name = "payment")
private boolean payment;
@Column(name = "classTime")
private String classTime;
@Column(name = "classDay")
private String classDay;
@Column(name = "studentStatus")
private Integer studentStatus;


@Column(name = "created_date", nullable = false, updatable = false)
@CreatedDate
private long createdDate;

@Column(name = "modified_date")
@LastModifiedDate
private long modifiedDate;

public Student() {
}

public Student(String nationalCode, String name, String family, String emailAddress, String cellphone,
               int age, String course, String teacher, String address, String instituteNo, int term,
               String season, boolean payment, String classTime, String classDay, Integer studentStatus) {
	this.nationalCode = nationalCode;
	this.name = name;
	this.family = family;
	this.emailAddress = emailAddress;
	this.cellphone = cellphone;
	this.age = age;
	this.course = course;
	this.teacher = teacher;
	this.address = address;
	this.instituteNo = instituteNo;
	this.term = term;
	this.season = season;
	this.payment = payment;
	this.classTime = classTime;
	this.classDay = classDay;
	this.studentStatus = studentStatus;
}

public Long getId() {
	return id;
}

public void setId(long id) {
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

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getCourse() { return course; }

public void setCourse(String course) { this.course = course; }

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getInstituteNo() {
	return instituteNo;
}

public void setInstituteNo(String institutedNo) {
	this.instituteNo = institutedNo;
}

public int getTerm() {
	return term;
}

public void setTerm(int term) { this.term = term; }

public String getSeason() {
	return season;
}

public void setSeason(String season) {
	this.season = season;
}

public boolean isPayment() {
	return payment;
}

public void setPayment(boolean payment) {
	this.payment = payment;
}

public long getCreatedDate() {
	return createdDate;
}

public void setCreatedDate(long createdDate) {
	this.createdDate = createdDate;
}

public long getModifiedDate() {
	return modifiedDate;
}

public void setModifiedDate(long modifiedDate) {
	this.modifiedDate = modifiedDate;
}

public String getClassTime() { return classTime; }

public void setClassTime(String classTime) { this.classTime = classTime; }

public String getClassDay() { return classDay; }

public void setClassDay(String classDay) { this.classDay = classDay; }

public Integer getStudentStatus() { return studentStatus; }

public void setStudentStatus(Integer studentStatus) { this.studentStatus = studentStatus; }

public String getTeacher() { return teacher; }

public void setTeacher(String teacher) { this.teacher = teacher; }

@Override
public String toString() {
	return "student{" +
			       "id=" + id +
			       ", nationalCode='" + nationalCode + '\'' +
			       ", name='" + name + '\'' +
			       ", family='" + family + '\'' +
			       ", emailAddress='" + emailAddress + '\'' +
			       ", cellphone='" + cellphone + '\'' +
			       '}';
}


}
