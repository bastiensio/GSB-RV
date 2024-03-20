package fr.gsb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

import fr.gsb.rv.entites.Motif;
import fr.gsb.rv.entites.Praticien;
import fr.gsb.rv.modeles.ModeleGsb;

public class SaisirRvActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    TextView dateSelectionner;
    GregorianCalendar ladaterapportVisite;

    private ModeleGsb modeleGsb;
    private String[] coeffConfiance = {"0","1","2","3","4","5"};
    Spinner motif;
    Spinner praticien;
    Spinner CoeffConfiance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisir_rv);
        dateSelectionner = findViewById(R.id.dateSelectionner);
        praticien = (Spinner) findViewById(R.id.Praticien);
        modeleGsb = ModeleGsb.getInstance();
        List<Praticien> praticiens = modeleGsb.getLesPraticiens();
        List<String> praticiensNomPrenom = new ArrayList<String>();
        praticiens.forEach(praticien -> {
            praticiensNomPrenom.add(praticien.getNom() + " " + praticien.getPrenom());
        });
        ArrayAdapter<String> PraticcienSpinner = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                praticiensNomPrenom
        );
        praticien.setAdapter(PraticcienSpinner);
        motif = (Spinner) findViewById(R.id.Motif);
        List<Motif> motifs = modeleGsb.getLesMotifs();
        List<String> Motif = new ArrayList<String>();
        motifs.forEach(motif -> {
            Motif.add(motif.getMotif());
        });
        ArrayAdapter<String> MotifSpinner = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                Motif
        );
        motif.setAdapter(MotifSpinner);
        CoeffConfiance = (Spinner) findViewById(R.id.CoeffConfiance);
        ArrayAdapter<String> CoeffConfianceSpinner = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                coeffConfiance
        );
        CoeffConfiance.setAdapter(CoeffConfianceSpinner);

    }
    public void retour(View vue){
        Intent intentionEnvoyer = new Intent(this , MenuRvActivity.class);
        startActivity(intentionEnvoyer);
    }
    public void selectionnerDateCommande (View view) {
        GregorianCalendar aujourdhui = new GregorianCalendar();
        int jour = aujourdhui.get(Calendar.DAY_OF_MONTH);
        int mois = aujourdhui.get(Calendar.MONTH);
        int annee = aujourdhui.get(Calendar.YEAR);
        new DatePickerDialog(this,this,annee,mois,jour).show();
    }



    public void onDateSet(DatePicker view,int year,int mounthOfYear,int dayOfMounth){
        String dateCommande = String.format("%02d/%02d/%04d",dayOfMounth,mounthOfYear+1,year);
        dateSelectionner.setText(dateCommande);
        ladaterapportVisite = new GregorianCalendar(year,mounthOfYear,dayOfMounth);

    }
}