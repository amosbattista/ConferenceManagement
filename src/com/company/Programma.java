package com.company;

import com.company.eccezioni.FullDayException;

import java.util.LinkedHashMap;
import java.util.Map;

public class Programma {
    private static final int MAX_SESSIONI = 12;
    private LinkedHashMap<Integer,Sessione> sessioni;
    private int day;
    private int sessionSize;

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

    // da vedere
    // memo: questa è associata a sessionSize
    public void addSession(Sessione session) throws FullDayException {

    }

    @Override
    public String toString() {

        String str = "";

        for (Map.Entry<Integer, Sessione> entry : sessioni.entrySet()) {
                str = str+entry.getValue().toString()+";";
        }


        return str.length()>0 ? str.substring(0,str.length()-1) : str;
    }
}
