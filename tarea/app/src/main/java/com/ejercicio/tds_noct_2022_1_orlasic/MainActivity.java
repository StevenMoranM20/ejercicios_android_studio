package com.ejercicio.tds_noct_2022_1_orlasic;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText TxtCorreoLogin, TxtClaveLogin;
    private Button BtnIniciarSesion, BtnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        BtnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = TxtCorreoLogin.getText().toString();
                String contraseña = TxtClaveLogin.getText().toString();
                boolean validacionInterfaz = validarCampos(usuario, contraseña);
                if (validacionInterfaz){
                    // inicio de sesin con base de datos
                }
            }
        });

        BtnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registro = new Intent( MainActivity.this, RegistroPersonaActivity.class );
                startActivity(registro);
            }
        });



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

    public void init(){
        TxtCorreoLogin = findViewById(R.id.TxtClaveLogin);
        TxtClaveLogin = findViewById(R.id.TxtClaveLogin);
        BtnIniciarSesion = findViewById(R.id.BtnIniciarSesion);
        BtnRegistrarse = findViewById(R.id.BtnRegistrarse);
    }
    public boolean validarCampos(String usuario, String contraseña){
        if (usuario.isEmpty()|| contraseña.isEmpty()){
            Toast.makeText(this, "Por favor ingrese usuario y contraseña", Toast.LENGTH_LONG).show();
            return false;
        }else if (usuario.length()<8 || contraseña.length()<8){
            Toast.makeText(this, "Por favor ingrese usuario y contraseña (minimo 8 caracteres)", Toast.LENGTH_LONG).show();
            return false;
        }else {
            return true;
        }

    }

}