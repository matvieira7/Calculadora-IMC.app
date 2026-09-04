package com.example.calculadoraimc;
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

        Button calcular = findViewById(R.id.btn_calcular);

        calcular.setOnClickListener(v -> calcular());
    }

    public void calcular() {

        String valor1 = numero1.getText().toString().trim();
        String valor2 = numero2.getText().toString().trim();

        if (valor1.isEmpty()) {
            numero1.setError("Digite o peso");
            return;
        }

        if (valor2.isEmpty()) {
            numero2.setError("Digite a altura");
            return;
        }

        float peso;
        float altura;

        try {
            peso = Float.parseFloat(valor1);
            altura = Float.parseFloat(valor2);
        } catch (NumberFormatException e) {
            campo_resultado.setText("Digite apenas numeros");
            return;
        }

        float imc = peso / (altura * altura);

        if (imc < 18.5) {
            campo_resultado.setText("IMC = " + imc + "\nBaixo peso");

        } else if (imc < 25) {
            campo_resultado.setText("IMC = " + imc + "\nPeso normal");

        } else if (imc < 30) {
            campo_resultado.setText("IMC = " + imc + "\nSobrepeso");

        } else if (imc < 35) {
            campo_resultado.setText("IMC = " + imc + "\nObesidade grau 1");

        } else if (imc < 40) {
            campo_resultado.setText("IMC = " + imc + "\nObesidade grau 2");

        } else {
            campo_resultado.setText("IMC = " + imc + "\nObesidade grau 3");
        }
    }
}