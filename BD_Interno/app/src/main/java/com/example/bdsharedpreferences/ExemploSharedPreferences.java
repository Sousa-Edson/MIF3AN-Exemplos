package com.example.bdsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewOnReceiveContentListener;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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
        findViewById(R.id.btnSalvar).setOnClickListener(clickListenerInterno);

        // chamar o metodo para preencher o formulário.
        //readPreferences();

        readFileInterno();
    }
    private View.OnClickListener clickListenerInterno = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //recuperar os dados para o formulário
            String nome = txtNome.getText().toString();
            String idade = txtIdade.getText().toString();
            String sexo = "";

            if (rbMasculino.isChecked()){
                sexo = "Masculino";
            }else{
                sexo = "Feminino";
            }
            salvarArquivoInterno(nome, sexo, idade);

            lblStatus.setText("Status: Dados salvos Interno !!!");
        }
    };
    private void salvarArquivoInterno(String nome, String sexo, String idade){
        String dados = "";
        dados += "nome+"+nome;
        dados += "\n";
        dados += "idade+"+idade;
        dados += "\n";
        dados += "sexo+"+sexo;
        dados += "\n";

        try{
            FileOutputStream fos = openFileOutput("dados.txt", MODE_PRIVATE);
            fos.write(dados.getBytes());
            fos.close();

        }catch (Exception e){
            Log.e("Error file: ", e.getMessage());
        }
    }
    // criar metodo para ler o arquivo
    private void readFileInterno(){
        String nome = "";
        String idade = "";
        String sexo = "Masculino";

        try {
            File dir = getFilesDir();
            File file = new File (dir+"/dados.txt");

            if(file.exists()){
                FileInputStream fis = openFileInput("dados.txt");
                byte[] buffer = new byte[(int) file.length()];

                while (fis.read(buffer) != -1){
                    String texto = new String(buffer);

                    if(texto.indexOf("nome") != -1){
                        int indice = texto.indexOf("=");
                        int indiceFinal = texto.indexOf("\n");
                        nome = texto.substring(indice+1, indiceFinal);
                        texto = texto.substring(indiceFinal+1);
                    }
                    if(texto.indexOf("idade") != -1){
                        int indice = texto.indexOf("=");
                        int indiceFinal = texto.indexOf("\n");
                        nome = texto.substring(indice+1, indiceFinal);
                        idade = texto.substring(indiceFinal+1);
                    }
                    if(texto.indexOf("sexo") != -1){
                        int indice = texto.indexOf("=");
                        sexo = texto.substring(indice+1);

                    }
                }
            }

        }catch (Exception e){
            Log.e("Error file: ", e.getMessage());
        }

        txtNome.setText(nome);
        txtIdade.setText(idade);

        if(sexo.contains("Masculino")){
            rbMasculino.setChecked(true);
        }else{
            rbFeminino.setChecked(true);
        }
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