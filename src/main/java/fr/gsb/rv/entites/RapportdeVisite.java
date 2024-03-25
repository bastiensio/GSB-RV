package fr.gsb.rv.entites;

import java.util.Date;
import java.util.List;

public class RapportdeVisite {
    private int num = 0;
    private Date date_de_visite = null;
    private String bilan = null;
    private Visiteur visiteur = null;
    private Motif motif = null;
    private Praticien praticien = null;

    private int coeffConfiance = 0;
    private List<Medicament> medicamentsOfferts;

    public RapportdeVisite(int num, Date date_de_visite, String bilan, Visiteur visiteur, Motif motif, Praticien praticien, int coeffConfiance, List<Medicament> medicamentsOfferts) {
        this.num = num;
        this.date_de_visite = date_de_visite;
        this.bilan = bilan;
        this.visiteur = visiteur;
        this.motif = motif;
        this.praticien = praticien;
        this.coeffConfiance = coeffConfiance;
        this.medicamentsOfferts = medicamentsOfferts;
    }

    public void ajouterMedicamentOffert(Medicament medicament) {
        this.medicamentsOfferts.add(medicament);
    }

    public void supprimerMedicamentOffert(Medicament medicament) {
        this.medicamentsOfferts.remove(medicament);
    }

    public List<Medicament> getMedicamentsOfferts() {
        return this.medicamentsOfferts;
    }

    public void setMedicamentsOfferts(List<Medicament> medicamentsOfferts) {
        this.medicamentsOfferts = medicamentsOfferts;
    }

    // Autres getters et setters

    public int getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = Integer.parseInt(num);
    }

    public Date getDate_de_visite() {
        return date_de_visite;
    }

    public void setDate_de_visite(Date date_de_visite) {
        this.date_de_visite = date_de_visite;
    }

    public String getBilan() {
        return bilan;
    }

    public void setBilan(String bilan) {
        this.bilan = bilan;
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public Motif getMotif() {
        return motif;
    }

    public void setMotif(Motif motif) {
        this.motif = motif;
    }

    public Praticien getPraticien() {
        return praticien;
    }

    public void setPraticien(Praticien praticien) {
        this.praticien = praticien;
    }

    public int getCoeffConfiance() {
        return coeffConfiance;
    }

    public void setCoeffConfiance(int coeffConfiance) {
        this.coeffConfiance = coeffConfiance;
    }
}