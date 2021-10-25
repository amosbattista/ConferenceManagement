package com.company;

import com.company.eccezioni.*;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedHashMap;


/**
 * Rappresenta la classe remota che gestisce i programmi giornalieri della conferenza. Si occupa di aggiungere nuovi
 * interventi ad una sessione e di restituire il programma del giorno, tramite i metodi implementati dall'interfaccia
 * remota GestioneProgrammi.
 *
 */
public class GestioneProgrammiImpl extends UnicastRemoteObject implements GestioneProgrammi{

    /**
     * @param MAX_GIORNI è la durata massima della conferenza, espressa in numero di giorni
     * @param programMap è una mappa che associa al giorno un programma
     */
    public static final int MAX_GIORNI = 3;
    private LinkedHashMap<Integer, Programma> programMap; //mappa integer=giorno,

    public GestioneProgrammiImpl() throws java.rmi.RemoteException {
        this.programMap = new LinkedHashMap<>();

        for(int i = 1; i <= MAX_GIORNI; i++){
            programMap.put(i, new Programma(i)); //istanzia i tre programmi
        }
    }

    /**
     * Restituisce il programma del giorno richiesto.
     *
     * @param day è il giorno per il quale si desidera ottenere il programma
     * @return una Stringa che rappresenta tutti gli interventi all'interno di ciascuna sessione del programma richiesto
     * @throws DayNotPresentException se il giorno fornito non è nell'intervallo [1,3]
     */
    public synchronized String getDayProgram(int day) throws DayNotPresentException, RemoteException {

        if(day < 1 || day > 3){
            throw new DayNotPresentException("Giorno non corretto");
        }
        Programma p = programMap.get(day);
        return p.toString();


    }

    /**
     * Aggiunge un nuovo intervento ad una sessione di un determinato giorno
     *
     * @param speakerName è il nome dello speaker dell'intervento da aggiungere
     * @param day è il giorno in cui aggiungere l'intervento
     * @param session è la sessione in cui aggiungere l'intervento
     *
     * @throws SpeakerAlreadyPresentException se nella sessione è già presente un intervento da parte dello stesso speaker
     * @throws DayNotPresentException se il giorno fornito non è nell'intervallo [1,3]
     * @throws SessionNotPresentException se la sessione fornita non è nell'intervallo [1,12]
     * @throws FullSessionException se la sessione è piena
     * @throws SpeakerIsNotAlphaNumericException se il nome dello speaker non è alfanumerico
     */
    public synchronized void enroll(String speakerName, int day, int session) throws
            SpeakerAlreadyPresentException, DayNotPresentException,
            SessionNotPresentException, FullSessionException, RemoteException, SpeakerIsNotAlphaNumericException {

        // se il giorno non è corretto
        if (day < 1 || day > 3){
            throw new DayNotPresentException("Giorno non corretto");
        }

        // se la sessione non è corretta
        if (session < 1 || session > 12){
            throw new SessionNotPresentException("Sessione non corretta");
        }

        if(!speakerName.matches("^[a-zA-Z0-9_]+$")){
            throw new SpeakerIsNotAlphaNumericException("Nome utente non valido!");


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
