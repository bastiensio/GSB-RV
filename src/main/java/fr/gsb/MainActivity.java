package fr.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.EditText;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.modeles.ModeleGsb;
import fr.gsb.rv.technique.Session;

public class MainActivity extends AppCompatActivity {
    private TextView echecauthentification;
    private EditText matriculeSaisie, mdpSaisie;
    private ModeleGsb modeleGsb;

    private static final String TAG = "GSB_MAIN_ACTIVITY";


    private Session session ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Création de l'activité principale");
        echecauthentification = (TextView) findViewById(R.id.erreur);
        echecauthentification.setText("");
        matriculeSaisie = findViewById(R.id.MatriculeSaisie);
        mdpSaisie = findViewById(R.id.MdpSaisie);
        modeleGsb = ModeleGsb.getInstance();
        session = Session.getSession();
    }

    public void valider(View vue) {

        String login = matriculeSaisie.getText().toString();
        String mdp = mdpSaisie.getText().toString();
        Visiteur connexion = modeleGsb.seConnecter(login, mdp);

        if (connexion == null) {
            echecauthentification = (TextView) findViewById(R.id.erreur);
            echecauthentification.setText("Erreur de l'authentification. Recommencer ...");
            Log.i(TAG, "connexionNok");


        } else {
            Session.ouvrir(connexion);
            echecauthentification = (TextView) findViewById(R.id.erreur);
            echecauthentification.setText("authetification réussi");
            String nomUtilisateur = connexion.getNom();
            String prenomUtilisateur = connexion.getPrenom();

            Log.i(TAG, "connexionOk "+ nomUtilisateur +" "+ prenomUtilisateur);
            Intent intentionEnvoyer = new Intent(this , MenuRvActivity.class);
            startActivity(intentionEnvoyer);
        }
    }
    /*public void valider(View vue) {
        String url = "http://172.20.50.98:5000/visiteurs/";
        String donnéeAEncoder = url + matriculeSaisie.getText().toString() +"/"+ mdpSaisie.getText().toString() ;
        Log.i(TAG,donnéeAEncoder);
        try {
            String visiteursaisie = URLEncoder.encode(donnéeAEncoder , "UTF-8");
            Response.Listener<JSONObject> ecouteurReponse = new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        Visiteur visiteur = new Visiteur();
                        visiteur.setNom(response.getString("vis_nom"));
                        visiteur.setMatricule(response.getString("vis_matricule"));
                        visiteur.setPrenom(response.getString("vis_prenom"));




                    }
                    catch(JSONException e){
                        Log.e("GSB-RV","ERREUR HTTP " + e.getMessage() );
                    }
                }
            };
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        Intent intentionEnvoyer = new Intent(this , MenuRvActivity.class);
        startActivity(intentionEnvoyer);
    }
    */
    public void annuler(View vue) {
        matriculeSaisie = findViewById(R.id.MatriculeSaisie);
        matriculeSaisie.setText("");
        mdpSaisie = findViewById(R.id.MdpSaisie);
        mdpSaisie.setText("");
        Log.i(TAG, "initialisation des champs ");


    }

}