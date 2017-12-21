/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmationobjet.classes;

import java.time.LocalDate; //dteNaissance

/**
 *
 * @author Ikikay
 */
public abstract class Personne {

    private String nom;
    private String prenom;
    private LocalDate dteNaissance;

    // --------------------------------------------------------------------
    // Constructeur :
    // --------------------------------------------------------------------
    public Personne(String nom, String prenom, LocalDate dteNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dteNaissance = dteNaissance;
    }

    // --------------------------------------------------------------------
    // Accesseurs :
    // --------------------------------------------------------------------
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

    public LocalDate getDteNaissance() {
        return dteNaissance;
    }

    public void setDteNaissance(LocalDate dteNaissance) {
        this.dteNaissance = dteNaissance;
    }

    @Override
    public String toString() {
        return this.getNom() + " " + this.getPrenom();
    }
}
