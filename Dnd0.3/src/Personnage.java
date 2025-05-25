public class Personnage {
    private String m_nom;
    private Race m_race;
    private Classe m_classe;
    private Caractéristiques m_stat;

    public Personnage(String nom, Race race, Classe classe, Caractéristiques stat) {
        this.m_nom = nom;
        this.m_race = race;
        this.m_classe = classe;
        this.m_stat = stat;
    }

    public String getNom() {
        return m_nom;
    }

    public Race getRace() {
        return m_race;
    }

    public Classe getClasse() {
        return m_classe;
    }

    public Caractéristiques getStat() {
        return m_stat;
    }

}