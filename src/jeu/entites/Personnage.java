package jeu.entites;
import jeu.entites.races.*;
import jeu.entites.classes.*;
import jeu.objets.*;
import jeu.support.supportJeu;

import java.util.ArrayList;
import java.util.List;

public class Personnage extends Entite {
    private Race _race;
    private ClassePersonnage _class;
    private List<Equipement> _inventory;

    public Personnage(String name, Race race, ClassePersonnage charclass) {
        super(name);
        this._race = race;
        this._class = charclass;
        this._inventory = new ArrayList<>(charclass.getStartingEquipment());

        this.getCaracteristiques().ajouterCaracteristiques(_race.getBonusStats());
        this.getCaracteristiques().ajouterCaracteristiques(_class.getBonusStats());

        //? Handling du pseudo pour garder l'alignement de la map
        if (name.length() == 1) {
            this.setPseudo(" " + name + " ");
        } else if (name.length() == 2) {
            this.setPseudo(name + " ");
        } else {
            this.setPseudo(name.substring(0, 3));
        }

        this.setMaxPV(this.getPV());

    }

    @Override
    public boolean isJoueur() {
        return true;
    }

    public String afficherInventaire() {
        if (_inventory == null || _inventory.isEmpty()) {
            return "L'inventaire est vide.";
        }
        StringBuilder inventoryDisplay = new StringBuilder();
        for (Equipement equipement : _inventory) {
            int n = _inventory.indexOf(equipement);
            inventoryDisplay.append("[" + n + "] ").append(equipement.toString()).append(" | ");
        }
        return inventoryDisplay.toString();
    }

    public List<Equipement> getInventaire() {
        return _inventory;
    }

    @Override
    public void equiperArme(Equipement equipement){
        if (this.getArmeEquipee()==null){
            this.setArmeEquipee((Arme) equipement);
            this._inventory.remove(equipement);
        }
        else {
            this ._inventory.add(this.getArmeEquipee());
            this.setArmeEquipee((Arme) equipement);
            this._inventory.remove(equipement);
        }
    }

    @Override
    public void equiperArmure(Equipement equipement){
        if (this.ArmureEquipee()==null){
            this.setArmureEquipee((Armure) equipement);
            this._inventory.remove(equipement);
        }
        else {
            this ._inventory.add(this.ArmureEquipee());
            this.setArmureEquipee((Armure) equipement);
            this._inventory.remove(equipement);
        }
    }


    public String getInfo(){
        return  "   PV ❤ : " + this.getPV() + "/" + this.getMaxPV() + "\n" +
                "   Armure ⊙ : " + (this.ArmureEquipee() != null ? this.ArmureEquipee().getNom() : "None") + "\n" +
                "   Arme ⚔ : " + (this.getArmeEquipee() != null ? this.getArmeEquipee().toString() : "None") + "\n" +
                "   Inventaire ◼ : " + this.afficherInventaire() + "\n" +
                "   FOR ✪ : " + this.getCaracteristiques().getForce() + "\n" +
                "   DEX ➔ : " + this.getCaracteristiques().getDexterite() + "\n" +
                "   VIT ⚡ : " + this.getCaracteristiques().getVitesse() + " (Vous pouvez bouger de " + this.getCaracteristiques().getVitesse()/3 + " cases par tour).";
    }
    @Override
    public String toString() {
        return supportJeu.VIOLET + super.getNom() + " le " + _class.getNom() + " " + _race.getNom() + supportJeu.REINITIALISER;
    }
}
