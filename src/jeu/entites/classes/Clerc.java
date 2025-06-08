package jeu.entites.classes;

import jeu.entites.Caracteristiques;
import jeu.support.*;

import java.util.Arrays;

public class Clerc extends ClassePersonnage {
    public Clerc() {
        super("Clerc", new Caracteristiques(16, 0, 0, 0, 0),
                Arrays.asList(
                        ListeEquipement.getEquipementparNom("Masse"),
                        ListeEquipement.getEquipementparNom("Armure d'écailles"),
                        ListeEquipement.getEquipementparNom("Arbalète légère")
                ));
    }
}
