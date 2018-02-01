/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmationobjet.classes;

import java.time.LocalDate; //dteNaissance
import java.util.ArrayList; // lesLivres

/**
 *
 * @author Ikikay
 */
public class Auteur extends Personne {

    private int id_Auteur;
    private ArrayList<Livre> lesLivres;

    // --------------------------------------------------------------------
    // Constructeur :
    // --------------------------------------------------------------------
    public Auteur() {
    }

    //Constructeur avec ID de la BDD
    public Auteur(int id_Auteur, int id, String nom, String prenom, LocalDate dteNaissance) {
        super(id, nom, prenom, dteNaissance);
        this.id_Auteur = id_Auteur;
    }
    
    //Constructeur de l'objet Avant insertion BDD
    public Auteur(String nom, String prenom, LocalDate dteNaissance) {
        super(nom, prenom, dteNaissance);
    }
    

    // --------------------------------------------------------------------
    // Accesseurs :
    // --------------------------------------------------------------------
    public int getId_Auteur() {
        return id_Auteur;
    }

    public void setId_Auteur(int id_Auteur) {
        this.id_Auteur = id_Auteur;
    }

    public ArrayList<Livre> getLesLivres() {
        return lesLivres;
    }

    public void setLesLivres(ArrayList<Livre> lesLivres) {
        this.lesLivres = lesLivres;
    }

    public String getClassToString() {
        return "Auteur";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
