package psp.procesos.gestoralumnos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorAlumnos extends JFrame implements ActionListener {

    private JLabel etiqueta;
    private JTextField campo;
    private JButton boton;

    public GestorAlumnos(){
        super();
        configurarGUI();
        inicializarComponentes();
    }

    private void configurarGUI(){
        this.setTitle("Gestor de Alumnos");
        this.setSize(600,500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void inicializarComponentes(){

        etiqueta = new JLabel();
        campo = new JTextField();
        boton = new JButton();

        etiqueta.setText("<html><b><i>Añadir Alumnos<i><b></html>");
        etiqueta.setBounds(50,100,200,50);

        campo.setBounds(50, 200, 200,20);

        boton.setText("PULSAR");
        boton.setBounds(100,300,200,20);
        boton.addActionListener(this);
        boton.setActionCommand("BUSCAR");


        this.add(etiqueta);
        this.add(campo);
        this.add(boton);

        JPanel panel = (JPanel) this.getContentPane();
        panel.revalidate();
        panel.repaint();

    }

    public static void main(String[] args) {
        GestorAlumnos gA = new GestorAlumnos();
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        String comando = evento.getActionCommand();

        if(comando.equals("BUSCAR")){

            String texto = campo.getText();
            JOptionPane.showConfirmDialog(this,"Boton pulsado. Texto: "+texto);
//            JOptionPane.showMessageDialog(this,"Boton pulsado. Texto: "+texto);

        }

    }
}
