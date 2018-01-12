package com.cebancpizza.cebancpizza;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ElegirBebida extends AppCompatActivity {
    EditText editCocacola;
    EditText editLimon;
    EditText editRedbull;
    EditText editNestea;
    EditText editCerveza;
    EditText editAgua;
    Button btnSiguiente;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_bebida);

        editCocacola = (EditText) findViewById(R.id.editText);
        editLimon = (EditText) findViewById(R.id.editText1);
        editRedbull = (EditText) findViewById(R.id.editText2);
        editNestea = (EditText) findViewById(R.id.editText3);
        editCerveza = (EditText) findViewById(R.id.editText4);
        editAgua = (EditText) findViewById(R.id.editText5);
        btnSiguiente = (Button) findViewById(R.id.button4);
        btnVolver = (Button) findViewById(R.id.button3);

        btnSiguiente.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                añadirBebidasPedido("Coca Cola",Integer.parseInt(editCocacola.getText().toString()),Double.parseDouble("2.20"));
                añadirBebidasPedido("Limón",Integer.parseInt(editLimon.getText().toString()),Double.parseDouble("2.20") );
                añadirBebidasPedido("Red Bull",Integer.parseInt(editRedbull.getText().toString()),Double.parseDouble("3") );
                añadirBebidasPedido("Nestea",Integer.parseInt(editNestea.getText().toString()),Double.parseDouble("2.10") );
                añadirBebidasPedido("Cerveza",Integer.parseInt(editCerveza.getText().toString()),Double.parseDouble("2.30") );
                añadirBebidasPedido("Agua",Integer.parseInt(editAgua.getText().toString()),Double.parseDouble("1.50") );


            }
        });

    }

    private void añadirBebidasPedido(String s, int i, double v) {


        Bebida bebida = new Bebida(s, i, v);
        bebida.setNombre(s);
        bebida.setCantidad(i);
        bebida.setPrecio(v);
        ((Pedido) this.getApplication()).anadirBebida(bebida);
//        Intent intent = new Intent(this, ElegirPizza.class);
//
//        startActivity(intent);
    }

}
