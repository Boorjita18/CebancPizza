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
        Toast.makeText(this, ((Pedido) this.getApplication()).getUsuario().getNombre()+"\n" + ((Pedido) this.getApplication()).getUsuario().getDireccion(),
                Toast.LENGTH_SHORT).show();
    }


    public void anadirBarbacoa(View v){
            Intent intent = new Intent(this, opcionesPizza.class);
            intent.putExtra("Nombre", "Barbacoa");
            intent.putExtra("Precio", "5,00");
            startActivity(intent);
    }
}
