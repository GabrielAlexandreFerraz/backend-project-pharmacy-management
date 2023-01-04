package com.api.projectpharmacy.exceptions;

public class ServerSideException extends RuntimeException{
    public ServerSideException() {
        super();
    }

    public ServerSideException(String message, String error) {
        super(message);
    }

}