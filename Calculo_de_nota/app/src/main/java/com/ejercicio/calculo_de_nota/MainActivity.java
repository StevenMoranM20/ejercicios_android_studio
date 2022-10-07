package com.ejercicio.calculo_de_nota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
// iniciamos las variables
    private EditText et_1;
    private EditText et_2;
    private EditText et_3;
    private TextView tv_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// hacemos un casting
        et_1 =( EditText) findViewById(R.id.txt_Matematicas);
        et_2 =( EditText) findViewById(R.id.txt_Fisica);
        et_3 =( EditText) findViewById(R.id.txt_Quimica);
        tv_1 = (TextView) findViewById(R.id.tv_status);
    }
// usamos el public void le ponemos un nombre a nuestra metodo
    //  usamos el parametro view y le ponemos un nombre y importamos
    public void estatus (View vista){
        // ponemos creamos los espacios de memoria para crear los valores
        // y lo convertimos a string con el metodo toString()
        // y optenemos el texto con el getText()
        String matemticas_String = et_1.getText().toString();
        String Fisica_String = et_2.getText().toString();
        String Quimica_String = et_3.getText().toString();
// parciamos los datos que acabamos de recuperar a entero

        int Matematicas_int = Integer.parseInt(matemticas_String);
        int Fisica_int = Integer.parseInt(Fisica_String);
        int Quimica_int = Integer.parseInt(Quimica_String);
// hacemos el proceso de la suma
        int promedio = (Matematicas_int + Fisica_int + Quimica_int)/3;
// hacemos la determinacion que esta aprovado o reprovado por medio de un if
        if (promedio >=7){
            // presentamos el mensaje con .setText
            tv_1.setText("El estudiante esta Aprovado " +promedio);
        }else if (promedio <=7){
            tv_1.setText("El estudiante esta Reprovado " + promedio );
        }
    }
// no olvidar de hacer la estancia del boton evaluar con la activity main
    // ingresar los valores correctamente de los text en res/values/strings.xml
}