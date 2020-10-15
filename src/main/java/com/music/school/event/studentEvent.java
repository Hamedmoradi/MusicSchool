package com.music.school.event;

import com.music.school.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;


public class studentEvent extends ApplicationEvent {
private static final long serialVersionUID = 1L;

private String message;
@Autowired
private Student student;

public studentEvent(Object source, String message, Student student) {
	super(source);
	this.message = message;
	this.student = student;
}

public String getMessage() {
	return message;
}

public Student getStudent() {
	return student;
}

public String toString() {
	return "My Custom Event";
}

}
