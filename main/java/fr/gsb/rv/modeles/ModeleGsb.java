package fr.gsb.rv.modeles;

import android.nfc.Tag;
import android.util.Log;

import java.util.ArrayList;
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

    }

    public List<Praticien> getLesPraticiens() {
        return lesPraticiens;
    }

    public List<Motif> getLesMotifs() {
        return LesMotifs;
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
}