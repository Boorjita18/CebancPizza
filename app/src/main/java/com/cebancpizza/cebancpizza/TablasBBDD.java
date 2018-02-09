package com.cebancpizza.cebancpizza;

import android.provider.BaseColumns;

/**
 * Created by adminportatil on 05/02/2018.
 */

public final class TablasBBDD {
    private TablasBBDD() {}

    // TABLA USUARIO
    public static class TablaUsuario implements BaseColumns {
        public static final String TABLE_NAME = "usuario";
        public static final String COLUMN_ID = "usuario_id";
        public static final String COLUMN_USUARIO = "usuario_usuario";
        public static final String COLUMN_NOMBRE = "usuario_nombre";
        public static final String COLUMN_APELLIDOS = "usuario_apellidos";
        public static final String COLUMN_TELEFONO = "usuario_telefono";
        public static final String COLUMN_DIRECCION = "usuario_direccion";
        public static final String COLUMN_EMAIL = "usuario_email";
    }

    // TABLA CABECERA PEDIDO
    public static class TablaCabeceraPedido implements BaseColumns {
        public static final String TABLE_NAME = "cabecera_pedido";
        public static final String COLUMN_ID = "cabecera_pedido_id";
        public static final String COLUMN_ID_USUARIO = "id_usuario";
        public static final String COLUMN_FECHA = "cabecera_pedido_fecha";
    }

    // TABLA LINEA PEDIDO
    public static class TablaLineaPedido implements BaseColumns {
        public static final String TABLE_NAME = "linea_pedido";
        public static final String COLUMN_ID = "linea_pedido_id";
        public static final String COLUMN_ID_CABECERA_PEDIDO = "id_cabecera_pedido";
        public static final String COLUMN_ID_PRODUCTO = "id_proucto";
        public static final String COLUMN_ID_MASA = "id_masa";
        public static final String COLUMN_ID_TAMANNO = "id_tamanno";
        public static final String COLUMN_CANTIDAD = "linea_pedido_cantidad";
        public static final String COLUMN_PRECIO_LINEA = "linea_pedido_precio";
    }

    // TABLA PRODUCTO
    public static class TablaProducto implements BaseColumns {
        public static final String TABLE_NAME = "producto";
        public static final String COLUMN_ID = "producto_id";
        public static final String COLUMN_NOMBRE = "producto_nombre";
        public static final String COLUMN_TIPO_PRODUCTO = "producto_tipo";
        public static final String COLUMN_PRECIO = "producto_precio";
    }

    // TABLA MASA
    public static class TablaMasa implements BaseColumns {
        public static final String TABLE_NAME = "masa";
        public static final String COLUMN_ID = "masa_id";
        public static final String COLUMN_NOMBRE = "masa_nombre";
        public static final String COLUMN_PRECIO = "masa_precio";
    }

    // TABLA TAMAÑO
    public static class TablaTamanno implements BaseColumns {
        public static final String TABLE_NAME = "tamanno";
        public static final String COLUMN_ID = "tamanno_id";
        public static final String COLUMN_NOMBRE = "tamanno_nombre";
        public static final String COLUMN_PRECIO = "tamanno_precio";
    }
}