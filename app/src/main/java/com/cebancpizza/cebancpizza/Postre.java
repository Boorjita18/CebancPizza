package com.cebancpizza.cebancpizza;

/**
 * Created by gorka on 10/01/2018.
 */

public class Postre {

    String nombre;
    int cantidad;
    Float precio;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    long id;

    public Postre(String nombre,int cantidad ,Float precio){
        this.nombre= nombre;
        this.cantidad=cantidad;
        this.precio=precio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Float getPrecio() {
        return precio;
    }
    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}