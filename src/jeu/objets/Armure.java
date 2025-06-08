package jeu.objets;

import jeu.entites.Caracteristiques;

public abstract class Armure extends Equipement {
    private String _nom;
    private int _ClasseArmure;
    private Caracteristiques _statsbonus;


    public Armure(String nom, int ClasseArmure, Caracteristiques statsbonus) {
        super(nom);
        this._ClasseArmure = ClasseArmure;
        this._statsbonus = statsbonus;
    }


    @Override
    public boolean isArmure() {
        return true;
    }
    @Override
    public String toString() {
        return getNom() + " (Classe d'armure: " + _ClasseArmure + ")";
    }

    public int getClasseArmure() {
        return _ClasseArmure;
    }
}
