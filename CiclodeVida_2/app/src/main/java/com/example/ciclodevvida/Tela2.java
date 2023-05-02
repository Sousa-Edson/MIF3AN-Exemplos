package com.example.ciclodevvida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        Log.i("ESTADO_ACTIVITY", "Tela 2: onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ESTADO_ACTIVITY", "Tela 2: onStar");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ESTADO_ACTIVITY", "Tela 2: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ESTADO_ACTIVITY", "Tela 2: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ESTADO_ACTIVITY", "Tela 2: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ESTADO_ACTIVITY", "Tela 2: onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ESTADO_ACTIVITY", "Tela 2: onRestart");
    }
}