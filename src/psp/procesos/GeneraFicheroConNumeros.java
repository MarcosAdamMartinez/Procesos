package psp.procesos;

import java.io.FileWriter;
import java.io.PrintWriter;

public class GeneraFicheroConNumeros {
    final static int NUM_LINEAS = 10000000;
    final static int PESO = Integer.MAX_VALUE / 100;

    public static void main(String[] args){

        if (args.length < 1) {
            System.out.println("Se necesita el nombre del fichero");
            System.exit(1);
        }

        try{

            PrintWriter salida = new PrintWriter(new FileWriter(args[0]));

            for (int num = 1; num <= NUM_LINEAS; num++){
                long aleatorio = (long) (Math.random() * PESO);
                salida.println(aleatorio);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Fichero generado");

    }

}
