package com.cebancpizza.cebancpizza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ElegirPizza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_pizza);
        Toast.makeText(this, ((Pedido) this.getApplication()).getUsuario().getNombre()+"\n" + ((Pedido) this.getApplication()).getUsuario().getDireccion(),
                Toast.LENGTH_SHORT).show();
    }
}
