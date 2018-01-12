package com.cebancpizza.cebancpizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class revisarPedido extends AppCompatActivity {
    TextView pedidoCompleto;
    TextView totalPedido;
    Float total =Float.parseFloat("0.0");
    String texto="";
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
            texto+="X"+pizza.getCantidad()+"-"+pizza.getNombre() +" " + pizza.getTamaño() +" "+ pizza.getTipoMasa()+ " " + pizza.getCantidad()*pizza.getPrecio()+"\n";
            total+=pizza.getCantidad()*pizza.getPrecio();
        }
        for(Bebida bebida:listaBebidas){
            texto+="X"+bebida.getCantidad()+"-"+bebida.getNombre()+" " + bebida.getCantidad()*bebida.getPrecio()+"\n";
            total+=bebida.getCantidad()*bebida.getPrecio();
        }
        for(Postre postre:listaPostres){
            texto+="X"+postre.getCantidad()+"-"+postre.getNombre()+" " + postre.getCantidad()*postre.getPrecio()+"\n";
            total+=postre.getCantidad()*postre.getPrecio();
        }
        totalPedido.setText(Float.toString(total));
        pedidoCompleto.setText(texto);
    }

    public void volver(View v){
        finish();
    }
    public void finalizar(View v){

        Intent intent = new Intent(this, Finalizar.class);
        intent.putExtra("texto",texto);
        intent .putExtra("total", totalPedido.getText().toString());
        startActivity(intent);
    }
}
