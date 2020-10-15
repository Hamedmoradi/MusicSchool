package com.music.school.exception;

public class StudentRegisteredPreviouslyException extends MusicSchoolBaseBusinessException {
    
    private static final long serialVersionUID = 1L;

    public StudentRegisteredPreviouslyException(String message) {
        super(message);
    }

    public StudentRegisteredPreviouslyException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentRegisteredPreviouslyException() {

    }
}
