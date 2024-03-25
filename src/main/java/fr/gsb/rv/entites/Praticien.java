package fr.gsb.rv.entites;


public class Praticien {
    private String num = null;
    private String nom = null;
    private String prenom = null;
    private String addresse = null;
    private Integer code_postal = null;
    private String ville = null;
    private Integer coef_notoriéte = null;

    public Praticien(String num, String nom, String prenom, String addresse, Integer code_postal, String ville, Integer coef_notoriéte) {
        this.num = num;
        this.nom = nom;
        this.prenom = prenom;
        this.addresse = addresse;
        this.code_postal = code_postal;
        this.ville = ville;
        this.coef_notoriéte = coef_notoriéte;
    }


    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public Integer getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(Integer code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getCoef_notoriéte() {
        return coef_notoriéte;
    }

    public void setCoef_notoriéte(Integer coef_notoriéte) {
        this.coef_notoriéte = coef_notoriéte;
    }
}
