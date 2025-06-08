package jeu.objets;

public abstract class Equipement {
    private String _nom;

    protected Equipement(String nom) {
        _nom = nom;
    }

    public String getNom(){
        return _nom;
    }

    public String toString(){
        return _nom;
    }

    public boolean isArme() {
        return false;
    }
    public boolean isArmure() {
        return false;
    }
}
