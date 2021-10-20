package com.company;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Logger;

public class Client {
    static Logger logger= Logger.getLogger("global");

    public static void main(String args[]){


        //Parse stringa
        String prova = "Ciao, Prova, Come; 1, 2, 3; Pippo, Pluto, Paperino;";

        String[] array = prova.split(";");

        for (String s : array){
            String [] speak = s.split(",");
            System.out.println("Speakers:");
            for(String t : speak){
                System.out.print(t.trim()+"\t");

            }
            System.out.println();

        }


        // lookup
        try {
            logger.info("Sto cercando l’oggetto remoto...");
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            GestioneProgrammi stub = (GestioneProgrammi) reg.lookup("rmi://localhost/GestioneProgrammiServer");
            logger.info("... Trovato! Ora invoco il metodo...");
            String response = stub.toString();
            System.out.println("Hello: " + response);


        } catch (AccessException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
