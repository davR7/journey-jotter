package com.davr7.journey_jotter.services.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(){
        super("User already exists");
    }
}
