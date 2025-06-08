package jeu.objets;

import jeu.entites.Caracteristiques;

public class ArmeGuerre extends Arme {
    public ArmeGuerre(String nom, int portee, int nbDes, int jetdegat) {
        super(nom, portee,nbDes, jetdegat, new Caracteristiques(0, 4, 0, -2, 0));
    }

}
