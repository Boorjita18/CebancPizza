package com.cebancpizza.cebancpizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ElegirPizza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_pizza);

    }


    public void anadirBarbacoa(View v){
            Intent intent = new Intent(this, opcionesPizza.class);
            intent.putExtra("Nombre", "Barbacoa");
            intent.putExtra("Precio", "5,00");
            startActivity(intent);
    }
    public void revisarPedido(View v){
        Intent intent = new Intent(this, revisarPedido.class);
        startActivity(intent);
    }
    public void volver(View v){
        finish();
    }
}
