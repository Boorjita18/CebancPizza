package com.cebancpizza.cebancpizza;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adminportatil on 02/02/2018.
 */

public class BaseDeDatos extends SQLiteOpenHelper {

    String sqlCreate_usuario = "CREATE TABLE Usuario (usuarioId INTEGER, nombre TEXT, apellidos TEXT, telefono TEXT, direccion TEXT, email TEXT)";
    String sqlCreate_pedidoCabecera= "CREATE TABLE PedidoCabecera (cabeceraId INTEGER, fecha NUMERIC)";
    String sqlCreate_pedidoLinea = "CREATE TABLE PedidoLinea (lineaId INTEGER, cantidad NUMERIC)";
    String sqlCreate_producto = "CREATE TABLE Producto (productoId INTEGER, nombre TEXT, tipoProducto TEXT, tipoMasa TEXT, tamano TEXT, precio NUMERIC)";

    public BaseDeDatos(Context contexto, String nombre,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
