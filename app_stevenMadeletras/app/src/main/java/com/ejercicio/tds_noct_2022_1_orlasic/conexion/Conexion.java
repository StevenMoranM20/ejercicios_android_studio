package com.ejercicio.tds_noct_2022_1_orlasic.conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexion extends SQLiteOpenHelper {
    // atributos de la clases
    private static final String database= "db_orlasic";
    private static final int version = 1;
    //TABLAS
    private static final String tb_tipo_usuario = "CREATE TABLE IF NOT EXISTS tb_tipo_usuario (id_tipo_usuario integer PRIMARY KEY autoincrement, descripcion text, estado integer);";
    private static final String tb_usuario = "CREATE TABLE IF NOT EXISTS tb_usuario (id_usuario integer PRIMARY KEY autoincrement, nombre text, correo text, clave text, id_tipo_usuario integer, estado integer, FOREIGN KEY(id_tipo_usuario) REFERENCES tb_tipo_usuario(id_tipo_usuario));";
    //INSERCIONES
    private static final String insert_tipo_usuario1 = "INSERT INTO tb_tipo_usuario(descripcion, estado)\n" +
            "values ('ADMINISTRADOR', 1); ";
    private static final String insert_tipo_usuario2 = "INSERT INTO tb_tipo_usuario(descripcion, estado)\n" +
            "values ('CLIENTE', 2); ";
    private static final String insert_usuario1 = "INSERT INTO tb_usuario (nombre, correo, clave, id_tipo_usuario,estado)\n" +
            "values ('admin', 'merino', '0921941357',1,1);";
    private static final String insert_usuario2 = "INSERT INTO tb_usuario (nombre, correo, clave, id_tipo_usuario,estado)\n" +
            "values ('steven moran', 'steven moran', '0921941357',2,1);";


    public Conexion( Context context) {
        // inicializamos la conexion
        super(context, database, null, version );


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(tb_tipo_usuario);
        sqLiteDatabase.execSQL(tb_usuario);
        sqLiteDatabase.execSQL(insert_tipo_usuario1);
        sqLiteDatabase.execSQL(insert_tipo_usuario2);
        sqLiteDatabase.execSQL(insert_usuario1);
        sqLiteDatabase.execSQL(insert_usuario2);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
