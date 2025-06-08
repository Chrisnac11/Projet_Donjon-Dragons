package jeu.objets;

import jeu.entites.Caracteristiques;

public class ArmureLourde extends Armure {

    public ArmureLourde(String nom, int ClasseArmure){
        super(nom, ClasseArmure, new Caracteristiques(0, 0, 0, -4, 0));

    }


}
