package com.cebancpizza.cebancpizza;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ElegirBebida extends AppCompatActivity {
    EditText editCocacola, editLimon, editRedbull, editNestea, editCerveza, editAgua;
    Button btnSiguiente, btnVolver, btnPedido;
    FeedReaderDbHelper conexion = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_bebida);

        try {
            conexion = new FeedReaderDbHelper(getApplicationContext());
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        editCocacola = (EditText) findViewById(R.id.editText);
        editLimon = (EditText) findViewById(R.id.editText1);
        editRedbull = (EditText) findViewById(R.id.editText2);
        editNestea = (EditText) findViewById(R.id.editText3);
        editCerveza = (EditText) findViewById(R.id.editText4);
        editAgua = (EditText) findViewById(R.id.editText5);
        btnSiguiente = (Button) findViewById(R.id.button4);
        btnVolver = (Button) findViewById(R.id.button3);
        btnPedido = (Button) findViewById(R.id.button2);

        btnSiguiente.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (editCocacola.getText().toString().isEmpty()) {
                    editCocacola.setText("0");
                }
                if (editLimon.getText().toString().isEmpty()) {
                    editLimon.setText("0");
                }
                if (editRedbull.getText().toString().isEmpty()) {
                    editRedbull.setText("0");
                }
                if (editNestea.getText().toString().isEmpty()) {
                    editNestea.setText("0");
                }
                if (editCerveza.getText().toString().isEmpty()) {
                    editCerveza.setText("0");
                }
                if (editAgua.getText().toString().isEmpty()) {
                    editAgua.setText("0");
                }

                try {
                    SQLiteDatabase db = conexion.getWritableDatabase();

                    String[] projection = {
                            TablasBBDD.TablaProducto.COLUMN_NOMBRE,
                            TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO,
                            TablasBBDD.TablaProducto.COLUMN_PRECIO

                    };

                    String selection = TablasBBDD.TablaProducto.COLUMN_TIPO_PRODUCTO+ " = ?";
                    //String[] selectionArgs = { nombreText.getText().toString() };
                    String[] selectionArgs = { "Bebida" };

                    Cursor cursor = db.query(
                            TablasBBDD.TablaProducto.TABLE_NAME,       // The table to query
                            projection,                               // The columns to return
                            selection,                                // The columns for the WHERE clause
                            selectionArgs,                            // The values for the WHERE clause
                            null,                                     // don't group the rows
                            null,                                     // don't filter by row groups
                            null                                      // The sort order
                    );

                    Integer[] canti = new Integer[] {Integer.parseInt(editCocacola.getText().toString()), Integer.parseInt(editLimon.getText().toString()), Integer.parseInt(editRedbull.getText().toString()), Integer.parseInt(editNestea.getText().toString()), Integer.parseInt(editCerveza.getText().toString()), Integer.parseInt(editAgua.getText().toString())};
                    int i=-1;
                    while(cursor.moveToNext()) {
                        i++;
                        Bebida b = new Bebida(cursor.getString(cursor.getColumnIndex(TablasBBDD.TablaProducto.COLUMN_NOMBRE)),canti[i],cursor.getFloat(cursor.getColumnIndex(TablasBBDD.TablaProducto.COLUMN_PRECIO)));

                        añadirBebidasPedido(b.getNombre(),b.getCantidad(),b.getPrecio());

                    }
                    cursor.close();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }

//                añadirBebidasPedido("Coca Cola",Integer.parseInt(editCocacola.getText().toString()),Float.parseFloat("2.25"));
//                añadirBebidasPedido("Limón",Integer.parseInt(editLimon.getText().toString()),Float.parseFloat("2.25"));
//                añadirBebidasPedido("Red Bull",Integer.parseInt(editLimon.getText().toString()),3);
//                añadirBebidasPedido("Nestea",Integer.parseInt(editNestea.getText().toString()),Float.parseFloat("2.0") );
//                añadirBebidasPedido("Cerveza",Integer.parseInt(editCerveza.getText().toString()),Float.parseFloat("2.25") );
//                añadirBebidasPedido("Agua",Integer.parseInt(editAgua.getText().toString()),Float.parseFloat("1.5") );
                Intent intent = new Intent(ElegirBebida.this, ElegirPostre.class);
                startActivity(intent);
            }
        });

        btnPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ElegirBebida.this, RevisarPedido.class);
                startActivity(intent);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void añadirBebidasPedido(String s, int i, float v) {
        Bebida bebida = new Bebida(s, i, v);

        ((Pedido) this.getApplication()).anadirBebida(bebida);
    }
}