package fr.gsb.rv.technique;
import fr.gsb.rv.entites.Visiteur;

public class Session {

    private static Session session = null ;
    private final Visiteur visiteur;

    private Session(Visiteur visiteur){
        this.visiteur = visiteur ;
    }
    public static void ouvrir(Visiteur unVisiteur){
        if( Session.session == null ){
            Session.session = new Session(unVisiteur) ;
        }
    }
    public static Session getSession() {
        return Session.session;
    }

    public static void fermer(){
        Session.session = null;
    }

}
