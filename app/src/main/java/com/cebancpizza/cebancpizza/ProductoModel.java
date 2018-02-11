package com.cebancpizza.cebancpizza;

/**
 * Created by gorka on 10/02/2018.
 */

public class ProductoModel {

String nombre;
String descripcion;
Float precio;
String imagen;
Long id;
public ProductoModel(){}
public ProductoModel( String nombre, String descripcion, Float precio, String imagen, Long id){

    this.nombre=nombre;
    this.descripcion=descripcion;
    this.precio=precio;
    this.imagen=imagen;
    this.id=id;

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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
