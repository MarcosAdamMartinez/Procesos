package psp.procesos;


public class EjecProceso {

    public void ejecutarPB(String comando){

        ProcessBuilder pb;
        Process proceso;
        //hola

        try{

            pb = new ProcessBuilder();
            proceso = pb.start();


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public static void main(String[] args) {

        String comando = "";
        EjecProceso ep = new EjecProceso();
        ep.ejecutarPB(comando);

    }

}