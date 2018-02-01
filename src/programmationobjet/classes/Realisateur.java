/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmationobjet.classes;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Ikikay
 */
public class Realisateur extends Personne {

    private int id_Realisateur;
    private ArrayList<Dvd> lesDvd;

    // --------------------------------------------------------------------
    // Constructeur :
    // --------------------------------------------------------------------
    public Realisateur() {
    }

    //Constructeur avec ID de la BDD
    public Realisateur(int id_Realisateur, int id, String nom, String prenom, LocalDate dteNaissance) {
        super(id, nom, prenom, dteNaissance);
        this.id_Realisateur = id_Realisateur;
    }
    
    //Constructeur de l'objet Avant insertion BDD
    public Realisateur(String nom, String prenom, LocalDate dteNaissance) {
        super(nom, prenom, dteNaissance);
    }
    

    // --------------------------------------------------------------------
    // Accesseurs :
    // --------------------------------------------------------------------
    public int getId_Realisateur() {
        return id_Realisateur;
    }

    public void setId_Realisateur(int id_Realisateur) {
        this.id_Realisateur = id_Realisateur;
    }

    public ArrayList<Dvd> getLesDvd() {
        return lesDvd;
    }

    public void setLesDvd(ArrayList<Dvd> lesDvd) {
        this.lesDvd = lesDvd;
    }

    public String getClassToString() {
        return "Realisateur";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
