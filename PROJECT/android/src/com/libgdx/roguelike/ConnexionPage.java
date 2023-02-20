package com.libgdx.roguelike;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConnexionPage extends AppCompatActivity {

    Button validerBtn;
    EditText etPseudo;
    String pseudoPlayer;

    public void initUi() {
        validerBtn = findViewById(R.id.validerBtn);
        etPseudo = findViewById(R.id.etPseudo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion_page);

        initUi();

        validerBtn.setOnClickListener(v -> {
            if(etPseudo != null) {
                pseudoPlayer = etPseudo.getText().toString();
                Toast.makeText(ConnexionPage.this, "Vous avez été enregistré sous le pseudo "
                        + pseudoPlayer + ".", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ConnexionPage.this, ModeSelection.class));

            } else {
                Toast.makeText(ConnexionPage.this, "Merci d'entrer un pseudo",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}