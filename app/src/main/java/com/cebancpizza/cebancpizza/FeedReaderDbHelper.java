package com.cebancpizza.cebancpizza;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by adminportatil on 05/02/2018.
 */

public class FeedReaderDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "PizzeriaCebanc.db";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

          db.execSQL(SQL_CREATE_TABLA_USUARIO);
          db.execSQL(SQL_CREATE_TABLA_CABECERA_PEDIDO);
          db.execSQL(SQL_CREATE_TABLA_LINEA_PEDIDO);
          db.execSQL(SQL_CREATE_TABLA_PRODUCTO);
        db.execSQL(SQL_DATOS_PRODUCTOS);
      }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion>1) {
            db.execSQL(SQL_DELETE_TABLA_USUARIO);
            db.execSQL(SQL_DELETE_TABLA_CABECERA_PEDIDO);
            db.execSQL(SQL_DELETE_TABLA_LINEA_PEDIDO);
            db.execSQL(SQL_DELETE_TABLA_PRODUCTO);
            onCreate(db);
        }
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

    private static final String SQL_DATOS_PRODUCTOS =
            "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Barbacoa','Pizza','Masa fina','Individual',5), "+
                    " ('Barbacoa','Pizza','Masa normal','Individual',6), "+
                    " ('Barbacoa','Pizza','Masa fina','Mediana',7), "+
                    " ('Barbacoa','Pizza','Masa normal','Mediana',8), "+
                    " ('Barbacoa','Pizza','Masa fina','Familiar',9),"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Barbacoa','Pizza','Masa normal','Familiar',10);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Campiña','Pizza','Masa fina','Individual',6);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Campiña','Pizza','Masa normal','Individual',7);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Campiña','Pizza','Masa fina','Mediana',8);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Campiña','Pizza','Masa normal','Mediana',9);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Campiña','Pizza','Masa fina','Familiar',10);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Campiña','Pizza','Masa normal','Familiar',11);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Gourmet','Pizza','Masa fina','Individual',7.5);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Gpurmet','Pizza','Masa normal','Individual',8.5);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Gourmet','Pizza','Masa fina','Mediana',9.5);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Gourmet','Pizza','Masa normal','Mediana',10.5);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Gourmet','Pizza','Masa fina','Familiar',11.5);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Gourmet','Pizza','Masa normal','Familiar',12.5);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Hawaiana','Pizza','Masa fina','Individual',6);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Hawaiana','Pizza','Masa normal','Individual',7);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Hawaiana','Pizza','Masa fina','Mediana',8);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Hawaiana','Pizza','Masa normal','Mediana',9);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Hawaiana','Pizza','Masa fina','Familiar',10);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Hawaiana','Pizza','Masa normal','Familiar',11);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Jamon y Queso','Pizza','Masa fina','Individual',5);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Jamon y Queso','Pizza','Masa normal','Individual',6);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Jamon y Queso','Pizza','Masa fina','Mediana',7);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Jamon y Queso','Pizza','Masa normal','Mediana',8);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Jamon y Queso','Pizza','Masa fina','Familiar',9);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Jamon y Queso','Pizza','Masa normal','Familiar',10);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Sin Gluten','Pizza','Masa fina','Individual',6);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Sin Gluten','Pizza','Masa normal','Individual',7);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Sin Gluten','Pizza','Masa fina','Mediana',8);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Sin Gluten','Pizza','Masa normal','Mediana',9);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Sin GLuten','Pizza','Masa fina','Familiar',10);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Sin Gluten','Pizza','Masa normal','Familiar',11);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Pepperoni','Pizza','Masa fina','Individual',7);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Pepperoni','Pizza','Masa normal','Individual',8);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Pepperoni','Pizza','Masa fina','Mediana',9);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Pepperoni','Pizza','Masa normal','Mediana',10);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Pepperoni','Pizza','Masa fina','Familiar',11);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Pepperoni','Pizza','Masa normal','Familiar',12);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Pulled Beef','Pizza','Masa fina','Individual',7.5);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Pulled Beef','Pizza','Masa normal','Individual',8.5);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Pulled Beef','Pizza','Masa fina','Mediana',9.5);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Pulled Beef','Pizza','Masa normal','Mediana',10.5);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Pulled Beef','Pizza','Masa fina','Familiar',11.5);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Pulled Beef','Pizza','Masa normal','Familiar',12.5);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Coca Cola','Bebida',2.25);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Limon','Bebida',2.25);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Red Bull','Bebida',3);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Nestea','Bebida',2);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Cerveza','Bebida',2.25);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Agua','Bebida',1.5);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Chocolate','Tarta',3.25);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Hojaldre','Tarta',3.25);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Manzana','Tarta',3.5);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Chocolate','Helado',2);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Vainilla','Helado',2);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Yogurt','Helado',2);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Platano','Fruta',1.25);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Piña','Fruta',1.5);"+
                    "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Melón','Bebida',1.5);";

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
