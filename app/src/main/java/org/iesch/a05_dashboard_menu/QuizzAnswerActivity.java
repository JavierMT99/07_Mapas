package org.iesch.a05_dashboard_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import org.iesch.a05_dashboard_menu.databinding.ActivityQuizzAnswerBinding;

public class QuizzAnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQuizzAnswerBinding binding = ActivityQuizzAnswerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();

        if(extras.getBoolean("correcta") == true){
            binding.texto.setText(R.string.respuestaCorrecta);
        }else{
            binding.texto.setText(R.string.respuestaFallada);
        }

        if(extras.getInt("numeroPregunta") < 2){
            binding.boton.setText(R.string.irSiguientePregunta);
        }else{
            binding.boton.setText(R.string.volverEmpezar);
        }

        binding.boton.setOnClickListener(v ->{
            Volver(extras);
        });
    }

    private void Volver(Bundle extras){
        Intent irPregunta = new Intent(this, QuizzesActivity.class);

        if(extras.getInt("numeroPregunta") > 1){
            irPregunta.putExtra("numeroPregunta", 0);
        }else{
            irPregunta.putExtra("numeroPregunta", extras.getInt("numeroPregunta") + 1);
        }

        startActivity(irPregunta);
    }
}