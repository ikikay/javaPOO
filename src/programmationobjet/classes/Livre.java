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
public class Livre extends Article {

    private String isbn;
    private int nbrPages;
    private String Auteur;

    // --------------------------------------------------------------------
    // Constructeur :
    // --------------------------------------------------------------------
    public Livre() {
        super(null, null, 0);
    }

    public Livre(String reference, String designation, double prix, String isbn, int nbrPages, String Auteur) {
        super(reference, designation, prix);
        this.isbn = isbn;
        this.nbrPages = nbrPages;
        this.Auteur = Auteur;
    }

    // --------------------------------------------------------------------
    // Accesseurs :
    // --------------------------------------------------------------------
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNbrPages() {
        return nbrPages;
    }

    public void setNbrPages(int nbrPages) {
        this.nbrPages = nbrPages;
    }

    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String Auteur) {
        this.Auteur = Auteur;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
