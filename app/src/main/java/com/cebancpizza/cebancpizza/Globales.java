package com.cebancpizza.cebancpizza;

/**
 * Created by gorka on 10/01/2018.
 */

public class Globales extends android.app.Application {
    Usuario usuario;
    Pizza[] listaPizzas;
    Postre[] listaPostres;
    Bebida[] listaBebidas;

    public void anadirUsuario(Usuario usuario){
        this.usuario=usuario;
    }

    public Usuario getUsuario(){
        return usuario;
    }
}