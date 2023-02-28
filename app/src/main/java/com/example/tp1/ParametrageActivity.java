package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ParametrageActivity extends AppCompatActivity {
    private EditText e_nomAjout;

    private RadioButton r_entree;
    private RadioButton r_plat;
    private RadioButton r_dessert;

    private Button b_gestPlats;

    private Button b_ajouter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrage);

        e_nomAjout = findViewById(R.id.e_nomAjout);
        r_dessert = findViewById(R.id.r_dessert);
        r_entree = findViewById(R.id.r_entree);
        r_plat = findViewById(R.id.r_plat);
        b_ajouter = findViewById(R.id.b_ajouter);
        b_ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text;
                text = e_nomAjout.getText().toString();
                if(!text.isEmpty()){
                    if (r_entree.isChecked()){
                        Log.d("entree", text);
                    }
                    else if (r_plat.isChecked()) {
                        Log.d("plat", text);
                    }
                    else if (r_dessert.isChecked()) {
                        Log.d("dessert", text);
                    }
                }
                else {
                    Log.d("erreur", "Pas de saisie");
                }

            }
        });


        b_gestPlats = findViewById(R.id.b_gestPlats);

        b_gestPlats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("nouvelleVue", "Vers gest plats");
                Intent intent = new Intent(getApplicationContext(), GestionPlatsActivity.class);
                startActivity(intent);
            }
        });

    }
}