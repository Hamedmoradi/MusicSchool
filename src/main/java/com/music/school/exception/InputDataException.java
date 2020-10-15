package com.music.school.exception;

public class InputDataException extends MusicSchoolBaseBusinessException {

    public InputDataException() {
        super("There was an error entering the data....");
    }

    public InputDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
