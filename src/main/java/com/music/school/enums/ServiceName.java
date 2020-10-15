package com.music.school.enums;

public enum ServiceName {
	STUDENT_REGISTRATION("student_Registration");
	private String name;

ServiceName(String name) {
	this.name = name;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
}
