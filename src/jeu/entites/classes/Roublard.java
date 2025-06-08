package jeu.entites.classes;

import jeu.entites.Caracteristiques;
import jeu.support.ListeEquipement;

import java.util.Arrays;

public class Roublard extends ClassePersonnage {
    public Roublard() {
        super("Roublard", new Caracteristiques(16, 0, 0, 0, 0),
                Arrays.asList(
                        ListeEquipement.getEquipementparNom("Rapière"),
                        ListeEquipement.getEquipementparNom("Arbalète légère")
                ));
    }
}
