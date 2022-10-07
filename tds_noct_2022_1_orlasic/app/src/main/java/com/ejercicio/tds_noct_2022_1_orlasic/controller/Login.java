package com.ejercicio.tds_noct_2022_1_orlasic.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.ejercicio.tds_noct_2022_1_orlasic.R;
import com.ejercicio.tds_noct_2022_1_orlasic.model.Usuario;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {
    // atributos de la clase
    TextInputEditText correo;
    TextInputEditText clave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // casteamos los objetos con los de la vista
        this.correo = findViewById(R.id.TxtCorreoLogin);
        this.clave = findViewById(R.id.TxtClaveLogin);


    }

    public void onClick(View view) {
        // defin9mos condiciones para defectuar de donde vienen los eventos (controles)
        if (view.getId() == R.id.BtnIniciarSesion ){
            // indtsncio un objeto de tipo usuario
            Usuario object = new Usuario();
            // inicializo los datos del usuario
            object.setCorreo(correo.getText().toString());
            object.setClave(clave.getText().toString());
            //condicion evaluar la respuesta del modelo
            // finalizo el registro
            if (object.login(this)== true){
                Toast toast1 = Toast.makeText(getApplicationContext(),"la credenciales son correctas",Toast.LENGTH_SHORT);
                toast1.show();
                //finalizo el registro
                Intent viewLogin = new Intent(Login.this, Home.class);
                startActivity(viewLogin);
                finish();
            }else {
                Toast toast1 = Toast.makeText(getApplicationContext(),"la credenciales son incorrectas,por favor cree una cuenta.",Toast.LENGTH_SHORT);
                toast1.show();

            }
// se entancia el boton con el crear login para k lo lleve a la view registros
        }else if (view.getId() == R.id.BtnCrearCuentaLogin){
            // finalizo el registro
            Intent viewRegister = new Intent(Login.this, UserRegister.class);
            startActivity(viewRegister);
        }
    }
}