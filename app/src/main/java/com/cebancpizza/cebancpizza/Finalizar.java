package com.cebancpizza.cebancpizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Finalizar extends AppCompatActivity {
    Intent i;
    TextView peluche;
    TextView vale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizar);
        i= getIntent();
        String confirmacionPedido="Pedido realizado correctamente\n\n";
        confirmacionPedido+=i.getStringExtra("texto");
        confirmacionPedido+="Total: "+i.getStringExtra("total")+"\n";


        if(Float.parseFloat(i.getStringExtra("total"))>30){
            confirmacionPedido+="\nRecibirás un peluche de muñeco android por compra superior a 30€";
            peluche=(TextView)findViewById(R.id.pelucheTexto);
            peluche.setVisibility(View.VISIBLE);
        }
        if(Float.parseFloat(i.getStringExtra("total"))>40){
            confirmacionPedido+="\nAdemás Recibirás un vale para comer en el comedor de Cebanc";
            vale=(TextView)findViewById(R.id.valeTexto);
            vale.setVisibility(View.VISIBLE);
        }

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,confirmacionPedido);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    public void finalizar(View v){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}
