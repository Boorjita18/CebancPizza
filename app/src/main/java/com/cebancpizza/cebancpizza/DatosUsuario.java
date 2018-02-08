package com.cebancpizza.cebancpizza;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DatosUsuario extends AppCompatActivity {

    EditText usuarioText, nombreText, apellidosText, direccionText, telefonoText, emailText;
    FeedReaderDbHelper conexion = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuario);

        usuarioText = (EditText)findViewById(R.id.usuarioUsuario);
        nombreText = (EditText)findViewById(R.id.nombreUsuario);
        apellidosText = (EditText)findViewById(R.id.apellidosUsuario);
        direccionText = (EditText)findViewById(R.id.direccionUsuario);
        telefonoText = (EditText)findViewById(R.id.telefonoUsuario);
        emailText = (EditText)findViewById(R.id.emailUsuario);

        try {
            conexion = new FeedReaderDbHelper(getApplicationContext());
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public boolean comprobarUsuario() {
        boolean errores = false;
        String erroresTexto = "";
        String usuario = "";
        String nombre = "";
        String apellidos = "";
        String email = "";
        String direccion = "";
        int telefono = 0;

        if(!usuarioText.getText().toString().equals("")) {
            usuario = usuarioText.getText().toString();
        } else {
            errores = true;
            erroresTexto += "El usuario es obligatorio\n";
        }

        if(!nombreText.getText().toString().equals("")) {
            nombre = nombreText.getText().toString();
        } else {
            errores = true;
            erroresTexto += "El nombre es obligatorio\n";
        }

        if(!apellidosText.getText().toString().equals("")) {
            apellidos = apellidosText.getText().toString();
        } else {
            errores = true;
            erroresTexto += "El apellido es obligatorio\n";
        }

        if(!direccionText.getText().toString().equals("")) {
            direccion = direccionText.getText().toString();
        } else {
            errores = true;
            erroresTexto += "La dirección es obligatoria\n";
        }

        if(!telefonoText.getText().toString().equals("")) {
            telefono = Integer.parseInt(telefonoText.getText().toString());
        } else {
            errores = true;
            erroresTexto += "El teléfono es obligatorio\n";
        }

        if(!emailText.getText().toString().equals("")) {
            email = emailText.getText().toString();
        } else {
            errores = true;
            erroresTexto += "El Email es obligatorio\n";
        }

        if (!errores) {
            try {
                SQLiteDatabase db = conexion.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(TablasBBDD.TablaUsuario.COLUMN_USUARIO, usuario);
                values.put(TablasBBDD.TablaUsuario.COLUMN_NOMBRE, nombre);
                values.put(TablasBBDD.TablaUsuario.COLUMN_APELLIDOS, apellidos);
                values.put(TablasBBDD.TablaUsuario.COLUMN_DIRECCION, direccion);
                values.put(TablasBBDD.TablaUsuario.COLUMN_TELEFONO, telefono);
                values.put(TablasBBDD.TablaUsuario.COLUMN_EMAIL, email);

                long nuevaLinea = db.insert(TablasBBDD.TablaUsuario.TABLE_NAME, null, values);
            }catch (Exception e){
                Toast.makeText(this,"err insertar" +e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            Usuario u = new Usuario();
            u.setUsuario(usuario);
            u.setNombre(nombre);
            u.setApellidos(apellidos);
            u.setDireccion(direccion);
            u.setTelefono(telefono);
            u.setEmail(email);
            ((Pedido) this.getApplication()).setUsuairo(u);
        } else {
            Toast.makeText(this, erroresTexto, Toast.LENGTH_SHORT).show();
        }

        return errores;
    }

    public void siguiente(View v) {
        if(!comprobarUsuario()) {
            Intent intent = new Intent(this, ElegirPizza.class);
            startActivity(intent);
        }
    }
    public void volver(View v){
        finish();
    }

    public void buscar(View v) {
        SQLiteDatabase db = conexion.getReadableDatabase();

        String[] projection = {
                TablasBBDD.TablaUsuario.COLUMN_ID,
                TablasBBDD.TablaUsuario.COLUMN_USUARIO,
                TablasBBDD.TablaUsuario.COLUMN_NOMBRE,
                TablasBBDD.TablaUsuario.COLUMN_APELLIDOS,
                TablasBBDD.TablaUsuario.COLUMN_TELEFONO,
                TablasBBDD.TablaUsuario.COLUMN_DIRECCION,
                TablasBBDD.TablaUsuario.COLUMN_EMAIL
        };

        String selection = TablasBBDD.TablaUsuario.COLUMN_USUARIO + " = ?";
        String[] selectionArgs = { usuarioText.getText().toString() };

        Cursor cursor = db.query(
                TablasBBDD.TablaUsuario.TABLE_NAME,       // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                      // The sort order
        );

        while(cursor.moveToNext()) {
            Usuario u = new Usuario();
            u.setUsuario(cursor.getString(cursor.getColumnIndex(TablasBBDD.TablaUsuario.COLUMN_USUARIO)));
            u.setNombre(cursor.getString(cursor.getColumnIndex(TablasBBDD.TablaUsuario.COLUMN_NOMBRE)));
            u.setApellidos(cursor.getString(cursor.getColumnIndex(TablasBBDD.TablaUsuario.COLUMN_APELLIDOS)));
            u.setDireccion(cursor.getString(cursor.getColumnIndex(TablasBBDD.TablaUsuario.COLUMN_DIRECCION)));
            u.setTelefono(cursor.getInt(cursor.getColumnIndex(TablasBBDD.TablaUsuario.COLUMN_TELEFONO)));
            u.setEmail(cursor.getString(cursor.getColumnIndex(TablasBBDD.TablaUsuario.COLUMN_EMAIL)));
            ((Pedido) this.getApplication()).setUsuairo(u);

            nombreText.setText(u.getNombre());
            apellidosText.setText(u.getApellidos());
            direccionText.setText(u.getDireccion());
            telefonoText.setText(String.valueOf(u.getTelefono()));
            emailText.setText(u.getEmail());
        }
        cursor.close();
    }
}