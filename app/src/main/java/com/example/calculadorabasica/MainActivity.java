package com.example.calculadorabasica;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText numero1, numero2;
    TextView campo_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = findViewById(R.id.N1);
        numero2 = findViewById(R.id.N2);
        campo_resultado = findViewById(R.id.txt_resultado);

        Button somar = findViewById(R.id.btn_somar);
        Button subtrair = findViewById(R.id.btn_subtrair);
        Button multiplicar = findViewById(R.id.btn_multiplicar);
        Button dividir = findViewById(R.id.btn_divisao);

        somar.setOnClickListener(v -> calcular("+"));
        subtrair.setOnClickListener(v -> calcular("-"));
        multiplicar.setOnClickListener(v -> calcular("*"));
        dividir.setOnClickListener(v -> calcular("/"));
    }

    public void calcular(String operacao) {

        String valor1 = numero1.getText().toString().trim();
        String valor2 = numero2.getText().toString().trim();

        if (valor1.isEmpty()) {
            numero1.setError("Digite o 1 número");
            return;
        }
        if (valor2.isEmpty()) {
            numero2.setError("Digite o 2 número");
            return;
        }

        float n1;
        float n2;

        try {
            n1 = Float.parseFloat(valor1);
            n2 = Float.parseFloat(valor2);
        } catch (NumberFormatException e){
            campo_resultado.setText("Número inválido");
            return;
        }
        
        float resultado = 0;

        switch (operacao) {

            case "+":
                resultado = n1 + n2;
                break;

            case "-":
                resultado = n1 - n2;
                break;

            case "*":
                resultado = n1 * n2;
                break;

            case "/":
                if (n2 == 0) {
                    campo_resultado.setText("Não pode dividir por zero");
                    return;
                }

                resultado = n1 / n2;
                break;
        }

        campo_resultado.setText("Resultado = " + resultado);
    }
}
