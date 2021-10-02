package com.example.proyecto2;

public class Vehiculo {
    //atributos privados
    private String matricula;
    private String modelo;
    private String color;
    private String tipo;
    private String hora;

    /**
     *Constructor tipo vehiculo sin ningun parametro.
     */
    public Vehiculo(){
        matricula = "";
        modelo = "";
        color = "";
        tipo = "";
        hora = "";
    }

    /**
     *
     * @param matricula
     * @param modelo
     * @param color
     * @param tipo
     */
    public Vehiculo(String matricula, String modelo, String color, String tipo /*, String hora*/){
        this.matricula = matricula;
        this.modelo = modelo;
        this.color = color;
        this.tipo = tipo;
        //this.hora = hora;
    }

    /**
     *
     * @return
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     *
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     *
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     *
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.modelo = tipo;
    }

    /**
     *
     * @return
     */
    public String getHora() {
        return hora;
    }

    /**
     *
     * @param hora
     */
    public void setHora(String hora) {
        this.hora = hora;
    }



    @Override
    public String toString() {
        return "   Vehiculo: "
                + "\n { Tipo= " + tipo + "\n matricula = " + matricula + "\n modelo = " + modelo + "\n color = " + color + " }";
    }
}
