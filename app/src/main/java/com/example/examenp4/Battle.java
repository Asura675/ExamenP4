package com.example.examenp4;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
public class Battle extends AppCompatActivity{
    private ImageView imageViewMapa;
    private Spinner spinnerLetras;
    private Spinner spinnerNumeros;
    private Button botonAtacar;
    private TextView textViewPuntuacion;
    private ToggleButton botonPausaReproducir;
    private TextView textViewVictoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battle);

        // Inicializar vistas
        imageViewMapa = findViewById(R.id.imageViewMapa);
        spinnerLetras = findViewById(R.id.spinnerLetras);
        spinnerNumeros = findViewById(R.id.spinnerNumeros);
        botonAtacar = findViewById(R.id.botonAtacar);
        textViewPuntuacion = findViewById(R.id.textViewPuntuacion);
        botonPausaReproducir = findViewById(R.id.botonPausaReproducir);
        textViewVictoria = findViewById(R.id.textViewVictoria);

        // Configurar el adaptador para los spinners (letras y números)
        ArrayAdapter<CharSequence> letrasAdapter = ArrayAdapter.createFromResource(
                this, R.array.letras_array, android.R.layout.simple_spinner_item);
        letrasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLetras.setAdapter(letrasAdapter);

        ArrayAdapter<CharSequence> numerosAdapter = ArrayAdapter.createFromResource(
                this, R.array.numeros_array, android.R.layout.simple_spinner_item);
        numerosAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNumeros.setAdapter(numerosAdapter);

        // Configurar el listener para el botón de Atacar
        botonAtacar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener la letra seleccionada del Spinner de letras
                String letraSeleccionada = spinnerLetras.getSelectedItem().toString();

                // Obtener el número seleccionado del Spinner de números
                String numeroSeleccionado = spinnerNumeros.getSelectedItem().toString();

            }
        });

        // Configurar el listener para los spinners (opcional, según tus necesidades)
        spinnerLetras.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Lógica al seleccionar una letra
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Lógica cuando no se selecciona ninguna letra
            }
        });

        spinnerNumeros.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Lógica al seleccionar un número
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Lógica cuando no se selecciona ningún número
            }
        });

        // Configurar el listener para el botón de Pausa/Reproducir (opcional, según tus necesidades)
        botonPausaReproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para pausar o reproducir el tema de juego
            }
        });
    }
}
