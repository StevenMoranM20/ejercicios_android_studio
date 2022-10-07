package com.ejercicio.tds_noct_2022_1_orlasic.controller;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ejercicio.tds_noct_2022_1_orlasic.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // configuracion de un aplash
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent( MainActivity.this,Login.class);
                // inicializamos el intent
                startActivity(intent);
                // Finalice el hilo de ejecucion
                finish();
            }
            // le damos el tiempo 4 milisegundos
        }, 4000);
    }
}