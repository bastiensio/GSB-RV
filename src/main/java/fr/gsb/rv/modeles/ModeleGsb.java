package fr.gsb.rv.modeles;

import android.nfc.Tag;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List ;

import fr.gsb.rv.entites.Motif;
import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.entites.Praticien;

import fr.gsb.rv.entites.Medicament;
import fr.gsb.rv.entites.RapportdeVisite;


public class ModeleGsb {

    private static ModeleGsb modele = null ;

    private List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>() ;
    private List<Praticien> lesPraticiens = new ArrayList<Praticien>() ;

    private List<Motif> LesMotifs = new ArrayList<Motif>();

    private List<Medicament> lesMedicaments = new ArrayList<>();

    private List<RapportdeVisite> lesRapports = new ArrayList<>();
    private ModeleGsb(){
        super() ;
        this.peupler() ;
    }

    public static ModeleGsb getInstance(){
        if( ModeleGsb.modele == null ){
            modele = new ModeleGsb() ;
        }
        return ModeleGsb.modele ;
    }

    private void peupler(){
        this.lesVisiteurs.add( new Visiteur("a131","azerty","Villechalane","Louis") ) ;
        this.lesVisiteurs.add( new Visiteur("b13","azerty","Bentot","Pascal") ) ;
        this.lesVisiteurs.add( new Visiteur("b16","azerty","Bioret","Luc") ) ;
        this.lesVisiteurs.add( new Visiteur("a17","azerty","Andre","David") ) ;
        this.lesPraticiens.add(new Praticien("1", "Doe", "John", "123 rue rue", 12345, "ville", 5));
        this.lesPraticiens.add(new Praticien("2", "Smith", "Jane", "456 boulevard boulevard", 67890, "mop", 4));
        this.lesPraticiens.add(new Praticien("3", "Johnson", "Bob", "789 rue boulevard", 10111, "george", 3));
        this.lesPraticiens.add(new Praticien("4", "Williams", "Alice", "987 boulvard rue", 54321, "marc", 6));
        this.LesMotifs.add(new Motif("première visite"));
        this.LesMotifs.add(new Motif("Visite régulière"));
        this.LesMotifs.add(new Motif("recommendation du praticien"));
        this.lesMedicaments.add(new Medicament("Depot1", "Doliprane"));
        this.lesMedicaments.add(new Medicament("Depot2", "Daphalgan"));
        this.lesMedicaments.add(new Medicament("Depot3", "Paracétamol"));
        this.lesMedicaments.add(new Medicament("Depot4", "Sirop pour la toux"));


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2024);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date january2024 = calendar.getTime();
        RapportdeVisite rapport1 = new RapportdeVisite(1, january2024, "super", lesVisiteurs.get(0), LesMotifs.get(0), lesPraticiens.get(0),1, new ArrayList<>());
        rapport1.ajouterMedicamentOffert(lesMedicaments.get(0));

        RapportdeVisite rapport2 = new RapportdeVisite(2, january2024, "moyen", lesVisiteurs.get(1), LesMotifs.get(1), lesPraticiens.get(1), 1, new ArrayList<>());
        rapport2.ajouterMedicamentOffert(lesMedicaments.get(1));
        rapport2.ajouterMedicamentOffert(lesMedicaments.get(2));

        lesRapports.add(rapport1);
        lesRapports.add(rapport2);


    }

    public List<Praticien> getLesPraticiens() {
        return lesPraticiens;
    }

    public List<Motif> getLesMotifs() {
        return LesMotifs;
    }

    public List<RapportdeVisite> getLesRapports() {
        return lesRapports;
    }

    public Visiteur seConnecter(String matricule, String mdp){
        for( Visiteur unVisiteur : this.lesVisiteurs ){
            System.out.println(unVisiteur.getMdp());
            if( unVisiteur.getMatricule().equals(matricule) && unVisiteur.getMdp().equals(mdp) ){
                return unVisiteur ;
            }
        }

        return null ;

    }
    public ArrayList<RapportdeVisite> filtre(String annee, String mois) {
        ArrayList<RapportdeVisite> Retour = new ArrayList<>();
        SimpleDateFormat sdfMois = new SimpleDateFormat("MM");
        SimpleDateFormat sdfAnnee = new SimpleDateFormat("yyyy");

        for (int i = 0; i < this.lesRapports.size(); i++) {
            Date dateDeVisite = lesRapports.get(i).getDate_de_visite();
            String moisVisite = sdfMois.format(dateDeVisite);
            String anneeVisite = sdfAnnee.format(dateDeVisite);
            int moisInt = Integer.parseInt(moisVisite);
            int anneeInt = Integer.parseInt(anneeVisite);

            if (moisInt == Integer.parseInt(mois) && anneeInt == Integer.parseInt(annee)) {
                Retour.add(lesRapports.get(i));
            }
        }
        return Retour;
    }
    public RapportdeVisite getRapportParNum(int numRapport) {
        for (RapportdeVisite rapport : lesRapports) {
            if (rapport.getNum() == numRapport) {
                return rapport;
            }
        }
        return null;
    }
}