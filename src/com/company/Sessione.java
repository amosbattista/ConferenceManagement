package com.company;


import com.company.Eccezioni.FullSessionException;
import com.company.Eccezioni.SpeakerAlreadyPresentException;

import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Sessione  {
    private static final int MAX_INTERVENTI = 5;
    private LinkedHashMap<String,Intervento> interventi; //Stringa=SpeakerName
    private int id;
    private int sizeInterventi;

    public Sessione(int id) {
        this.id = id;
        this.interventi = new LinkedHashMap<String, Intervento>();
    }

    public void addIntervento(Intervento intervento) throws
            FullSessionException, SpeakerAlreadyPresentException {

        // controlla se la sessione è piena
        if (sizeInterventi == MAX_INTERVENTI)
            throw new FullSessionException("Errore");

        // controlla se lo speaker è già nella sessione
        // se non lo è, aggiungilo
        String speakerName = intervento.getSpeakerName();
        if (interventi.containsKey(speakerName)) {

            throw new SpeakerAlreadyPresentException("Errore");
        }
        else {
            interventi.put(speakerName, intervento);
            sizeInterventi++;
        }
    }


    @Override
    public String toString() {


        String str = "";

        for (Map.Entry<String, Intervento> entry : interventi.entrySet()) {
            str = str+entry.getValue().toString()+",";
        }


        return str.length()>0 ? str.substring(0,str.length()-1) : str;
    }
}
