package com.bulyginkonstantin.friend_app.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NullPointerException.class, Exception.class})
    public ResponseEntity<Object> handleNullPointerException(Exception exception, WebRequest webRequest) {
        String errMessage = exception.getLocalizedMessage();
        if (errMessage == null) errMessage = exception.toString();
        ErrorMessage message = new ErrorMessage(new Date(), errMessage);
        return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
