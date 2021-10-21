package com.company.eccezioni;

public class SpeakerAlreadyPresentException extends Exception{

    public SpeakerAlreadyPresentException(String message) {
        super(message);
    }
}