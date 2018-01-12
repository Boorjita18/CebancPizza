package com.cebancpizza.cebancpizza;


import android.content.Intent;
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
    Button btnPedido;

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
        btnPedido = (Button) findViewById(R.id.button2);

        btnSiguiente.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (editCocacola.getText().toString().isEmpty()) {
                    editCocacola.setText("0");
                }
                if (editLimon.getText().toString().isEmpty()) {
                    editLimon.setText("0");
                }
                if (editRedbull.getText().toString().isEmpty()) {
                    editRedbull.setText("0");
                }
                if (editNestea.getText().toString().isEmpty()) {
                    editNestea.setText("0");
                }
                if (editCerveza.getText().toString().isEmpty()) {
                    editCerveza.setText("0");
                }
                if (editAgua.getText().toString().isEmpty()) {
                    editAgua.setText("0");
                }
                añadirBebidasPedido("Coca Cola",Integer.parseInt(editCocacola.getText().toString()),Float.parseFloat("2.25"));
                añadirBebidasPedido("Limón",Integer.parseInt(editLimon.getText().toString()),Float.parseFloat("2.25"));
                añadirBebidasPedido("Red Bull",Integer.parseInt(editRedbull.getText().toString()),3);
                añadirBebidasPedido("Nestea",Integer.parseInt(editNestea.getText().toString()),Float.parseFloat("2.0") );
                añadirBebidasPedido("Cerveza",Integer.parseInt(editCerveza.getText().toString()),Float.parseFloat("2.25") );
                añadirBebidasPedido("Agua",Integer.parseInt(editAgua.getText().toString()),Float.parseFloat("1.5") );
                Intent intent = new Intent(ElegirBebida.this, ElegirPostre.class);
                startActivity(intent);

            }
        });

        btnPedido.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ElegirBebida.this, revisarPedido.class);
                startActivity(intent);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void añadirBebidasPedido(String s, int i, float v) {


//        Intent intent = new Intent(this, ElegirPizza.class);
//
//        startActivity(intent);
        Bebida bebida = new Bebida(s, i, v);

        ((Pedido) this.getApplication()).anadirBebida(bebida);
    }

}
