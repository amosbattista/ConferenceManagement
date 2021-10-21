package com.company.eccezioni;

public class SessionNotPresentException extends Exception{

    public SessionNotPresentException(String message) {
        super(message);
    }
}
