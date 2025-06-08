package jeu;

import jeu.entites.Entite;
import jeu.objets.Equipement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Positions {
    private HashMap<Entite, int[]> _positionEntite;
    private HashMap<Equipement, int[]> _positionEquipement;
    private List<int[]> _obstacles;


    public Positions() {
        _positionEntite = new HashMap<>();
        _positionEquipement = new HashMap<>();
        _obstacles = new ArrayList<>();
    }

    public void ajouterEntite(Entite entite, int[] position) {
        _positionEntite.put(entite, position);
    }
    public void ajouterEquipement(Equipement equipement, int[] position) {
        _positionEquipement.put(equipement, position);
    }
    public void ajouterObstacle(int[] position) {
        _obstacles.add(position);
    }
    public void retirerEntite(Entite target) {
        _positionEntite.remove(target);
    }

    public HashMap<Entite, int[]> getPositionEntite() {
        return _positionEntite;
    }
    public HashMap<Equipement, int[]> getPositionEquipement() {
        return _positionEquipement;
    }
    public List<int[]> getObstacles() {
        return _obstacles;
    }

    public int distanceEntre(Entite entite, int[] positionCible) {
        int[] positionEntite = _positionEntite.get(entite);

        int dx = Math.abs(positionEntite[0] - positionCible[0]);
        int dy = Math.abs(positionEntite[1] - positionCible[1]);

        return Math.max(dx, dy);
    }

    public int[] getEntityPosition(Entite entite) {
        return _positionEntite.get(entite);
    }
}
