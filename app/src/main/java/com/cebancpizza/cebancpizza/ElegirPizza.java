package com.cebancpizza.cebancpizza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ElegirPizza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_pizza);
        Usuario u = ((Globales) this.getApplication()).getUsuario();
        Toast.makeText(getApplicationContext(),u.nombre +" " + u.apellidos, Toast.LENGTH_SHORT).show();
    }
}
