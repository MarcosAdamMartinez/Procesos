package psp.practica1;

import java.io.File;
import java.lang.invoke.StringConcatFactory;
import java.util.Scanner;

public class Menu {

    public static void ejecutarPing(String ip, String os){

        ProcessBuilder pb;
        Process process;
        try{
            if (os.contains("win")) {
                pb = new ProcessBuilder("ping", "-n", "4", ip);
            } else {
                pb = new ProcessBuilder("ping", "-c", "4", ip);
            }

            process = pb.start();

            Scanner scan = new Scanner(process.getInputStream());
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public static void volcarAArchivo(String nombreArchivo, String os){
        ProcessBuilder pb;
        Process process;
        File log;
        try{
            if (os.contains("win")) {
                pb = new ProcessBuilder("cmd.exe", "/c", "dir","C:\\");
                log = new File(nombreArchivo);
            } else {
                pb = new ProcessBuilder("ls", "-l", "/home");
                log = new File(nombreArchivo);
            }
            pb.redirectOutput(log);
            pb.redirectError(log);

            process = pb.start();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void listarPr(String os){

        ProcessBuilder pb;
        Process process;

        try{
            if (os.contains("win")) {
                pb = new ProcessBuilder("cmd.exe", "/c", "tasklist");
            } else {
                pb = new ProcessBuilder("ps", "-e");
            }

            process = pb.start();

            Scanner scan = new Scanner(process.getInputStream());
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public static void eliminarPr(String numProc, String os){

        ProcessBuilder pb;
        Process process;

        try{
            if (os.contains("win")) {
                pb = new ProcessBuilder("cmd.exe", "/c", "taskkill /PID",numProc,"/F");
            } else {
                pb = new ProcessBuilder("kill", "-9",numProc);
            }

            process = pb.start();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void buscarEnNavegador(String url, String os){

        ProcessBuilder pb;
        Process process;

        try{
            if (os.contains("win")) {
                pb = new ProcessBuilder("cmd.exe", "/c", "start", url);
            } else {
                pb = new ProcessBuilder("xdg-open", url);
            }

            process = pb.start();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public static void main(String[] args) {
        int opc = 0;
        Scanner teclado = new Scanner(System.in);
        Scanner teclado2 = new Scanner(System.in);
        do{

            System.out.println("Elige una de las siguientes opciones:");
            System.out.println("1. Ejecutar ping");
            System.out.println("2. Lista de archivos a archivo");
            System.out.println("3. Leer procesos y eliminar");
            System.out.println("4. Ejecutar un navegador con URL");
            System.out.println("5. Salir");
            System.out.println("Introduce una opcion 1-5");
            opc = teclado.nextInt();
            String so = System.getProperty("os.name").toLowerCase();
            System.out.println(so);

            switch (opc) {
                case 1:
                    System.out.println("Introduce la ip:");
                    String ip;
                    ip = teclado2.nextLine();
                    ejecutarPing(ip,so);
                    break;

                case 2:
                    System.out.println("Introduce el nombre del fichero");
                    String nombreFich;
                    nombreFich = teclado2.nextLine();
                    volcarAArchivo(nombreFich,so);
                    break;

                case 3:
                    System.out.println("Listado de procesos:");
                    listarPr(so);
                    System.out.println("Elige el proceso a borrar (por numero):");
                    String numProc;
                    numProc = teclado2.nextLine();
                    eliminarPr(numProc,so);
                    break;

                case 4:
                    System.out.println("Introduce la URL:");
                    String url;
                    url = teclado2.nextLine();
                    buscarEnNavegador(url,so);
                    break;

                case 5:
                    System.out.println("Saliendo del programa . . .");
                    break;
                }
            System.out.println("\n");
        } while (opc != 5);

    }

}
