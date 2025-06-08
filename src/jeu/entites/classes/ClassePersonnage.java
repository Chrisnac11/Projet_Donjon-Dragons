package jeu.entites.classes;

import jeu.entites.Caracteristiques;
import jeu.objets.Equipement;

import java.util.List;

public abstract class ClassePersonnage {
    private String _nom;
    private List<Equipement> _equipementDepart;
    private Caracteristiques _bonusStats;


    protected ClassePersonnage(String nom, Caracteristiques bonusStats, List<Equipement> equipementDepart) {
        this._nom = nom;
        this._bonusStats = bonusStats;
        this._equipementDepart = equipementDepart;
    }

    public List<Equipement> getStartingEquipment() {
        return _equipementDepart;
    }

    public Caracteristiques getBonusStats() {
        return _bonusStats;
    }

    public String getNom() {
        return _nom;
    }


}
