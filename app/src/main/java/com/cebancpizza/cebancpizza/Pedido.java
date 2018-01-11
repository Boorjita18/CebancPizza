package com.cebancpizza.cebancpizza;

import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by adminportatil on 11/01/2018.
 */

public class Pedido extends android.app.Application {

    private Usuario usuario;
    private ArrayList<Pizza> listaPizzas= new ArrayList<Pizza>();
    private ArrayList<Bebida> listaBebidas= new ArrayList<Bebida>();
    private ArrayList<Postre> listaPostres= new ArrayList<Postre>();

    public void comprobarPizza(Pizza p){
        boolean modificado = false;
        for (Pizza pizza : listaPizzas){

            if (pizza.getNombre().equals(p.getNombre()) && pizza.getTamaño().equals(p.getTamaño()) && pizza.getTipoMasa().equals(p.getTipoMasa()) ){
                listaPizzas.get(listaPizzas.indexOf(pizza)).anadirCantidad(p.cantidad);
                Toast.makeText(this, "añadido pizza " +listaPizzas.get(listaPizzas.indexOf(pizza)).getNombre()+"\ntotal: "+listaPizzas.get(listaPizzas.indexOf(pizza)).getCantidad(),
                        Toast.LENGTH_SHORT).show();
                modificado = true;
            }
        }
        if (!modificado){
            listaPizzas.add(p);
            Toast.makeText(this, "añadida nueva pizza "+ p.getNombre(),
                    Toast.LENGTH_SHORT).show();
        }
    }


    public void anadirPizza(Pizza p){
        if (listaPizzas.size()>0) {
            comprobarPizza(p);
        }else{
            listaPizzas.add(p);
            Toast.makeText(this, "añadida nueva pizza "+ p.getNombre(),
                    Toast.LENGTH_SHORT).show();
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuairo(Usuario usuario) {
        this.usuario = usuario;
    }

    public void borrarBebida(Bebida b){
        for (Bebida bebida : listaBebidas){

            if (bebida.getNombre().equals(b.getNombre())){
                listaPizzas.remove(bebida);
            }
        }
    }

    public void anadirBebida(Bebida b){
        if (b.cantidad==0) {
            borrarBebida(b);
        }else{
            boolean modificado=false;
            for (Bebida bebida : listaBebidas){

                if (bebida.getNombre().equals(b.getNombre())){
                    listaBebidas.get(listaBebidas.indexOf(bebida)).setCantidad(b.cantidad);
                }
            }
            if (!modificado){
                listaBebidas.add(b);
            }
        }
    }
    public void borrarPostre(Postre p){
        for (Postre postre : listaPostres){

            if (postre.getNombre().equals(p.getNombre())){
                listaPostres.remove(postre);
            }
        }
    }

    public void anadirPostre(Postre p){
        if (p.cantidad==0) {
            borrarPostre(p);
        }else{
            boolean modificado=false;
            for (Postre postre : listaPostres){

                if (postre.getNombre().equals(p.getNombre())){
                    listaPostres.get(listaPostres.indexOf(postre)).setCantidad(p.cantidad);
                }
            }
            if (!modificado){
                listaPostres.add(p);
            }
        }
    }

}
