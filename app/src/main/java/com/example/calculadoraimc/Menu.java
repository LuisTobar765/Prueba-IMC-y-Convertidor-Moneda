package com.example.calculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {
    private Button btnCalculadoraIMC;
    private Button btnConvertidorMoneda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        // Botón para la calculadora de IMC
        btnCalculadoraIMC = findViewById(R.id.btnCalculadoraIMC);
        if (btnCalculadoraIMC != null) {
            btnCalculadoraIMC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Menu.this, IMC.class);
                    startActivity(intent);
                }
            });
        } else {
            Toast.makeText(this, "Botón de Calculadora IMC no encontrado", Toast.LENGTH_SHORT).show();
        }

        // Botón para el conversor de moneda
        btnConvertidorMoneda = findViewById(R.id.btnConvertidorMoneda);
        if (btnConvertidorMoneda != null) {
            btnConvertidorMoneda.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Menu.this, ConvertidorMoneda.class);
                    startActivity(intent);
                }
            });
        } else {
            Toast.makeText(this, "Botón de Convertidor de Moneda no encontrado", Toast.LENGTH_SHORT).show();
        }
    }
}
