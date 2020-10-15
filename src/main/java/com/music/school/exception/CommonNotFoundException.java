package com.music.school.exception;


public class CommonNotFoundException extends MusicSchoolBaseBusinessException {

    public CommonNotFoundException() {
        super("Resource not found");
    }

    public CommonNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
