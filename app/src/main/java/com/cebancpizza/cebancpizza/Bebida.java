package com.cebancpizza.cebancpizza;

/**
 * Created by gorka on 10/01/2018.
 */

public class Bebida {

    String nombre;
    int cantidad;
    float precio;
//    String imagen;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    long id;

    public Bebida(String nombre,int cantidad,float precio){
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
//    public Bebida(String nombre,int cantidad,float precio,String imagen){
//        this.nombre = nombre;
//        this.cantidad = cantidad;
//        this.precio = precio;
//        this.imagen=imagen;
//    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    public String getImagen() {
//        return imagen;
//    }

//    public void setImagen(String imagen) {
//        this.imagen = imagen;
//    }

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
