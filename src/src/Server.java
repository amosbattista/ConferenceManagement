public class Server {

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

    }
}
