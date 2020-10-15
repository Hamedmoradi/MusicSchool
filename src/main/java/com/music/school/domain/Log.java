package com.music.school.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "event_logs")
@EntityListeners(AuditingEntityListener.class)
public class Log extends Auditable<String>{
@Id
@GeneratedValue
private int id;
@Column(name = "context")
private String content;
@Column(name = "action")
private String action;
@JoinColumn(name = "student_id")
@ManyToOne
private Student studentId;
@Column(name = "service_name")
private String serviceName;
@Column(name = "successRate")
private boolean successRate;

private String json;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getAction() {
	return action;
}

public void setAction(String action) {
	this.action = action;
}

public boolean isSuccessRate() {
	return successRate;
}

public void setSuccessRate(boolean successRate) {
	this.successRate = successRate;
}

public String getServiceName() {
	return serviceName;
}

public void setServiceName(String serviceName) {
	this.serviceName = serviceName;
}

public Student getStudentId() {
	return studentId;
}

public void setStudentId(Student studentId) {
	this.studentId = studentId;
}

}
