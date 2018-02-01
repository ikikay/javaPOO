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

    private int id_Livre;
    private String isbn;
    private int nbrPages;
    private Auteur Auteur;

    // --------------------------------------------------------------------
    // Constructeur :
    // --------------------------------------------------------------------
    public Livre() {
    }
    
    //Constructeur avec ID de la BDD
    public Livre(int id_Livre, String isbn, int nbrPages, Auteur Auteur, int id, String reference, String designation, double prix) {
        super(id, reference, designation, prix);
        this.id_Livre = id_Livre;
        this.isbn = isbn;
        this.nbrPages = nbrPages;
        this.Auteur = Auteur;
    }
    
    //Constructeur de l'objet Avant insertion BDD
    public Livre(String isbn, int nbrPages, Auteur Auteur, String reference, String designation, double prix) {
        super(reference, designation, prix);
        this.isbn = isbn;
        this.nbrPages = nbrPages;
        this.Auteur = Auteur;
    }
    

    // --------------------------------------------------------------------
    // Accesseurs :
    // --------------------------------------------------------------------
    public int getId_Livre() {
        return id_Livre;
    }

    public void setId_Livre(int id_Livre) {
        this.id_Livre = id_Livre;
    }

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

    public Auteur getAuteur() {
        return Auteur;
    }

    public void setAuteur(Auteur Auteur) {
        this.Auteur = Auteur;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
