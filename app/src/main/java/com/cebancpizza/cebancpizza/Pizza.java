package com.cebancpizza.cebancpizza;

/**
 * Created by adminportatil on 19/12/2017.
 */

public class Pizza {
    String nombre;
    String tipoMasa;
    String tamaño;
    Double precio;
    int cantidad;
    public Pizza(){}

    public Pizza(String nombre,String tipoMasa,String tamaño,Double precio,int cantidad){
        this.nombre = nombre;
        this.tipoMasa = tipoMasa;
        this.tamaño = tamaño;
        this.precio = precio;
        this.cantidad = cantidad;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipoMasa() {
        return tipoMasa;
    }
    public void setTipoMasa(String tipoMasa) {
        this.tipoMasa = tipoMasa;
    }
    public String getTamaño() {
        return tamaño;
    }
    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


}
