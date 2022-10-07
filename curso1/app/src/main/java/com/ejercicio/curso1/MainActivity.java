package com.ejercicio.curso1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int matematicas =10;
        int quimica = 7;
        int fisica = 9;
        int promedio = 0;

        promedio =(matematicas+ quimica + fisica) / 3;

        if (promedio >=6){
            Toast.makeText(this, "Aprovado", Toast.LENGTH_LONG).show();
        } else if(promedio <= 5){
           Toast.makeText(this,"Reprovado", Toast.LENGTH_SHORT).show();
        }
    }

}