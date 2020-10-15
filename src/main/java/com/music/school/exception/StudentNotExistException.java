package com.music.school.exception;

public class StudentNotExistException extends MusicSchoolBaseBusinessException {

private static final long serialVersionUID = 1L;

public StudentNotExistException(String message) {
	super(message);
}

public StudentNotExistException(String message, Throwable cause) {
	super(message, cause);
}

public StudentNotExistException() {

}
}
