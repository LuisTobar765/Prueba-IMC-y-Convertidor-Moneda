package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class IMC extends AppCompatActivity {

    private EditText etHeight, etWeight;
    private RadioGroup genderGroup;
    private RadioButton rbMale, rbFemale;
    private Button btnCalculate;
    private TextView tvResult;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imc);

        // Vincular vistas
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        genderGroup = findViewById(R.id.genderGroup);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);
        btnVolver = findViewById(R.id.btnVolver);

        // Acción del botón calcular
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

        // Acción del botón volver
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void calculateBMI() {
        String heightStr = etHeight.getText().toString();
        String weightStr = etWeight.getText().toString();

        // Validación básica
        if (heightStr.isEmpty() || weightStr.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa todos los datos", Toast.LENGTH_SHORT).show();
            return;
        }

        float height = Float.parseFloat(heightStr);
        float weight = Float.parseFloat(weightStr);

        // Calcular IMC
        float bmi = weight / (height * height);

        // Determinar género
        int selectedGenderId = genderGroup.getCheckedRadioButtonId();
        if (selectedGenderId == -1) {
            Toast.makeText(this, "Por favor selecciona un género", Toast.LENGTH_SHORT).show();
            return;
        }

        String gender = selectedGenderId == R.id.rbMale ? "Hombre" : "Mujer";
        displayBMIResult(bmi, gender);
    }

    private void displayBMIResult(float bmi, String gender) {
        String bmiCategory;
        if (bmi < 18.5) {
            bmiCategory = "Bajo peso";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            bmiCategory = "Peso normal";
        } else if (bmi >= 25 && bmi <= 29.9) {
            bmiCategory = "Sobrepeso";
        } else {
            bmiCategory = "Obesidad";
        }

        String result = "Género: " + gender + "\nIMC: " + String.format("%.2f", bmi) + "\nCategoría: " + bmiCategory;
        tvResult.setText(result);
    }
}
