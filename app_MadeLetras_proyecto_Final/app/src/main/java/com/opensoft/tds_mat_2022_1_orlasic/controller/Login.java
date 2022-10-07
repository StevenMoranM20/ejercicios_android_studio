package com.opensoft.tds_mat_2022_1_orlasic.controller;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.opensoft.tds_mat_2022_1_orlasic.R;
import com.opensoft.tds_mat_2022_1_orlasic.model.Usuario;

public class Login extends AppCompatActivity {
    //Atributos de la clase
    TextInputEditText correo;
    TextInputEditText clave;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Casteamos los objetos con los de la vista
        this.correo =findViewById(R.id.TxtCorreoLogin);
        this.clave = findViewById(R.id.TxtClaveLogin);
    }
    
    public void onClick(View view) {
        //Definimos condiciones para detectar de donde vienen los eventos (controles)
        if(view.getId() == R.id.BtnIniciarLogin){
            //Instancio un objeto de tipo usuario
            Usuario object = new Usuario();
            //Inicilizar los datos del usuario
            object.setCorreo(correo.getText().toString());
            object.setClave(clave.getText().toString());
            //Condicion evaluar la respuesta del modelo
            if (object.login(this)== true){
                Toast toast1 = Toast.makeText(getApplicationContext(),
                        "Las credenciales son correctas", Toast.LENGTH_SHORT);
                toast1.show();
                //finalizo el registro
                Intent viewLogin = new Intent(Login.this, Home.class);
                startActivity(viewLogin);
                finish();
               
            }else{
                Toast toast1 = Toast.makeText(getApplicationContext(),
                        "La credenciales son Incorrectas, por favor cree una cuenta.", Toast.LENGTH_SHORT);
                toast1.show();
            }
        }else if (view.getId() == R.id.BtnCrearCuentaLogin){
            //finalizo el registro
            Intent viewRegister = new Intent(Login.this, UserRegister.class);
            startActivity(viewRegister);
        }
    }
}