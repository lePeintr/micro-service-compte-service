package org.microservice.compteService.exceptions;

public class CompteNotFoundException extends Exception{
    public CompteNotFoundException(String message) {
        super(message);
    }
}
