import Eccezioni.FullDayException;

import java.util.HashMap;

public class Programma {
        private static final int MAX_SESSIONI = 12;
        private HashMap<Integer,Sessione> sessioni;
        private int day;
        private int sessionSize;

        public Programma(int day){
                this.sessioni = new HashMap<>();
                this.day = day;

                for (int i = 1; i <= MAX_SESSIONI, i++){
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
}
