package com.ejercicio.tds_noct_2022_1_orlasic.controller;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import com.ejercicio.tds_noct_2022_1_orlasic.R;


public class Home extends AppCompatActivity {

    Button BtnInventario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BtnInventario = findViewById(R.id.BtnInventario);
        BtnInventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,Caja_inventario.class);
                startActivity(intent);
            }
        });
    }

    public void onClick(View view) {
    }
}
