package com.music.school.enums;



public enum StudentState {
	INACTIVE("inactive",10001),
	PENDING("pending",10002),
	ACTIVE("active",10003);
	private String status;
	private Integer statusCode;

StudentState(final String status,final int statusCode) {
	this.status=status;
	this.statusCode=statusCode;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public Integer getStatusCode() {
	return statusCode;
}

public void setStatusCode(Integer statusCode) {
	this.statusCode = statusCode;
}
}

