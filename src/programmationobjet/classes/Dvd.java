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

    private double duree;
    private String Realisateur;

    // --------------------------------------------------------------------
    // Constructeur :
    // --------------------------------------------------------------------
    public Dvd() {
        super(null, null, 0);
    }

    public Dvd(String reference, String designation, double prix, double duree, String Realisateur) {
        super(reference, designation, prix);
        this.duree = duree;
        this.Realisateur = Realisateur;
    }

    // --------------------------------------------------------------------
    // Accesseurs :
    // --------------------------------------------------------------------
    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public String getRealisateur() {
        return Realisateur;
    }

    public void setRealisateur(String Realisateur) {
        this.Realisateur = Realisateur;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
