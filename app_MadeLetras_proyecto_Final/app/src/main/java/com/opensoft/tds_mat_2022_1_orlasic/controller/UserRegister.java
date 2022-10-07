package com.opensoft.tds_mat_2022_1_orlasic.controller;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.opensoft.tds_mat_2022_1_orlasic.R;
import com.opensoft.tds_mat_2022_1_orlasic.model.Usuario;

public class UserRegister extends AppCompatActivity {
    //Atributos de la clase
    TextInputEditText nombre;
    TextInputEditText correo;
    TextInputEditText clave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        // calling the action bar
        ActionBar actionBar = getSupportActionBar();
        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        //Casteamos los objetos con los de la vista
        this.nombre = findViewById(R.id.TxtNombreCrearUsuario);
        this.correo =findViewById(R.id.TxtCorreoCrearUsuario);
        this.clave = findViewById(R.id.TxtClaveCrearUsuario);
    }
    
    public void onClick(View view) {
        //Definimos condiciones para detectar de donde vienen los eventos (controles)
        if(view.getId() == R.id.BtnCrearUsuario){
            //Instancio un objeto de tipo usuario
            Usuario object = new Usuario();
            //Inicilizar los datos del usuario
            object.setNombre(nombre.getText().toString());
            object.setCorreo(correo.getText().toString());
            object.setClave(clave.getText().toString());
            //Condicion evaluar la respuesta del modelo
            if (object.crear(this)== true){
                Toast toast1 = Toast.makeText(getApplicationContext(),
                        "El usuario se a creado correctamente.", Toast.LENGTH_SHORT);
                toast1.show();
                //finalizo el registro
                Intent viewLogin = new Intent(UserRegister.this, Login.class);
                startActivity(viewLogin);
                finish();
            }else{
                Toast toast1 = Toast.makeText(getApplicationContext(),
                        "No se a creado el usuario, intentelo nuevamente.", Toast.LENGTH_SHORT);
                toast1.show();
            }
        }
    }
}