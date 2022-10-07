package com.ejercicio.tds_noct_2022_1_orlasic.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ejercicio.tds_noct_2022_1_orlasic.R;

public class Lista extends AppCompatActivity {

    private TextView tv1;
    private ListView lv1;

    private String producto [] = {"Cuadro Personalizdos", "LLaveros", "Pulcera", "Rosario Cristo", "LLavero Personalizado", "Pulcera bebe",
            "Cuadro San Jose", "Recuerdo Bautizo", "Recuerdo Difuntos", "Recurdo Matrimonio"};
    private String precio [] = {"25,50", "1.00", "1.00", "1.50", "1.75", "1.25", "20.o", "2.50", "2.50", "2.50"};
    private String codigo [] = {"001", "002", "003", "004", "005", "006", "007", "008", "009", "010"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        tv1 = (TextView)findViewById(R.id.tv1);
        lv1 = (ListView)findViewById(R.id.lv1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, producto);
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv1.setText("El precio de " + lv1.getItemAtPosition(i) + " es $"+precio[i] + " y su codigo es " + codigo[i] );
            }
        });
    }
}