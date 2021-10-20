import Eccezioni.*;


import java.util.HashMap;


public class GestioneProgrammi extends UnicastRemoteObject implements GestioneProgrammi {

    public static final int MAX_GIORNI = 3;
    private HashMap<Integer, Programma> programMap;

    public GestioneProgrammi() throws java.rmi.RemoteException {
        this.programMap = new HashMap<>();

        for(int i = 1; i <= MAX_GIORNI; i++){
            programMap.put(i, new Programma(i));
        }
    }

    public String synchronized getDayProgram(int day) throws DayNotPresentException {

        return ""; //stringa formattata , ;

    }

    public void synchronized enroll(String speakerName, int day, int session) throws
            SpeakerAlreadyPresentException, DayNotPresentException,
            SessionNotPresentException, FullSessionException  {

        // se il giorno non è corretto
        if (day < 1 || day > 3){
            throw new DayNotPresentException();
        }

        // se la sessione non è corretta
        if (session < 1 || session > 12){
            throw new FullDayException();
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
