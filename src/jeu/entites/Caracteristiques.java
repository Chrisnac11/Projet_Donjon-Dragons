package jeu.entites;

public class Caracteristiques {
    private int _pv;
    private int _force;
    private int dexterite;
    private int _vitesse;
    private int _initiative;

    public Caracteristiques() {
        this._pv = 0;
        this._force = 0;
        this.dexterite = 0;
        this._vitesse = 0;
        this._initiative = 0;
    }

    public Caracteristiques(int pv, int force, int dexterite, int vitesse, int initiative) {
        this._pv = pv;
        this._force = force;
        this.dexterite = dexterite;
        this._vitesse = vitesse;
        this._initiative = initiative;
    }


    public void ajouterCaracteristiques(Caracteristiques s) {
        this._pv += s._pv;
        this._force += s._force;
        this.dexterite += s.dexterite;
        this._vitesse += s._vitesse;
        this._initiative += s._initiative;
    }

    public void retirerCaracteristiques(Caracteristiques s) {
        this._pv -= s._pv;
        this._force -= s._force;
        this.dexterite -= s.dexterite;
        this._vitesse -= s._vitesse;
        this._initiative -= s._initiative;
    }

    public int getPV() {
        return _pv;
    }
    public int getForce() {
        return _force;
    }
    public int getDexterite() {
        return dexterite;
    }
    public int getVitesse() {
        return _vitesse;
    }
    public int getInitiative() {
        return _initiative;
    }

}
