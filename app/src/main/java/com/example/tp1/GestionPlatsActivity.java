package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class GestionPlatsActivity extends AppCompatActivity {

    // Déclaration des variables (tous les éléments
    Button b_supprimer;
    Button b_ajouter;
    EditText et_nouveau;
    LinearLayout ll_listeCheckbox;


    // Fonctions de gestion des événements
    private void afficherChk(){
        ll_listeCheckbox.removeAllViews();

        for (int i = 0; i < Modele.lesPlats.size(); i++){
            CheckBox unchk = new CheckBox(this);
            unchk.setText(Modele.lesPlats.get(i));
            ll_listeCheckbox.addView(unchk);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_plats);

        b_supprimer = findViewById(R.id.b_supprimer);
        b_ajouter = findViewById(R.id.b_ajouter);
        et_nouveau = findViewById(R.id.et_nouveau);
        ll_listeCheckbox = findViewById(R.id.ll_listeCheckbox);

        Modele.initPlats();
        afficherChk();
    }
}