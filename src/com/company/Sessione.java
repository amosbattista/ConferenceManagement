package com.company;


import com.company.eccezioni.FullSessionException;
import com.company.eccezioni.SpeakerAlreadyPresentException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Rappresenta la sessione di una conferenza costituita da massimo cinque interventi
 */
public class Sessione  {
    /**
     * @param MAX_INTERVENTI è il numero massimo di interventi all'interno di una stessa sessione
     * @param interventi è una mappa che associa al nome dello speaker un intervento
     * @param id è un identificativo numerico della sessione
     * @param sizeInterventi è l'attuale numero degli interventi presenti nella sessione
     */
    private static final int MAX_INTERVENTI = 5;
    private LinkedHashMap<String,Intervento> interventi; //Stringa=SpeakerName
    private int id;
    private int sizeInterventi;

    public Sessione(int id) {
        this.id = id;
        this.interventi = new LinkedHashMap<>();
        sizeInterventi = 0;
    }

    /**
     * Aggiunge un intervento alla sessione
     *
     * @param intervento
     * @throws FullSessionException se la sessione è piena, cioè già esistono cinque interventi al suo interno
     * @throws SpeakerAlreadyPresentException se nella sessione è già presente un intervento da parte dello stesso speaker
     * */
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
    /**
     * Stampa tutti gli interventi nella sessione separandoli da virgole. Se nella sessione non sono
     * presenti interventi, restituisce una stringa vuota.
     */
    public String toString() {

        StringBuilder str = new StringBuilder();

        for (Map.Entry<String, Intervento> entry : interventi.entrySet()) {
            str.append(entry.getValue().toString()).append(",");
        }

        // se c'è almeno un intervento rimuove l'ultima virgola in eccesso
        return str.length()>0 ? str.substring(0,str.length()-1) : str.toString();
    }
}
