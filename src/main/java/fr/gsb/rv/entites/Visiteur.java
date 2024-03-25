package fr.gsb.rv.entites;

public class Visiteur {
    private String matricule = null ;
    private String mdp = null;
    private String nom = null;
    private String prenom = null;



    public Visiteur(String matricule, String mdp,String nom, String prenom ) {
        this.matricule = matricule;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }


    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMdp(){ return mdp;}

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMdp(String mdp){ this.mdp = mdp;}
}
