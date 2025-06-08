package jeu.entites.races;

import jeu.entites.Caracteristiques;

public class Humain extends Race{
    public Humain() {
        super("Humain", new Caracteristiques(2, 2, 2, 2, 2));
    }
}
