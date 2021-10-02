package com.example.cliente;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.*;
import java.net.Socket;

public class HelloController {
    public static final int PUERTO = 4182;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        try {
            Socket misocket;
            misocket = new Socket("localhost",PUERTO);
            //System.out.println("(*******cliente) Socket Creado");

            DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
            //System.out.println("********(cliente) flujo creado de salida creado");

            flujo_salida.writeUTF("Solicitando reporte");
            //System.out.println("\n ******Escribiendo mensaje en el flujo de salida");


            //////////////////
            DataInputStream flujo_entrada = new DataInputStream(misocket.getInputStream());
            //System.out.println("****Creando Flujo en el servidor de entrada");

            String mensaje_texto =  flujo_entrada.readUTF(); // leyendo mensaje en el flujo
            welcomeText.setText(mensaje_texto+"\n Conexion cerrada."); //Imprimiendo


            flujo_salida.writeUTF("Gracias, reporte recibido");



            flujo_salida.close();


        }catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        catch (Exception e) {
            System.err.println(e);
        }


    }


    protected void initialize() {
        welcomeText.setText("Solicitar informacion del servidor");
    }

}