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

        btnSiguiente.setOnClickListener(new View.OnClickListener(){
            int cantTartaChoco;
            int cantHojaldre ;
            int cantManzana ;
            int cantHeladoChoco ;
            int cantVainilla ;
            int cantYogurt ;
            int cantPlatano ;
            int cantPina ;
            int cantMelon ;
            double precioTartaChoco;
            double precioHojaldre;
            double precioManzana;
            double precioHeladoChoco;
            double precioVainilla;
            double precioYogurt;
            double precioPlatano;
            double precioPina;
            double precioMelon;
            double precioPostres;


            @Override
            public void onClick(View view) {
                if (!editTartaChoco.getText().toString().equals("")) {
                    cantTartaChoco= Integer.parseInt(editTartaChoco.getText().toString());
                    precioTartaChoco = cantTartaChoco * 3.10;
                } else
                    precioTartaChoco = 0;

                if (!editHojaldre.getText().toString().equals("")) {
                    cantHojaldre = Integer.parseInt(editHojaldre.getText().toString());
                    precioHojaldre = cantHojaldre*3.30;
                } else
                    precioHojaldre =0;

                if (!editManzana.getText().toString().equals("")) {
                    cantManzana = Integer.parseInt(editManzana.getText().toString());
                    precioManzana = cantManzana*3.50;
                } else
                    precioManzana = 0;

                if (!editHeladoChoco.getText().toString().equals("")) {
                    cantHeladoChoco = Integer.parseInt(editHeladoChoco.getText().toString());
                    precioHeladoChoco= cantHeladoChoco*2;
                } else
                    precioHeladoChoco= 0;

                if (!editVainilla.getText().toString().equals("")) {
                    cantVainilla= Integer.parseInt(editVainilla.getText().toString());
                    precioVainilla= cantVainilla*2;
                } else
                    precioVainilla= 0;

                if (!editYogurt.getText().toString().equals("")) {
                    cantYogurt= Integer.parseInt(editYogurt.getText().toString());
                    precioYogurt = cantYogurt*2;
                } else
                    precioYogurt = 0;

                if (!editPlatano.getText().toString().equals("")) {
                    cantPlatano= Integer.parseInt(editPlatano.getText().toString());
                    precioPlatano= cantPlatano*1.20;
                } else
                    precioPlatano= 0;

                if (!editPina.getText().toString().equals("")) {
                    cantPina= Integer.parseInt(editPina.getText().toString());
                    precioPina= cantPina*1.60;
                } else
                    precioPina= 0;

                if (!editMelon.getText().toString().equals("")) {
                    cantMelon= Integer.parseInt(editMelon.getText().toString());
                    precioMelon= cantMelon*1.60;
                } else
                    precioMelon= 0;

                precioPostres=precioTartaChoco+precioHojaldre+precioManzana+precioHeladoChoco+precioVainilla+precioYogurt+precioPlatano+precioPina+precioMelon;
            }
        });
    }
}
