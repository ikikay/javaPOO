/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmationobjet.main;

import programmationobjet.classes.*;

import java.time.LocalDate;
import java.util.ArrayList;
import programmationobjet.forms.Fenetre;

/**
 *
 * @author Ikikay
 */
public class ProgrammationObjet {

    public static ArrayList<Article> globalLesArticles;             // Créer une liste qui sera accessible partout
    public static ArrayList<Personne> globalLesPersonnes;           // Créer une liste qui sera accessible partout

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        globalLesArticles = new ArrayList<>();                      // Instancie la liste global
        globalLesPersonnes = new ArrayList<>();                     // Instancie la liste global

        //Création d'un jeu de test
        Realisateur rea = new Realisateur("Lucas", "Georges", LocalDate.of(1944, 04, 14));
        Auteur aut = new Auteur("Terry", "Goodkind", LocalDate.of(1962, 10, 01));        
        Dvd dvd = new Dvd("Star Wars I", "La Menace Fantome", 10.0, 2.16, "Georges Lucas");
        Livre livre = new Livre("L'épée de vérité", "La Première leçon du sorcier", 10.0, "2811211187", 532 ,"Terry GOODKIND");
        // Ajoute le DVD au réalisateur, et le livre à l'auteur
        rea.getLesDvd().add(dvd);
        aut.getLesLivres().add(livre);

        //Ajoute les éléments ci-dessus à la liste global
        globalLesArticles.add(dvd);
        globalLesArticles.add(livre);
        globalLesPersonnes.add(rea);
        globalLesPersonnes.add(aut);
        
        Fenetre formMain = new Fenetre();                           // Instanciation de Fenetre avec le titre "Menu"
        
        /* Premier exercice, commenté car devenu inutile
        JFrame formMain = new JFrame();                             // Création d'un JFrame nommé formMain
        JPanel panel = new JPanel();                                // Création d'un JPanel nommé panel

        //Création de la fenêtre principal
        formMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ferme l'application si la dernière fenêtre est fermé
        formMain.setTitle("Menu");                                  // Met le titre "Menu" à la fenêtre
        formMain.setBounds(25, 25, 1024, 768);                      // Créer une fenêtre de 768x1024 avec 25 de marges
        formMain.setLocationRelativeTo(null);                       // Centre la fenêtre

        //Création des boutons 
        JButton boutonRouge = new JButton("Rouge");                 // Créer un bouton "boutonRouge"
        boutonRouge.setSize(100, 50);                               // de taille 100x50
        panel.add(boutonRouge);                                     // ajoute ce bouton, au panel

        JButton boutonVert = new JButton("Vert");                   // Créer un bouton
        boutonVert.setSize(100, 50);                                // de taille 100x50
        panel.add(boutonVert);                                      // ajoute ce bouton, au panel

        JButton boutonBleu = new JButton("Bleu");                   // Créer un bouton
        boutonBleu.setSize(100, 50);                                // de taille 100x50
        panel.add(boutonBleu);                                      // ajoute ce bouton, au panel

        //Action Boutons
        boutonRouge.addActionListener((event) -> {                  // Créer une " "micro fonction" " lorsque quelque chose se passe sur le bouton
            //Actions lors des cliques sur le bouton 
            panel.setBackground(Color.red);                         // Met le fond en rouge
        });
        boutonVert.addActionListener((event) -> {                   // Créer une " "micro fonction" " lorsque quelque chose se passe sur le bouton
            //Actions lors des cliques sur le bouton
            panel.setBackground(Color.green);                       // Met le fond en Vert
        });
        boutonBleu.addActionListener((event) -> {                   // Créer une " "micro fonction" " lorsque quelque chose se passe sur le bouton
            //Actions lors des cliques sur le bouton
            panel.setBackground(Color.blue);                        // Met le fond en Bleu
        });
         
        formMain.getContentPane().add(panel);                       // Met le Panel à la fenêtre
        formMain.setVisible(true);                                  // Rend la fenêtre principal visible
        */
    }

}
