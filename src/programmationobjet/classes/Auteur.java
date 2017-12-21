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

    private ArrayList<Livre> lesLivres;

    // --------------------------------------------------------------------
    // Constructeur :
    // --------------------------------------------------------------------
    public Auteur() {
        super(null, null, null);
    }

    public Auteur(String nom, String prenom, LocalDate dteNaissance) {
        super(nom, prenom, dteNaissance);
        this.lesLivres = new ArrayList<Livre>();
    }

    // --------------------------------------------------------------------
    // Accesseurs :
    // --------------------------------------------------------------------
    public ArrayList<Livre> getLesLivres() {
        return lesLivres;
    }

    public void setLesLivres(ArrayList<Livre> lesLivres) {
        this.lesLivres = lesLivres;
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
}
