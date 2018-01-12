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

    public void anadirBarbacoa(View v) {
        Intent intent = new Intent(this, opcionesPizza.class);
        intent.putExtra("Nombre", "Barbacoa");
        intent.putExtra("Precio", "5.00");
        startActivity(intent);
    }

    public void anadirCampinna(View v) {
        Intent intent = new Intent(this, opcionesPizza.class);
        intent.putExtra("Nombre", "Campiña");
        intent.putExtra("Precio", "6.00");
        startActivity(intent);
    }

    public void anadirGourmet(View v) {
        Intent intent = new Intent(this, opcionesPizza.class);
        intent.putExtra("Nombre", "Gourmet");
        intent.putExtra("Precio", "7.50");
        startActivity(intent);
    }

    public void anadirHawaiana(View v) {
        Intent intent = new Intent(this, opcionesPizza.class);
        intent.putExtra("Nombre", "Hawaiana");
        intent.putExtra("Precio", "6.00");
        startActivity(intent);
    }

    public void anadirJamonQueso(View v) {
        Intent intent = new Intent(this, opcionesPizza.class);
        intent.putExtra("Nombre", "Jamón y Queso");
        intent.putExtra("Precio", "5.00");
        startActivity(intent);
    }

    public void anadirMargarita(View v) {
        Intent intent = new Intent(this, opcionesPizza.class);
        intent.putExtra("Nombre", "Margarita");
        intent.putExtra("Precio", "5.00");
        startActivity(intent);
    }

    public void anadirSinGluten(View v) {
        Intent intent = new Intent(this, opcionesPizza.class);
        intent.putExtra("Nombre", "Sin Gluten");
        intent.putExtra("Precio", "6.00");
        startActivity(intent);
    }

    public void anadirPepperoni(View v) {
        Intent intent = new Intent(this, opcionesPizza.class);
        intent.putExtra("Nombre", "Pepperoni");
        intent.putExtra("Precio", "7.00");
        startActivity(intent);
    }

    public void anadirPulledBeef(View v) {
        Intent intent = new Intent(this, opcionesPizza.class);
        intent.putExtra("Nombre", "Pulled Beef");
        intent.putExtra("Precio", "7.50");
        startActivity(intent);
    }

    public void revisarPedido(View v) {
        Intent intent = new Intent(this, revisarPedido.class);
        startActivity(intent);
    }

    public void volver(View v) {
        finish();
    }

    public void elegirBebida(View v) {
        Intent intent = new Intent(this, ElegirBebida.class);
        startActivity(intent);
    }
}