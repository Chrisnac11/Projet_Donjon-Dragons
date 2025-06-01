package Objets;

import java.util.ArrayList;
import java.util.List;

public class EquipementPersonnage {
    private Arme armePrincipale;
    private Armure armure;
    private List<Objet> accessoires;

    public EquipementPersonnage() {
        this.accessoires = new ArrayList<>();
    }

    public Arme getArmePrincipale() {
        return armePrincipale;
    }

    public void changerArme(Arme armePrincipale) {
        this.armePrincipale = armePrincipale;
    }

    public Armure getArmure() {
        return armure;
    }

    public void changerArmure(Armure armure) {
        this.armure = armure;
    }

    public List<Objet> getAccessoires() {
        return accessoires;
    }

    public void ajouterAccessoire(Objet accessoire) {
        this.accessoires.add(accessoire);
    }

    public void retirerAccessoire(Objet accessoire) {
        this.accessoires.remove(accessoire);
    }

    @Override
    public String toString() {
        return "ÉquipementPersonnage{" +
                "armePrincipale=" + (armePrincipale != null ? armePrincipale.getNom() : "aucune") +
                ", armure=" + (armure != null ? armure.getNom() : "aucune") +
                ", accessoires=" + accessoires +
                '}';
    }
}