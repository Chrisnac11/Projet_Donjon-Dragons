package jeu.support;

import jeu.objets.*;

import java.util.List;

public class ListeEquipement {
    private static List<Equipement> _listeEquipement;
    public ListeEquipement() {
        _listeEquipement = new java.util.ArrayList<>();

        ajouterEquipement(new ArmureLegere("Armure d'écailles", 9));
        ajouterEquipement(new ArmureLegere("Demi plaque", 10));

        ajouterEquipement(new ArmureLourde("Cotte de maille", 11));
        ajouterEquipement(new ArmureLourde("Armure de plaque", 12));

        ajouterEquipement(new ArmeCaC("Baton", 1, 1,6));
        ajouterEquipement(new ArmeCaC("Masse", 1, 1,6));

        ajouterEquipement(new ArmeGuerre("Eppe longue", 1, 1,8));
        ajouterEquipement(new ArmeGuerre("Rapière", 1,1, 8));
        ajouterEquipement(new ArmeGuerre("Epee à deux mains", 2,2, 6));

        ajouterEquipement(new ArmeDistance("Arbalète légère", 16, 1,8));
        ajouterEquipement(new ArmeDistance("Frond", 6, 1,4));
        ajouterEquipement(new ArmeDistance("Arc court", 16, 1,6));

    }


    public void ajouterEquipement(Equipement e) {
        if (e != null && !_listeEquipement.contains(e)) {
            _listeEquipement.add(e);
        }
    }

    public void retirerEquipement(Equipement e) {
        if (e != null && _listeEquipement.contains(e)) {
            _listeEquipement.remove(e);
        } else {
            System.out.println("N'existe pas.");
        }
    }


    public List<Equipement> getEquipments() {
       return _listeEquipement;
    }

    public static Equipement getEquipementparNom(String equipment) {
        for (Equipement e : _listeEquipement) {
            if (e.getNom().equals(equipment)) {
                return e;
            }
        }
        return null;
    }

}
