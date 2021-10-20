public interface GestioneProgrammi {

    public String synchronized getDayProgram(int day) throws DayNotPresentException;
    public void synchronized enroll(String speakerName, int day, int session) throws
            SpeakerAlreadyPresentException, DayNotPresentException,
            SessionNotPresentException, FullSessionException;

}