package jeu.entites.races;

import jeu.entites.Caracteristiques;

public abstract class Race {
    private String _nom;
    private Caracteristiques _statsbonus;


    protected Race(String nom, Caracteristiques statsbonus) {
        this._nom = nom;
        this._statsbonus = statsbonus;
    }

    public Caracteristiques getBonusStats() {
        return _statsbonus;
    }

    public String getNom() {
        return _nom;
    }
}
