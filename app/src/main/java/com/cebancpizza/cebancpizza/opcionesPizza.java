package com.cebancpizza.cebancpizza;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class opcionesPizza extends AppCompatActivity {

    Intent intent;
    TextView nombre;
    TextView precio;
    EditText cantidad;
    RadioGroup rgMasa;
    RadioGroup rgTamanno;
    String masa;
    double precioMasa;
    String tamanno;
    double precioTamanno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_pizza);

        intent = getIntent();
        nombre = (TextView)findViewById(R.id.textView29);
        precio = (TextView)findViewById(R.id.textView36);
        cantidad = (EditText) findViewById(R.id.editText13);
        rgMasa = (RadioGroup) findViewById(R.id.radioGroup2);
        rgTamanno = (RadioGroup) findViewById(R.id.radioGroup3);

        nombre.setText(intent.getStringExtra("Nombre"));
        precio.setText(intent.getStringExtra("Precio"));

        rgMasa.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId == R.id.radioButton) {
                    masa = "masa fina";
                    precioMasa = 0.00;
                } else if (checkedId == R.id.radioButton2) {
                    masa = "masa normal";
                    precioMasa = 1.00;
                }
                calcularPrecio();
            }
        });

        rgTamanno.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId == R.id.radioButton3) {
                    tamanno = "individual";
                    precioTamanno = 0.00;
                } else if (checkedId == R.id.radioButton5) {
                    tamanno = "mediana";
                    precioTamanno = 2.00;
                } else if (checkedId == R.id.radioButton6) {
                    tamanno = "familiar";
                    precioTamanno = 4.00;
                }
                calcularPrecio();
            }
        });
    }

    public void masUno() {
        int iCant;
        iCant = Integer.parseInt(cantidad.toString());
        iCant++;
        cantidad.setText(iCant);
        calcularPrecio();
    }

    public void menosUno() {
        int iCant;
        iCant = Integer.parseInt(cantidad.toString());
        iCant--;
        cantidad.setText(iCant);
        calcularPrecio();
    }

    public void calcularPrecio() {
        double precioTotal;
        precioTotal = (Double.parseDouble(intent.getStringExtra("Precio")) + precioMasa + precioTamanno) * Integer.parseInt(cantidad.toString());
        precio.setText(Double.toString(precioTotal));
    }

    public void anadirPizzaPedido(View v){
//        Pizza pizza = new Pizza(nombre.getText().toString(),"fina","individual",Double.parseDouble(precio.getText().toString()),1);
        Pizza pizza = new Pizza(nombre.getText().toString(),masa,tamanno,Double.parseDouble(nombre.getText().toString()),Integer.parseInt(cantidad.toString()));
        ((Pedido) this.getApplication()).anadirPizza(pizza);
        Intent intent = new Intent(this, ElegirPizza.class);

        startActivity(intent);
    }
}
