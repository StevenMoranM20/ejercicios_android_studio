package com.ejercicio.appcedula;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //control edit text de los numeros ingresados
    private EditText et1;

    //luego le damos privacidad al tex viuw resultado
    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creamos los objetos de privacidad de los id

        //los id de los dos numeros ingresados

        et1 =(EditText) findViewById(R.id.txt_num1);

        //creamos los id resultado
        //tv1 = (TextView) findViewById(R.id.txt_resultado);
    }
    //Luego creamos el metodo del boton suma
    //METODO QUE REALIZA LA SUMA
    public void suma (View view ) {
        //recuperamos los valores en string de los dos numeros ingresados
        String cedula = et1.getText().toString();

        //luego hacemos el parceo de los dos numeros ingresados como son enteros


        //METODO QUE REALIZA LA SUMA

        //cambio de string a numero
        int num = 0;
        int suma = 0;
        for (int i = 0; i < cedula.length(); i++) {
            num = Integer.parseInt(String.valueOf(cedula.charAt(i)));

            if (i % 2 == 0) {
                num = num * 2;
                if (num > 9) {
                    num = num - 9;
                }
            }
            suma = suma + num;

        }
        if ((suma %10) != 0) {
            int resultado = 10 - (suma % 10);
            Toast.makeText(this, ""+resultado, Toast.LENGTH_SHORT).show();
            //cuando termine nuestro ciclo fir nuestra variable  num va a quedar con el ultimo numero
            if (resultado == num) {
                Toast.makeText(this, "La cedula es Ecuatoriana", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Usted si es ecuatoriano", Toast.LENGTH_SHORT).show();
            }


        }else{
            Toast.makeText(this, "Usted si es ecuatoriano", Toast.LENGTH_SHORT).show();

        }
    }
}





