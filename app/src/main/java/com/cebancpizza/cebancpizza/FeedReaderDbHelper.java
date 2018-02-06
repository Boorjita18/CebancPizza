package com.cebancpizza.cebancpizza;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adminportatil on 05/02/2018.
 */

public class FeedReaderDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "PizzeriaCebanc.db";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLA_USUARIO);
        db.execSQL(SQL_CREATE_TABLA_CABECERA_PEDIDO);
        db.execSQL(SQL_CREATE_TABLA_LINEA_PEDIDO);
        db.execSQL(SQL_CREATE_TABLA_PRODUCTO);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLA_USUARIO);
        db.execSQL(SQL_DELETE_TABLA_CABECERA_PEDIDO);
        db.execSQL(SQL_DELETE_TABLA_LINEA_PEDIDO);
        db.execSQL(SQL_DELETE_TABLA_PRODUCTO);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    // TABLA USUARIO
    private static final String SQL_CREATE_TABLA_USUARIO =
            "CREATE TABLE " + TablasBBDD.TablaUsuario.TABLE_NAME + " (" +
                    TablasBBDD.TablaUsuario.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    TablasBBDD.TablaUsuario.COLUMN_NOMBRE + " TEXT, " +
                    TablasBBDD.TablaUsuario.COLUMN_APELLIDOS + " TEXT, " +
                    TablasBBDD.TablaUsuario.COLUMN_TELEFONO + " TEXT, " +
                    TablasBBDD.TablaUsuario.COLUMN_DIRECCION + " TEXT, " +
                    TablasBBDD.TablaUsuario.COLUMN_EMAIL + " TEXT)";

    private static final String SQL_DELETE_TABLA_USUARIO =
            "DROP TABLE IF EXISTS " + TablasBBDD.TablaUsuario.TABLE_NAME;

    // TABLA CAECERA PEDIDO
    private static final String SQL_CREATE_TABLA_CABECERA_PEDIDO =
            "CREATE TABLE " + TablasBBDD.TablaCabeceraPedido.TABLE_NAME + " (" +
                    TablasBBDD.TablaCabeceraPedido.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    TablasBBDD.TablaCabeceraPedido.COLUMN_ID_USUARIO + " INTEGER," +
                    TablasBBDD.TablaCabeceraPedido.COLUMN_FECHA + " NUMERIC, " +
                    "FOREIGN KEY (" + TablasBBDD.TablaCabeceraPedido.COLUMN_ID_USUARIO + ") REFERENCES " + TablasBBDD.TablaUsuario.TABLE_NAME + "(" + TablasBBDD.TablaUsuario.COLUMN_ID + "))";

    private static final String SQL_DELETE_TABLA_CABECERA_PEDIDO =
            "DROP TABLE IF EXISTS " + TablasBBDD.TablaCabeceraPedido.TABLE_NAME;

    // TABLA LINEA PEDIDO
    private static final String SQL_CREATE_TABLA_LINEA_PEDIDO =
            "CREATE TABLE " + TablasBBDD.TablaLineaPedido.TABLE_NAME + " (" +
                    TablasBBDD.TablaLineaPedido.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    TablasBBDD.TablaLineaPedido.COLUMN_ID_CABECERA_PEDIDO + " INTEGER," +
                    TablasBBDD.TablaLineaPedido.COLUMN_ID_PRODUCTO + " INTEGER," +
                    TablasBBDD.TablaLineaPedido.COLUMN_CANTIDAD + " INTEGER," +
                    "FOREIGN KEY (" + TablasBBDD.TablaLineaPedido.COLUMN_ID_CABECERA_PEDIDO + ") REFERENCES " + TablasBBDD.TablaCabeceraPedido.TABLE_NAME + "(" + TablasBBDD.TablaCabeceraPedido.COLUMN_ID + "), " +
                    "FOREIGN KEY (" + TablasBBDD.TablaLineaPedido.COLUMN_ID_PRODUCTO + ") REFERENCES " + TablasBBDD.TablaProducto.TABLE_NAME + "(" + TablasBBDD.TablaProducto.COLUMN_ID + "))";

    private static final String SQL_DELETE_TABLA_LINEA_PEDIDO =
            "DROP TABLE IF EXISTS " + TablasBBDD.TablaLineaPedido.TABLE_NAME;

    // TABLA PRODUCTO
    private static final String SQL_CREATE_TABLA_PRODUCTO =
            "CREATE TABLE " + TablasBBDD.TablaProducto.TABLE_NAME + " (" +
                    TablasBBDD.TablaProducto.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    TablasBBDD.TablaProducto.COLUMN_NOMBRE + " TEXT, " +
                    TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO + " TEXT, " +
                    TablasBBDD.TablaProducto.COLUMN_TIPO_MASA + " TEXT, " +
                    TablasBBDD.TablaProducto.COLUMN_TAMANNO + " TEXT, " +
                    TablasBBDD.TablaProducto.COLUMN_PRECIO + " NUMERIC)";

    private static final String SQL_DELETE_TABLA_PRODUCTO =
            "DROP TABLE IF EXISTS " + TablasBBDD.TablaProducto.TABLE_NAME;
}