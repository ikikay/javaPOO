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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import programmationobjet.classes.Auteur;
import programmationobjet.classes.Realisateur;
import static programmationobjet.main.ProgrammationObjet.globalLesArticles;

/**
 *
 * @author Ikikay
 */
public class Personne {

    //Mes futurs TextField
    TextField tfNom;
    TextField tfPrenom;
    TextField tfDateNaissance;

    //Constructeur d'Ajout (Première entré dans la fenêtre)
    public Personne() {
        creationForm();
        //Dao .create();
    }

    //Constructeur de Modification
    public Personne(Object laPersonne) {
        creationForm();
        String laClassePersonne = laPersonne.getClass().toString();

        switch (laClassePersonne) {
            case "Auteur":
                laPersonne = (Auteur) laPersonne;
                Auteur lAuteur = new Auteur();
                lAuteur = (Auteur) laPersonne;

                tfNom.setText(lAuteur.getNom());
                tfPrenom.setText(lAuteur.getPrenom());
                tfDateNaissance.setText(String.valueOf(lAuteur.getDteNaissance()));
                break;

            case "Livre":
                laPersonne = (Realisateur) laPersonne;
                Realisateur leRealisateur = new Realisateur();
                leRealisateur = (Realisateur) laPersonne;

                tfNom.setText(leRealisateur.getNom());
                tfPrenom.setText(leRealisateur.getPrenom());
                tfDateNaissance.setText(String.valueOf(leRealisateur.getDteNaissance()));
                break;

            default:
                System.out.println(laClassePersonne);
                break;
        }
        //Dao .update();
    }

    public void creationForm() {
        JFrame fenetre = new JFrame();                                          // Création d'un JFrame
        fenetre.setTitle("Ajouter une Personne");                               // Applique le titre à la fenêtre
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

        //Panel Error
        JPanel PanelError = new JPanel();                                       // Création d'un JPanel
        PanelError.setLayout(new GridBagLayout());                              // Création d'un Layaout de tipe GridBag
        GridBagConstraints gbCE = new GridBagConstraints();                     // Le gbC va définir la position et la taille des éléments
        gbCE.fill = GridBagConstraints.BOTH;                                    // Prend toute la place diponible en hauteur et en largeur
        gbCE.insets = new Insets(5, 5, 5, 5);                                   // insets défini la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */

        gbC.gridy = 0;
        panel.add(panelContenu, gbC);
        gbC.gridy = 1;
        panel.add(PanelError, gbC);

        // *********************
        // Panel Contenu Erreurs
        // *********************
        gbCE.gridy = 0;
        JLabel lRefError = new JLabel("X");                                     // Créer un label
        PanelError.add(lRefError, gbCE);                                        // le label au panelContenu

        gbCE.gridy = 2;
        JLabel lDesignationError = new JLabel("X");                             // Créer un label
        PanelError.add(lDesignationError, gbCE);                                // le label au panelContenu

        gbCE.gridy = 4;
        JLabel lPrixError = new JLabel("X");                                    // Créer un label
        PanelError.add(lPrixError, gbCE);                                       // le label au panelContenu

        gbCE.gridy = 6;
        JLabel lObjet1Error = new JLabel("X");                                  // Créer un label
        PanelError.add(lObjet1Error, gbCE);                                     // le label au panelContenu

        gbCE.gridy = 8;
        JLabel lObjet2Error = new JLabel("X");                                  // Créer un label
        PanelError.add(lObjet2Error, gbCE);                                     // le label au panelContenu

        // ************************
        // Panel Contenu principal
        // ************************
        //Création d'un Label demande de nom
        gbCC.gridy = 0;
        JLabel lNom = new JLabel("Entrez le nom de la Personne");               // Créer un label
        panelContenu.add(lNom, gbCC);                                           // le label au panelContenu

        //Création d'un TextField nom
        gbCC.gridy = 1;
        tfNom = new TextField("", 50);                                          // Créer un Text Field
        panelContenu.add(tfNom, gbCC);                                          // le Text Field au panelContenu

        //Création d'un Label demande de prenom
        gbCC.gridy = 2;
        JLabel lPrenom = new JLabel("Entrez le prenom de la Personne");         // Créer un label
        panelContenu.add(lPrenom, gbCC);                                        // le label au panelContenu

        //Création d'un TextField prenom
        gbCC.gridy = 3;
        tfPrenom = new TextField("", 50);                                       // Créer un Text Field
        panelContenu.add(tfPrenom, gbCC);                                        // le Text Field au panelContenu

        //Création d'un Label demande de date de naissance
        gbCC.gridy = 4;
        JLabel lDteNaissance = new JLabel("Entrez la date de naissance de la Personne");    // Créer un label
        panelContenu.add(lDteNaissance, gbCC);                                              // le label au panelContenu

        //Création d'un TextField date de naissance
        gbCC.gridy = 5;
        tfDateNaissance = new TextField("", 50);                                // Créer un Text Field
        panelContenu.add(tfDateNaissance, gbCC);                                // le Text Field au panelContenu

        // **********************
        //Création du panel Auteur
        // *********************
        JPanel panelAuteur = new JPanel();                                      // Création d'un JPanel à intégré dans le JPanel principal
        panelAuteur.setLayout(new GridBagLayout());                             // Création d'un Layaout de tipe GridBag
        GridBagConstraints gbCAuteur = new GridBagConstraints();                // Le gbCAuteur va définir la position et la taille des éléments
        gbCAuteur.fill = GridBagConstraints.BOTH;                               // Prend toute la place diponible en hauteur et en largeur
        gbCAuteur.insets = new Insets(5, 5, 5, 5);                              // insets défini la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */
        panelAuteur.setVisible(false);


        // *********************
        // Création du panel Realisateur
        // *********************
        JPanel panelRealisateur = new JPanel();                                 // Création d'un JPanel
        panelRealisateur.setLayout(new GridBagLayout());                        // Création d'un Layaout de tipe GridBag
        GridBagConstraints gbCRealisateur = new GridBagConstraints();           // Le gbCAuteur va définir la position et la taille des éléments
        gbCRealisateur.fill = GridBagConstraints.BOTH;                          // Prend toute la place diponible en hauteur et en largeur
        gbCRealisateur.insets = new Insets(5, 5, 5, 5);                         // insets défini la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */
        panelRealisateur.setVisible(false);


        // *************************************
        // Retour sur le Panel Contenu principal
        // *************************************
        //Création du choix Auteur/Realisateur
        gbCC.gridy = 6;
        gbCC.gridx = 0;
        ButtonGroup bg = new ButtonGroup();
        JPanel lesRadioButton = new JPanel();
        JRadioButton auteur = new JRadioButton("Auteur");
        bg.add(auteur);
        lesRadioButton.add(auteur);
        JRadioButton realisateur = new JRadioButton("Realisateur");
        bg.add(realisateur);
        lesRadioButton.add(realisateur);
        panelContenu.add(lesRadioButton, gbCC);
        auteur.addActionListener((event) -> {                                   // Créer une " "micro fonction" " lorsque quelque chose se passe sur le bouton
            //Actions lors des cliques sur le bouton 
            panelRealisateur.setVisible(false);
            panelAuteur.setVisible(true);
            fenetre.pack();
        });
        realisateur.addActionListener((event) -> {                              // Créer une " "micro fonction" " lorsque quelque chose se passe sur le bouton
            //Actions lors des cliques sur le bouton 
            panelRealisateur.setVisible(true);
            panelAuteur.setVisible(false);
            fenetre.pack();
        });

        //Emplacement des Panels DVD et Livre
        gbCC.gridy = 7;
        gbCC.gridx = 0;
        panelContenu.add(panelAuteur, gbCC);
        panelContenu.add(panelRealisateur, gbCC);

        //Création des boutons
        gbCC.gridy = 8;
        JButton bAddPersonne = new JButton("Ajouter");                           // Créer un bouton "Ajouter"
        bAddPersonne.setSize(100, 50);                                           // de taille 100x50
        panelContenu.add(bAddPersonne, gbCC);                                    // ajoute ce bouton, au panelContenu
        bAddPersonne.addActionListener((event) -> {                              // Créer une " "micro fonction" " lorsque quelque chose se passe sur le bouton
            //Actions lors des cliques sur le bouton 
            if (auteur.isSelected()) {
                Fenetre formMain = new Fenetre("Menu");                         // Instanciation de Fenetre de 1024x768 avec le titre "Menu"
                fenetre.dispose();

            } else if (realisateur.isSelected()) {
                Fenetre formMain = new Fenetre("Menu");                         // Instanciation de Fenetre de 1024x768 avec le titre "Menu"
                fenetre.dispose();
            }
        });

        gbCC.gridy = 9;
        JButton bRetour = new JButton("Retour");                                // Créer un bouton "Retour"
        bAddPersonne.setSize(100, 50);                                          // de taille 100x50
        panelContenu.add(bRetour, gbCC);                                        // ajoute ce bouton, au panelContenu
        bRetour.addActionListener((event) -> {                                  // Créer une " "micro fonction" " lorsque quelque chose se passe sur le bouton
            //Actions lors des cliques sur le bouton 
            Fenetre formMain = new Fenetre("Menu");                             // Instanciation de Fenetre avec le titre "Menu"
            fenetre.dispose();                                                  // Ferme la fenetre
        });

        // Couleurs pour les Tests
        PanelError.setBackground(Color.red);
        panelContenu.setBackground(Color.PINK);
        panelRealisateur.setBackground(Color.CYAN);
        panelAuteur.setBackground(Color.GREEN);
        panel.setBackground(Color.gray);

        fenetre.add(panel);                                                     // Ajoute le JPanel (panelContenu) au JFrame (fenetre)
        fenetre.pack();                                                         //
        fenetre.setVisible(true);                                               // Rend la fenêtre visible
    }
}
