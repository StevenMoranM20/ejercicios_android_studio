package com.ejercicio.tds_noct_2022_1_orlasic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ejercicio.tds_noct_2022_1_orlasic.adapters.UsuarioAdapter;
import com.ejercicio.tds_noct_2022_1_orlasic.models.UsuarioModel;

public class Login extends AppCompatActivity {

     private EditText TxtCorreoLogin, TxtClaveLogin;
    private Button BtnIniciarSesion, BtnRegistrarse;
    private UsuarioAdapter adapter;
    private UsuarioModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        adapter = new UsuarioAdapter(getApplicationContext());
        model = new UsuarioModel();

        BtnIniciarSesion.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String usuario = TxtCorreoLogin.getText().toString();
                String contrasena = TxtClaveLogin.getText().toString();
                boolean validacionInterfaz = validarCampos(usuario, contrasena);
                if (validacionInterfaz){
                    adapter.openRead();
                    model = adapter.login1(usuario, contrasena);
                    adapter.close();

                    if (model != null){
                        Toast.makeText(Login.this, "usuario encontrado, iniciando sesion...", Toast.LENGTH_LONG).show();
                        Intent contactos = new Intent(Login.this,ContactosActivity.class);
                        contactos.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(contactos);
                    }else {
                        Toast.makeText(Login.this, "usuario no encontrado, revice su infrmacion", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        BtnRegistrarse.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent registro = new Intent( Login.this, RegistroPersonaActivity.class );
                startActivity(registro);
            }
        });

    }



     public void init(){
        TxtCorreoLogin = findViewById(R.id.TxtClaveLogin);
        TxtClaveLogin = findViewById(R.id.TxtClaveLogin);
        BtnIniciarSesion = findViewById(R.id.BtnIniciarSesion);
        BtnRegistrarse = findViewById(R.id.BtnRegistrarse);
    }
    public boolean validarCampos(String usuario, String contrasena){
        if (usuario.isEmpty()|| contrasena.isEmpty()){
            Toast.makeText(this, "Por favor ingrese usuario y contraseña", Toast.LENGTH_LONG).show();
            return false;
        }else if (usuario.length()<8 || contrasena.length()<8){
            Toast.makeText(this, "Por favor ingrese usuario y contraseña (minimo 8 caracteres)", Toast.LENGTH_LONG).show();
            return false;
        }else {
            return true;
        }

    }

}

