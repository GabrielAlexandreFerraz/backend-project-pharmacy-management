package com.api.projectpharmacy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

@ControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity tratarNotFoundException(Exception e){
        return new ResponseEntity(
                new ExceptionDto(
                        HttpStatus.NOT_FOUND.value(),
                        e.getMessage(),
                        e.getClass().getName(),
                        e.getCause()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity tratarBadRequestException(Exception e){
        return new ResponseEntity(
                new ExceptionDto(
                        HttpStatus.BAD_REQUEST.value(),
                        e.getMessage(),
                        e.getClass().getName(),
                        e.getCause()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServerSideException.class)
    public ResponseEntity tratarServerSideException(Exception e){
        return new ResponseEntity(
                new ExceptionDto(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        e.getMessage(),
                        e.getClass().getName(),
                        e.getCause()
                ),

                HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarMethodArgumentNotValidException(Exception e) {
        return new ResponseEntity(
                new ExceptionDto(
                        HttpStatus.BAD_REQUEST.value(),
                        e.getMessage(),
                        e.getClass().getName(),
                        e.getCause()
                ),

                HttpStatus.BAD_REQUEST);
    }

}
