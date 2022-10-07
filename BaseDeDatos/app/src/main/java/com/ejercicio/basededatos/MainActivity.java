package com.ejercicio.basededatos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // crear los objetos
    private EditText et_codigo, et_descripcion, et_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // relacion entre la parte logica y la parte grafica
        et_codigo = (EditText)findViewById(R.id.txt_codigo);
        et_descripcion = (EditText)findViewById(R.id.txt_descripcion);
        et_precio = (EditText)findViewById(R.id.txt_precio);


    }


    //Méotdo para dar de alta los productos
    public void Registrar(View view){
        // creamos un objeto de la clase ya creada
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        // abrir la base de dato en modo escritura y lectura
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        // trabajar con los datos k se vallan proporcionando
        // para recuperar los datos de un int a string

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();
        // validar los campos con estructura condicional
// si la variable codigo es diferente a vacio o la variable descripcion  es diferente a vacio o la variable precion es diferente a vacio
        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){
            //para retener los valores de un solo registro, que será el que se insertará. ContenValues le creamos un nombre
            // = nuevo objeto de la clase contesValues ();
            ContentValues registro = new ContentValues();

            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);
            // para insertar o guardar los valores en la tabla que se llama articulos
            // nombre de la tabla y el metodo .insert se inserta nombre de la tabla, null y el nombre metodo donde esta el contenido de la tabla
            BaseDeDatos.insert("articulos", null, registro);
            //IMPORTANTE cuando se trabaja con base de datos importante cerrarla la base de datos con .close();
            BaseDeDatos.close();
            // limpiar los campos donde se ah escrito
            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");
            //aleta que el registro fue exitoso
            Toast.makeText(this,"Registro exitoso", Toast.LENGTH_SHORT).show();
        } else{
            // damos un aviso por medio de este toast para k si en caso no aya llenado uno de los campos
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    //Método para consultar un artículo o producto
    public void Buscar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        // abrimos la base de datos modo lectura escritura
        SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();
// recupar los valores para buscar los Valores
        // en esta ves usamos el codigo para buscar el producto
        String codigo = et_codigo.getText().toString();
        // colocar la validacion para que el cliente no deje ningun espacio vacio
        // si el codigo viene con texto es diferente de vacio
        if(!codigo.isEmpty()){
            // nos premite seleccionar un producto a traves de su codigo
            //rawQuery() nos permite aplicar un select
            // selecciona la descripcion precio de la tabla articulos don de codigo sea igual a codigo
            Cursor fila = BaseDeDatabase.rawQuery
                    ("select descripcion, precio from articulos where codigo =" + codigo, null);
            // creamos una estructura condicional que nos retorm true si hay algun dato en nuestra tabla
            //.moveToFirst() nos permite identificar si nuestra consulta si tiene valores y en caso k lo contenga que lo demuestre
            if(fila.moveToFirst()){
                // ponemos donde quiere k se refleje la condicion va a colocar dentro de nuestro editext con la ayuda de metodo setText y el metodo fila
                // al ser el primer valor k vamos a conectar se le pone 0
                et_descripcion.setText(fila.getString(0));
                et_precio.setText(fila.getString(1));
                BaseDeDatabase.close();
            } else {
                Toast.makeText(this,"No existe el artículo", Toast.LENGTH_SHORT).show();
                BaseDeDatabase.close();
            }

        } else {
            Toast.makeText(this, "Debes introducir el código del artículo", Toast.LENGTH_SHORT).show();
        }
    }

    //Método para eliminar un producto o Artículo
    public void Eliminar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper
                (this, "administracion", null, 1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();
        // creamos una variable una llamada codigo y aqui dentro se lo alojara
        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){
            // creamos una variable tipo int xk el metodo delete retorna un entero que indica la cantidad de registro borrados
            int cantidad = BaseDatabase.delete("articulos", "codigo=" + codigo, null);
            BaseDatabase.close();

            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            if(cantidad == 1){
                Toast.makeText(this, "Artículo eliminado exitosamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El artículo no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes de introducir el código del artículo", Toast.LENGTH_SHORT).show();
        }
    }

    //Método para modificar un artículo o producto
    public void Modificar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();
        // validar los campos para k usuario no deje ningunos vacio
        // si el codigo es y la descripcion y el precio diferente de vacio
        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){

            ContentValues registro = new ContentValues();
            // colocar lo k queremos guardar momentaneamente
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);
            // guardalos dentro de una base de datos
            // nos permite modificar los valores de la base de datos
            int cantidad = BaseDatabase.update("articulos", registro, "codigo=" + codigo, null);
            // cerramos la base de datos
            BaseDatabase.close();
            // creamos una estructura condicional k verefique si el artuculo se modifico o no exixte
            if(cantidad == 1){
                Toast.makeText(this, "Artículo modificado correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El artículo no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}