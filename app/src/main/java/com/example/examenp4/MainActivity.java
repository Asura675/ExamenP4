package com.example.examenp4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Duración del splash screen en milisegundos
    private static final int SPLASH_TIME_OUT = 3000; // 3 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Delay para el splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Después del tiempo determinado, inicia la actividad de conexión
                Intent intent = new Intent(MainActivity.this, ConexionActivity.class);
                startActivity(intent);

                // Cierra la actividad actual
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}