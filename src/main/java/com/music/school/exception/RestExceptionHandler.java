package com.music.school.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.List;


@ControllerAdvice
//@Slf4j
public class RestExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(value = StudentRegisteredPreviouslyException.class)
    public ResponseEntity<Object> handleDuplicateStudentException(StudentRegisteredPreviouslyException exception) {
        LOGGER.error(exception.getMessage(), exception);
        return new ResponseEntity<>("student checked that duplicate national Code does not register again", HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = NotificationTypeNotSelectedException.class)
    public ResponseEntity<Object> handleSelectNotificationException(NotificationTypeNotSelectedException exception) {
        LOGGER.error(exception.getMessage(), exception);
        return new ResponseEntity<>("any check box not selected....", HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = {MusicSchoolBaseBusinessException.class})
    public ResponseEntity<List<ExceptionResponse>> handleBusinessEx(MusicSchoolBaseBusinessException ex) {
        LOGGER.error(ex.getMessage(), ex);
        return ResponseEntity.status(Integer.parseInt(ex.getMessage()))
                             .body(Arrays.asList(new ExceptionResponse(ex.getMessage())));
    }

    @ExceptionHandler(value = {Throwable.class})
    public ResponseEntity<List<ExceptionResponse>> handleError(Throwable ex) {
        LOGGER.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(Arrays.asList(new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage())));
    }

@ExceptionHandler(value = StudentNotExistException.class)
public ResponseEntity<Object> handleStudentNotExistException(StudentNotExistException exception) {
    LOGGER.error(exception.getMessage(), exception);
    return new ResponseEntity<>("student does not exist....", HttpStatus.INTERNAL_SERVER_ERROR);
}

}
