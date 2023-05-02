package com.example.bdsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewOnReceiveContentListener;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class ExemploSharedPreferences extends AppCompatActivity {
    private TextView lblStatus;
    private EditText txtNome, txtIdade;
    private RadioButton rbMasculino, rbFeminino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_shared_preferences);

        // referencia a todos os componentes
        lblStatus = (TextView) findViewById(R.id.textViewStatus);
        txtNome = (EditText) findViewById(R.id.editTextNome);
        txtIdade = (EditText) findViewById(R.id.editTextIdade);
        rbMasculino = (RadioButton) findViewById(R.id.radioMasculino);
        rbFeminino = (RadioButton) findViewById(R.id.radioFeminino);

        // adicionar um listener ao botão
        findViewById(R.id.btnSalvar).setOnClickListener(clickListenerSharePreferences);

        // chamar o metodo para preencher o formulário.
        readPreferences();
    }
    private View.OnClickListener clickListenerSharePreferences = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String nome = txtNome.getText().toString();
            String idade = txtIdade.getText().toString();
            String sexo = "";

            if (rbMasculino.isChecked()){
                sexo = "Masculino";
            }else{
                sexo = "Feminino";
            }
            // criar arquivo de preferencias
            SharedPreferences filePreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = filePreferences.edit();

            editor.putString("nome", nome);
            editor.putString("sexo", sexo);
            editor.putString("idade", idade);

            //salvar os dados
            editor.commit();

            lblStatus.setText("Status: Preferências salvas com sucesso!!!");
        }
    };
    // metodo para ler os dados quando o App for iniciado.
    private void readPreferences(){
        SharedPreferences filePreferences = getPreferences(MODE_PRIVATE);

        String nome = filePreferences.getString("nome","");
        String idade = filePreferences.getString("idade","");
        String sexo = filePreferences.getString("sexo","Masculino");

        txtNome.setText(nome);
        txtIdade.setText(idade);

        if(sexo.equals("Masculino")){
            rbMasculino.setChecked(true);
        }else{
            rbFeminino.setChecked(true);
        }
    }



}