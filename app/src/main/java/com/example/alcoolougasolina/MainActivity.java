package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText edtPrecoAlcool, edtPrecoGasolina;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPrecoAlcool = findViewById(R.id.edtPrecoAlcool);
        edtPrecoGasolina = findViewById(R.id.edtPrecoGasolina);
        txtResultado = findViewById(R.id.txtResultado);
    }

    public void btnCalcularClick(View view) {
        if (edtPrecoAlcool.getText().toString().equals("")) {
            Toast.makeText(this, "Informe o preço do Álcool", Toast.LENGTH_SHORT).show();
            edtPrecoAlcool.requestFocus();
            return;
        }
        if (edtPrecoGasolina.getText().toString().equals("")) {
            Toast.makeText(this, "Informe o preço da Gasolina", Toast.LENGTH_SHORT).show();
            edtPrecoGasolina.requestFocus();
        }

        Double precoAlcool = Double.parseDouble(edtPrecoAlcool.getText().toString());
        Double precoGasolina = Double.parseDouble(edtPrecoGasolina.getText().toString());

        txtResultado.setText("Melhor utilizar " + ((precoAlcool / precoGasolina) >= 0.7 ? "Gasolina" : "Álcool"));
    }
}