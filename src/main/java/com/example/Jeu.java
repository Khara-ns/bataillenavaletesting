package com.example;

public class Jeu {
    public static void partie(int[] joueurs, Tableau Joueur1, Tableau Joueur2) {
        Tableau joueurCourant = Joueur2;
        String Attaquant = "Joueur 1 commencez la partie.";
        int Joueur1Vie = Joueur1.getVies();
        int Joueur2Vie = Joueur2.getVies();
        while ((Joueur1Vie != 0) && (Joueur2Vie != 0)) {
            System.out.println(Attaquant);
            joueurCourant.tirBateau();
            Joueur1.VisuTableau(joueurs[0]);
            Joueur2.VisuTableau(joueurs[1]);
            Joueur1Vie = Joueur1.getVies();
            Joueur2Vie = Joueur2.getVies();
            System.out.println("Bateaux en vie du joueur 1 :" + Joueur1Vie);
            System.out.println("Bateaux en vie du joueur 2 :" + Joueur2Vie);
            if (joueurCourant == Joueur1) {
                joueurCourant = Joueur2;
                Attaquant = "Tour du joueur 1 !";
            } else {
                joueurCourant = Joueur1;
                Attaquant = "Tour du joueur 2 !";
            }
        }
        // Tableau.VisuTableau(TableauxUpdate, joueurs[0]);
        // Tableau.VisuTableau(TableauxUpdate, joueurs[1]);

        // System.out.println("Bateaux en vie du joueur 1 :"+vies[0]);
        // System.out.println("Bateaux en vie du joueur 2 :"+vies[1]);
        // Joueur1.tirBateau(joueurs[1], joueurs[0] , vies);
        // Joueur2.VisuTableau(joueurs[1]);
        // Joueur1.VisuTableau(joueurs[0]);
        // Tableau.VisuTableau(TableauxUpdate, joueurs[1]);
        // Tableau.VisuTableau(TableauxUpdate, joueurs[0]);
        // System.out.println("Bateaux en vie du joueur 2 :"+vies[0]);
        // System.out.println("Bateaux en vie du joueur 2 :"+vies[1]);

        if (Joueur1Vie == 0) {
            System.out.println("Le joueur 1 a perdu !!");
        }
        if (Joueur2Vie == 0) {
            System.out.println("Le joueur 2 a perdu !!");
        }
    }
}
