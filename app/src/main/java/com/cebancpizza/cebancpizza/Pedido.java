package com.cebancpizza.cebancpizza;

/**
 * Created by gorka on 10/01/2018.
 */

public class Pedido {
    Usuario usuario;
    Pizza[] listaPizzas;
    Postre[] listaPostres;
    Bebida[] listaBebidas;

    public Pedido(){
    }

    public void anadirUsuario(Usuario usuario){
        this.usuario=usuario;
    }

    public Usuario getUsuario(){
        return usuario;
    }

}
