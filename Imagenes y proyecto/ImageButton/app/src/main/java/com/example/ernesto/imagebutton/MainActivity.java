package com.example.ernesto.imagebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Método para el botón Geekipedia
    public void MensajeGeekipedia(View view){
        Toast.makeText(this, "La Geekipedia de Ernesto", Toast.LENGTH_SHORT).show();
    }

    //Método para el botón Mano
    public void MensajeMano(View view){
        Toast.makeText(this, "Esto es una mano", Toast.LENGTH_SHORT).show();
    }
}
