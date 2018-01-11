package com.cebancpizza.cebancpizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class datosUsuario extends AppCompatActivity {

    EditText nombreText;
    EditText apellidosText;
    EditText direccionText;
    EditText telefonoText;
    EditText emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuario);
    }

    public boolean comprobarUsuario(){
        boolean errores = false;
        String erroresTexto = "";
        String nombre = "";
        String apellidos = "";
        String email = "";
        String direccion = "";
        int telefono = 0;

        nombreText   = (EditText)findViewById(R.id.nombreUsuario);
        apellidosText   = (EditText)findViewById(R.id.apellidosUsuario);
        direccionText   = (EditText)findViewById(R.id.direccionUsuario);
        telefonoText   = (EditText)findViewById(R.id.telefonoUsuario);
        emailText   = (EditText)findViewById(R.id.emailUsuario);

        if (!nombreText.getText().toString().equals("")) {
            nombre = nombreText.getText().toString();
        }
        else{
            errores = true;
            erroresTexto+="El nombre es obligatorio\n";
        }

        if (!apellidosText.getText().toString().equals("")) {
            apellidos = apellidosText.getText().toString();
        }
        else{
            errores = true;
            erroresTexto+="El apellido es obligatorio\n";
        }

        if (!direccionText.getText().toString().equals("")) {
            direccion = direccionText.getText().toString();
        }
        else{
            errores = true;
            erroresTexto+="La dirección es obligatoria\n";
        }

        if (!telefonoText.getText().toString().equals("")) {
            telefono = Integer.parseInt(telefonoText.getText().toString());
        }
        else{
            errores = true;
            erroresTexto+="El teléfono es obligatorio\n";
        }
        if (!emailText.getText().toString().equals("")) {
            email = emailText.getText().toString();
        }
        else{
            errores = true;
            erroresTexto+="El Email es obligatorio\n";
        }
        if (!errores){
            Usuario u = new Usuario();
            u.setNombre(nombre);
            u.setApellidos(apellidos);
            u.setDireccion(direccion);
            u.setTelefono(telefono);
            u.setEmail(email);
            ((Pedido) this.getApplication()).setUsuairo(u);
        }else{
            Toast.makeText(this, erroresTexto,
                    Toast.LENGTH_SHORT).show();
        }

        return errores;
    }

    public void siguiente(View v){
        if (!comprobarUsuario()) {
            Intent intent = new Intent(this, ElegirPizza.class);
            startActivity(intent);
        }
    }

}
