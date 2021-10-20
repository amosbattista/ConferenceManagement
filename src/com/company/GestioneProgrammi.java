package com.company;

import com.company.Eccezioni.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GestioneProgrammi extends Remote {
    public String getDayProgram(int day) throws DayNotPresentException, RemoteException;

    public void  enroll(String speakerName, int day, int session) throws SpeakerAlreadyPresentException,
            DayNotPresentException,
            SessionNotPresentException, FullSessionException, FullDayException, RemoteException;


}
