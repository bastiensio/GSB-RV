
package fr.gsb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import fr.gsb.rv.entites.RapportdeVisite;
import fr.gsb.rv.modeles.ModeleGsb;

public class RapportDeVisiteActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapport_de_visite_vue);

        Intent intent = getIntent();
        int rapportNum = intent.getIntExtra("rapportNum", -1);

        ModeleGsb modeleGSB = ModeleGsb.getInstance();
        RapportdeVisite rapport = modeleGSB.getRapportParNum(rapportNum);

        if (rapport != null) {
            TextView num = findViewById(R.id.num);
            num.setText("Numéro de rapport : " + rapport.getNum() + "\n");

            TextView date = findViewById(R.id.date);
            date.setText("Date de visite : " + rapport.getDate_de_visite() + "\n");

            TextView redac = findViewById(R.id.redac);
            redac.setText("Rédacteur : " + rapport.getVisiteur().getNom() + " " +rapport.getVisiteur().getPrenom() + "\n" );

            TextView visite = findViewById(R.id.visite);
            visite.setText("Praticien visité : " + rapport.getPraticien().getNom() + " " + rapport.getPraticien().getPrenom() + "\n");

            TextView motif = findViewById(R.id.motif);
            motif.setText("Motif de visite : " + rapport.getMotif().getMotif() + "\n" );

            TextView bilan = findViewById(R.id.bilan);
            bilan.setText("Bilan : " + rapport.getBilan() + "\n" );

            TextView coefConfiance = findViewById(R.id.coefConfiance);
            coefConfiance.setText("Coefficient de confiance : " + rapport.getCoeffConfiance() + "\n");

        }
    }

    public void retour(View view) {
        Intent intent = new Intent(RapportDeVisiteActivity.this, MenuRvActivity.class);
        startActivity(intent);
    }
}

