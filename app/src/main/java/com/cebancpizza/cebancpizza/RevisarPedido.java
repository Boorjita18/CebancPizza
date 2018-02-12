package com.cebancpizza.cebancpizza;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import static com.cebancpizza.cebancpizza.R.string.direccion;
import static com.cebancpizza.cebancpizza.R.string.telefono;

public class RevisarPedido extends AppCompatActivity {
    TextView pedidoCompleto, totalPedido;
    Float total =Float.parseFloat("0.0");
    String texto="";
    Usuario u;
    Date fecha;
    long cabecera;
    long lineaUsuario;

    FeedReaderDbHelper conexion=null;
    ArrayList<Pizza> listaPizzas;
    ArrayList<Bebida> listaBebidas;
    ArrayList<Postre> listaPostres;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revisar_pedido);

        u = ((Pedido) this.getApplication()).getUsuario();
        lineaUsuario = u.getId();
        fecha = new Date();
        conexion = new FeedReaderDbHelper(getApplicationContext());
        pedidoCompleto = (TextView)findViewById(R.id.resumenPedido);
        totalPedido = (TextView)findViewById(R.id.totalPedido);
        listaPizzas= ((Pedido) this.getApplication()).getListaPizzas();
        listaBebidas=((Pedido) this.getApplication()).getListaBebidas();
        listaPostres= ((Pedido) this.getApplication()).getListaPostres();
        escribirResumen();
    }

    public void escribirResumen(){
         for(Pizza pizza:listaPizzas){
            texto+="X"+pizza.getCantidad()+"-"+pizza.getNombre() +" " + pizza.getTamaño() +" "+ pizza.getTipoMasa()+ " " + pizza.getCantidad()*pizza.getPrecio()+"\n";
            total+=pizza.getCantidad()*pizza.getPrecio();
         }
         for(Bebida bebida:listaBebidas){
             texto+="X"+bebida.getCantidad()+"-"+bebida.getNombre()+" " + bebida.getCantidad()*bebida.getPrecio()+"\n";
             total+=bebida.getCantidad()*bebida.getPrecio();
         }
         for(Postre postre:listaPostres){
             texto+="X"+postre.getCantidad()+"-"+postre.getNombre()+" " + postre.getCantidad()*postre.getPrecio()+"\n";
             total+=postre.getCantidad()*postre.getPrecio();
         }
         totalPedido.setText(Float.toString(total));
         pedidoCompleto.setText(texto);
    }

    public void volver(View v){
        finish();
    }
    public void finalizar(View v){

        try {
            SQLiteDatabase db = conexion.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(TablasBBDD.TablaCabeceraPedido.COLUMN_ID_USUARIO,lineaUsuario);
            values.put(TablasBBDD.TablaCabeceraPedido.COLUMN_FECHA,fecha.toString());

            cabecera = db.insert(TablasBBDD.TablaCabeceraPedido.TABLE_NAME, null, values);
        }catch (Exception e){
            Toast.makeText(this,"err insertar" +e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        for (Bebida bebida:listaBebidas) {
            try {
                SQLiteDatabase db = conexion.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(TablasBBDD.TablaLineaPedido.COLUMN_ID_CABECERA_PEDIDO, cabecera);
                values.put(TablasBBDD.TablaLineaPedido.COLUMN_ID_PRODUCTO,bebida.getId() );
                values.put(TablasBBDD.TablaLineaPedido.COLUMN_CANTIDAD,bebida.getCantidad() );
                values.put(TablasBBDD.TablaLineaPedido.COLUMN_PRECIO_LINEA,bebida.getPrecio() );


                long lineaBebida = db.insert(TablasBBDD.TablaLineaPedido.TABLE_NAME, null, values);
            } catch (Exception e) {
                Toast.makeText(this, "err insertar" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        for (Postre postre:listaPostres) {
            try {
                SQLiteDatabase db = conexion.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(TablasBBDD.TablaLineaPedido.COLUMN_ID_CABECERA_PEDIDO, cabecera);
                values.put(TablasBBDD.TablaLineaPedido.COLUMN_ID_PRODUCTO,postre.getId() );
                values.put(TablasBBDD.TablaLineaPedido.COLUMN_CANTIDAD,postre.getCantidad() );
                values.put(TablasBBDD.TablaLineaPedido.COLUMN_PRECIO_LINEA,postre.getPrecio() );

                long lineaPostre = db.insert(TablasBBDD.TablaLineaPedido.TABLE_NAME, null, values);
            } catch (Exception e) {
                Toast.makeText(this, "err insertar" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        for (Pizza pizza:listaPizzas) {
            try {
                SQLiteDatabase db = conexion.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(TablasBBDD.TablaLineaPedido.COLUMN_ID_CABECERA_PEDIDO, cabecera);
                values.put(TablasBBDD.TablaLineaPedido.COLUMN_ID_PRODUCTO,pizza.getId() );
                values.put(TablasBBDD.TablaLineaPedido.COLUMN_CANTIDAD,pizza.getCantidad() );
                values.put(TablasBBDD.TablaLineaPedido.COLUMN_PRECIO_LINEA,pizza.getPrecio() );
                values.put(TablasBBDD.TablaLineaPedido.COLUMN_ID_TAMANNO,pizza.getTamanoId() );
                values.put(TablasBBDD.TablaLineaPedido.COLUMN_ID_MASA,pizza.getMasaId() );


                long lineaPostre = db.insert(TablasBBDD.TablaLineaPedido.TABLE_NAME, null, values);
            } catch (Exception e) {
                Toast.makeText(this, "err insertar" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        Intent intent = new Intent(this, Finalizar.class);
        intent.putExtra("texto",texto);
        intent .putExtra("total", totalPedido.getText().toString());
        startActivity(intent);
    }
}