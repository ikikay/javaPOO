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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import programmationobjet.classes.Auteur;
import programmationobjet.classes.Realisateur;
import programmationobjet.dao.dao;
import static programmationobjet.main.ProgrammationObjet.globalLesPersonnes;

/**
 *
 * @author Ikikay
 */
public class FormPersonne {

    //Mes futurs TextField et Radio Bouton
    TextField tfIdMere;
    TextField tfIdFille;
    TextField tfNom;
    TextField tfPrenom;
    TextField tfDteNaissance;
    JRadioButton auteur;
    JRadioButton realisateur;

    DateTimeFormatter formatterToDate = DateTimeFormatter.ofPattern("d/MM/yyyy");

    boolean toUpdate;

    ArrayList<String> lesErreurs;

    //Constructeur d'Ajout (Première entré dans la fenêtre)
    public FormPersonne() {
        creationForm();
        //Dao .create();
    }

    //Constructeur de Modification
    public FormPersonne(Object laPersonne) {
        creationForm();                                                         // Appelle la fonction de création de la fenêtre
        String laClassePersonne = laPersonne.getClass().toString();              // Permet de savoir si c'est un DVD ou un Livre
        laClassePersonne = laClassePersonne.split("\\.")[laClassePersonne.split("\\.").length - 1];
        switch (laClassePersonne) {
            case "Auteur":
                laPersonne = (Auteur) laPersonne;                               // Modifie le type de la variable FormPersonne (que l'ont modifie) en Auteur
                Auteur lAuteur = new Auteur();                                  // Créer une variable de type Auteur (pour travailler dessus plutôt que sur laPersonne qui n'est pas parlant)
                lAuteur = (Auteur) laPersonne;                                  // Met lAuteur (qui est un Auteur) dans la variable lAuteur

                tfIdMere.setText(String.valueOf(lAuteur.getId_Personne()));
                tfIdFille.setText(String.valueOf(lAuteur.getId_Auteur()));
                tfNom.setText(lAuteur.getNom());                                // Prérempli les champs avec l'objets actuel
                tfPrenom.setText(lAuteur.getPrenom());                          // Prérempli les champs avec l'objets actuel
                tfDteNaissance.setText(lAuteur.getDteNaissance().format(formatterToDate)); // Prérempli les champs avec l'objets actuel
                auteur.setSelected(true);

                toUpdate = true;
                break;
            case "Realisateur":
                laPersonne = (Realisateur) laPersonne;                          // Modifie le type de la variable laPersonne (que l'ont modifie) en Realisateur
                Realisateur leRealisateur = new Realisateur();                  // Créer une variable de type Realisateur (pour travailler dessus plutôt que sur laPersonne qui n'est pas parlant)
                leRealisateur = (Realisateur) laPersonne;                       // Met leRealisateur (qui est un Realisateur) dans la variable leRealisateur

                tfIdMere.setText(String.valueOf(leRealisateur.getId_Personne()));
                tfIdFille.setText(String.valueOf(leRealisateur.getId_Realisateur()));
                tfNom.setText(leRealisateur.getNom());                          // Prérempli les champs avec l'objets actuel
                tfPrenom.setText(leRealisateur.getPrenom());                    // Prérempli les champs avec l'objets actuel
                tfDteNaissance.setText(leRealisateur.getDteNaissance().format(formatterToDate)); // Prérempli les champs avec l'objets actuel
                realisateur.setSelected(true);

                toUpdate = true;
                break;

            default:                                                            // Si l'objet n'est ni un auteur ni un réalisateur
                System.out.println("Erreur dans le préremplissage des champs, aucune case pour : '" + laClassePersonne + "'");
                break;
        }
        //Dao .update();
    }

    public void creationForm() {
        lesErreurs = new ArrayList<>();

        JFrame fenetre = new JFrame();                                          // Création d'un JFrame
        fenetre.setTitle("Ajouter une Personne");                               // Applique le titre à la fenêtre
        fenetre.setBounds(25, 25, 100, 100);                                    // Fait une fenêtre de largeur x hauteur avec 25 de marge
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
        gbCC.insets = new Insets(5, 5, 5, 5);

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

        //Création d'un Label demande du nom
        gbCC.gridy = 0;
        JLabel lnom = new JLabel("Entrez le nom de la personne");               // Créer un label
        panelContenu.add(lnom, gbCC);                                           // le label au panelContenu en position x = 0, Y = 0

        //Création d'un TextField Nom
        gbCC.gridy = 1;
        tfNom = new TextField("", 50);                                          // Créer un Text Field
        panelContenu.add(tfNom, gbCC);                                          // le Text Field au panelContenu en position x = 0, Y = 1

        //Création d'un Label demande du nom
        gbCC.gridy = 2;
        JLabel lprenom = new JLabel("Entrez le prenom de la personne");         // Créer un label
        panelContenu.add(lprenom, gbCC);                                        // le label au panelContenu en position x = 0, Y = 2

        //Création d'un TextField Nom
        gbCC.gridy = 3;
        tfPrenom = new TextField("", 50);                                       // Créer un Text Field
        panelContenu.add(tfPrenom, gbCC);                                       // le Text Field au panelContenu en position x = 0, Y = 3

        //Création d'un Label demande de la date de naissance
        gbCC.gridy = 4;
        JLabel ldteNaissance = new JLabel("Entrez la date de naissance de la personne (jj/mm/yyyy)");               // Créer un label
        panelContenu.add(ldteNaissance, gbCC);                                           // le label au panelContenu en position x = 0, Y = 4

        //Création d'un TextField de la date de naissance
        gbCC.gridy = 5;
        tfDteNaissance = new TextField("", 50);                                 // Créer un Text Field
        panelContenu.add(tfDteNaissance, gbCC);                                 // le Text Field au panelContenu en position x = 0, Y = 5

        //Création du choix DVD/Livre
        gbCC.gridy = 6;
        ButtonGroup bg = new ButtonGroup();                                     // Ajoute un groupe de boutons pour lier mes RadioButton
        JPanel lesRadioButton = new JPanel();                                   // Créer un panel contenant les Radion Boutons
        auteur = new JRadioButton("Auteur");                       // Créer un radio bouton "Auteur"
        bg.add(auteur);                                                         // Ajoute le radio bouton au groupe de boutons
        lesRadioButton.add(auteur);                                             // Ajoute le radio bouton au panel de boutons
        realisateur = new JRadioButton("Realisateur");             // Créer un radio bouton "Realisateur"
        bg.add(realisateur);                                                    // Ajoute le radio bouton au groupe de boutons
        lesRadioButton.add(realisateur);                                        // Ajoute le radio bouton au panel de boutons
        panelContenu.add(lesRadioButton, gbCC);                                 // Ajoute le panel de boutons en position x = 0, Y = 6
        auteur.addActionListener((event) -> {                                   // Créer une " "micro fonction" " lorsque quelque chose se passe sur le bouton
            //Actions lors des cliques sur le bouton 

        });
        realisateur.addActionListener((event) -> {                              // Créer une " "micro fonction" " lorsque quelque chose se passe sur le bouton
            //Actions lors des cliques sur le bouton 

        });

        //Création des boutons
        gbCC.gridy = 7;
        JButton bAddPersonne = new JButton("Ajouter");                          // Créer un bouton "Ajouter"
        bAddPersonne.setSize(100, 50);                                          // de taille 100x50
        panelContenu.add(bAddPersonne, gbCC);                                   // ajoute ce bouton, au panelContenu
        bAddPersonne.addActionListener((event) -> {                             // Créer une " "micro fonction" " lorsque quelque chose se passe sur le bouton
            //Actions lors des cliques sur le bouton 
            checkNom();                                                         // Vérifis les erreurs sur le champ nom
            checkPrenom();                                                      // Vérifis les erreurs sur le champ prenom
            checkDteNaissance();                                                // Vérifis les erreurs sur le champ date de naissance

            if (auteur.isSelected()) {
                if (lesErreurs.isEmpty()) {     
                    if (toUpdate) {
                        Auteur lAuteur = new Auteur(Integer.parseInt(tfIdFille.getText()), Integer.parseInt(tfIdMere.getText()), tfNom.getText(), tfPrenom.getText(), LocalDate.parse(tfDteNaissance.getText(), formatterToDate));
                        dao.updateAuteur(lAuteur);                              // Modifie l'Auteur
                    } else {
                        Auteur lAuteur = new Auteur(tfNom.getText(), tfPrenom.getText(), LocalDate.parse(tfDteNaissance.getText(), formatterToDate));             
                        dao.createAuteur(lAuteur);                              // Ajout de l'auteur
                    }
                    FormFenetre formMain = new FormFenetre();                   // Instanciation de FormFenetre de 1024x768 avec le titre "Menu"
                    fenetre.dispose();
                }
                showErrors();                                                   // Affiche et vide les erreurs

            } else if (realisateur.isSelected()) {
                if (lesErreurs.isEmpty()) {                                     // Si il n'y à pas d'erreurs
                    if (toUpdate) {
                        Realisateur leRealisateur = new Realisateur(Integer.parseInt(tfIdFille.getText()), Integer.parseInt(tfIdMere.getText()), tfNom.getText(), tfPrenom.getText(), LocalDate.parse(tfDteNaissance.getText(), formatterToDate));
                        dao.updateRealisateur(leRealisateur);                   // Modifie le réalisateur
                    } else {
                        Realisateur leRealisateur = new Realisateur(tfNom.getText(), tfPrenom.getText(), LocalDate.parse(tfDteNaissance.getText(), formatterToDate));
                        dao.createRealisateur(leRealisateur);                   // Ajout du réalisateur
                    }
                    FormFenetre formMain = new FormFenetre();                   // Instanciation de FormFenetre de 1024x768 avec le titre "Menu"
                    fenetre.dispose();
                }
                showErrors();                                                   // Affiche et vide les erreurs
            }
        });

        gbCC.gridy = 8;
        JButton bRetour = new JButton("Retour");                                // Créer un bouton "Retour"
        bRetour.setSize(100, 50);                                               // de taille 100x50
        panelContenu.add(bRetour, gbCC);                                        // ajoute ce bouton, au panelContenu
        bRetour.addActionListener((event) -> {                                  // Créer une " "micro fonction" " lorsque quelque chose se passe sur le bouton
            //Actions lors des cliques sur le bouton 
            FormFenetre formMain = new FormFenetre();                                   // Instanciation de FormFenetre avec le titre "Menu"
            fenetre.dispose();                                                  // Ferme la fenetre
        });

        // Couleurs pour les Tests
        panelContenu.setBackground(Color.PINK);
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

    public void checkNom() {                                                    // Fonction de vérification du champs nom
        if (tfNom.getText().length() < 1) {                                     // Si le champs nom contient moins de 1 charactère (=> en gros si il est vide)
            lesErreurs.add("Champ du nom vide.");                               // Ajoute une erreur "champ vide"
        }
    }

    public void checkPrenom() {                                                 // Fonction de vérification du champs prenom
        if (tfPrenom.getText().length() < 1) {                                  // Si le champs Désignation contient moins de 1 charactère (=> en gros si il est vide)
            lesErreurs.add("Champ du prénom vide.");                            // Ajoute une erreur "champ vide"
        }
    }

    public void checkDteNaissance() {                                           // Fonction de vérification du champs prenom
        if (tfDteNaissance.getText().length() < 1) {                            // Si le champs Désignation contient moins de 1 charactère (=> en gros si il est vide)
            lesErreurs.add("Champ de la date de naissance vide.");              // Ajoute une erreur "champ vide"
        }
    }
}
