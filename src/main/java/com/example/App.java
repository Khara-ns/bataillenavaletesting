package com.example;

public class App {
    public static void main(String[] args) {
        Tableau Joueur1 = new Tableau();
        Tableau Joueur2 = new Tableau();
        int[] joueurs = new int[2];

        // Joueur1.setupVies();
        // Joueur2.setupVies();
        joueurs = Tableau.setupJoueurs(joueurs);
        Joueur1.CreaTableau();
        Joueur2.CreaTableau();
        Joueur1.VisuTableau(joueurs[0]);
        Joueur2.VisuTableau(joueurs[1]);
        // Tableau.VisuTableau(TableauxUpdate, joueurs[0]);
        // Tableau.VisuTableau(TableauxUpdate, joueurs[1]);
        String[] positionjoueur1 = Tableau.positionBateau(joueurs[0]);
        Joueur1.Ajout(positionjoueur1, joueurs[0]);
        Joueur1.VisuTableau(joueurs[0]);
        // Tableau.VisuTableau(TableauxUpdate, joueurs[0]);
        String[] positionjoueur2 = Tableau.positionBateau(joueurs[0]);
        Joueur2.Ajout(positionjoueur2, joueurs[1]);
        Joueur2.VisuTableau(joueurs[1]);
        // Tableau.VisuTableau(TableauxUpdate, joueurs[1]);
        Jeu.partie(joueurs, Joueur1, Joueur2);
    }

}
