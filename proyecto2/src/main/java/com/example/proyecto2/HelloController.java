package com.example.proyecto2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class HelloController{
    public static final int PUERTO = 4182;

    Acciones a = new Acciones();

    @FXML
    private Label mostrartexto;

    @FXML
    private TextField cantidadparqueos;

    @FXML
    private TextField inparqueo;

    @FXML
    private TextField retirarvehiculo;

    @FXML
    private TextField inmatricula;

    @FXML
    private TextField inmodelo;

    @FXML
    private TextField incolor;

    @FXML
    private TextField intipo;


    @FXML
    private TextField cobro;

    String hola = "-";

    @FXML
    private void ingresouser(KeyEvent event){
        //System.out.println(event);
        Object ovj = event.getSource();


            if(ovj.equals(inparqueo)){

                if(!Character.isDigit(event.getCharacter().charAt(0))){

                    mostrartexto.setText(" *********     Ingresa Solo digitos    ******");
                    event.consume();
                }


            } else if (ovj.equals(inmatricula)){

                if((!Character.isDigit(event.getCharacter().charAt(0)) || !Character.isLetter(event.getCharacter().charAt(0))) &&
                        inmatricula.getText().length() <= 7){

                    mostrartexto.setText(" *********     Ingresa digitos y letras   ******\n ejemplo: p0123abc");
                    event.consume();
                }

            } else if (ovj.equals(inmodelo)){

                if(!Character.isDigit(event.getCharacter().charAt(0)) && inmodelo.getText().length() <= 7){
                    event.consume();
                    mostrartexto.setText(" *********     Ingresa Solo el año   ******\n ejemplo: 2021");
                }

            }else if (ovj.equals(incolor)){

                if(!Character.isLetter(event.getCharacter().charAt(0)) && incolor.getText().length() <= 10){
                    event.consume();
                    mostrartexto.setText(" *********     Ingresa Solo  letras   ******\n ejemplo: rojo");
                }

            }else if (ovj.equals(intipo)){

                if(!Character.isLetter(event.getCharacter().charAt(0)) && intipo.getText().length() <= 10){
                    event.consume();
                    mostrartexto.setText(" *********     Ingresa Solo  letras   ******\n ejemplo: Moto, Vehiculo, Camion");
                }

            }else if (ovj.equals(retirarvehiculo)){

                if(!Character.isDigit(event.getCharacter().charAt(0)) && (retirarvehiculo.getText().length() <= Integer.parseInt(cantidadparqueos.getText()))){
                    event.consume();
                    mostrartexto.setText(" *********     Ingresa digitos   ******");
                }

            }else if (ovj.equals(cobro)){

                if(!Character.isDigit(event.getCharacter().charAt(0)) && (cobro.getText().length() <= 1000)){
                    event.consume();
                    mostrartexto.setText(" *********     Ingresa digitos   ******");
                }

            }





        //System.out.println(ovj);


    }


    //int cantidadparqueos;
    @FXML
    protected void onAbrirButtonClick(ActionEvent event) {
        try {
            if (cantidadparqueos.getText().length() <= 1){
                mostrartexto.setText(a.abrirEst(Integer.parseInt(String.valueOf(cantidadparqueos.getText()))));

            }else {
                mostrartexto.setText("Ingresa 1 digito");
            }
        }catch (Exception e){
            mostrartexto.setText("Ingresa solo numeros");
        }
    }
    //@FXML public void onkeyinput(KeyEvent keyEvent) {}

    @FXML
    protected void onAsigCobButtonClick(ActionEvent event){
        mostrartexto.setText("Se ha asignado el cobro: "+cobro.getText());
    }

    @FXML
    protected void onAsigVehiButtonClick(ActionEvent event) throws Exception {


        try {


            mostrartexto.setText(a.asignarLugar(Short.parseShort(inparqueo.getText()),inmatricula.getText(),inmodelo.getText(),incolor.getText(),intipo.getText()));


        }catch (Exception e){
            mostrartexto.setText("Ingresa todos lo valores\n "+e);
        }


    }


    @FXML
    protected void onAsigNLuVehiButtonClick(ActionEvent event){
        mostrartexto.setText(a.moverVehic((short) 1,(short) 2));
    }


    @FXML
    protected void onRetVehiButtonClick(ActionEvent event) throws Exception {
    try{
        mostrartexto.setText(a.retirarVehic(Short.parseShort(retirarvehiculo.getText()),Integer.parseInt(cobro.getText())));
    }catch (NumberFormatException ex){
        mostrartexto.setText("asigna el monto");
    }catch (Exception e){
        mostrartexto.setText("Llena todos los valores");
    }

    }

    @FXML
    protected void onCerrarButtonClick(ActionEvent event){
        mostrartexto.setText(a.cerrarEst());
    }


    @FXML
    protected void onMostrarButtonClick(ActionEvent event){
        mostrartexto.setText(a.printArr());
    }

    @FXML
    protected void onCambDatVehiButtonClick(){



        mostrartexto.setText(a.cambiarDatos((short) 1,"456CDF","2022","Azul"));
    }


    @FXML
    protected void onSrvrButtonClick(){

        try {

            //while(true){
            ServerSocket servidor = new ServerSocket(PUERTO);
            //System.out.println("*****(server)Socket creado");

            Socket misocket = servidor.accept();
            //System.out.println("*****(server)socket aceptado");

            DataInputStream flujo_entrada = new DataInputStream(misocket.getInputStream());
            //System.out.println("****Flujo de entrada en el servidor creado");

            String mensaje_texto =  flujo_entrada.readUTF();  //leyendo flujo de entrada

            System.out.println("(Recibi server): \n"+ mensaje_texto); //imprmiendo flujo de entrada

            //////////

            DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
            //System.out.println("********(server) flujo de salida creado");
            String tlt = String.valueOf(a.getCobroTotal());

            flujo_salida.writeUTF(a.printArr().toString()+"\n Cobro: Q"+String.valueOf(a.getCobroTotal()));
            //System.out.println("\n *******Almacenando mensaje del servidor en el flujo");

            mensaje_texto =  flujo_entrada.readUTF();
            System.out.println("(Recibi server): \n"+ mensaje_texto);

            flujo_salida.close();

            misocket.close();

            //}

        } catch (IOException e) {
            System.err.println(e);
        } catch (Exception ex){
            System.err.println(ex);
        }


    }

    public void initialize(){


        mostrartexto.setText("Bienvenido usuario!");

    }

}