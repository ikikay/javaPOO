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

    private ArrayList<Dvd> lesDvd;

    // --------------------------------------------------------------------
    // Constructeur :
    // --------------------------------------------------------------------
    public Realisateur() {
        super(null, null, null);
    }

    public Realisateur(String nom, String prenom, LocalDate dteNaissance) {
        super(nom, prenom, dteNaissance);
        this.lesDvd = new ArrayList<Dvd>();
    }

    // --------------------------------------------------------------------
    // Accesseurs :
    // --------------------------------------------------------------------
    public ArrayList<Dvd> getLesDvd() {
        return lesDvd;
    }

    public void setLesDvd(ArrayList<Dvd> lesDvd) {
        this.lesDvd = lesDvd;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
