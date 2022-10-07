package com.ejercicio.calculadoraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonSuma;
    private Button buttonResta;
    private Button buttonMultiplicacion;
    private Button buttonDivision;
    private TextView txt_resultado;
    private EditText txt_num1;
    private EditText txt_num2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_resultado = findViewById(R.id.txt_resultado);

        txt_num1 = findViewById(R.id.txt_num1);
        txt_num2 = findViewById(R.id.txt_num2);

        buttonSuma = findViewById(R.id.buttonSuma);
        buttonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               txt_resultado.setText( suma(Integer.parseInt(txt_num1.getText().toString()),Integer.parseInt(txt_num2.getText().toString()))+"");
            }
        });
        buttonResta = findViewById(R.id.buttonResta);
        buttonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_resultado.setText( resta(Integer.parseInt(txt_num1.getText().toString()),Integer.parseInt(txt_num2.getText().toString()))+"");

            }
        });

        buttonMultiplicacion = findViewById(R.id.buttonMultiplicacion);
        buttonMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_resultado.setText( multiplicacion(Integer.parseInt(txt_num1.getText().toString()),Integer.parseInt(txt_num2.getText().toString()))+"");

            }
        });
        buttonDivision = findViewById(R.id.buttonDivision);
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_resultado.setText( division(Integer.parseInt(txt_num1.getText().toString()),Integer.parseInt(txt_num2.getText().toString()))+"");

            }
        });

// tambien le podemos poner un double en ves del in para que muetre los numeros decimales
    }
    public int suma(int a, int b){
        return a+b;
    }
    public int resta(int a, int b){
        return a-b;
    }
    public int multiplicacion(int a, int b){
        return a*b;
    }
    public int division(int a, int b){
        // si la respuesta es diferente de 0 que muestre la respuesta que es 0
        int respuesta =0;
        if (b!=0){
            respuesta =a/b;
        }
        return respuesta;
    }



    }