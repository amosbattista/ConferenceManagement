import Eccezioni.FullSessionException;

import java.util.HashMap;

public class Sessione {

    private static final int MAX_INTERVENTI = 5;
    private HashMap<String,Intervento> interventi;
    private int id;
    private int sizeInterventi;

    public Sessione(int id) {
        this.id = id;
        this.interventi = new HashMap<>();
    }

    public void addIntervento(Intervento intervento) throws
            FullSessionException, SpeakerAlreadyPresentException{

        // controlla se la sessione è piena
        if (sizeInterventi == MAX_INTERVENTI)
            throw new FullSessionExpection();

        // controlla se lo speaker è già nella sessione
        // se non lo è, aggiungilo
        String speakerName = intervento.getSpeakerName();
        if (interventi.contains(speakerName)) {
            throw new SpeakerAlreadyPresentExcpetion();
        }
        else {
            interventi.put(speakerName, intervento);
            sizeInterventi++;
        }
    }


}
