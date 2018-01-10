package com.cebancpizza.cebancpizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class datosUsuario extends AppCompatActivity {

    EditText textNombre;
    EditText textApellidos;
    EditText textDireccion;
    EditText textTelefono;
    EditText textEmail;
    Usuario u;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuario);


    }

    public void comprobarUsuario(){
        textNombre   = (EditText)findViewById(R.id.nombre);
        textApellidos   = (EditText)findViewById(R.id.apellidos);
        textDireccion   = (EditText)findViewById(R.id.direccion);
        textTelefono   = (EditText)findViewById(R.id.telefono);
        textEmail   = (EditText)findViewById(R.id.email);
        u= new Usuario(textNombre.getText().toString(),textApellidos.getText().toString(),Integer.parseInt(textTelefono.getText().toString()),textEmail.getText().toString(),textDireccion.getText().toString());
        ((Globales) this.getApplication()).anadirUsuario(u);


    }

    public void elegirPizza(View v){

        comprobarUsuario();
        Intent intent= new Intent(this, ElegirPizza.class);
        startActivity(intent);

    }

}
