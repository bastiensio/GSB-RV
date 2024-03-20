package fr.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.technique.Session;

public class MenuRvActivity extends AppCompatActivity {
    TextView nomPrenom ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_rv);
        nomPrenom = findViewById(R.id.nomPrenom);

    }


    public void saisir(View vue){
        Intent intentionEnvoyer = new Intent(this , SaisirRvActivity.class);
        startActivity(intentionEnvoyer);
    }
    public void consulter(View vue){
        Intent intentionEnvoyer = new Intent(this , RecherchevActivity.class);
        startActivity(intentionEnvoyer);
    }
    public void deconnection(View vue){
        Intent intentionEnvoyer = new Intent(this , MainActivity.class);
        startActivity(intentionEnvoyer);
    }
}