/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmationobjet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import programmationobjet.classes.Auteur;
import programmationobjet.classes.Dvd;
import programmationobjet.classes.Livre;
import programmationobjet.classes.Personne;
import programmationobjet.classes.Realisateur;
import programmationobjet.main.ProgrammationObjet;

/**
 *
 * @author Ikikay
 */
public class dao {

    private static Connection cnxDirect;
    private static Statement stat;
    private static ResultSet res;

    public static void setClassForName(String classForName) {
        try {
            Class.forName(classForName);
            System.out.println("Driver chargé avec succès");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur pendant le chargement du pilote");
        }
    }

    public static void setConnection(String host, String port, String db, String user, String mdp) {
        try {
            cnxDirect = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db + "?user=" + user + "&password=" + mdp);
            System.out.println("Connexion établie avec succès --> bdd : " + db + " user : " + user);
        } catch (SQLException e) {
            System.out.println("Erreur pendant la connexion : " + e);
        }
    }

    public static void executeSql(String sql) {
        try {
            stat = cnxDirect.createStatement();
            System.out.println("Objet Statement créé avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur pendant la création de l'objet Statement : " + e);
        }
        try {
            stat.execute(sql);
            System.out.println("Exécution de la requête avec succès : " + sql);
        } catch (SQLException e) {
            System.out.println("Erreur pendant l'éxecution de la requête : " + sql + " : " + e);
        }
    }

    public static void createAuteur(Auteur lAuteur) {
        try {
            stat = cnxDirect.createStatement();
            System.out.println("Objet Statement créé avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur pendant la création de l'objet Statement : " + e);
        }
        try {
            Date DateNaissance = Date.valueOf(lAuteur.getDteNaissance());
            stat.execute("INSERT INTO personne("
                    + "Nom, Prenom, DteNaissance) VALUES ('"
                    + lAuteur.getNom() + "','" + lAuteur.getPrenom() + "','" + DateNaissance + "')");
            res = stat.executeQuery("SELECT ID_Personne FROM personne WHERE "
                    + "Nom = '" + lAuteur.getNom()
                    + "' AND Prenom = '" + lAuteur.getPrenom()
                    + "' AND DteNaissance = '" + DateNaissance + "'");
            while (res.next()) {
                lAuteur.setId_Personne(res.getInt("ID_Personne"));
            }
            stat.execute("INSERT INTO auteur(FK_ID_Personne) VALUES (" + lAuteur.getId_Personne() + ")");
            res = stat.executeQuery("SELECT ID_Auteur FROM auteur WHERE FK_ID_Personne = " + lAuteur.getId_Personne());
            while (res.next()) {
                lAuteur.setId_Auteur(res.getInt("ID_Auteur"));
            }

            System.out.println("Exécution de la requête d'ajout d'Auteur avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur pendant l'éxecution de la requête d'ajout d'Auteur : " + e);
        }
    }

    public static void createRealisateur(Realisateur leRealisateur) {
        try {
            stat = cnxDirect.createStatement();
            System.out.println("Objet Statement créé avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur pendant la création de l'objet Statement : " + e);
        }
        try {
            Date DateNaissance = Date.valueOf(leRealisateur.getDteNaissance());
            stat.execute("INSERT INTO personne("
                    + "Nom, Prenom, DteNaissance) VALUES ('"
                    + leRealisateur.getNom() + "','" + leRealisateur.getPrenom() + "','" + DateNaissance + "')");
            res = stat.executeQuery("SELECT ID_Personne FROM personne WHERE "
                    + "Nom = '" + leRealisateur.getNom()
                    + "' AND Prenom = '" + leRealisateur.getPrenom()
                    + "' AND DteNaissance = '" + DateNaissance + "'");
            while (res.next()) {
                leRealisateur.setId_Personne(res.getInt("ID_Personne"));
            }
            stat.execute("INSERT INTO realisateur(FK_ID_Personne) VALUES (" + leRealisateur.getId_Personne() + ")");
            res = stat.executeQuery("SELECT ID_Realisateur FROM realisateur WHERE FK_ID_Personne = " + leRealisateur.getId_Personne());
            while (res.next()) {
                leRealisateur.setId_Realisateur(res.getInt("ID_Realisateur"));
            }

            System.out.println("Exécution de la requête d'ajout d'Auteur avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur pendant l'éxecution de la requête d'ajout d'Auteur : " + e);
        }
    }

    public static void createDvd(Dvd leDvd) {
        try {
            stat = cnxDirect.createStatement();
            System.out.println("Objet Statement créé avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur pendant la création de l'objet Statement : " + e);
        }
        try {
            stat.execute("INSERT INTO article("
                    + "Reference, Designation, Prix) VALUES ('"
                    + leDvd.getReference() + "','"
                    + leDvd.getDesignation() + "','"
                    + leDvd.getPrix() + "')");
            res = stat.executeQuery("SELECT ID_Article FROM article WHERE "
                    + "Reference = '" + leDvd.getReference()
                    + "' AND Designation = '" + leDvd.getDesignation()
                    + "' AND Prix = '" + leDvd.getPrix() + "'");
            while (res.next()) {
                leDvd.setId_Article(res.getInt("ID_Article"));
            }
            stat.execute("INSERT INTO dvd("
                    + "FK_ID_Article, Duree, FK_ID_Realisateur) VALUES ('"
                    + leDvd.getId_Article() + "','"
                    + leDvd.getDuree() + "','"
                    + leDvd.getRealisateur().getId_Realisateur() + "')");
            res = stat.executeQuery("SELECT ID_Dvd FROM dvd WHERE FK_ID_Article = " + leDvd.getId_Article());
            while (res.next()) {
                leDvd.setId_Dvd(res.getInt("ID_Dvd"));
            }

            System.out.println("Exécution de la requête d'ajout d'Auteur avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur pendant l'éxecution de la requête d'ajout d'Auteur : " + e);
        }
    }

    public static void createLivre(Livre leLivre) {
        try {
            stat = cnxDirect.createStatement();
            System.out.println("Objet Statement créé avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur pendant la création de l'objet Statement : " + e);
        }
        try {
            stat.execute("INSERT INTO article("
                    + "Reference, Designation, Prix) VALUES ('"
                    + leLivre.getReference() + "','"
                    + leLivre.getDesignation() + "','"
                    + leLivre.getPrix() + "')");
            res = stat.executeQuery("SELECT ID_Article FROM article WHERE "
                    + "Reference = '" + leLivre.getReference()
                    + "' AND Designation = '" + leLivre.getDesignation()
                    + "' AND Prix = '" + leLivre.getPrix() + "'");
            while (res.next()) {
                leLivre.setId_Article(res.getInt("ID_Article"));
            }
            stat.execute("INSERT INTO livre("
                    + "FK_ID_Article, Isbn, NbrPages, FK_ID_Auteur) VALUES ('"
                    + leLivre.getId_Article() + "','"
                    + leLivre.getIsbn() + "','"
                    + leLivre.getNbrPages() + "','"
                    + leLivre.getAuteur().getId_Auteur() + "')");
            res = stat.executeQuery("SELECT ID_Livre FROM livre WHERE FK_ID_Article = " + leLivre.getId_Article());
            while (res.next()) {
                leLivre.setId_Livre(res.getInt("ID_Livre"));
            }

            System.out.println("Exécution de la requête d'ajout d'Auteur avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur pendant l'éxecution de la requête d'ajout d'Auteur : " + e);
        }
    }

    public static ArrayList<Realisateur> getAllRealisateur() {
        ArrayList<Realisateur> lesRealisateurs = new ArrayList();

        try {
            stat = cnxDirect.createStatement();
            System.out.println("Objet Statement créé avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur pendant la création de l'objet Statement : " + e);
        }
        try {
            res = stat.executeQuery("SELECT * FROM realisateur "
                    + "INNER JOIN Personne ON FK_ID_Personne = ID_Personne");
            System.out.println("Exécution du select * de la table réalisateur");

            while (res.next()) {
                Realisateur r = new Realisateur();
                r.setId_Realisateur(res.getInt("ID_Realisateur"));
                r.setId_Personne(res.getInt("ID_Personne"));
                r.setNom(res.getString("Nom"));
                r.setPrenom(res.getString("Prenom"));
                r.setDteNaissance(res.getDate("DteNaissance").toLocalDate());
                lesRealisateurs.add(r);
            }

            return lesRealisateurs;

        } catch (SQLException e) {
            System.out.println("Erreur pendant l'exécution du select sur la table réalisateur : " + e);
        }

        return lesRealisateurs;
    }

    public static ArrayList<Auteur> getAllAuteur() {
        ArrayList<Auteur> lesAuteurs = new ArrayList();

        try {
            stat = cnxDirect.createStatement();
            System.out.println("Objet Statement créé avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur pendant la création de l'objet Statement : " + e);
        }
        try {
            res = stat.executeQuery("SELECT * FROM auteur "
                    + "INNER JOIN Personne ON FK_ID_Personne = ID_Personne");
            System.out.println("Exécution du select * de la table auteur");

            while (res.next()) {
                Auteur a = new Auteur();
                a.setId_Auteur(res.getInt("ID_Auteur"));
                a.setId_Personne(res.getInt("ID_Personne"));
                a.setNom(res.getString("Nom"));
                a.setPrenom(res.getString("Prenom"));
                a.setDteNaissance(res.getDate("DteNaissance").toLocalDate());
                lesAuteurs.add(a);
            }

            return lesAuteurs;

        } catch (SQLException e) {
            System.out.println("Erreur pendant l'exécution du select sur la table auteur : " + e);
        }

        return lesAuteurs;
    }

    public static ArrayList<Dvd> getAllDvd() {
        ArrayList<Dvd> lesDvd = new ArrayList();

        try {
            stat = cnxDirect.createStatement();
            System.out.println("Objet Statement créé avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur pendant la création de l'objet Statement : " + e);
        }
        try {
            res = stat.executeQuery("SELECT * FROM dvd INNER JOIN article ON FK_ID_Article = ID_Article "
                    + "INNER JOIN realisateur ON FK_ID_Realisateur = ID_Realisateur "
                    + "INNER JOIN personne ON FK_ID_Personne = ID_Personne");
            System.out.println("Exécution du select * de la table Dvd");

            while (res.next()) {
                Dvd d = new Dvd();
                d.setId_Dvd(res.getInt("ID_Dvd"));
                d.setDuree(res.getInt("Duree"));
                d.setId_Article(res.getInt("ID_Article"));
                d.setReference(res.getString("Reference"));
                d.setDesignation(res.getString("Designation"));
                d.setPrix(res.getInt("Prix"));
                d.setRealisateur(new Realisateur(res.getInt("ID_Realisateur"), res.getInt("ID_Personne"), res.getString("Nom"), res.getString("Prenom"), res.getDate("DteNaissance").toLocalDate()));
                lesDvd.add(d);
            }

            return lesDvd;

        } catch (SQLException e) {
            System.out.println("Erreur pendant l'exécution du select sur la table Dvd : " + e);
        }

        return lesDvd;
    }

    public static ArrayList<Livre> getAllLivre() {
        ArrayList<Livre> lesLivre = new ArrayList();

        try {
            stat = cnxDirect.createStatement();
            System.out.println("Objet Statement créé avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur pendant la création de l'objet Statement : " + e);
        }
        try {
            res = stat.executeQuery("SELECT * FROM livre INNER JOIN article ON FK_ID_Article = ID_Article "
                    + "INNER JOIN auteur ON FK_ID_Auteur = ID_Auteur "
                    + "INNER JOIN personne ON FK_ID_Personne = ID_Personne");
            System.out.println("Exécution du select * de la table livre");

            while (res.next()) {
                Livre l = new Livre();
                l.setId_Livre(res.getInt("ID_Livre"));
                l.setIsbn(res.getString("Isbn"));
                l.setNbrPages(res.getInt("ID_Livre"));
                l.setId_Article(res.getInt("ID_Article"));
                l.setReference(res.getString("Reference"));
                l.setDesignation(res.getString("Designation"));
                l.setPrix(res.getInt("Prix"));
                l.setAuteur(new Auteur(res.getInt("ID_Auteur"), res.getInt("ID_Personne"), res.getString("Nom"), res.getString("Prenom"), res.getDate("DteNaissance").toLocalDate()));
                lesLivre.add(l);
            }

            return lesLivre;

        } catch (SQLException e) {
            System.out.println("Erreur pendant l'exécution du select sur la table livre : " + e);
        }

        return lesLivre;
    }
}
