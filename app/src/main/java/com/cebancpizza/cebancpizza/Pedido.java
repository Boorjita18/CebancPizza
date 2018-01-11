package com.cebancpizza.cebancpizza;

import java.util.ArrayList;

/**
 * Created by adminportatil on 11/01/2018.
 */

public class Pedido extends android.app.Application {

    private Usuario usuario;
    private ArrayList<Pizza> listaPizzas= new ArrayList<Pizza>();

    public void comprobarPizza(Pizza p){
        for (Pizza pizza : listaPizzas){

            if (pizza.getNombre().equals(p.getNombre()) && pizza.getTamaño().equals(p.getTamaño()) && pizza.getTipoMasa().equals(p.getTipoMasa()) ){
                listaPizzas.get(listaPizzas.indexOf(pizza)).anadirCantidad(p.cantidad);

            }
            else{
                listaPizzas.add(p);
            }

        }
    }


    public void anadirPizza(Pizza p){
        comprobarPizza(p);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuairo(Usuario usuario) {
        this.usuario = usuario;
    }
}
