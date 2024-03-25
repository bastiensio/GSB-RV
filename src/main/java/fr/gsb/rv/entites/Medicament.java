package fr.gsb.rv.entites;

public class Medicament {
    private String depot_legal = null;
    private String nom = null;

    public Medicament(String depot_legal, String nom) {
        this.depot_legal = depot_legal;
        this.nom = nom;
    }

    public String getDepot_legal() {
        return depot_legal;
    }

    public void setDepot_legal(String depot_legal) {
        this.depot_legal = depot_legal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
