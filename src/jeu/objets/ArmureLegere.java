package jeu.objets;

import jeu.entites.Caracteristiques;

public class ArmureLegere extends Armure {
    public ArmureLegere(String nom, int ClasseArmure) {
        super(nom, ClasseArmure, new Caracteristiques(0, 0, 0, 0, 0));
    }
}
