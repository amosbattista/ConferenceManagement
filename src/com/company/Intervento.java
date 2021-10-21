package com.company;

import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;

public class Intervento {
    private String speakerName;

    public Intervento(String speakerName) throws java.rmi.RemoteException {
        this.speakerName = speakerName;
    }


    public String getSpeakerName() {
        return speakerName;
    }

    @Override
    public String toString() {
        return  speakerName;
    }
}
