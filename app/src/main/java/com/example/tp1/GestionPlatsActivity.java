package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

    ArrayList<CheckBox> lstCheck;


    // Fonctions de gestion des événements
    private void afficherChk(){
        lstCheck.clear();
        ll_listeCheckbox.removeAllViews();

        for (int i = 0; i < Modele.lesPlats.size(); i++){
            LinearLayout unLayout = new LinearLayout(GestionPlatsActivity.this);
            unLayout.setOrientation(LinearLayout.HORIZONTAL);

            CheckBox unchk = new CheckBox(this);
            unchk.setText(Modele.lesPlats.get(i));
            lstCheck.add(unchk);

            unLayout.addView(unchk);
            ll_listeCheckbox.addView(unLayout);
        }
    }

    private void supprimerChk(){
        for (int i = lstCheck.size()-1; i > 0; i--){
            // Prendre le checkbox actuel
            if (lstCheck.get(i).isChecked()){
                Modele.lesPlats.remove(i);
            }
        }
        afficherChk();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_plats);

        b_supprimer = findViewById(R.id.b_supprimer);

        b_supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                supprimerChk();
            }
        });


        b_ajouter = findViewById(R.id.b_ajouter);
        et_nouveau = findViewById(R.id.et_nouveau);
        ll_listeCheckbox = findViewById(R.id.ll_listeCheckbox);

        lstCheck = new ArrayList();


        afficherChk();
    }
}