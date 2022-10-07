package com.example.steven;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Configuracion del splash
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Inicio.class);
                //INCIALIZO EL INTENT
                startActivity(intent);
                //Finalizo el hilo de la ejecucion
                finish();
            }
        }, 3000);

    }
}