package fr.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListeRvActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rv);
    }
    public void retour(View vue){
        Intent intentionEnvoyer = new Intent(this , RecherchevActivity.class);
        startActivity(intentionEnvoyer);
    }

}