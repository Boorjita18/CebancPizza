package com.cebancpizza.cebancpizza;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MostrarPedidos extends AppCompatActivity {
    Spinner spinner;
    FeedReaderDbHelper conexion = null;
    ArrayList<Usuario>listaUsuarios = new ArrayList<>();
    TextView textoPedidos;
    String texto="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_pedidos);

        textoPedidos = (TextView)findViewById(R.id.textoPedidos);

        spinner = (Spinner) findViewById(R.id.spinner);
        cargarUsuarios();
        ArrayAdapter<Usuario> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,listaUsuarios);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                texto="";

                Usuario usuarioElejido = (Usuario) spinner.getSelectedItem(); // Object which was selected.
                mostrarPedidoUsuario(usuarioElejido.getId());
        } @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }

        });
    }

    public void mostrarPedidoUsuario(Long id){
        ArrayList<Long> idCabecera = new ArrayList<>();
        float totalPedido=0;
        conexion = new FeedReaderDbHelper(getApplicationContext());
        SQLiteDatabase db = conexion.getReadableDatabase();

        String[] projection = {
                TablasBBDD.TablaCabeceraPedido.COLUMN_ID,
                TablasBBDD.TablaCabeceraPedido.COLUMN_ID_USUARIO
        };

        String selection = TablasBBDD.TablaCabeceraPedido.COLUMN_ID_USUARIO + " = ?";
        String[] selectionArgs = {String.valueOf(id)};

        Cursor cursor = db.query(
                TablasBBDD.TablaCabeceraPedido.TABLE_NAME,       // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                      // The sort order
        );
        while(cursor.moveToNext()) {
            idCabecera.add(cursor.getLong(cursor.getColumnIndex(TablasBBDD.TablaCabeceraPedido.COLUMN_ID)));
        }

        for(int i =0;i<idCabecera.size();i++){
            totalPedido=0;
            SQLiteDatabase dbU = conexion.getReadableDatabase();

            String[] projectionU = {
                    TablasBBDD.TablaLineaPedido.COLUMN_ID,
                    TablasBBDD.TablaLineaPedido.COLUMN_ID_PRODUCTO,
                    TablasBBDD.TablaLineaPedido.COLUMN_ID_MASA,
                    TablasBBDD.TablaLineaPedido.COLUMN_ID_TAMANNO,
                    TablasBBDD.TablaLineaPedido.COLUMN_CANTIDAD,
                    TablasBBDD.TablaLineaPedido.COLUMN_PRECIO_LINEA,
                    TablasBBDD.TablaLineaPedido.COLUMN_ID_CABECERA_PEDIDO,
                    TablasBBDD.TablaProducto.COLUMN_NOMBRE,
                    TablasBBDD.TablaMasa.COLUMN_NOMBRE,
                    TablasBBDD.TablaTamanno.COLUMN_NOMBRE
            };

//            String selectionU =TablasBBDD.TablaLineaPedido.COLUMN_ID_PRODUCTO + "=" + TablasBBDD.TablaProducto.COLUMN_ID +" AND "+ TablasBBDD.TablaLineaPedido.COLUMN_ID_CABECERA_PEDIDO + " = ?";
            String selectionU =TablasBBDD.TablaLineaPedido.COLUMN_ID_CABECERA_PEDIDO + " = ?";
            String[] selectionArgsU = {String.valueOf(idCabecera.get(i))};

            Cursor cursorU = dbU.query(
                    TablasBBDD.TablaLineaPedido.TABLE_NAME +" LEFT OUTER JOIN "+TablasBBDD.TablaProducto.TABLE_NAME +" ON " +TablasBBDD.TablaLineaPedido.COLUMN_ID_PRODUCTO + "=" + TablasBBDD.TablaProducto.COLUMN_ID+" LEFT OUTER JOIN "+TablasBBDD.TablaMasa.TABLE_NAME +" ON " +TablasBBDD.TablaLineaPedido.COLUMN_ID_MASA + "=" + TablasBBDD.TablaMasa.COLUMN_ID+" LEFT OUTER JOIN "+TablasBBDD.TablaTamanno.TABLE_NAME +" ON " +TablasBBDD.TablaLineaPedido.COLUMN_ID_TAMANNO + "=" + TablasBBDD.TablaTamanno.COLUMN_ID,       // The table to query
                    projectionU,                               // The columns to return
                    selectionU,                                // The columns for the WHERE clause
                    selectionArgsU,                            // The values for the WHERE clause
                    null,                                     // don't group the rows
                    null,                                     // don't filter by row groups
                    null                                      // The sort order
            );
            texto+="Pedido Nº:"+ String.valueOf(idCabecera.get(i))+"\n";
            texto += "____________________\n";
            while(cursorU.moveToNext()) {
                texto+= "X"+ cursorU.getInt(cursorU.getColumnIndex( TablasBBDD.TablaLineaPedido.COLUMN_CANTIDAD))+"-";
                texto+= cursorU.getString(cursorU.getColumnIndex( TablasBBDD.TablaProducto.COLUMN_NOMBRE))+" ";
                texto+= cursorU.getString(cursorU.getColumnIndex(TablasBBDD.TablaTamanno.COLUMN_NOMBRE))+" ";
                texto+= cursorU.getString(cursorU.getColumnIndex(TablasBBDD.TablaMasa.COLUMN_NOMBRE))+" ";
                texto+= cursorU.getInt(cursorU.getColumnIndex(TablasBBDD.TablaLineaPedido.COLUMN_CANTIDAD))*cursorU.getFloat(cursorU.getColumnIndex(TablasBBDD.TablaLineaPedido.COLUMN_PRECIO_LINEA))+"€\n";
                totalPedido+=cursorU.getInt(cursorU.getColumnIndex(TablasBBDD.TablaLineaPedido.COLUMN_CANTIDAD))*cursorU.getFloat(cursorU.getColumnIndex(TablasBBDD.TablaLineaPedido.COLUMN_PRECIO_LINEA));

            }
            cursorU.close();
            texto+="____________________\n";
            texto += "Total del Pedido: "+ totalPedido +" €\n\n";
            texto= texto.replaceAll("null", " " );
        }
        textoPedidos.setText(texto);
        cursor.close();

    }

    public void cargarUsuarios(){
        conexion = new FeedReaderDbHelper(getApplicationContext());
        SQLiteDatabase db = conexion.getReadableDatabase();

        String[] projection = {
                TablasBBDD.TablaCabeceraPedido.COLUMN_ID,
                TablasBBDD.TablaCabeceraPedido.COLUMN_ID_USUARIO
        };

//        String selection = TablasBBDD.TablaUsuario.COLUMN_USUARIO + " = ?";
//        String[] selectionArgs = {usuarioText.getText().toString()};

        Cursor cursor = db.query(
                TablasBBDD.TablaCabeceraPedido.TABLE_NAME,       // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                      // The sort order
        );

        if (cursor.moveToFirst() == false) {
            Toast.makeText(this, "No hay pedidos de  usuarios", Toast.LENGTH_LONG).show();
        }else{
        ArrayList<Long> idUsuario = new ArrayList<>();

        while(cursor.moveToNext()) {
//            Toast.makeText(this, String.valueOf(cursor.getLong(cursor.getColumnIndex(TablasBBDD.TablaCabeceraPedido.COLUMN_ID_USUARIO))), Toast.LENGTH_LONG).show();
            if (!idUsuario.contains(cursor.getLong(cursor.getColumnIndex(TablasBBDD.TablaCabeceraPedido.COLUMN_ID_USUARIO)))){
                    idUsuario.add(cursor.getLong(cursor.getColumnIndex(TablasBBDD.TablaCabeceraPedido.COLUMN_ID_USUARIO)));
//                Toast.makeText(this, String.valueOf(cursor.getLong(cursor.getColumnIndex(TablasBBDD.TablaCabeceraPedido.COLUMN_ID_USUARIO))), Toast.LENGTH_LONG).show();
            }
        }
        for(int i =0;i<idUsuario.size();i++){
            SQLiteDatabase dbU = conexion.getReadableDatabase();

            String[] projectionU = {
                    TablasBBDD.TablaUsuario.COLUMN_ID,
                    TablasBBDD.TablaUsuario.COLUMN_NOMBRE
            };

        String selectionU = TablasBBDD.TablaUsuario.COLUMN_ID + " = ?";
        String[] selectionArgsU = {String.valueOf(idUsuario.get(i))};

            Cursor cursorU = dbU.query(
                    TablasBBDD.TablaUsuario.TABLE_NAME,       // The table to query
                    projectionU,                               // The columns to return
                    selectionU,                                // The columns for the WHERE clause
                    selectionArgsU,                            // The values for the WHERE clause
                    null,                                     // don't group the rows
                    null,                                     // don't filter by row groups
                    null                                      // The sort order
            );
            while(cursorU.moveToNext()) {
                Usuario u = new Usuario();
                u.setId(cursorU.getLong(cursorU.getColumnIndex(TablasBBDD.TablaUsuario.COLUMN_ID)));
                u.setNombre(cursorU.getString(cursorU.getColumnIndex(TablasBBDD.TablaUsuario.COLUMN_NOMBRE)));
                listaUsuarios.add(u);
            }
            cursorU.close();
        }
        }
        cursor.close();

    }


    public void finalizar(View v){

        ((Pedido) this.getApplication()).borrarPedido();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
