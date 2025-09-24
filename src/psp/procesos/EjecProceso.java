package psp.procesos;

import java.io.File;

public class EjecProceso {

    public void ejecutarPB(){

        ProcessBuilder pb;
        Process process;

        try{

            pb = new ProcessBuilder( "ls");
            File log = new File("salida.log");
            pb.redirectOutput(log);
            pb.redirectError(log);
            process = pb.start();
//            int retorno = process.waitFor();

//            System.out.println("La ejecución de "+pb.command()+" devuelve "+retorno);
//            System.out.println("Las variable de entorno del proceso son: "+pb.environment());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public void ejecutarRun(String[] comando){

        Runtime runtime;
        Process process;

        try{

            runtime = Runtime.getRuntime();
            process = runtime.exec(comando);
            synchronized (process){
                process.wait(5000);
            }
            process.destroy();

        } catch (Exception e){
            throw new RuntimeException();
        }

    }

    public static void main(String[] args) {

//        String comando = "gnome-terminal";
//        String comando2 = "notepad";
        EjecProceso ep = new EjecProceso();
        ep.ejecutarPB();

//        ep.ejecutarRun(args);
    }

}