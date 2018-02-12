package com.cebancpizza.cebancpizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MostrarPedidos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_pedidos);
    }



    public void finalizar(View v){

        ((Pedido) this.getApplication()).borrarPedido();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
