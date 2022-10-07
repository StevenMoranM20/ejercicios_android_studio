package com.example.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText user, pass;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user);
        pass = findViewById(R.id.password);
        btnlogin = findViewById(R.id.btnLoging);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( user.getText().toString().equals("user") && pass.getText().toString().equals("123")){
                    //Intent intent = new Intent(MainActivity.this, Principal.class);
                    //startActivity(intent);
                    startActivity(new Intent(MainActivity.this, Principal.class));
                    Toast.makeText(MainActivity.this, "Is OK!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}