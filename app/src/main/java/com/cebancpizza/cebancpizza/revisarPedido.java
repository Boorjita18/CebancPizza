package com.cebancpizza.cebancpizza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class revisarPedido extends AppCompatActivity {
    TextView pedidoCompleto;
    TextView totalPedido;
    double total =0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revisar_pedido);
        pedidoCompleto   = (TextView)findViewById(R.id.resumenPedido);
        totalPedido   = (TextView)findViewById(R.id.totalPedido);
        escribirResumen();
    }

    public void escribirResumen(){
         ArrayList<Pizza> listaPizzas= ((Pedido) this.getApplication()).getListaPizzas();
         ArrayList<Bebida> listaBebidas=((Pedido) this.getApplication()).getListaBebidas();
         ArrayList<Postre> listaPostres= ((Pedido) this.getApplication()).getListaPostres();


         for(Pizza pizza:listaPizzas){
             pedidoCompleto.setText("X"+pizza.getCantidad()+"-"+pizza.getNombre() + pizza.getTamaño() + " masa " + pizza.getTipoMasa() + pizza.getCantidad()*pizza.getPrecio()+"\n");
             total+=pizza.getCantidad()*pizza.getPrecio();
         }
    totalPedido.setText(Double.toString(total));
    }

    public void volver(View v){
        finish();
    }
}
