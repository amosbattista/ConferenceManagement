package com.company;

/**
 * Rappresenta un intervento di uno speaker in una sessione
 */
public class Intervento {

    /**
     * @param spekerName è il nome dello speaker che identifica l'intervento
     */
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
