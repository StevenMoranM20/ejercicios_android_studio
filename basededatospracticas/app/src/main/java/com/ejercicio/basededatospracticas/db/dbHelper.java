package com.ejercicio.basededatospracticas.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

// clase k ayuda a proporcionar los elementos para crear las bases de datos y las tablas
// implementamos los metodos y creamos el constructor con alt intro
public class dbHelper extends SQLiteOpenHelper {
// CON ESTA BARIABLE SE CONTROLA LA VASE DE DATOS K SE VA A UTILIZAR
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "agenda.db";
// PARA EL NOMBRE DE LA TABLA
    public static final String TABLE_CONTACTOS = "t_contactos";

// borramos los parte del codigo y solo dejamos en context
    // y colocamos en el context,DATABASE_NOMBRE, null, DATABASE_VERSION)
    public dbHelper(@Nullable Context context) {
        super(context,DATABASE_NOMBRE, null,DATABASE_VERSION);
    }
// este metodo se va a ejecutar cuando inicializemos nuestra base de datos
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
// creamos nuestro query
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CONTACTOS +"(" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "telefono TEXT NOT NULL," +
                "correo_electronico TEXT) ");

    }
// este se va a ejecutar cuando combie la version de mi base de dato
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
// para eliminar la tabla que ya tenemos
        sqLiteDatabase.execSQL(" DROP TABLE "+ TABLE_CONTACTOS);
        // y luego la agrege con las modificaciones k aya creado
        onCreate(sqLiteDatabase);


    }
}
