package com.company;

import com.company.eccezioni.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedHashMap;

public class GestioneProgrammiImpl extends UnicastRemoteObject implements GestioneProgrammi{

    public static final int MAX_GIORNI = 3;
    private LinkedHashMap<Integer, Programma> programMap; //mappa integer=giorno,

    public GestioneProgrammiImpl() throws java.rmi.RemoteException {
        this.programMap = new LinkedHashMap<Integer, Programma>();

        for(int i = 1; i <= MAX_GIORNI; i++){
            programMap.put(i, new Programma(i));
        }
    }

    public synchronized String getDayProgram(int day) throws DayNotPresentException, RemoteException {

        if(day < 1 || day > 3){
            throw new DayNotPresentException("Giorno non corretto");
        }

        Programma p = programMap.get(day);
        return p.toString();


    }

    public synchronized void enroll(String speakerName, int day, int session) throws
            SpeakerAlreadyPresentException, DayNotPresentException,
            SessionNotPresentException, FullSessionException, RemoteException {

        // se il giorno non è corretto
        if (day < 1 || day > 3){
            throw new DayNotPresentException("Giorno non corretto");
        }

        // se la sessione non è corretta
        if (session < 1 || session > 12){
            throw new SessionNotPresentException("Sesssione non corretta");
        }

        // addIntervento lancia
        // SpeakerAlreadyPresentException
        // e FullSessionException
        Intervento intervento = new Intervento(speakerName);
        Programma programma = programMap.get(day);
        Sessione sessione = programma.getSessione(session);
        sessione.addIntervento(intervento);
    }

}
