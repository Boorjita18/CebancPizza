package com.cebancpizza.cebancpizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class opcionesPizza extends AppCompatActivity {

    Intent intent;
    TextView nombre;
    TextView precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_pizza);

        intent = getIntent();
        nombre = (TextView)findViewById(R.id.textView29);
        precio = (TextView)findViewById(R.id.textView36);

        nombre.setText(intent.getStringExtra("Nombre"));
        precio.setText(intent.getStringExtra("Precio"));
    }


    public void anadirBarbacoa(View v){
        Pizza pizza = new Pizza(nombre.getText().toString(),"fina","individual",Double.parseDouble(precio.getText().toString()),1);
        ((Pedido) this.getApplication()).anadirPizza(pizza);
        Intent intent = new Intent(this, ElegirPizza.class);

        startActivity(intent);
    }
}
