package Entités.Personnages.Classes;

public abstract class Classes {
    private String m_nom;

    public Classes(String name) {
        this.m_nom = name;
    }

    public String getNom() {
        return m_nom;
    }
}