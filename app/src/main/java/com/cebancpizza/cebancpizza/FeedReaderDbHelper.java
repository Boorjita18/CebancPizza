package com.cebancpizza.cebancpizza;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adminportatil on 05/02/2018.
 */

public class FeedReaderDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 9;
    public static final String DATABASE_NAME = "PizzeriaCebanc.db";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        // TABLAS
        db.execSQL(SQL_CREATE_TABLA_PRODUCTO);
        db.execSQL(SQL_CREATE_TABLA_USUARIO);
        db.execSQL(SQL_CREATE_TABLA_CABECERA_PEDIDO);
        db.execSQL(SQL_CREATE_TABLA_LINEA_PEDIDO);
        db.execSQL(SQL_CREATE_TABLA_MASA);
        db.execSQL(SQL_CREATE_TABLA_TAMANNO);
        // DATOS
        db.execSQL(SQL_INSERT_PIZZAS);
        db.execSQL(SQL_INSERT_BEBIDAS);
        db.execSQL(SQL_INSERT_POSTRES);
        db.execSQL(SQL_INSERT_MASAS);
        db.execSQL(SQL_INSERT_TAMANNOS);
        // DATOS DE PRUEBA INICIALES
        db.execSQL(SQL_INSERT_USUARIOS_PRUEBA);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            db.execSQL(SQL_DELETE_TABLA_USUARIO);
            db.execSQL(SQL_DELETE_TABLA_CABECERA_PEDIDO);
            db.execSQL(SQL_DELETE_TABLA_LINEA_PEDIDO);
            db.execSQL(SQL_DELETE_TABLA_PRODUCTO);
            db.execSQL(SQL_DELETE_TABLA_MASA);
            db.execSQL(SQL_DELETE_TABLA_TAMANNO);
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
                    TablasBBDD.TablaUsuario.COLUMN_USUARIO + " TEXT, " +
                    TablasBBDD.TablaUsuario.COLUMN_NOMBRE + " TEXT, " +
                    TablasBBDD.TablaUsuario.COLUMN_APELLIDOS + " TEXT, " +
                    TablasBBDD.TablaUsuario.COLUMN_TELEFONO + " TEXT, " +
                    TablasBBDD.TablaUsuario.COLUMN_DIRECCION + " TEXT, " +
                    TablasBBDD.TablaUsuario.COLUMN_EMAIL + " TEXT)";

    private static final String SQL_DELETE_TABLA_USUARIO =
            "DROP TABLE IF EXISTS " + TablasBBDD.TablaUsuario.TABLE_NAME;

    // TABLA CABECERA PEDIDO
    private static final String SQL_CREATE_TABLA_CABECERA_PEDIDO =
            "CREATE TABLE " + TablasBBDD.TablaCabeceraPedido.TABLE_NAME + " (" +
                    TablasBBDD.TablaCabeceraPedido.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    TablasBBDD.TablaCabeceraPedido.COLUMN_ID_USUARIO + " INTEGER," +
                    TablasBBDD.TablaCabeceraPedido.COLUMN_FECHA + " NUMERIC, " +
                    "FOREIGN KEY (" + TablasBBDD.TablaCabeceraPedido.COLUMN_ID_USUARIO + ") "+
                        "REFERENCES " + TablasBBDD.TablaUsuario.TABLE_NAME + "(" + TablasBBDD.TablaUsuario.COLUMN_ID + "))";

    private static final String SQL_DELETE_TABLA_CABECERA_PEDIDO =
            "DROP TABLE IF EXISTS " + TablasBBDD.TablaCabeceraPedido.TABLE_NAME;

    // TABLA LINEA PEDIDO
    private static final String SQL_CREATE_TABLA_LINEA_PEDIDO =
            "CREATE TABLE " + TablasBBDD.TablaLineaPedido.TABLE_NAME + " (" +
                    TablasBBDD.TablaLineaPedido.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    TablasBBDD.TablaLineaPedido.COLUMN_ID_CABECERA_PEDIDO + " INTEGER," +
                    TablasBBDD.TablaLineaPedido.COLUMN_ID_PRODUCTO + " INTEGER," +
                    TablasBBDD.TablaLineaPedido.COLUMN_ID_MASA + " INTEGER," +
                    TablasBBDD.TablaLineaPedido.COLUMN_ID_TAMANNO + " INTEGER," +
                    TablasBBDD.TablaLineaPedido.COLUMN_CANTIDAD + " INTEGER," +
                    TablasBBDD.TablaLineaPedido.COLUMN_PRECIO_LINEA + " NUMERIC," +
                    "FOREIGN KEY (" + TablasBBDD.TablaLineaPedido.COLUMN_ID_CABECERA_PEDIDO + ") " +
                        "REFERENCES " + TablasBBDD.TablaCabeceraPedido.TABLE_NAME + "(" + TablasBBDD.TablaCabeceraPedido.COLUMN_ID + "), " +
                    "FOREIGN KEY (" + TablasBBDD.TablaLineaPedido.COLUMN_ID_PRODUCTO + ") " +
                        "REFERENCES " + TablasBBDD.TablaProducto.TABLE_NAME + "(" + TablasBBDD.TablaProducto.COLUMN_ID + ")," +
                    "FOREIGN KEY (" + TablasBBDD.TablaLineaPedido.COLUMN_ID_MASA + ") " +
                        "REFERENCES " + TablasBBDD.TablaMasa.TABLE_NAME + "(" + TablasBBDD.TablaMasa.COLUMN_ID + "), " +
                    "FOREIGN KEY (" + TablasBBDD.TablaLineaPedido.COLUMN_ID_TAMANNO + ") " +
                        "REFERENCES " + TablasBBDD.TablaTamanno.TABLE_NAME + "(" + TablasBBDD.TablaTamanno.COLUMN_ID + "))";

    private static final String SQL_DELETE_TABLA_LINEA_PEDIDO =
            "DROP TABLE IF EXISTS " + TablasBBDD.TablaLineaPedido.TABLE_NAME;

    // TABLA PRODUCTO
    private static final String SQL_CREATE_TABLA_PRODUCTO =
            "CREATE TABLE " + TablasBBDD.TablaProducto.TABLE_NAME + " (" +
                    TablasBBDD.TablaProducto.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    TablasBBDD.TablaProducto.COLUMN_NOMBRE + " TEXT, " +
                    TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO + " TEXT, " +
                    TablasBBDD.TablaProducto.COLUMN_IMAGEN + " TEXT, " +
                    TablasBBDD.TablaProducto.COLUMN_DESCRIPCION + " TEXT, " +
                    TablasBBDD.TablaProducto.COLUMN_PRECIO + " NUMERIC)";

    private static final String SQL_DELETE_TABLA_PRODUCTO =
            "DROP TABLE IF EXISTS " + TablasBBDD.TablaProducto.TABLE_NAME;

    // TABLA MASA
    private static final String SQL_CREATE_TABLA_MASA =
            "CREATE TABLE " + TablasBBDD.TablaMasa.TABLE_NAME + " (" +
                    TablasBBDD.TablaMasa.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    TablasBBDD.TablaMasa.COLUMN_NOMBRE + " TEXT, " +
                    TablasBBDD.TablaMasa.COLUMN_PRECIO + " NUMERIC)";

    private static final String SQL_DELETE_TABLA_MASA =
            "DROP TABLE IF EXISTS " + TablasBBDD.TablaMasa.TABLE_NAME;

    // TABLA TAMAÑO
    private static final String SQL_CREATE_TABLA_TAMANNO =
            "CREATE TABLE " + TablasBBDD.TablaTamanno.TABLE_NAME + " (" +
                    TablasBBDD.TablaTamanno.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    TablasBBDD.TablaTamanno.COLUMN_NOMBRE + " TEXT, " +
                    TablasBBDD.TablaTamanno.COLUMN_PRECIO + " NUMERIC)";

    private static final String SQL_DELETE_TABLA_TAMANNO =
            "DROP TABLE IF EXISTS " + TablasBBDD.TablaTamanno.TABLE_NAME;

    // INSERTAR PRODUCTOS
    private static final String SQL_INSERT_PIZZAS =
            "INSERT INTO " + TablasBBDD.TablaProducto.TABLE_NAME + " (" +
                    TablasBBDD.TablaProducto.COLUMN_NOMBRE + ", " +
                    TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO + ", " +
                    TablasBBDD.TablaProducto.COLUMN_PRECIO + ") " +
                    "VALUES " +
                        "('Barbacoa','Pizza',5), " +
                        "('Campiña','Pizza',6), " +
                        "('Gourmet','Pizza',7.5), " +
                        "('Hawaiana','Pizza',6), " +
                        "('Jamón y Queso','Pizza',5), " +
                        "('Sin Gluten','Pizza',6), " +
                        "('Pepperoni','Pizza',7), " +
                        "('Pulled Beef','Pizza',7.5)";

    private static final String SQL_INSERT_BEBIDAS =
            "INSERT INTO " + TablasBBDD.TablaProducto.TABLE_NAME + " (" +
                    TablasBBDD.TablaProducto.COLUMN_NOMBRE + ", " +
                    TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO + ", " +
                    TablasBBDD.TablaProducto.COLUMN_PRECIO + ", " +
                    TablasBBDD.TablaProducto.COLUMN_IMAGEN+ ") " +
                    "VALUES " +
                        "('Coca Cola','Bebida',2.25,'cocacola'), " +
                        "('Limon','Bebida',2.25,'limon'), " +
                        "('Red Bull','Bebida',3,'redbull'), " +
                        "('Nestea','Bebida',2,'nestea'), " +
                        "('Cerveza','Bebida',2.25,'cerveza'), " +
                        "('Agua','Bebida',1.5,'agua')";

    private static final String SQL_INSERT_POSTRES =
            "INSERT INTO " + TablasBBDD.TablaProducto.TABLE_NAME + " (" +
                    TablasBBDD.TablaProducto.COLUMN_NOMBRE + ", " +
                    TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO + ", " +
                    TablasBBDD.TablaProducto.COLUMN_PRECIO + ", " +
                    TablasBBDD.TablaProducto.COLUMN_IMAGEN+ ") " +
                    "VALUES " +
                        "('Tarta de Chocolate','Postre',3.25, 'tartachocolate'), " +
                        "('Tarta de Hojaldre','Postre',3.25, 'hojaldre'), " +
                        "('Tarta de Manzana','Postre',3.5, 'manzana'), " +
                        "('Helado de Chocolate','Postre',2, 'heladochocolate'), " +
                        "('Helado de Vainilla','Postre',2, 'vainilla'), " +
                        "('Helado de Yogurt','Postre',2, 'yogurt'), " +
                        "('Platano','Postre',1.25, 'platanos'), " +
                        "('Piña','Postre',1.5, 'pina'), " +
                        "('Melón','Postre',1.5, 'melon')";

    private static final String SQL_INSERT_MASAS =
            "INSERT INTO " + TablasBBDD.TablaMasa.TABLE_NAME + " (" +
                    TablasBBDD.TablaMasa.COLUMN_NOMBRE + ", " +
                    TablasBBDD.TablaMasa.COLUMN_PRECIO + ") " +
                    "VALUES " +
                        "('Masa fina',0), " +
                        "('Masa normal',1)";

    private static final String SQL_INSERT_TAMANNOS =
            "INSERT INTO " + TablasBBDD.TablaTamanno.TABLE_NAME + " (" +
                    TablasBBDD.TablaTamanno.COLUMN_NOMBRE + ", " +
                    TablasBBDD.TablaTamanno.COLUMN_PRECIO + ") " +
                    "VALUES " +
                        "('Indvidual',0), " +
                        "('Mediana',2), " +
                        "('Familiar',4)";

    //INSERTAR DATOS DE PRUEBA INICIALES
    private static final String SQL_INSERT_USUARIOS_PRUEBA =
            "INSERT INTO " + TablasBBDD.TablaUsuario.TABLE_NAME + " (" +
                    TablasBBDD.TablaUsuario.COLUMN_USUARIO + ", " +
                    TablasBBDD.TablaUsuario.COLUMN_NOMBRE + ", " +
                    TablasBBDD.TablaUsuario.COLUMN_APELLIDOS + ", " +
                    TablasBBDD.TablaUsuario.COLUMN_TELEFONO + ", " +
                    TablasBBDD.TablaUsuario.COLUMN_DIRECCION + ", " +
                    TablasBBDD.TablaUsuario.COLUMN_EMAIL + ") " +
                    "VALUES " +
                        "('gmaniega','Gorka','Maniega','987654321','Dirección de Gorka','gmaiega@email.com'), " +
                        "('etoledo','Eneko','Toledo','654321987','Dirección de Eneko','etoledo@email.com'), " +
                        "('aetxezarreta','Aitor','Etxezarreta','321987654','Dirección de Aitor','aetxezarreta@email.com') ";
}
