package com.example.proyecto2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Acciones {
    private String enviar;
    private String salir;
    private String segundos;
    private String segundos2;
    private String salida;
    private String entrada;
    private int convertido;
    private int convertido2;
    private int total;
    private long diff;
    private int cobrototal;


    public int getCobroTotal() {
        return cobrototal;
    }

    /**
     *
     * @return salir
     */
    public String getSalir() {
        return salir;
    }
    /**
     *
     * @param salir
     */
    public void setSalir(String salir) {
        this.salir = salir;
    }
    /**
     *
     * @return enviar
     */
    public String getEnviar() {
        return enviar;
    }
    /**
     *
     * @param enviar
     */
    public void setEnviar(String enviar) {
        this.enviar = enviar;
    }

    /**
     *Constructor
     */
    public Acciones() {
    }

    short opc1,opc2,aux;
    Vehiculo autos[];
    //Vehiculo aux2;


    Hora tiempo;


    /**
     *
     */
    public String printArr(){
        String fila = "";
        if(autos!=null){
            for (int i = 0; i < autos.length; i++) {

                 fila = fila+"\nLugar ["+i+"] = "+autos[i];
            }
        }
        else {
            fila = "-El estacionamiento esta cerrado-";
        }
        return fila;
    }

    /**
     *
     * @param abrirest
     */
    public String abrirEst(int abrirest){
        String respuesta = "";
        if(autos==null){
            tiempo = new Hora();
            this.autos = new Vehiculo[abrirest];
            respuesta = " -Estacionamiento abierto- \n"+
            "Hora de apertura: "+ tiempo.horaActual();
            System.out.println(tiempo.horaActual());
        }
        else    respuesta = " -El estacionamiento ya fue abierto-";
        return respuesta;
    }

    /**
     *
     * @throws Exception
     */
    public String asignarLugar(short asignarlugar, String matricula, String modelo, String color, String tipo) throws Exception{
        String asignado ="";
        if(autos != null){
            //asignado = "Ingrese el lugar para estacionar el vehiculo:";
            opc1 = (short) asignarlugar;

            if(opc1>=0 && opc1<autos.length ){
                tiempo = new Hora();
                autos[opc1]=new Vehiculo(matricula,modelo,color,tipo);
                autos[opc1].setHora(tiempo.horaActual());

                System.out.println("Hora entrada: "+tiempo.horaActual());
                entrada = tiempo.horaActual();
                String str = tiempo.horaActual();
                String[] newStr = str.split(":");
                for (int i = 0; i < newStr.length; i++) {
                    segundos = newStr[2];
                }

                convertido = Integer.parseInt(segundos);

                this.enviar = autos[opc1].toString();
               asignado ="\nAutomovil asignado en lugar ["+opc1+"] : "+autos[opc1]+
                //Imprimir i = new Imprimir ();
                //i.imprimirEntrada(enviar);

                "\n ***Revise el archivo en la ruta:\n /GrupoVehiculoAlquiler/ticket.pdf***";

            }
            else    asignado = "Lugar invalido - fuera de rango";
        }
        else    asignado ="-El estacionamiento esta cerrado-";
        return asignado;
    }

    /**
     *
     */
    public String moverVehic(short nuevolugar, short antiguolugar){
        String mover = "";
        if(autos != null){
            //System.out.println("\nIngrese el lugar ACTUAL del automovil:");
            opc1 = nuevolugar;

            if(opc1>=0 && opc1<=autos.length){
                //System.out.println("\nIngrese el NUEVO lugar del automovil :");
                opc2 = antiguolugar;
                if(autos[opc2] != null)
                    mover = "El lugar "+opc2+" esta ocupado por : "+autos[opc2];
                else {
                    autos[opc2] = autos[opc1];
                    mover = "Automovil asignado de lugar ["+opc1+"] : "+autos[opc1];
                    autos[opc1] = null;
                    mover = "\nAutomovil asignado al lugar ["+opc2+"] : "+autos[opc2];
                }
            }
            else    mover = "-Lugar inexistente en el estacionamiento-";
        }
        else    mover = "-El estacionamiento esta cerrado-";

        return mover;
    }

    /**
     *
     */
    public String cambiarDatos(short ubicacion,String matricula, String modelo,String color){
        String modificado;
        if(autos != null){
            //System.out.println("Ingrese el lugar del vehiculo : ");
            opc1 = ubicacion;

            if(autos[opc1] != null){
                //System.out.println("Ingrese la matricula del auto: ");
                autos[opc1].setMatricula(matricula);
                //System.out.println("Ingrese la modelo del auto: ");
                autos[opc1].setModelo(modelo);

                //System.out.println("Ingrese el color del auto: ");
                autos[opc1].setColor(color);
               modificado = "\nDatos del Automovil modificados en lugar ["+opc1+"] : "+autos[opc1];
            }
            else    modificado = "-No existe un vehiculo en ese lugar-";
        }
        else    modificado = "-El estacionamiento esta cerrado-";
        return modificado;
    }

    /**
     *
     * @throws Exception
     */
    public String retirarVehic(short r, int monto) throws Exception{
        String retirar;
        if(autos != null){
            //retirar = "Ingrese el lugar a retirar : ";
            opc1 = r;
            if(autos[opc1]!=null){

                retirar = autos[opc1].toString();
                this.salir = autos[opc1].toString();

                tiempo = new Hora();
                System.out.println("Hora Salida: "+tiempo.horaActual());
                String str = tiempo.horaActual();
                salida = tiempo.horaActual();
                String[] newStr = str.split(":");
                for (int i = 0; i < newStr.length; i++) {
                    segundos2 = newStr[2];
                }

                convertido2 = Integer.parseInt(segundos2);

                DateFormat df = new SimpleDateFormat("HH:mm:ss");
                try{
                    Date d1 = df.parse(String.valueOf(entrada));
                    Date d2 = df.parse(String.valueOf(salida));
                    diff = d2.getTime()-d1.getTime();
                    total = (int) (diff / 1000);



                    //System.out.println(entrada+" salida -> "+salida);
                    //System.out.println(diff+" diff");
                    //System.out.println(total);
                }catch (Exception e){
                    System.err.println(e);
                }


                retirar =" ***Revise el archivo en la ruta: /GrupoVehiculoAlquiler/ticket.pdf***\n"


                +"\t"+autos[opc1]+"\n Vehiculo eliminado del lugar ["+opc1+"]" +
                        "\n La cantidad de segundos es de: "+total+"\n Hora de entrada: "+entrada+"\n Hora de salida: "+
                        salida+"\nUn toal de Q"+total*monto;
                cobrototal = monto*total;

                autos[opc1] = null;
            }
            else    retirar = "-No existe algun vehiculo en ese lugar-";
        }
        else    retirar ="-El estacionamiento esta cerrado-";
        return retirar;
    }

    /**
     *
     */
    public String cerrarEst(){
        String cerrar;
        if(autos != null){
            autos = null;
            cerrar = "<-El estacionamiento ha sido cerrado correctamente->";

        } else {

            cerrar = "-El estacionamiento no ha sido abierto aun-";


        }

        return cerrar;
    }

    /**
     *
     */
    public void Cobro(){


    }

}
