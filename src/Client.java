public class Client{

    static Logger logger= Logger.getLogger("global");

    public static void main(String args[]){


        //Parse stringa
        String prova = "Ciao, Prova, Come; 1, 2,3; Pippo, Pluto, Paperino;";

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
            Hello stub = (Hello) reg.lookup("rmi://localhost/HelloServer");
            logger.info("... Trovato! Ora invoco il metodo...");
            String response = stub.sayHello("Carmen");
            System.out.println("Hello: " + response);
        }
    }
}