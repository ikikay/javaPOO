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
public abstract class Article {

    private int id_Article;
    private String reference;
    private String designation;
    private double prix;

    // --------------------------------------------------------------------
    // Constructeur :
    // --------------------------------------------------------------------
    public Article() {
    }

    //Constructeur avec ID de la BDD
    public Article(int id, String reference, String designation, double prix) {
        this.id_Article = id;
        this.reference = reference;
        this.designation = designation;
        this.prix = prix;
    }

    //Constructeur de l'objet Avant insertion BDD
    public Article(String reference, String designation, double prix) {
        this.reference = reference;
        this.designation = designation;
        this.prix = prix;
    }

    // --------------------------------------------------------------------
    // Accesseurs :
    // --------------------------------------------------------------------
    public int getId_Article() {
        return id_Article;
    }

    public void setId_Article(int id_Article) {
        this.id_Article = id_Article;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return this.reference + ", " + this.designation;
    }
}
