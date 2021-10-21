package com.company;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Logger;

public class Server {
    static Logger logger= Logger.getLogger("global");

    public static void main(String args[]){

        try {
            logger.info("Creo l’oggetto remoto...");
            Registry reg = LocateRegistry.createRegistry(1099);// invece di usare rmiregistry da terminale - 1099 by default
            GestioneProgrammiImpl obj = new GestioneProgrammiImpl();
            logger.info("... ora ne effettuo il rebind...");
            reg.rebind("rmi://localhost/GestioneProgrammiServer", obj);
//
//
//            logger.info("... Pronto!");
//            System.err.println("Server ready");









        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
