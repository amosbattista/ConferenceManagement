package com.company;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Rappresenta il programma giornaliero della conferenza, costituito da dodici sessioni.
 */

public class Programma {
    /**
     * @param MAX_SESSIONI è il numero massimo di sessioni possibili in un giorno
     * @param sessioni è una mappa che associa all'id della sessione una sessione
     * @param day è un intero che rappresenta il giorno in cui avviene la conferenza
     */
    private static final int MAX_SESSIONI = 12;
    private LinkedHashMap<Integer,Sessione> sessioni;
    private int day;

    public Programma(int day){
        this.sessioni = new LinkedHashMap<>();
        this.day = day;

        for (int i = 1; i <= MAX_SESSIONI; i++){
            sessioni.put(i, new Sessione(i)); //istanzia le 12 sessioni
        }
    }

    public Sessione getSessione(int idSessione){
        return sessioni.get(idSessione);
    }

    @Override
    /**
     * Stampa tutte le sessioni nel programma del giorno separandoli da punto e virgola.
     */
    public String toString() {

        StringBuilder str = new StringBuilder();

        for (Map.Entry<Integer, Sessione> entry : sessioni.entrySet()) {
                str.append(entry.getValue().toString()).append(";");
        }


        return  str.substring(0,str.length()-1);
    }
}
