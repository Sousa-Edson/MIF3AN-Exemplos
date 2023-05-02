package com.example.ciclodevvida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNovaTela = (Button) findViewById(R.id.btnNovaTela);
        btnNovaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Tela2.class);
                startActivity(intent);
            }
        });
        Log.i("ESTADO_ACTIVITY", "Tela 1: onCreate");
    }

    // primeiro método é o onCreate linha 13

    @Override
    protected void onStart() {
        super.onStart();
        // para visualizar cada interação vamos usar o console para imprimir o estado atual da Activity
        // vamos usar a classe Log
        Log.i("ESTADO_ACTIVITY", "Tela 1: onStar");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ESTADO_ACTIVITY", "Tela 1: onResume");
    }
    // Até aqui o app já é visualizado e pode ser manipulado.

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ESTADO_ACTIVITY", "Tela 1: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ESTADO_ACTIVITY", "Tela 1: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ESTADO_ACTIVITY", "Tela 1: onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ESTADO_ACTIVITY", "Tela 1: onRestart");
    }
}