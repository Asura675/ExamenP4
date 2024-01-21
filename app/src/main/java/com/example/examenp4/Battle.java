package com.example.examenp4;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class Battle extends AppCompatActivity {
    private ImageView imageViewMapa;
    private Spinner spinnerLetras;
    private Spinner spinnerNumeros;
    private Button botonAtacar;
    private TextView textViewPuntuacion;
    private ToggleButton botonPausaReproducir;
    private TextView textViewVictoria;
    private MediaPlayer mediaPlayer;
    private String letraSeleccionada;
    private String numeroSeleccionado;
    private int puntuacion;
    private int blancoLetra;
    private int blancoNumero;

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

        // Inicializar MediaPlayer con el archivo de audio
        mediaPlayer = MediaPlayer.create(this, R.raw.bgm_para_app);

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
                letraSeleccionada = spinnerLetras.getSelectedItem().toString();

                // Obtener el número seleccionado del Spinner de números
                numeroSeleccionado = spinnerNumeros.getSelectedItem().toString();

                // Realizar el ataque y actualizar el puntaje
                atacar();
            }
        });

        // Configurar el listener para el botón de Pausa/Reproducir
        botonPausaReproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    // Si el audio está reproduciéndose, pausar
                    mediaPlayer.pause();
                } else {
                    // Si el audio no está reproduciéndose, iniciar la reproducción
                    mediaPlayer.start();
                }
            }
        });

        // Configurar el listener para el spinner de letras
        spinnerLetras.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Obtener la letra seleccionada
                letraSeleccionada = parentView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Lógica cuando no se selecciona ninguna letra
                // Por ejemplo, puedes mostrar un mensaje indicando que no se ha seleccionado ninguna letra
                Toast.makeText(Battle.this, "Ninguna letra seleccionada", Toast.LENGTH_SHORT).show();
            }
        });

        // Configurar el listener para el spinner de números
        spinnerNumeros.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Obtener el número seleccionado
                numeroSeleccionado = parentView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Lógica cuando no se selecciona ningún número
                // Por ejemplo, puedes mostrar un mensaje indicando que no se ha seleccionado ningún número
                Toast.makeText(Battle.this, "Ningún número seleccionado", Toast.LENGTH_SHORT).show();
            }
        });

        // Inicializar puntuación y generar coordenadas para el blanco
        puntuacion = 0;
        generarBlancoAleatorio();
        actualizarVistaBlanco();
    }

    // Método para realizar el ataque
    private void atacar() {
        // Generar nuevas coordenadas aleatorias para el blanco
        generarBlancoAleatorio();

        // Verificar si el ataque acierta al blanco
        if (letraSeleccionada.equals(String.valueOf(blancoLetra)) && numeroSeleccionado.equals(String.valueOf(blancoNumero))) {
            // Incrementar la puntuación si el ataque acierta al blanco
            puntuacion++;
            // Mostrar un mensaje indicando que el ataque fue exitoso y la puntuación actualizada
            Toast.makeText(Battle.this, "¡Ataque exitoso! Puntuación: " + puntuacion, Toast.LENGTH_SHORT).show();
        } else {
            // Mostrar un mensaje indicando que el ataque falló
            Toast.makeText(Battle.this, "Ataque fallido. Inténtalo de nuevo.", Toast.LENGTH_SHORT).show();
        }

        // Actualizar el TextView de puntuación
        textViewPuntuacion.setText("Puntuación: " + puntuacion);
        // Actualizar la vista con las nuevas coordenadas del blanco
        actualizarVistaBlanco();
    }

    // Método para generar coordenadas aleatorias para el blanco
    private void generarBlancoAleatorio() {
        Random random = new Random();
        blancoLetra = random.nextInt(10); // Rango de 0 a 9 (10 letras de A a J)
        blancoNumero = random.nextInt(10) + 1; // Rango de 1 a 10
    }

    // Método para actualizar la vista con las coordenadas del blanco
    private void actualizarVistaBlanco() {
        // Puedes mostrar las coordenadas del blanco en algún lugar de la interfaz de usuario (por ejemplo, un TextView)
        String coordenadasBlanco = "Blanco en: " + obtenerLetraCorrespondiente(blancoLetra) + blancoNumero;
        textViewVictoria.setText(coordenadasBlanco);
    }

    // Método para obtener la letra correspondiente a un índice
    private String obtenerLetraCorrespondiente(int indice) {
        // Se asume que las letras están en orden de A a J
        char letra = (char) ('A' + indice);
        return String.valueOf(letra);
    }

    // Asegúrate de liberar los recursos del MediaPlayer cuando la actividad se destruye
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
