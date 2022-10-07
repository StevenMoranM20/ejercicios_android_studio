package com.ejercicio.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtNumero1;
    EditText txtNumero2;
    EditText txtNumero3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNumero1 = findViewById(R.id.txtNumero1);
        txtNumero2 = findViewById(R.id.txtNumero2);
        txtNumero3 = findViewById(R.id.txtNumero3);
    }
    public void imc(View vista){
        String numero1Texto = txtNumero1.getText().toString();
        String numero2Texto = txtNumero2.getText().toString();
        String numero3Texto = txtNumero3.getText().toString();
        if (numero1Texto.equals("") || numero2Texto.equals("") || numero3Texto.equals("")) {
            Toast.makeText(getApplicationContext(), "Por favor llene los datos", Toast.LENGTH_LONG).show();
        }else{
            int numero1 = Integer.parseInt(numero1Texto);
            float numero2 = Float.parseFloat(numero2Texto);
            float numero3 = Float.parseFloat(numero3Texto);
            numero3= numero3/100;
            //Proceso de calcular el indice de masa corporal
            float imc=numero2/(float)Math.pow(numero3,2);
            //Convirtiendo el resultado a texto
            String imcTexto = String.format("%.1f", imc);
            if (imc < 18.5f)
                Toast.makeText(getApplicationContext(), "Su edad es de: " + numero1 + " y su indice de masa coporal es de: " + imcTexto+" usted tiene Desnutricion", Toast.LENGTH_LONG).show(); // Desnutrición
            if (imc >= 18.5f && imc < 25)
                Toast.makeText(getApplicationContext(), "Su edad es de: " + numero1 + " y su indice de masa coporal es de: " + imcTexto+" usted esta Normal", Toast.LENGTH_LONG).show(); // Normal
            if (imc >= 25 && imc < 30)
                Toast.makeText(getApplicationContext(), "Su edad es de: " + numero1 + " y su indice de masa coporal es de: " + imcTexto+" usted tiene Sobrepeso", Toast.LENGTH_LONG).show(); //Sobrepeso
            if (imc >= 30 && imc < 35)
                Toast.makeText(getApplicationContext(), "Su edad es de: " + numero1 + " y su indice de masa coporal es de: " + imcTexto+" usted tiene Obesidad Grado 1", Toast.LENGTH_LONG).show(); // Obestdad Grado1
            if (imc >= 35 && imc < 40)
                Toast.makeText(getApplicationContext(), "Su edad es de: " + numero1 + " y su indice de masa coporal es de: " + imcTexto+" usted tiene Obesidad Grado 2", Toast.LENGTH_LONG).show(); // Obesidod Grado2
            if (imc >= 40)
                Toast.makeText(getApplicationContext(), "Su edad es de: " + numero1 + " y su indice de masa coporal es de: " + imcTexto+" usted tiene Obesidad Grado 3", Toast.LENGTH_LONG).show(); // Obesidod Grado3

        }
    }
}