/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmationobjet.forms;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import programmationobjet.classes.Auteur;
import programmationobjet.classes.Dvd;
import programmationobjet.classes.Livre;
import programmationobjet.classes.Realisateur;
import programmationobjet.dao.dao;
import static programmationobjet.dao.dao.getAllRealisateur;
import static programmationobjet.main.ProgrammationObjet.globalLesArticles;

/**
 *
 * @author Ikikay
 */
public class FormArticle {

    //Mes futurs TextField
    TextField tfIdMere;
    TextField tfIdFille;
    TextField tfReference;
    TextField tfDesignation;
    TextField tfPrix;
    TextField tfDuree;
    JComboBox cbRealisateur;
    TextField tfISBN;
    TextField tfNbPage;
    JComboBox cbAuteur;

    boolean toUpdate;

    ArrayList<String> lesErreurs;

    //Constructeur d'Ajout (Première entré dans la fenêtre)
    public FormArticle() {
        creationForm();
        //Dao .create();
    }

    //Constructeur de Modification
    public FormArticle(Object lArticle) {
        creationForm();                                                         // Appelle la fonction de création de la fenêtre
        String laClasseArticle = lArticle.getClass().toString();                // Permet de savoir si c'est un DVD ou un Livre
        laClasseArticle = laClasseArticle.split("\\.")[laClasseArticle.split("\\.").length - 1];
        switch (laClasseArticle) {
            case "Dvd":                                                         // Si l'objet est un DVD
                lArticle = (Dvd) lArticle;                                      // Modifie le type de la variable FormArticle (que l'ont modifie) en DVD
                Dvd leDvd = new Dvd();                                          // Créer une variable de type DVD (pour travailler dessus plutôt que sur lArticle qui n'est pas parlant)
                leDvd = (Dvd) lArticle;                                         // Met lArticle (qui est un DVD) dans la variable leDVD

                tfIdMere.setText(String.valueOf(leDvd.getId_Article()));
                tfIdFille.setText(String.valueOf(leDvd.getId_Dvd()));
                tfReference.setText(leDvd.getReference());                      // Prérempli les champs avec l'objets actuel
                tfDesignation.setText(leDvd.getDesignation());                  // Prérempli les champs avec l'objets actuel
                tfPrix.setText(String.valueOf(leDvd.getPrix()));                // Prérempli les champs avec l'objets actuel

                tfDuree.setText(String.valueOf(leDvd.getDuree()));              // Prérempli les champs avec l'objets actuel
                cbRealisateur.setSelectedItem(leDvd.getRealisateur());          // Prérempli les champs avec l'objets actuel // TODO

                toUpdate = true;
                break;

            case "Livre":                                                       // Si l'objet est un livre
                lArticle = (Livre) lArticle;                                    // Modifie le type de la variable FormArticle (que l'ont modifie) en Livre
                Livre leLivre = new Livre();                                    // Créer une variable de type Livre (pour travailler dessus plutôt que sur lArticle qui n'est pas parlant)
                leLivre = (Livre) lArticle;                                     // Met lArticle (qui est un Livre) dans la variable leLivre

                tfIdMere.setText(String.valueOf(leLivre.getId_Article()));
                tfIdFille.setText(String.valueOf(leLivre.getId_Livre()));
                tfReference.setText(leLivre.getReference());                    // Prérempli les champs avec l'objets actuel
                tfDesignation.setText(leLivre.getDesignation());                  // Prérempli les champs avec l'objets actuel
                tfPrix.setText(String.valueOf(leLivre.getPrix()));              // Prérempli les champs avec l'objets actuel

                tfISBN.setText(leLivre.getIsbn());                              // Prérempli les champs avec l'objets actuel
                tfNbPage.setText(String.valueOf(leLivre.getNbrPages()));        // Prérempli les champs avec l'objets actuel
                cbAuteur.setSelectedItem(leLivre.getAuteur());                  // Prérempli les champs avec l'objets actuel // TODO

                toUpdate = true;
                break;

            default:                                                            // Si l'objet n'est ni un DVD ni un Livre
                System.out.println("Erreur dans le préremplissage des champs, aucune case pour : '" + laClasseArticle + "'");
                break;
        }
        //Dao .update();
    }

    public void creationForm() {
        lesErreurs = new ArrayList<>();                                         // Instancie la liste des erreurs

        JFrame fenetre = new JFrame();                                          // Création d'un JFrame
        fenetre.setTitle("Ajouter un Article");                                 // Applique le titre à la fenêtre
        fenetre.setBounds(25, 25, 100, 500);                                    // Fait une fenêtre de largeur x hauteur avec 25 de marge
        fenetre.setDefaultCloseOperation(DISPOSE_ON_CLOSE);                     // Ferme l'application si il n'y à plus de fenêtre
        fenetre.setLocationRelativeTo(null);                                    // Centre la fenêtre
        JPanel panel = new JPanel();                                            // Création d'un JPanel
        panel.setLayout(new GridBagLayout());                                   // Création d'un Layaout de tipe GridBag
        GridBagConstraints gbC = new GridBagConstraints();                      // Le gbC va définir la position et la taille des éléments
        gbC.fill = GridBagConstraints.BOTH;                                     // Prend toute la place diponible en hauteur et en largeur
        gbC.insets = new Insets(5, 5, 5, 5);                                    // insets défini la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */

        //Panel Contenu
        JPanel panelContenu = new JPanel();                                     // Création d'un JPanel
        panelContenu.setLayout(new GridBagLayout());                            // Création d'un Layaout de tipe GridBag
        GridBagConstraints gbCC = new GridBagConstraints();                     // Le gbC va définir la position et la taille des éléments
        gbCC.fill = GridBagConstraints.BOTH;                                    // Prend toute la place diponible en hauteur et en largeur
        gbCC.insets = new Insets(5, 5, 5, 5);                                   // insets défini la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */

        gbC.gridy = 0;
        panel.add(panelContenu, gbC);                                           // Ajoute un panel "panelContenu" à "panel" en position x = 0, Y = 0
        gbC.gridy = 1;

        // ************************
        // Panel Contenu principal
        // ************************
        //Création d'un TextField idMere
        gbCC.gridy = 0;
        gbCC.gridx = 1;
        tfIdMere = new TextField("", 50);                                    // Créer un Text Field
        panelContenu.add(tfIdMere, gbCC);
        tfIdMere.setVisible(false);
        gbCC.gridx = 0;

        //Création d'un TextField idFille
        gbCC.gridy = 1;
        gbCC.gridx = 1;
        tfIdFille = new TextField("", 50);                                    // Créer un Text Field
        panelContenu.add(tfIdFille, gbCC);
        tfIdFille.setVisible(false);
        gbCC.gridx = 0;

        //Création d'un Label demande de reference
        gbCC.gridy = 0;
        JLabel lRef = new JLabel("Entrez la référence de l'article");           // Créer un label
        panelContenu.add(lRef, gbCC);                                           // le label au panelContenu en position x = 0, Y = 0

        //Création d'un TextField reference
        gbCC.gridy = 1;
        tfReference = new TextField("", 50);                                    // Créer un Text Field
        panelContenu.add(tfReference, gbCC);                                    // le Text Field au panelContenu en position x = 0, Y = 1

        //Création d'un Label demande de désignation
        gbCC.gridy = 2;
        JLabel lDes = new JLabel("Entrez la désignation de l'article");         // Créer un label
        panelContenu.add(lDes, gbCC);                                           // le label au panelContenu en position x = 0, Y = 3

        //Création d'un TextField designation
        gbCC.gridy = 3;
        tfDesignation = new TextField("", 50);                                  // Créer un Text Field
        panelContenu.add(tfDesignation, gbCC);                                  // le Text Field au panelContenu en position x = 0, Y = 3

        //Création d'un Label demande de prix
        gbCC.gridy = 4;
        JLabel lPrix = new JLabel("Entrez le prix de l'article");               // Créer un label
        panelContenu.add(lPrix, gbCC);                                          // le label au panelContenu en position x = 0, Y = 4

        //Création d'un TextField prix
        gbCC.gridy = 5;
        tfPrix = new TextField("", 50);                                         // Créer un Text Field
        panelContenu.add(tfPrix, gbCC);                                         // le Text Field au panelContenu en position x = 0, Y = 5

        // **********************
        //Création du panel DVD
        // *********************
        JPanel panelDVD = new JPanel();                                         // Création d'un JPanel à intégré dans le JPanel principal
        panelDVD.setLayout(new GridBagLayout());                                // Création d'un Layaout de tipe GridBag
        GridBagConstraints gbCDVD = new GridBagConstraints();                   // Le gbCDVD va définir la position et la taille des éléments
        gbCDVD.fill = GridBagConstraints.BOTH;                                  // Prend toute la place diponible en hauteur et en largeur
        gbCDVD.insets = new Insets(5, 5, 5, 5);                                 // insets défini la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */
        panelDVD.setVisible(false);

        //Création d'un Label demande de durée
        gbCDVD.gridy = 0;
        JLabel lDuree = new JLabel("Entrez la durée du DVD");                   // Créer un label
        panelDVD.add(lDuree, gbCDVD);                                           // le label au panel en position x = 0, Y = 0
        //Création d'un TextField duree
        gbCDVD.gridy = 1;
        tfDuree = new TextField("", 50);                                        // Créer un Text Field
        panelDVD.add(tfDuree, gbCDVD);                                          // le Text Field au panel en position x = 0, Y = 1
        //Création d'un Label demande de realisateur
        gbCDVD.gridy = 2;
        JLabel lRealisateur = new JLabel("Entrez le réalisateur du DVD");       // Créer un label
        panelDVD.add(lRealisateur, gbCDVD);                                     // le label au panel en position x = 0, Y = 2
        //Création d'une combobox contenant les realisateur
        gbCDVD.gridy = 3;
        cbRealisateur = new JComboBox(dao.getAllRealisateur().toArray());       // Créer une ComboBox
        panelDVD.add(cbRealisateur, gbCDVD);                                    // le Text Field au panel en position x = 0, Y = 3

        // *********************
        // Création du panel Livre
        // *********************
        JPanel panelLivre = new JPanel();                                       // Création d'un JPanel
        panelLivre.setLayout(new GridBagLayout());                              // Création d'un Layaout de tipe GridBag
        GridBagConstraints gbCLivre = new GridBagConstraints();                 // Le gbCDVD va définir la position et la taille des éléments
        gbCLivre.fill = GridBagConstraints.BOTH;                                // Prend toute la place diponible en hauteur et en largeur
        gbCLivre.insets = new Insets(5, 5, 5, 5);                               // insets défini la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */
        panelLivre.setVisible(false);

        //Création d'un Label demande de l'ISBN
        gbCLivre.gridy = 0;
        JLabel lIsbn = new JLabel("Entrez l'ISBN du livre");                    // Créer un label
        panelLivre.add(lIsbn, gbCLivre);                                        // le label au panel en position x = 0, Y = 0
        //Création d'un TextField ISBN
        gbCLivre.gridy = 1;
        tfISBN = new TextField("", 50);                                         // Créer un Text Field
        panelLivre.add(tfISBN, gbCLivre);                                       // le Text Field au panel en position x = 0, Y = 1
        //Création d'un Label demande du nombre de pages
        gbCLivre.gridy = 2;
        JLabel lNbPage = new JLabel("Entrez le nombre de pages du livre");      // Créer un label
        panelLivre.add(lNbPage, gbCLivre);                                      // le label au panel en position x = 0, Y = 2
        //Création d'un TextField Nombre de pages
        gbCLivre.gridy = 3;
        tfNbPage = new TextField("", 50);                                       // Créer un Text Field
        panelLivre.add(tfNbPage, gbCLivre);                                     // le Text Field au panel en position x = 0, Y = 3
        //Création d'un Label demande de l'auteur
        gbCLivre.gridy = 4;
        JLabel lAuteur = new JLabel("Entrez l'auteur du livre");                // Créer un label
        panelLivre.add(lAuteur, gbCLivre);                                      // le label au panel en position x = 0, Y = 4
        //Création d'un TextField auteur
        gbCLivre.gridy = 5;
        cbAuteur = new JComboBox(dao.getAllAuteur().toArray());                 // Créer une combobox
        panelLivre.add(cbAuteur, gbCLivre);                                     // le Text Field au panel en position x = 0, Y = 5

        // *************************************
        // Retour sur le Panel Contenu principal
        // *************************************
        //Création du choix DVD/Livre
        gbCC.gridy = 6;
        gbCC.gridx = 0;
        ButtonGroup bg = new ButtonGroup();                                     // Ajoute un groupe de boutons pour lier mes RadioButton
        JPanel lesRadioButton = new JPanel();                                   // Créer un panel contenant les Radion Boutons
        JRadioButton dvd = new JRadioButton("DVD");                             // Créer un radio bouton "DVD"
        bg.add(dvd);                                                            // Ajoute le radio bouton au groupe de boutons
        lesRadioButton.add(dvd);                                                // Ajoute le radio bouton au panel de boutons
        JRadioButton livre = new JRadioButton("Livre");                         // Créer un radio bouton "Livre"
        bg.add(livre);                                                          // Ajoute le radio bouton au groupe de boutons
        lesRadioButton.add(livre);                                              // Ajoute le radio bouton au panel de boutons
        panelContenu.add(lesRadioButton, gbCC);                                 // Ajoute le panel de boutons en position x = 0, Y = 6
        dvd.addActionListener((event) -> {                                      // Créer une " "micro fonction" " lorsque quelque chose se passe sur le bouton
            //Actions lors des cliques sur le bouton 
            panelLivre.setVisible(false);                                       // Cache la partie des livres
            panelDVD.setVisible(true);                                          // et rend visible la partie des DVD
            fenetre.pack();
        });
        livre.addActionListener((event) -> {                                    // Créer une " "micro fonction" " lorsque quelque chose se passe sur le bouton
            //Actions lors des cliques sur le bouton 
            panelLivre.setVisible(true);                                        // Rend visible la partie des livres
            panelDVD.setVisible(false);                                         // et cache la partie des DVD
            fenetre.pack();
        });

        //Emplacement des Panels DVD et Livre
        gbCC.gridy = 7;
        gbCC.gridx = 0;
        panelContenu.add(panelDVD, gbCC);                                       // Ajoute le panelDvd en position x = 0, Y = 7
        panelContenu.add(panelLivre, gbCC);                                     // Ajoute le panelDvd en position x = 0, Y = 7

        //Création des boutons
        gbCC.gridy = 8;
        JButton bAddArticle = new JButton("Ajouter");                           // Créer un bouton "Ajouter"
        bAddArticle.setSize(100, 50);                                           // de taille 100x50
        panelContenu.add(bAddArticle, gbCC);                                    // ajoute ce bouton, au panelContenu
        bAddArticle.addActionListener((event) -> {                              // Créer une " "micro fonction" " lorsque quelque chose se passe sur le bouton
            //Actions lors des cliques sur le bouton 
            checkRef();                                                         // Vérifis les erreurs sur le champs Référence
            checkDesignation();                                                 // Vérifis les erreurs sur le champ Désignation
            checkPrix();                                                        // Vérifis les erreurs sur le champ Prix

            if (dvd.isSelected()) {
                checkDuree();                                                   // Vérifis les erreurs sur le champ Réalisateur

                if (lesErreurs.isEmpty()) {                 
                    if (toUpdate) {
                        Dvd leDvd = new Dvd(Integer.parseInt(tfIdFille.getText()), Double.parseDouble(tfDuree.getText()), (Realisateur) cbRealisateur.getSelectedItem(), Integer.parseInt(tfIdMere.getText()), tfReference.getText(), tfDesignation.getText(), Double.parseDouble(tfPrix.getText()));                  
                        dao.updateDvd(leDvd);                                   // Modifie le Dvd
                    } else {
                        Dvd leDvd = new Dvd(Double.parseDouble(tfDuree.getText()), (Realisateur) cbRealisateur.getSelectedItem(), tfReference.getText(), tfDesignation.getText(), Double.parseDouble(tfPrix.getText()));
                        dao.createDvd(leDvd);                                   // Ajout du Dvd
                    }
                    FormFenetre formMain = new FormFenetre();                   // Instanciation de FormFenetre de 1024x768 avec le titre "Menu"
                    fenetre.dispose();
                }
                showErrors();                                                   // Affiche et vide les erreurs

            } else if (livre.isSelected()) {
                checkISBN();                                                    // Vérifis les erreurs sur le champ ISBN
                checkNBPages();                                                 // Vérifis les erreurs sur le champ Auteur

                if (lesErreurs.isEmpty()) {                                     // Si il n'y à pas d'erreurs
                    if (toUpdate) {
                        Livre leLivre = new Livre(Integer.parseInt(tfIdFille.getText()), tfISBN.getText(), Integer.parseInt(tfNbPage.getText()), (Auteur) cbAuteur.getSelectedItem(), Integer.parseInt(tfIdMere.getText()), tfReference.getText(), tfDesignation.getText(), Double.parseDouble(tfPrix.getText()));         
                        dao.updateLivre(leLivre);                               // Modifie le Livre
                    } else {
                        Livre leLivre = new Livre(tfISBN.getText(), Integer.parseInt(tfNbPage.getText()), (Auteur) cbAuteur.getSelectedItem(), tfReference.getText(), tfDesignation.getText(), Double.parseDouble(tfPrix.getText()));
                        dao.createLivre(leLivre);                               // Ajout du Livre
                    }
                    FormFenetre formMain = new FormFenetre();                   // Instanciation de FormFenetre de 1024x768 avec le titre "Menu"
                    fenetre.dispose();
                }
                showErrors();                                                   // Affiche et vide les erreurs
            }
        });

        gbCC.gridy = 9;
        JButton bRetour = new JButton("Retour");                                // Créer un bouton "Retour"
        bRetour.setSize(100, 50);                                               // de taille 100x50
        panelContenu.add(bRetour, gbCC);                                        // ajoute ce bouton, au panelContenu
        bRetour.addActionListener((event) -> {                                  // Créer une " "micro fonction" " lorsque quelque chose se passe sur le bouton
            //Actions lors des cliques sur le bouton 
            FormFenetre formMain = new FormFenetre();                           // Instanciation de FormFenetre avec le titre "Menu"
            fenetre.dispose();                                                  // Ferme la fenetre
        });

        // Couleurs pour les Tests
        panelContenu.setBackground(Color.PINK);
        panelLivre.setBackground(Color.CYAN);
        panelDVD.setBackground(Color.GREEN);
        panel.setBackground(Color.gray);

        fenetre.add(panel);                                                     // Ajoute le JPanel (panelContenu) au JFrame (fenetre)
        fenetre.pack();                                                         //
        fenetre.setVisible(true);                                               // Rend la fenêtre visible
    }

    // *************************************
    // Les fonctions de véfification d'erreurs
    // *************************************
    public void showErrors() {
        String errorsString = "";                                               // Avoir toutes les erreurs en une seul variable
        for (String erreur : lesErreurs) {                                      // Fusionne toutes les erreurs
            errorsString = errorsString + erreur + "\n";                        // en une seul variable
        }
        if (!lesErreurs.isEmpty()) {
            JOptionPane.showMessageDialog(null, errorsString, "Erreurs", JOptionPane.OK_OPTION);// Affiche les erreurs
        }
        lesErreurs.removeAll(lesErreurs);                                       // Vide la liste des erreurs

    }

    public void checkRef() {                                                    // Fonction de vérification du champs Référence
        if (tfReference.getText().length() < 1) {                               // Si le champs référence contient moins de 1 charactère (=> en gros si il est vide)
            lesErreurs.add("Champ de référence vide.");                         // Ajoute une erreur "champ vide"
        }
    }

    public void checkDesignation() {                                            // Fonction de vérification du champs Désignation
        if (tfDesignation.getText().length() < 1) {                               // Si le champs Désignation contient moins de 1 charactère (=> en gros si il est vide)
            lesErreurs.add("Champ de désignation vide.");                       // Ajoute une erreur "champ vide"
        }
    }

    public void checkPrix() {                                                   // Fonction de vérification du champs Prix
        if (tfPrix.getText().length() < 1) {                                    // Si le champs Prix contient moins de 1 charactère (=> en gros si il est vide)
            lesErreurs.add("Champ du prix vide.");                              // Ajoute une erreur "champ vide"
        }
    }

    public void checkDuree() {                                                  // Fonction de vérification du champs Duree
        if (tfDuree.getText().length() < 1) {                                   // Si le champs Duree contient moins de 1 charactère (=> en gros si il est vide)
            lesErreurs.add("Champ de la durée vide.");                          // Ajoute une erreur "champ vide"
        }
    }

    public void checkISBN() {                                                   // Fonction de vérification du champs ISBN
        if (tfISBN.getText().length() < 1) {                                    // Si le champs ISBN contient moins de 1 charactère (=> en gros si il est vide)
            lesErreurs.add("Champ du ISBN vide.");                              // Ajoute une erreur "champ vide"
        }
    }

    public void checkNBPages() {                                                // Fonction de vérification du champs NBPages
        if (tfNbPage.getText().length() < 1) {                                  // Si le champs NBPages contient moins de 1 charactère (=> en gros si il est vide)
            lesErreurs.add("Champ du nombre de pages vide.");                   // Ajoute une erreur "champ vide"
        }
    }
}
