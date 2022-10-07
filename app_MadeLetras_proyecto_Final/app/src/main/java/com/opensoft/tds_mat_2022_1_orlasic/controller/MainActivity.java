package com.opensoft.tds_mat_2022_1_orlasic.controller;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.opensoft.tds_mat_2022_1_orlasic.R;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Configurar el splash
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent
                Intent intent = new Intent(MainActivity.this, Login.class);
                //Inicializo el intent
                startActivity(intent);
                //finalice el hilo
                finish();
            }
        } , 4000);
    }
}

