package com.example.tp1;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner s_quantite;
    private EditText e_quantite;
    private Button b_parametre;

    private Spinner s_plat;

    private void affSpinnerPlats(){
        Spinner s_plat = findViewById(R.id.s_plat);

        ArrayAdapter<String> contenu = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        //Modele unModele = new Modele();

        for (int i = 0; i < Modele.lesPlats.size(); i++){
            contenu.add(Modele.lesPlats.get(i));
        }

        s_plat.setAdapter(contenu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Modele.initPlats();
        s_quantite=findViewById(R.id.s_quantite);
        e_quantite=findViewById(R.id.e_quantite);

        // Spinner Quantite
        s_quantite.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = s_quantite.getSelectedItem().toString();
                e_quantite.setText(text);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                e_quantite.setText(0);
            }
        });

        // Edit quantite
        e_quantite.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text;
                text = e_quantite.getText().toString();
                if (text.isEmpty() || (parseInt(text) >= 1 && parseInt(text)<=10) ){
                    s_quantite.setEnabled(true);
                }
                else{
                    s_quantite.setEnabled(false);
                }

            }
        });

        b_parametre=findViewById(R.id.b_parametre);
        b_parametre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent unIntent = new Intent(getApplicationContext(), ParametrageActivity.class);
                startActivity(unIntent);
            }
        });

        affSpinnerPlats();

    }
}