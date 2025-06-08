package jeu.entites;


import jeu.objets.Armure;
import jeu.objets.Equipement;
import jeu.objets.Arme;
import jeu.support.supportJeu;

import java.util.List;

public abstract class Entite {
    private String _nom;
    private String _pseudo;
    private Caracteristiques _caracteristiques;
    private Arme _armeEquipee;
    private Armure _armureEquipee;
    private int _maxPV;


    protected Entite(String nom) {
        this._nom = nom;
        this._caracteristiques = new Caracteristiques(
                0,
                (supportJeu.lancer(4, 4) + 3),
                (supportJeu.lancer(4, 4) + 3),
                (supportJeu.lancer(4, 4) + 3),
                (supportJeu.lancer(4, 4) + 3));
    }

    public Caracteristiques getCaracteristiques() {
        return _caracteristiques;
    }



    //!popopo le instanceof du pauvre
    public boolean isJoueur() {return false;}
    public boolean isMonstre() {return false;}




    public abstract String toString();

    public String getNom() {
        return _nom;
    }

    public String getPseudo() {
        return _pseudo;
    }


    public abstract String getInfo();


    public int getInitiative() {
        return _caracteristiques.getInitiative();
    }

    public void retirerPV(int pv) {
        this._caracteristiques.ajouterCaracteristiques(new Caracteristiques(-pv, 0, 0, 0, 0));
    }
    public void setPV(int pv) {
        this._caracteristiques.ajouterCaracteristiques(new Caracteristiques(pv, 0, 0, 0, 0));
    }

    public void setMaxPV(int maxPV) {
        this._maxPV = maxPV;
    }
    public int getPV() {
        return _caracteristiques.getPV();
    }

    public int getMaxPV() {
        return _maxPV;
    }

    public void setPseudo(String pseudo) {
        this._pseudo = pseudo;
    }

    public String getCouleur() {
        return supportJeu.VIOLET;
    }

    public boolean isVivant() {
        if (_caracteristiques.getPV() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean peutAttaquer(Entite cible) {
        if ((this.isMonstre() && cible.isJoueur() || this.isJoueur() && cible.isMonstre()) && this.getArmeEquipee() != null) {
            return true;
        }
        return false;
    }


    public int getClasseArmure() {
        if (_armureEquipee == null) {
            return 0;
        }
        return _armureEquipee.getClasseArmure();
    }

    public abstract String afficherInventaire();
    public abstract List<Equipement> getInventaire();

    public Arme getArmeEquipee() {
        return _armeEquipee;
    }
    public Armure ArmureEquipee() {
        return _armureEquipee;
    }



    protected void setArmeEquipee(Arme arme) {
        this._armeEquipee = arme;
    }
    protected void setArmureEquipee(Armure armure){
        this._armureEquipee = armure;
    }

    public abstract void equiperArmure(Equipement equipement);

    public abstract void equiperArme(Equipement equipement);
}
