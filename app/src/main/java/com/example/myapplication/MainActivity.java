package com.example.myapplication;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button buttonCalcular;
    private EditText editTextValor;
    private TextView textViewSerie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewSerie = findViewById(R.id.textViewSerie);
        editTextValor = findViewById(R.id.editTextValor);

        buttonCalcular.setOnClickListener(e->calculate());
    }

    private void calculate(){
        int n = Integer.parseInt(editTextValor.getText().toString());

        if(n >0 && n <20){
            double soma = 0.0;
            for (int i = 1; i <= n; i++) {
                soma += (double) i / (i * i);
            }

            textViewSerie.setText("Resultado da série:\n"+soma);
            textViewSerie.setTextColor(Color.parseColor("#FF0000"));

        }else{
            textViewSerie.setText("Valor Inválido.");
            textViewSerie.setTextColor(Color.parseColor("#FF0000"));
        }

    }

}