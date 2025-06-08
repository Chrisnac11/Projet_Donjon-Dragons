package jeu.support;

import java.util.Random;
import java.util.Scanner;

public class supportJeu {


    public static final String REINITIALISER = "\u001B[0m";
    public static final String ROUGE = "\u001B[31m";
    public static final String VERT = "\u001B[32m";
    public static final String BlEU = "\u001B[34m";
    public static final String VIOLET = "\u001B[35m";
    public static final String JAUNE = "\u001B[33m";
    public static final String FOND_BLANC = "\u001B[47m";
    public static final Random random = new Random();
    public static final Scanner scanner = new Scanner(System.in);

    public static int lancer(int num, int faces) {
        int acc = 0;
        for (int i = 0; i < num; i++) {
            acc += random.nextInt(faces) + 1;
        }
        return acc;
    }

    public static int[] parsePosition(String position) {
        char colonne = position.charAt(0);
        String ligne = position.substring(1);

        int x = Integer.parseInt(ligne);
        int y = Character.toUpperCase(colonne) - 'A' + 1;

        return new int[]{x, y};
    }
}
