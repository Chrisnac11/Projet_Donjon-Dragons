package jeu.entites.classes;

import jeu.entites.Caracteristiques;
import jeu.support.ListeEquipement;

import java.util.Arrays;

public class Guerrier extends ClassePersonnage {
    public Guerrier() {
        super("Guerrier", new Caracteristiques(20, 0, 0, 0, 0),
                Arrays.asList(
                        ListeEquipement.getEquipementparNom("Cotte de mailles"),
                        ListeEquipement.getEquipementparNom("Epée longue"),
                        ListeEquipement.getEquipementparNom("Arbalète légère")
                ));
    }
}
