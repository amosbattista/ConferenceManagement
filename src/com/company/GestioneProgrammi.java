package com.company;

import com.company.eccezioni.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GestioneProgrammi extends Remote {
    String getDayProgram(int day) throws DayNotPresentException, RemoteException;

    void  enroll(String speakerName, int day, int session) throws SpeakerAlreadyPresentException,
            DayNotPresentException,
            SessionNotPresentException, FullSessionException, FullDayException, RemoteException;


}
