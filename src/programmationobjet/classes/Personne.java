/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmationobjet.classes;

import java.time.LocalDate; //dteNaissance
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Ikikay
 */
public abstract class Personne {

    private int id_Personne;
    private String nom;
    private String prenom;
    private LocalDate dteNaissance;

    // --------------------------------------------------------------------
    // Constructeur :
    // --------------------------------------------------------------------
    public Personne() {
    }

    //Constructeur avec ID de la BDD
    public Personne(int id, String nom, String prenom, LocalDate dteNaissance) {
        this.id_Personne = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dteNaissance = dteNaissance;
    }
    
    //Constructeur de l'objet Avant insertion BDD
    public Personne(String nom, String prenom, LocalDate dteNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dteNaissance = dteNaissance;
    }
    

    // --------------------------------------------------------------------
    // Accesseurs :
    // --------------------------------------------------------------------
    public int getId_Personne() {
        return id_Personne;
    }

    public void setId_Personne(int id_Personne) {
        this.id_Personne = id_Personne;
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

    public LocalDate getDteNaissance() {
        return dteNaissance;
    }

    public void setDteNaissance(LocalDate dteNaissance) {
        this.dteNaissance = dteNaissance;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatterToDate = DateTimeFormatter.ofPattern("d/MM/yyyy");
        return this.getNom() + " " + this.getPrenom() + " " + this.getDteNaissance().format(formatterToDate);
    }
}
