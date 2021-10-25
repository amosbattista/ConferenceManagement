package com.company;

public class Intervento {
    private String speakerName;

    public Intervento(String speakerName){
        this.speakerName = speakerName;
    }


    public String getSpeakerName() {
        return speakerName;
    }

    @Override
    public String toString() {
        return  speakerName;
    }
}
