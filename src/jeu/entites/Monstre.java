package jeu.entites;

import jeu.objets.Equipement;
import jeu.objets.Arme;
import jeu.support.Affichage;
import jeu.support.supportJeu;

import java.util.List;

public class Monstre extends Entite {
    private int _nombre;
    private int ClasseArmure;


    public Monstre(String especes, int nombre, Arme arme, int AC) {
        super(especes);
        this.setPV(supportJeu.lancer(4, 4) + 3);
        this.setMaxPV(getPV());
        this._nombre = nombre;
        this.ClasseArmure = AC;
        this.setArmeEquipee(arme);

        if (especes.length() == 1) {
            this.setPseudo(especes + "#" + nombre);
        } else if (especes.length() == 2) {
            this.setPseudo(especes + nombre);
        } else {
            this.setPseudo(especes.substring(0, 2) + nombre);
        }
    }


    @Override
    public boolean isMonstre() {
        return true;
    }

    @Override
    public int getClasseArmure() {
        return ClasseArmure;
    }

    @Override
    public String afficherInventaire() {
        return "Les monstres n'ont pas d'inventaire.";
    }
    @Override
    public void equiperArme(Equipement equipement) {
        Affichage.afficherErreur("Les monstres ne peuvent pas équiper d'arme.");

    }
    @Override
    public void equiperArmure(Equipement equipement) {
        Affichage.afficherErreur("Les monstres ne peuvent pas équiper d'armure.");
    }
    @Override
    public List<Equipement> getInventaire() {
        return null;
    }

    @Override
    public String getCouleur() {
        return supportJeu.ROUGE;
    }

    public String getInfo() {
        return  "   PV ❤ : " + this.getPV() + "/" + this.getMaxPV() + "\n" +
                "   Portee : " + this.getArmeEquipee().getPortee() + "\n" +
                "   FOR ✪ : " + this.getCaracteristiques().getForce() + "\n" +
                "   DEX ➔ : " + this.getCaracteristiques().getDexterite() + "\n" +
                "   VIT ⚡ : " + this.getCaracteristiques().getVitesse() + " (Vous pouvez bouger de " + this.getCaracteristiques().getVitesse()/3 + " cases par tour.";
    }

    @Override
    public String toString() {
        return supportJeu.ROUGE + super.getNom() + " #" + _nombre + supportJeu.REINITIALISER;
    }
}