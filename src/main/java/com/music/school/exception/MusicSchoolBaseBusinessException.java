package com.music.school.exception;

public class MusicSchoolBaseBusinessException extends RuntimeException {

    public MusicSchoolBaseBusinessException() {
        super();
    }

    public MusicSchoolBaseBusinessException(String message) {
        super(message);
    }

    public MusicSchoolBaseBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
