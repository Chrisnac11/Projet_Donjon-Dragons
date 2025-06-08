package jeu.entites.classes;

import jeu.entites.Caracteristiques;
import jeu.support.ListeEquipement;

import java.util.Arrays;

public class Magicien extends ClassePersonnage {
    public Magicien() {
        super("Magicien", new Caracteristiques(12, 0, 0, 0, 0),
                Arrays.asList(
                        ListeEquipement.getEquipementparNom("Bâton"),
                        ListeEquipement.getEquipementparNom("Fronde")
                ));
    }
}
