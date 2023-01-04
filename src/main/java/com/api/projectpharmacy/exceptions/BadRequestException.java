package com.api.projectpharmacy.exceptions;

public class BadRequestException extends RuntimeException{

    BadRequestException(){
        super();
    }
    BadRequestException(String message, String error){
        super(message);
    }
}
