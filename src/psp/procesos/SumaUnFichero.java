package psp.procesos;

import java.io.BufferedReader;
import java.io.FileReader;

public class SumaUnFichero {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.err.println("Se necesita el nombre del fichero");
            System.exit(1);
        }

        String filename = args[0];
        long total = 0;

        try{

            BufferedReader br = new BufferedReader(new FileReader(filename));
            String linea;
            while ((linea = br.readLine()) != null){

                total += Long.parseLong(linea);

            }

        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(total);

    }

}
