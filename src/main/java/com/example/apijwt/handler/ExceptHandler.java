package com.example.apijwt.handler;

import com.example.apijwt.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Walter Porfirio
 *
 */
@RestControllerAdvice
public class ExceptHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorMgs("Sorry! An unexpected error occurs. Please, refresh your page or contact us if the problem persists.",
                        HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMgs("Invalid JSON", HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(value = EmailExistsException.class)
    public ResponseEntity<Object> handleEmailAlreadyExistsException(EmailExistsException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(new ErrorMgs(e.getMessage(), e.getCode()));
    }

    @ExceptionHandler(value = InvalidFieldsException.class)
    public ResponseEntity<Object> handleInvalidFieldsException(InvalidFieldsException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(new ErrorMgs(e.getMessage(), e.getCode()));
    }

    @ExceptionHandler(value = MissingFieldsException.class)
    public ResponseEntity<Object> handleMissingFieldsException(MissingFieldsException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(new ErrorMgs(e.getMessage(), e.getCode()));
    }

    @ExceptionHandler(value = InvalidCredentialsException.class)
    public ResponseEntity<Object> handleInvalidCredentialsException(InvalidCredentialsException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(new ErrorMgs(e.getMessage(), e.getCode()));
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    public ResponseEntity<Object> handleUnauthorizedException(UnauthorizedException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(new ErrorMgs(e.getMessage(),e.getCode()));
    }

}
