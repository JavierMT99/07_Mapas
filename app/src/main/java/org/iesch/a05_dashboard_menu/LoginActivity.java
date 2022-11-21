package org.iesch.a05_dashboard_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import org.iesch.a05_dashboard_menu.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);

        if (preferencias.getString("email","") != ""){
            Intent i = new Intent(LoginActivity.this, MenuActivity.class);
            startActivity(i);
        }

        binding.editTextEmailAddress.setText(preferencias.getString("email",""));
        binding.editTextPassword.setText(preferencias.getString("pass",""));

        binding.btnEntrar.setOnClickListener(v -> {
            guardar(binding.editTextPassword.getText().toString(), binding.editTextPassword.getText().toString());
            Toast.makeText(this, "Se ha guardado correctamente", Toast.LENGTH_SHORT).show();

        });
    }

    private void guardar(String pass, String mail) {

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = preferences.edit();

        Obj_editor.putString("email", pass);
        Obj_editor.putString("pass", mail);
        Obj_editor.commit();

        Intent i = new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(i);
    }
}