package com.cebancpizza.cebancpizza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ElegirPostre extends AppCompatActivity {
    EditText editTartaChoco;
    EditText editHojaldre;
    EditText editManzana;
    EditText editHeladoChoco;
    EditText editVainilla;
    EditText editYogurt;
    EditText editPlatano;
    EditText editPina;
    EditText editMelon;
    Button btnSiguiente;
    Button btnVolver;
    Button btnPedido;

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
                añadirPostrePedido("Tarta de Chocolate",Integer.parseInt(editTartaChoco.getText().toString()),Double.parseDouble("3.10"));
                añadirPostrePedido("Tarta de Hojaldre",Integer.parseInt(editHojaldre.getText().toString()),Double.parseDouble("3.30"));
                añadirPostrePedido("Tarta de Manzana",Integer.parseInt(editManzana.getText().toString()),Double.parseDouble("3.50"));
                añadirPostrePedido("Helado de Chocolate",Integer.parseInt(editHeladoChoco.getText().toString()),Double.parseDouble("2"));
                añadirPostrePedido("Helado de Vainilla",Integer.parseInt(editVainilla.getText().toString()),Double.parseDouble("2"));
                añadirPostrePedido("Helado de Yogurt",Integer.parseInt(editYogurt.getText().toString()),Double.parseDouble("2"));
                añadirPostrePedido("Platano",Integer.parseInt(editPlatano.getText().toString()),Double.parseDouble("1.20"));
                añadirPostrePedido("Piña",Integer.parseInt(editPina.getText().toString()),Double.parseDouble("1.60"));
                añadirPostrePedido("Melón",Integer.parseInt(editMelon.getText().toString()),Double.parseDouble("1.60"));
            }
        });

        btnPedido.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void añadirPostrePedido(String s, int i, double v) {
        Postre postre = new Postre(s, i, v);
        postre.setNombre(s);
        postre.setCantidad(i);
        postre.setPrecio(v);
        ((Pedido) this.getApplication()).anadirPostre(postre);
    }
}
