/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmationobjet.forms;

import programmationobjet.main.ProgrammationObjet;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Ikikay
 */
public class Fenetre {

    public Fenetre(String titre) {
        JFrame fenetre = new JFrame();                                          // Création d'un JFrame
        fenetre.setTitle(titre);                                                // Applique le titre à la fenêtre
        fenetre.setBounds(25, 25, 100, 100);                                    // Fait une fenêtre de largeur x hauteur avec 25 de marge
        fenetre.setDefaultCloseOperation(DISPOSE_ON_CLOSE);                     // Ferme l'application si il n'y à plus de fenêtre
        fenetre.setLocationRelativeTo(null);                                    // Centre la fenêtre
        JPanel panel = new JPanel();                                            // Création d'un JPanel
        panel.setLayout(new GridBagLayout());                                   // Création d'un Layaout de tipe GridBag
        GridBagConstraints gbC = new GridBagConstraints();                      // Le gbC va définir la position et la taille des éléments
        gbC.fill = GridBagConstraints.BOTH;                                     // Prend toute la place diponible en hauteur et en largeur
        gbC.insets = new Insets(5, 5, 5, 5);                                    // insets défini la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */

        //Création de la liste d'articles
        gbC.gridx = 0;
        gbC.gridy = 0;
        JList listArticles = new JList(ProgrammationObjet.globalLesArticles.toArray());     // Création d'une JList avec les articles
        panel.add(new JScrollPane(listArticles), gbC);                                      // Ajoute un scrollbar + la liste des articles au panel

        //Création de la liste de personnes
        gbC.gridx = 0;
        gbC.gridy = 1;
        JList listPersonnes = new JList(ProgrammationObjet.globalLesPersonnes.toArray());   // Création d'une JList avec les personnes
        panel.add(new JScrollPane(listPersonnes), gbC);                                     // Ajoute un scrollbar + la liste des personnes au panel

        //Création des boutons
        gbC.gridx = 1;
        gbC.gridy = 0;
        JButton bAddArticle = new JButton("Ajouter");                           // Créer un bouton "Ajouter"
        bAddArticle.setSize(100, 50);                                           // de taille 100x50
        panel.add(bAddArticle, gbC);                                            // ajoute ce bouton, au panel
        //Action Boutons
        bAddArticle.addActionListener((event) -> {                              // Créer une " "micro fonction" " lorsque quelque chose se passe sur le bouton
            //Actions lors des cliques sur le bouton 
            Article formAddArticle = new Article();                             // Ouvre une fenetre AddArticle
            fenetre.dispose();                                                  // Ferme la fenetre
        });

        //Création des boutons        
        gbC.gridx = 1;
        gbC.gridy = 1;
        JButton bAddPersonne = new JButton("Ajouter");                          // Créer un bouton "Ajouter"
        bAddPersonne.setSize(100, 50);                                          // de taille 100x50
        panel.add(bAddPersonne, gbC);                                           // ajoute ce bouton, au panel
        bAddPersonne.addActionListener((event) -> {                             // Créer une " "micro fonction" " lorsque quelque chose se passe sur le bouton
            //Actions lors des cliques sur le bouton 
            Personne formAddPersonne = new Personne();                          // Ouvre une fenetre AddArticle
            fenetre.dispose();                                                  // Ferme la fenetre
        });

        fenetre.add(panel);                                                     // Ajoute le JPanel (panel) au JFrame (fenetre)
        fenetre.pack();                                                         //
        fenetre.setVisible(true);                                               // Rend la fenêtre visible
    }
}
