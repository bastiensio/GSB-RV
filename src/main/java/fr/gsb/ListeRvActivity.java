package fr.gsb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

import fr.gsb.rv.entites.RapportdeVisite;
import fr.gsb.rv.modeles.ModeleGsb;

public class ListeRvActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rv);

        Intent intent = getIntent();
        String anneeSelectionne = intent.getStringExtra("annee");
        String moisSelectionne = intent.getStringExtra("mois");

        ModeleGsb modeleGSB = ModeleGsb.getInstance();
        ArrayList<RapportdeVisite> filtreRVs = modeleGSB.filtre(anneeSelectionne, moisSelectionne);

        ListView listerapports = findViewById(R.id.liste_rapports);

        ArrayList<String> rvStringList = new ArrayList<>();
        for (RapportdeVisite rv : filtreRVs){
            rvStringList.add( rv.getNum() + "\nDate rapport: " + rv.getDate_de_visite() + "\nRédacteur: " + rv.getVisiteur() );
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rvStringList);
        listerapports.setAdapter(adapter);

        listerapports.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RapportdeVisite clickedRapport = filtreRVs.get(position);
                Intent intent = new Intent(ListeRvActivity.this, RapportDeVisiteActivity.class);
                intent.putExtra("rapportNum", clickedRapport.getNum());
                startActivity(intent);
            }
        });
    }
}