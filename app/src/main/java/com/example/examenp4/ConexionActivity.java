package com.example.examenp4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
public class ConexionActivity extends AppCompatActivity{
    private Button botonConectar;
    private EditText editTextNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conexion);

        // Vincula los elementos del diseño con las variables en tu código
        botonConectar = findViewById(R.id.botonConectar);
        editTextNombre = findViewById(R.id.editTextNombre);

        // Configura un listener para el botón de conexión
        botonConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtiene el nombre ingresado por el usuario
                String nombreUsuario = editTextNombre.getText().toString();

                // Ejemplo: Inicia una nueva actividad
                Intent intent = new Intent(ConexionActivity.this, Battle.class);
                intent.putExtra("nombreUsuario", nombreUsuario); // Puedes enviar datos extras si es necesario
                startActivity(intent);
            }
        });
    }
}
