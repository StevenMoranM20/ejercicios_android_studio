package com.ejercicio.tds_noct_2022_1_orlasic.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ejercicio.tds_noct_2022_1_orlasic.database.SQLiteHelper;
import com.ejercicio.tds_noct_2022_1_orlasic.models.UsuarioModel;

public class UsuarioAdapter {
    private final String NOMBRE_DB = "contactosv2.db";
    private final int VERSION = 1;
    public static final String NOMBRE_TABLA = "usuario";

    public static final String SCRIP_NUEVA_TABLA = "CREATE TABLE" + NOMBRE_TABLA +
            "(" +
            "id integer primary key autoincrement, " +
            "nombre text, " +
            "usuario text, " +
            "contrasena text" +
            ");"
            ;
    private static SQLiteDatabase database;
    private static SQLiteHelper helper;
    private final Context context;
    private UsuarioModel model;

    public UsuarioAdapter(Context context) {
    this.context = context;
    helper = new SQLiteHelper(context, NOMBRE_DB, null, VERSION);
    }
public void openRead(){
        database = helper.getReadableDatabase();
}

    public void openWrite(){
        database = helper.getWritableDatabase();
    }
    public void close(){
        database.close();
    }

    @SuppressLint("Range")
    public UsuarioModel login1(String usuario, String contrasena){
        String where = "usuario = ? AND contrasena = ?";
        Cursor cursor = database.query(NOMBRE_TABLA, null, where, new String[]{usuario, contrasena}, null, null, null);
        if (cursor.getCount() <1){
            return null;
        }else{
            cursor.moveToFirst();
            model = new UsuarioModel();
            model.set_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("id"))));
            model.set_nombre(cursor.getString(cursor.getColumnIndex("nombre")));
            model.set_usuario(usuario);
            model.set_contrasena(contrasena);
            return model;
        }

    }

}










