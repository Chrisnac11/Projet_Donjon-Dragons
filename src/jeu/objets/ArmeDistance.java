package jeu.objets;

import jeu.entites.Caracteristiques;

public class ArmeDistance extends Arme {
    public ArmeDistance(String nom, int portee, int nbDes, int jetdegat) {
        super(nom, portee, nbDes, jetdegat, new Caracteristiques(0, 0, 0, 0, 0));
    }

}
