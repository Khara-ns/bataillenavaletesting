package com.example;

import java.util.Scanner;

public class Tableau {
    private String[][] TableauxUpdateZ;
    private int vies;

    public Tableau() {
        TableauxUpdateZ = new String[5][5];
        vies = 5;
    }

    public String[][] CreaTableau() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                TableauxUpdateZ[i][j] = "-";
            }
        }
        System.out.println("");
        return TableauxUpdateZ;
    }

    public static String[] positionBateau(int Joueur) {
        String[] positionBatable = new String[5];
        String nomJoueur = Integer.toString(Joueur + 1);
        for (int i = 0; i < 5; i++) {
            System.out.println("Joueur " + nomJoueur + " Inserez les cases de votre bateau sous le format 1;2 : ");
            Scanner scannedplaces = new Scanner(System.in);
            String positionbato = scannedplaces.next();
            if (positionbato.length() < 3) {
                System.out.println("Veuillez corriger votre syntaxe");
                positionBatable = positionBateau(Joueur);
                return positionBatable;
            }
            positionBatable[i] = positionbato;
        }
        int doublon = 0;
        for (int i = 0; i < positionBatable.length; i++) {
            for (int j = 0; j < positionBatable.length; j++) {
                if (positionBatable[i].equals(positionBatable[j])) {
                    doublon++;
                }
            }
        }
        if (doublon > 5) {
            System.out.println("Il y a un doublon , veuillez ressayer");
            positionBatable = positionBateau(Joueur);
            return positionBatable;
        }
        System.out.println("");
        return positionBatable;
    }

    public void VisuTableau(int Joueur) {
        String nomJoueur = Integer.toString(Joueur + 1);
        System.out.println("Tableau du joueur" + nomJoueur);
        System.out.print("  0 1 2 3 4");
        for (int i = 0; i < 5; i++) {
            System.out.println("");
            System.out.print(i + " ");
            for (int j = 0; j < 5; j++) {
                if (TableauxUpdateZ[i][j] == "@") {
                    System.out.print("- ");
                } else {
                    System.out.print(TableauxUpdateZ[i][j]);
                    System.out.print(" ");
                }
            }
        }
        System.out.println("");
    }

    public String[][] Ajout(String[] position, int Joueur) {
        for (int i = 0; i < position.length; i++) {
            ajouterBateau(position[i], TableauxUpdateZ, Joueur);
        }
        return TableauxUpdateZ;
    }

    public static boolean estDansLesClous(int valeur) {
        if ((valeur >= 0) && (valeur <= 4)) {
            return true;
        } else {
            return false;
        }
    }

    public String[][] tirBateau() {
        Scanner scannedplaces = new Scanner(System.in);
        String tirEmplacement = scannedplaces.next();
        if (tirEmplacement.length() < 3) {
            System.out.println("Veuillez corriger votre syntaxe");
            tirBateau();
            return TableauxUpdateZ;
        }
        char iarg = tirEmplacement.charAt(0);
        char jarg = tirEmplacement.charAt(2);
        int a = Character.getNumericValue(iarg);
        int b = Character.getNumericValue(jarg);
        if ((estDansLesClous(a)) && (estDansLesClous(b))) {
            if ((TableauxUpdateZ[a][b] == "X") || (TableauxUpdateZ[a][b] == "o")) {
                System.out.println("Vous avez deja tire ici , ressayez");
                tirBateau();
                return TableauxUpdateZ;
            } else {
                if (TableauxUpdateZ[a][b] == "@") {
                    TableauxUpdateZ[a][b] = "X";
                    vies--;
                }
                if (TableauxUpdateZ[a][b] == "-") {
                    TableauxUpdateZ[a][b] = "o";
                }
            }
        } else {
            System.out.println("Veuillez corriger votre syntaxe");
            tirBateau();
        }
        return TableauxUpdateZ;
    }

    public static String[][] ajouterBateau(String bateauEmplacement, String[][] Tableau, int Joueur) {
        if (bateauEmplacement.length() < 3) {
            System.out.println("Veuillez corriger votre syntaxe");
            ajouterBateau(bateauEmplacement, Tableau, Joueur);
            return Tableau;
        }
        char iarg = bateauEmplacement.charAt(0);
        char jarg = bateauEmplacement.charAt(2);
        int a = Character.getNumericValue(iarg);
        int b = Character.getNumericValue(jarg);
        if ((estDansLesClous(a)) && (estDansLesClous(b))) {
            Tableau[a][b] = "@";
            return Tableau;
        } else {
            System.out.println("Veuillez corriger votre syntaxe");
            ajouterBateau(bateauEmplacement, Tableau, Joueur);
            return Tableau;
        }
    }

    public static int[] setupJoueurs(int[] Joueurs) {
        for (int i = 0; i < 2; i++) {
            Joueurs[i] = i;
        }
        return Joueurs;
    }

    public int getVies() {
        return vies;
    }
    // public int[] setupVies() {
    // for (int i = 0; i < 2; i++) {
    // vies[i] = 5;
    // }
    // return vies;
    // }
}