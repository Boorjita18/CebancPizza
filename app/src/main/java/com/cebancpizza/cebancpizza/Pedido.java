package com.cebancpizza.cebancpizza;

import android.widget.Toast;

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
                Toast.makeText(this, "añadido pizza " +listaPizzas.get(listaPizzas.indexOf(pizza)).getNombre()+"\ntotal: "+listaPizzas.get(listaPizzas.indexOf(pizza)).getCantidad(),
                        Toast.LENGTH_SHORT).show();
            }
            else{
                listaPizzas.add(p);
                Toast.makeText(this, "añadida nueva pizza "+ p.getNombre(),
                        Toast.LENGTH_SHORT).show();
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
