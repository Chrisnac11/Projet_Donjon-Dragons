package jeu.objets;

import jeu.entites.Caracteristiques;
import jeu.support.supportJeu;

public abstract class Arme extends Equipement {
    private int _portee;
    private int _jetdegat;
    private int _nbDes;
    private Caracteristiques _statsbonus;


    protected Arme(String nom, int portee, int nbDes, int jetdegat, Caracteristiques statsbonus) {
        super(nom);
        _portee = portee;
        _nbDes = nbDes;
        _jetdegat = jetdegat;
        _statsbonus = statsbonus;
    }


    public int getPortee() {
        return _portee;
    }
    public String getDegat() {
        return _nbDes + "d" + _jetdegat;
    }

    @Override
    public boolean isArme() {
        return true;
    }
    @Override
    public String toString() {
        return getNom() + " (Portee: " + getPortee() + ", Degat: " + getDegat() + ")";
    }

    public int degat() {
        return supportJeu.lancer(_nbDes, _jetdegat);
    }
}
