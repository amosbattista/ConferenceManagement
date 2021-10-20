import Eccezioni.FullSessionException;

import java.util.HashMap;

public class Sessione {

    private HashMap<String,Intervento> interventi;
    private int id;
    private int sizeInterventi;
    private static final int MAX_INTERVENTI = 5;

    public void addIntervento(Intervento intervento) throws FullSessionException { //incrementare size

    }

    public Sessione(int id) {
        this.id = id;
        this.interventi = new HashMap<>();
    }
}
