/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmationobjet.main;

import java.time.LocalDate;
import programmationobjet.classes.*;

import java.util.ArrayList;
import programmationobjet.dao.dao;
import programmationobjet.forms.FormFenetre;

/**
 *
 * @author Ikikay
 */
public class ProgrammationObjet {

    public static ArrayList<Article> globalLesArticles;                         // Créer une liste qui sera accessible partout
    public static ArrayList<Personne> globalLesPersonnes;                       // Créer une liste qui sera accessible partout

    public static String classForName = "com.mysql.jdbc.Driver";
    public static String host = "localhost";
    public static String port = "3306";
    public static String db = "S04_projet";
    public static String user = "root";
    public static String mdp = "";

    //Création de la BDD
    public static String createPersonnetSql
            = "CREATE TABLE Personne ( "
            + "`ID_Personne` INT NOT NULL AUTO_INCREMENT , "
            + "`Nom` VARCHAR(255) NOT NULL , "
            + "`Prenom` VARCHAR(255) NOT NULL , "
            + "`DteNaissance` DATE NOT NULL , "
            + "PRIMARY KEY (`ID_Personne`)) ENGINE = InnoDB;";
    public static String createAuteurSql
            = "CREATE TABLE Auteur ( "
            +"`ID_Auteur` INT NOT NULL AUTO_INCREMENT, "
            +"`FK_ID_Personne` INT NOT NULL  , "
            +"PRIMARY KEY (`ID_Auteur`)) ENGINE = InnoDB;";
    public static String createRealisateurSql
            = "CREATE TABLE Realisateur ( "
            +"`ID_Realisateur` INT NOT NULL AUTO_INCREMENT , "
            +"`FK_ID_Personne` INT NOT NULL  , "
            +"PRIMARY KEY (`ID_Realisateur`)) ENGINE = InnoDB;";
    public static String createArticleSql
            = "CREATE TABLE Article ( "
            +"`ID_Article` INT NOT NULL AUTO_INCREMENT , "
            +"`Reference` VARCHAR(255) NOT NULL , "
            +"`Designation` VARCHAR(255) NOT NULL , "
            +"`Prix` DOUBLE NOT NULL , "
            +"PRIMARY KEY (`ID_Article`)) ENGINE = InnoDB;";
    private static String createDvdSql
            = "CREATE TABLE Dvd ( "
            +"`ID_Dvd` INT NOT NULL AUTO_INCREMENT , "
            +"`Duree` DOUBLE NOT NULL , "
            +"`FK_ID_Article` INT NOT NULL ,  "
            +"`FK_ID_Realisateur` INT NOT NULL , "
            +"PRIMARY KEY (`ID_Dvd`)) ENGINE = InnoDB;";
    private static String createLivreSql
            = "CREATE TABLE Livre ( "
            +"`ID_Livre` INT NOT NULL AUTO_INCREMENT , "
            +"`Isbn` VARCHAR(255) NOT NULL , "
            +"`NbrPages` INT NOT NULL, "
            +"`FK_ID_Article` INT NOT NULL  , "
            +"`FK_ID_Auteur` INT NOT NULL , "
            +"PRIMARY KEY (`ID_Livre`)) ENGINE = InnoDB;";
    private static String alterAuteurFkPersonne
            = "ALTER TABLE `auteur` ADD CONSTRAINT `FK_ID_Personne_On_Auteur` "
            +"FOREIGN KEY (`FK_ID_Personne`) REFERENCES `personne`(`ID_Personne`) "
            +"ON DELETE RESTRICT ON UPDATE RESTRICT;";
    private static String alterRealisateurFkPersonne
            = "ALTER TABLE `realisateur` ADD CONSTRAINT `FK_ID_Personne_On_Realisateur` "
            +"FOREIGN KEY (`FK_ID_Personne`) REFERENCES `personne`(`ID_Personne`) "
            +"ON DELETE RESTRICT ON UPDATE RESTRICT;";
    private static String alterDvdFkArticle
            = "ALTER TABLE `dvd` ADD CONSTRAINT `FK_ID_Article_On_Dvd` "
            +"FOREIGN KEY (`FK_ID_Article`) REFERENCES `article`(`ID_Article`) "
            +"ON DELETE RESTRICT ON UPDATE RESTRICT;";
    private static String alterDvdFkRealisateur
            = "ALTER TABLE `dvd` ADD CONSTRAINT `FK_ID_Realisateur_On_Dvd` "
            +"FOREIGN KEY (`FK_ID_Realisateur`) REFERENCES `realisateur`(`ID_Realisateur`) "
            +"ON DELETE RESTRICT ON UPDATE RESTRICT;";
    private static String alterLivreArticle
            = "ALTER TABLE `livre` ADD CONSTRAINT `FK_ID_Article_On_Livre` "
            +"FOREIGN KEY (`FK_ID_Article`) REFERENCES `article`(`ID_Article`) "
            +"ON DELETE RESTRICT ON UPDATE RESTRICT;";
    private static String alterLivreFkAuteur
            = "ALTER TABLE `livre` ADD CONSTRAINT `FK_ID_Auteur_On_Livre` "
            +"FOREIGN KEY (`FK_ID_Auteur`) REFERENCES `auteur`(`ID_Auteur`) "
            +"ON DELETE RESTRICT ON UPDATE RESTRICT;";
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        dao.setClassForName(classForName);
        dao.setConnection(host, port, db, user, mdp);
        
        // Création des tables et des clefs étrangères 
        
        dao.executeSql(createPersonnetSql);
        dao.executeSql(createAuteurSql);
        dao.executeSql(createRealisateurSql);
        dao.executeSql(createArticleSql);
        dao.executeSql(createDvdSql);
        dao.executeSql(createLivreSql);
        dao.executeSql(alterAuteurFkPersonne);
        dao.executeSql(alterRealisateurFkPersonne);
        dao.executeSql(alterDvdFkArticle);
        dao.executeSql(alterDvdFkRealisateur);
        dao.executeSql(alterLivreArticle);
        dao.executeSql(alterLivreFkAuteur);
        
        FormFenetre formMain = new FormFenetre();                                       // Instanciation de FormFenetre avec le titre "Menu"
    }

}
