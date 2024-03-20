package fr.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class RecherchevActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] moisEnlettre = {"janvier","février","mars","avril","mai","juin","juillet","août","septembre","octobre","novembre","décembre"};
    private String[] anneeEnChiffre = {"2020","2021","2022","2023","2024","2025"};
    Spinner mois;
    Spinner annee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherchev);
        mois = (Spinner) findViewById(R.id.lvmois);
        annee = (Spinner) findViewById(R.id.lvannee);
        ArrayAdapter<String> adapteurmois = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                moisEnlettre
        );
        ArrayAdapter<String> adapteurannee = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                anneeEnChiffre
        );
        mois.setAdapter(adapteurmois);
        annee.setAdapter(adapteurannee);

    }
    public void retour(View vue){
        Intent intentionEnvoyer = new Intent(this , MenuRvActivity.class);
        startActivity(intentionEnvoyer);
    }
    public void valider(View  vue){
        Intent intentionEnvoyer = new Intent(this , ListeRvActivity.class);
        startActivity(intentionEnvoyer);
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

    }
}