package com.company;

import java.util.LinkedHashMap;
import java.util.Map;

public class Programma {
    private static final int MAX_SESSIONI = 12;
    private LinkedHashMap<Integer,Sessione> sessioni;
    private int day;

    public Programma(int day){
        this.sessioni = new LinkedHashMap<>();
        this.day = day;

        for (int i = 1; i <= MAX_SESSIONI; i++){
            sessioni.put(i, new Sessione(i));
        }
    }

    public Sessione getSessione(int idSessione){
        return sessioni.get(idSessione);
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        for (Map.Entry<Integer, Sessione> entry : sessioni.entrySet()) {
                str.append(entry.getValue().toString()).append(";");
        }


        return str.length()>0 ? str.substring(0,str.length()-1) : str.toString();
    }
}
