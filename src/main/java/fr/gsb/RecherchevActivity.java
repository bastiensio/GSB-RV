package fr.gsb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class RecherchevActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherchev);

        Spinner mois = findViewById(R.id.lvmois);
        Spinner annee = findViewById(R.id.lvannee);
        Button validerButton = findViewById(R.id.btnValider);
        Button buttonRetour = findViewById(R.id.retour);

        List<String> months = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            months.add(String.valueOf(i));
        }
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, months);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mois.setAdapter(monthAdapter);

        List<String> years = new ArrayList<>();
        for (int i = 2020; i <= 2030; i++) {
            years.add(String.valueOf(i));
        }
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, years);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        annee.setAdapter(yearAdapter);

        validerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecherchevActivity.this, ListeRvActivity.class);
                String moisSelectionne = mois.getSelectedItem().toString();
                String anneeSelectionne = annee.getSelectedItem().toString();

                intent.putExtra("mois", moisSelectionne);
                intent.putExtra("annee", anneeSelectionne);
                startActivity(intent);
            }
        });

        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecherchevActivity.this, MenuRvActivity.class);
                startActivity(intent);
            }
        });
    }
}
