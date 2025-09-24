package psp.practica1;

import java.io.File;
import java.util.Scanner;

public class Menu {

    public static void ejecutarPing(String ip){

        ProcessBuilder pb;
        Process process;
        try{

            pb = new ProcessBuilder( "ping", "-c", "1", ip);
            process = pb.start();

            Scanner scan = new Scanner(process.getInputStream());
            while (scan.hasNextLine()){
                System.out.println(scan.nextLine());
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public static void main(String[] args) {
        int opc = 0;
        Scanner teclado = new Scanner(System.in);
        do{

            System.out.println("Elige una de las siguientes opciones:");
            System.out.println("1. Ejecutar ping");
            System.out.println("2. Lista de archivos a archivo");
            System.out.println("3. Leer procesos y eliminar");
            System.out.println("4. Ejecutar un navegador con URL");
            System.out.println("5. Salir");
            System.out.println("Introduce una opcion 1-5");
            opc = teclado.nextInt();

            switch (opc){
                case 1:
                    ejecutarPing("0.0.0.0");
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:
                    System.out.println("Saliendo del programa . . .");
                    break;
            }
            System.out.println("\n");
        } while (opc != 5);

    }

}
