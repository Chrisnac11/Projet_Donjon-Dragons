public class Personnage {
    private String m_nom;
    private Race m_race;
    private Classe m_classe;
    private Statistique m_stat;

    public Personnage(String nom, Race race, Classe classe, Statistique stat) {
        this.m_nom = nom;
        this.m_race = race;
        this.m_classe = classe;
        this.m_stat = stat;
    }

    public String GetNom() {
        return this.m_nom;
    }

    public Race GetRace() {
        return this.m_race;
    }

    public Classe GetClasse() {
        return this.m_classe;
    }

}
