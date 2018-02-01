/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmationobjet.classes;

/**
 *
 * @author Ikikay
 */
public class Dvd extends Article {

    private int id_Dvd;
    private double duree;
    private Realisateur Realisateur;

    // --------------------------------------------------------------------
    // Constructeur :
    // --------------------------------------------------------------------
    public Dvd() {
    }

    //Constructeur avec ID de la BDD
    public Dvd(int id_Dvd, double duree, Realisateur Realisateur, int id, String reference, String designation, double prix) {
        super(id, reference, designation, prix);
        this.id_Dvd = id_Dvd;
        this.duree = duree;
        this.Realisateur = Realisateur;
    }
    
    //Constructeur de l'objet Avant insertion BDD
        public Dvd(double duree, Realisateur Realisateur, String reference, String designation, double prix) {
        super(reference, designation, prix);
        this.duree = duree;
        this.Realisateur = Realisateur;
    }

    // --------------------------------------------------------------------
    // Accesseurs :
    // --------------------------------------------------------------------
    public int getId_Dvd() {
        return id_Dvd;
    }

    public void setId_Dvd(int id_Dvd) {
        this.id_Dvd = id_Dvd;
    }

    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public Realisateur getRealisateur() {
        return Realisateur;
    }

    public void setRealisateur(Realisateur Realisateur) {
        this.Realisateur = Realisateur;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
