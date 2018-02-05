package com.cebancpizza.cebancpizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ElegirPostre extends AppCompatActivity {
    EditText editTartaChoco, editHojaldre, editManzana, editHeladoChoco, editVainilla, editYogurt, editPlatano, editPina, editMelon;
    Button btnSiguiente, btnVolver, btnPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_postre);

        editTartaChoco = (EditText) findViewById(R.id.editText3);
        editHojaldre = (EditText) findViewById(R.id.editText4);
        editManzana = (EditText) findViewById(R.id.editText5);
        editHeladoChoco = (EditText) findViewById(R.id.editText6);
        editVainilla = (EditText) findViewById(R.id.editText7);
        editYogurt = (EditText) findViewById(R.id.editText8);
        editPlatano = (EditText) findViewById(R.id.editText9);
        editPina = (EditText) findViewById(R.id.editText10);
        editMelon = (EditText) findViewById(R.id.editText11);
        btnSiguiente = (Button) findViewById(R.id.button7);
        btnVolver = (Button) findViewById(R.id.button5);
        btnPedido =(Button) findViewById(R.id.button);

        btnSiguiente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if (editTartaChoco.getText().toString().isEmpty()) {
                    editTartaChoco.setText("0");
                }
                if (editHojaldre.getText().toString().isEmpty()) {
                    editHojaldre.setText("0");
                }
                if (editManzana.getText().toString().isEmpty()) {
                    editManzana.setText("0");
                }
                if (editHeladoChoco.getText().toString().isEmpty()) {
                    editHeladoChoco.setText("0");
                }
                if (editVainilla.getText().toString().isEmpty()) {
                    editVainilla.setText("0");
                }
                if (editYogurt.getText().toString().isEmpty()) {
                    editYogurt.setText("0");
                }
                if (editPlatano.getText().toString().isEmpty()) {
                    editPlatano.setText("0");
                }
                if (editPina.getText().toString().isEmpty()) {
                    editPina.setText("0");
                }
                if (editMelon.getText().toString().isEmpty()) {
                    editMelon.setText("0");
                }
                añadirPostrePedido("Tarta de Chocolate",Integer.parseInt(editTartaChoco.getText().toString()),Float.parseFloat("3.25"));
                añadirPostrePedido("Tarta de Hojaldre",Integer.parseInt(editHojaldre.getText().toString()),Float.parseFloat("3.25"));
                añadirPostrePedido("Tarta de Manzana",Integer.parseInt(editManzana.getText().toString()),Float.parseFloat("3.50"));
                añadirPostrePedido("Helado de Chocolate",Integer.parseInt(editHeladoChoco.getText().toString()),2);
                añadirPostrePedido("Helado de Vainilla",Integer.parseInt(editVainilla.getText().toString()),2);
                añadirPostrePedido("Helado de Yogurt",Integer.parseInt(editYogurt.getText().toString()),2);
                añadirPostrePedido("Platano",Integer.parseInt(editPlatano.getText().toString()),Float.parseFloat("1.25"));
                añadirPostrePedido("Piña",Integer.parseInt(editPina.getText().toString()),Float.parseFloat("1.50"));
                añadirPostrePedido("Melón",Integer.parseInt(editMelon.getText().toString()),Float.parseFloat("1.50"));

                Intent intent = new Intent(ElegirPostre.this, RevisarPedido.class);
                startActivity(intent);
            }
        });

        btnPedido.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ElegirPostre.this, RevisarPedido.class);
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

    private void añadirPostrePedido(String s, int i, float v) {
        Postre postre = new Postre(s, i, v);
        ((Pedido) this.getApplication()).anadirPostre(postre);
    }
}