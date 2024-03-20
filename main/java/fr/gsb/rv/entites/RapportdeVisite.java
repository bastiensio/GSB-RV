package fr.gsb.rv.entites;

import java.util.Date;

public class RapportdeVisite {
    private String num = null;
    private Date date_de_visite = null;
    private String bilan = null ;
    public Visiteur visiteur = null;
    public Motif motif = null;
    public Praticien praticien = null;

    public RapportdeVisite(String num, Date date_de_visite, String bilan, Visiteur visiteur, Motif motif, Praticien praticien) {
        this.num = num;
        this.date_de_visite = date_de_visite;
        this.bilan = bilan;
        this.visiteur = visiteur;
        this.motif = motif;
        this.praticien = praticien;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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
}
