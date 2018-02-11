package com.cebancpizza.cebancpizza;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by gorka on 10/02/2018.
 */

public class ProductosAdapter extends ArrayAdapter<ProductoModel> {

    private ArrayList<ProductoModel> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView txtNombre;
        TextView txtDescripcion;
        TextView txtPrecio;
        TextView txtID;
        ImageView imagen;
    }

    public ProductosAdapter(ArrayList<ProductoModel> data, Context context) {
        super(context, R.layout.row_format, data);
        this.dataSet = data;
        this.mContext=context;
    }

//    public void onClick(View v) {
//
////        int position = (Integer) v.getTag();
////        Toast.makeText(this.getContext(), v.getTag().toString(),Toast.LENGTH_SHORT);
////        Object object = getItem(position);
////        ProductoModel producto = (ProductoModel) object;
//
//    }

//    private int lastPosition = -1;

    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ProductoModel producto = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_format, parent, false);
            viewHolder.txtNombre = (TextView) convertView.findViewById(R.id.nombreLista);
            viewHolder.txtPrecio = (TextView) convertView.findViewById(R.id.precioLista);
            viewHolder.txtDescripcion = (TextView) convertView.findViewById(R.id.descripcionLista);
            viewHolder.imagen = (ImageButton) convertView.findViewById(R.id.imagenLista);


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }


        viewHolder.txtNombre.setText(producto.getNombre());
        viewHolder.txtPrecio.setText(String.valueOf(producto.getPrecio()));
        viewHolder.txtDescripcion.setText(producto.getDescripcion());

//        viewHolder.imagen.setOnClickListener(this);

        String mDrawableName = producto.getImagen() ;
        Resources res = convertView.getResources();
        int resID = res.getIdentifier(mDrawableName , "mipmap","com.cebancpizza.cebancpizza");
        viewHolder.imagen.setImageResource(resID);


        // Return the completed view to render on screen
        return convertView;
    }

}
