package com.ejercicio.my_calculator_nocturno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// configurar del splash:
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent( MainActivity.this, Inicio.class );
                // inicializo el hilo Intent
                startActivity(intent);
                // finalice el hilo de ejecucion
                finish();
            }
        },  3000) ;


        }


    }
