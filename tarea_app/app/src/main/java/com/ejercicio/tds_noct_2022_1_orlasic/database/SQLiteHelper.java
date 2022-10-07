package com.ejercicio.tds_noct_2022_1_orlasic.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//import androidx.annotation.Nullable;

import com.ejercicio.tds_noct_2022_1_orlasic.adapters.UsuarioAdapter;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(UsuarioAdapter.SCRIP_NUEVA_TABLA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + UsuarioAdapter.NOMBRE_TABLA );
        onCreate(sqLiteDatabase);

    }
}
