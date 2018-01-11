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
            int cantCocacola;
            int cantLimon ;
            int cantRedbull ;
            int cantNestea ;
            int cantCerveza ;
            int cantAgua ;
            double precioCocacola;
            double precioLimon;
            double precioRedbull;
            double precioNestea;
            double precioCerveza;
            double precioAgua;
            double precioBebidas;

            @Override
            public void onClick(View view) {
                if (!editCocacola.getText().toString().equals("")) {
                    cantCocacola = Integer.parseInt(editCocacola.getText().toString());
                    precioCocacola = cantCocacola * 2.30;
                } else
                    precioCocacola = 0;

                if (!editLimon.getText().toString().equals("")) {
                    cantLimon = Integer.parseInt(editLimon.getText().toString());
                    precioLimon = cantLimon*2.10;
                } else
                    precioLimon =0;

                if (!editRedbull.getText().toString().equals("")) {
                    cantRedbull = Integer.parseInt(editRedbull.getText().toString());
                    precioRedbull = cantRedbull*3;
                } else
                    precioRedbull = 0;

                if (!editNestea.getText().toString().equals("")) {
                    cantNestea = Integer.parseInt(editNestea.getText().toString());
                    precioNestea = cantNestea*1.90;
                } else
                    precioNestea = 0;

                if (!editCerveza.getText().toString().equals("")) {
                    cantCerveza= Integer.parseInt(editCerveza.getText().toString());
                    precioCerveza = cantCerveza*2.20;
                } else
                    precioCerveza = 0;

                if (!editAgua.getText().toString().equals("")) {
                    cantAgua= Integer.parseInt(editAgua.getText().toString());
                    precioAgua= cantAgua*1.50;
                } else
                    precioAgua= 0;

                precioBebidas=precioCocacola+precioLimon+precioRedbull+precioNestea+precioCerveza+precioAgua;
            }
        });

    }

}
