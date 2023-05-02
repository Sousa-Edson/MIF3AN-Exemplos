package com.example.segundoprograma;

//import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // escopo de variaveis
    EditText edtNome, edtSobreNome, edtIdade;
    Button btnUnir, btnLimpar, btnFechar;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        inicializarComponentes();

        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });

        btnUnir.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                //utilize Alt+Enter para IDE oferecer opçoes de correção
               if(!validaDados()){
                   String nome = edtNome.getText().toString();
                   String sobreNome = edtSobreNome.getText().toString();
                   String idade = edtIdade.getText().toString();

                   tvResult.setText("Bem vindo!"+nome+" "+sobreNome+"\nVocê tem"+idade+"anos de idade");
               }else{
                   tvResult.setText("Resultado");
                   Toast.makeText(getApplicationContext(),"Existem campos em branco!",Toast.LENGTH_LONG).show();
               }
            }
        });
    }

    private boolean validaDados() {
        Boolean existeErros = false;
        if (edtNome.getText().toString().isEmpty()){
            edtNome.setError("Obrigatório *");
            edtNome.requestFocus();
            existeErros = true;
        }else if (edtSobreNome.getText().toString().isEmpty()) {
            edtSobreNome.setError("Obrigatório *");
            edtSobreNome.requestFocus();
            existeErros = true;
        }else if (edtIdade.getText().toString().isEmpty()) {
            edtIdade.setError("Obrigatório *");
            edtIdade.requestFocus();
            existeErros = true;
        }
        return existeErros;
    }

    private void limparCampos() {
        edtNome.setText("");
        edtSobreNome.setText("");
        edtIdade.setText("");
        tvResult.setText("Resultado");

        //voltar foco para primeira linha
        edtNome.requestFocus();
    }

    private void inicializarComponentes() {
        edtNome = findViewById(R.id.edtNome);
        edtSobreNome = findViewById(R.id.edtSobreNome);
        edtIdade = findViewById(R.id.edtIdade);

        btnUnir = findViewById(R.id.btnUnir);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFechar = findViewById(R.id.btnFechar);

        tvResult = findViewById(R.id.textView);

        edtNome.requestFocus();

    }

}