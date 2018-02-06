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

        db.execSQL(SQL_CREATE_TABLA_PRODUCTO);
          db.execSQL(SQL_CREATE_TABLA_USUARIO);
          db.execSQL(SQL_CREATE_TABLA_CABECERA_PEDIDO);
          db.execSQL(SQL_CREATE_TABLA_LINEA_PEDIDO);
        db.execSQL(SQL_DATOS_PIZZAS);
        db.execSQL(SQL_DATOS_COMPLEMENTO);

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

    private static final String SQL_DATOS_PIZZAS =
            "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE+","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_TIPO_MASA +","+TablasBBDD.TablaProducto.COLUMN_TAMANNO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES ('Barbacoa','Pizza','Masa fina','Individual',5), ('Barbacoa','Pizza','Masa normal','Individual',6), ('Barbacoa','Pizza','Masa fina','Mediana',7), ('Barbacoa','Pizza','Masa normal','Mediana',8), ('Barbacoa','Pizza','Masa fina','Familiar',9), ('Barbacoa','Pizza','Masa normal','Familiar',10), ('Campiña','Pizza','Masa fina','Individual',6), ('Campiña','Pizza','Masa normal','Individual',7), ('Campiña','Pizza','Masa fina','Mediana',8), ('Campiña','Pizza','Masa normal','Mediana',9), ('Campiña','Pizza','Masa fina','Familiar',10), ('Campiña','Pizza','Masa normal','Familiar',11), ('Gourmet','Pizza','Masa fina','Individual',7.5), ('Gpurmet','Pizza','Masa normal','Individual',8.5), ('Gourmet','Pizza','Masa fina','Mediana',9.5), ('Gourmet','Pizza','Masa normal','Mediana',10.5), ('Gourmet','Pizza','Masa fina','Familiar',11.5), ('Gourmet','Pizza','Masa normal','Familiar',12.5), ('Hawaiana','Pizza','Masa fina','Individual',6), ('Hawaiana','Pizza','Masa normal','Individual',7),  ('Hawaiana','Pizza','Masa fina','Mediana',8), ('Hawaiana','Pizza','Masa normal','Mediana',9), ('Hawaiana','Pizza','Masa fina','Familiar',10), ('Hawaiana','Pizza','Masa normal','Familiar',11), ('Jamon y Queso','Pizza','Masa fina','Individual',5), ('Jamon y Queso','Pizza','Masa normal','Individual',6), ('Jamon y Queso','Pizza','Masa fina','Mediana',7), ('Jamon y Queso','Pizza','Masa normal','Mediana',8), ('Jamon y Queso','Pizza','Masa fina','Familiar',9), ('Jamon y Queso','Pizza','Masa normal','Familiar',10), ('Sin Gluten','Pizza','Masa fina','Individual',6), ('Sin Gluten','Pizza','Masa normal','Individual',7), ('Sin Gluten','Pizza','Masa fina','Mediana',8), ('Sin Gluten','Pizza','Masa normal','Mediana',9), ('Sin GLuten','Pizza','Masa fina','Familiar',10), ('Sin Gluten','Pizza','Masa normal','Familiar',11), ('Pepperoni','Pizza','Masa fina','Individual',7), ('Pepperoni','Pizza','Masa normal','Individual',8), ('Pepperoni','Pizza','Masa fina','Mediana',9), ('Pepperoni','Pizza','Masa normal','Mediana',10), ('Pepperoni','Pizza','Masa fina','Familiar',11), ('Pepperoni','Pizza','Masa normal','Familiar',12), ('Pulled Beef','Pizza','Masa fina','Individual',7.5), ('Pulled Beef','Pizza','Masa normal','Individual',8.5), ('Pulled Beef','Pizza','Masa fina','Mediana',9.5), ('Pulled Beef','Pizza','Masa normal','Mediana',10.5), ('Pulled Beef','Pizza','Masa fina','Familiar',11.5), ('Pulled Beef','Pizza','Masa normal','Familiar',12.5);";

    private static final String SQL_DATOS_COMPLEMENTO =
            "INSERT INTO "+TablasBBDD.TablaProducto.TABLE_NAME+" ("+TablasBBDD.TablaProducto.COLUMN_NOMBRE +","+TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO +","+TablasBBDD.TablaProducto.COLUMN_PRECIO+") VALUES('Coca Cola','Bebida',2.25),"+
                    " ('Limon','Bebida',2.25),"+
                    " ('Red Bull','Bebida',3),"+
                    " ('Nestea','Bebida',2),"+
                    " ('Cerveza','Bebida',2.25),"+
                    " ('Agua','Bebida',1.5),"+
                    " ('Chocolate','Tarta',3.25),"+
                    " ('Hojaldre','Tarta',3.25),"+
                    " ('Manzana','Tarta',3.5),"+
                    " ('Chocolate','Helado',2),"+
                    " ('Vainilla','Helado',2),"+
                    " ('Yogurt','Helado',2),"+
                    " ('Platano','Fruta',1.25),"+
                    " ('Piña','Fruta',1.5),"+
                    " ('Melón','Bebida',1.5)";

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
