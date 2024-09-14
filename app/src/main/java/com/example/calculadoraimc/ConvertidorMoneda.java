package com.example.calculadoraimc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class ConvertidorMoneda extends AppCompatActivity {
    private EditText etAmount;
    private Button btnConvert, btnVolver;
    private TextView tvConverted;
    private Spinner spinnerCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convertidor);

        // Inicializar los componentes de la interfaz
        etAmount = findViewById(R.id.et_amount);
        btnConvert = findViewById(R.id.btn_convert);
        tvConverted = findViewById(R.id.tv_converted);
        spinnerCurrency = findViewById(R.id.spinnerSeleccionador);
        btnVolver = findViewById(R.id.btnVolver);

        // Configurar el Spinner con las opciones de monedas
        String[] currencies = {"USD", "EUR", "GBP", "JPY"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, currencies);
        spinnerCurrency.setAdapter(adapter);

        // Tasa de cambio ficticia de CLP a otras monedas
        double usdRate = 0.0013;
        double eurRate = 0.0011;
        double gbpRate = 0.0010;
        double jpyRate = 0.18;

        // Acción del botón convertir
        btnConvert.setOnClickListener(v -> {
            String amountStr = etAmount.getText().toString();
            String selectedCurrency = spinnerCurrency.getSelectedItem().toString();

            if (!amountStr.isEmpty()) {
                double amount = Double.parseDouble(amountStr);
                double converted = 0;

                // Realizar la conversión dependiendo de la moneda seleccionada
                switch (selectedCurrency) {
                    case "USD":
                        converted = amount * usdRate;
                        break;
                    case "EUR":
                        converted = amount * eurRate;
                        break;
                    case "GBP":
                        converted = amount * gbpRate;
                        break;
                    case "JPY":
                        converted = amount * jpyRate;
                        break;
                }

                tvConverted.setText("Equivale a: " + String.format("%.2f", converted) + " " + selectedCurrency);
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
}
