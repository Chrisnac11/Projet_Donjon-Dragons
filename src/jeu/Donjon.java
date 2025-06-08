package jeu;

import jeu.entites.Entite;
import jeu.objets.Equipement;
import jeu.support.supportJeu;
import jeu.support.Affichage;

import java.util.*;

import static jeu.support.supportJeu.parsePosition;
import static jeu.support.supportJeu.scanner;


public class Donjon {
    private String[][] _carte;
    private int _hauteur;
    private int _largeur;
    private Positions _positions;
    private int _nombre;


    public Donjon(int h, int l, int nombre) {
        if (l >= 15 && l <= 26 && h >= 15 && h <= 26) {
            _hauteur = h;
            _largeur = l;
        } else {
            System.out.println("La carte doit faire entre 15 et 26 cases de large et de haut.");
            _hauteur = 15;
            _largeur = 15;
        }

        _nombre = nombre;
        _carte = new String[_hauteur + 3][_largeur + 1];
        _positions = new Positions();

        for (int j = 0; j < _carte[0].length; j++) {
            if (j >= 1) {
                _carte[_carte.length - 1][j] = (char) ('A' + j - 1) + "  ";
            } else {
                _carte[_carte.length - 1][j] = "      ";
            }
        }

        for (int j = 0; j < _carte[0].length; j++) {
            _carte[0][j] = "   *";
            _carte[_carte.length - 2][j] = "   *";
            for (int k = 1; k < _carte[0].length; k++) {
                _carte[0][k] = "---";
                _carte[_carte.length - 2][k] = "---";
            }
            _carte[0][_carte[0].length - 1] = "-----*";
            _carte[_carte.length - 2][_carte[0].length - 1] = "-----*";
        }

        for (int i = 1; i < _carte.length - 2; i++) {
            for (int j = 0; j < _carte[i].length; j++) {
                if (j == 0) {
                    _carte[i][j] = (i < 10 ? " " : "") + i + " | ";
                } else {
                    _carte[i][j] = (j == _carte[i].length - 1 ? " .  |" : " . ");
                }
            }
        }
    }

    public boolean isPositionValide(int x, int y) {

        if (x < 1 || x >= _carte.length - 1 || y < 1 || y >= _carte[0].length) {
            return false;
        }

        for (int[] obstacle : _positions.getObstacles()) {
            if (obstacle[0] == x && obstacle[1] == y) {
                return false;
            }
        }

        for (Map.Entry<Entite, int[]> entity : _positions.getPositionEntite().entrySet()) {
            if (entity.getValue()[0] == x && entity.getValue()[1] == y) {
                return false;
            }
        }

        for (Map.Entry<Equipement, int[]> equipement : _positions.getPositionEquipement().entrySet()) {
            if (equipement.getValue()[0] == x && equipement.getValue()[1] == y) {
                return false;
            }
        }
        return true;
    }

    public void ajouterEntite(int x, int y, Entite entite) {
        if (isPositionValide(x, y)) {
            _positions.ajouterEntite(entite, new int[]{x, y});
        }
    }
    public void setEntiteAleatoirement(List<Entite> entities) {
        for (Entite entite : entities) {
            int x = supportJeu.lancer(1, _hauteur -2);
            int y = supportJeu.lancer(1, _largeur -1);
            while (!isPositionValide(x, y)) {
                x = supportJeu.lancer(1, _hauteur -2);
                y = supportJeu.lancer(1, _largeur -1);
            }
            ajouterEntite(x, y, entite);
        }
    }
    public void ajouterEquipement(int x, int y, Equipement equipement) {
        if (isPositionValide(x, y)) {
            _positions.ajouterEquipement(equipement,new int[]{x, y});
        }
    }
    public void setEquipementAleatoirement(List<Equipement> equipements) {
        for (Equipement equipement : equipements) {
            int x = supportJeu.lancer(1, _hauteur -2);
            int y = supportJeu.lancer(1, _largeur -1);
            while (!isPositionValide(x, y)) {
                x = supportJeu.lancer(1, _hauteur -2);
                y = supportJeu.lancer(1, _largeur -1);
            }
            ajouterEquipement(x, y, equipement);
        }
    }
    public void ajouterObstacle(int x, int y) {
        if (isPositionValide(x, y)) {
            _positions.ajouterObstacle(new int[]{x, y});
        }
    }
    public void setObstaclesAleatoirement() {
        for (int groupe = 0; groupe < 5; groupe++) {
            Random r = new Random();
            int x = r.nextInt(2, _carte.length - 4);
            int y = r.nextInt(2, _carte[0].length-3);

            for (int i = 0; i < 5; i++) {
                ajouterObstacle(x, y);

                int direction = (int) (Math.random() * 4);
                switch (direction) {
                    case 0:
                        if (x > 2) x--;
                        break;
                    case 1:
                        if (x < _carte.length - 4) x++;
                        break;
                    case 2:
                        if (y > 2) y--;
                        break;
                    case 3:
                        if (y < _carte[0].length - 1) y++;
                        break;
                }
            }
        }
    }

    private void setObstacles() {
        for (int[] coord : _positions.getObstacles()) {
            int x = coord[0];
            int y = coord[1];
            if (y == _carte[0].length - 1) {
                _carte[x][y] = supportJeu.FOND_BLANC + "   " + supportJeu.REINITIALISER + " |";
            } else {
                _carte[x][y] = supportJeu.FOND_BLANC + "   " + supportJeu.REINITIALISER;
            }
        }
    }
    private void setEntites() {
        _positions.getPositionEntite().forEach((entite, coordonnee) -> {
            int x = coordonnee[0];
            int y = coordonnee[1];
            if (y == _carte[0].length - 1) {
                _carte[x][y] = entite.getCouleur() + entite.getPseudo() + supportJeu.REINITIALISER + " |";
            } else {
                _carte[x][y] = entite.getCouleur() + entite.getPseudo() + supportJeu.REINITIALISER;
            }

        });
    }
    private void setEquipements() {
        _positions.getPositionEquipement().forEach((equipement, coordonnees) -> {
            int x = coordonnees[0];
            int y = coordonnees[1];
            _carte[x][y] = supportJeu.BlEU + "[⌘]" + supportJeu.REINITIALISER;
        });
    }

    public void MajCarte() {
        setObstacles();
        setEntites();
        setEquipements();
        affichageGrille();
    }

    private void affichageGrille() {
        for (String[] strings : _carte) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
        Affichage.affichage( supportJeu.FOND_BLANC + "   " + supportJeu.REINITIALISER + " : Obstacles ||" + supportJeu.BlEU + " [@]" + supportJeu.REINITIALISER + " : Equipements || " + supportJeu.VIOLET + " [*]" + supportJeu.REINITIALISER + " : Entites ||" + supportJeu.ROUGE + " [#]" + supportJeu.REINITIALISER + " : Monstres");
    }

    public void attaquer(Entite personnageQuiAttaque, String pos) {
        int[] position = parsePosition(pos);
        int x = position[0];
        int y = position[1];

        Entite cible = getEntiteSurCase(x, y);
        if (cible == null) {
            Affichage.afficherErreur("Aucune entité à cette position.");
            return;
        }

        if (!personnageQuiAttaque.peutAttaquer(cible)) {
            Affichage.afficherErreur("Tu ne peux pas attaquer cette entité.");
            return;
        }

        if (_positions.distanceEntre(personnageQuiAttaque, position) > personnageQuiAttaque.getArmeEquipee().getPortee()) {
            Affichage.afficherErreur("Tu es trop loin de " + cible.getNom() + " pour l'attaquer.");
            return;
        }
        int lancerAttaque = supportJeu.lancer(1, 20);
        Affichage.affichage("Tu as fait " + lancerAttaque);
        if (personnageQuiAttaque.getArmeEquipee().getPortee() == 1) {
            lancerAttaque += personnageQuiAttaque.getCaracteristiques().getForce();
            Affichage.affichage("Ton attaque est " + lancerAttaque + " (Bonus de force appliqué [+"+ personnageQuiAttaque.getCaracteristiques().getForce() +"])");
        } else {
            lancerAttaque += personnageQuiAttaque.getCaracteristiques().getDexterite();
            Affichage.affichage("Ton lancer d'attaque est " + lancerAttaque + " (Bonus de dextérité appliqué [+"+ personnageQuiAttaque.getCaracteristiques().getDexterite() +"])");
        }

        if (lancerAttaque > cible.getClasseArmure()){
            Affichage.affichage("Tu as touché " + cible.getNom() + "!");
            int degats = personnageQuiAttaque.getArmeEquipee().degat();
            Affichage.affichage("Tu as infligé " + degats + " dégats !");
            cible.retirerPV(degats);
            if (!cible.isVivant()) {
                Affichage.affichage(cible.getNom() + " a été vaincu!");
                cible.setPV(0);
                _positions.retirerEntite(cible);
                _carte[x][y] = " . ";
                return;
            }
            Affichage.affichage(cible.getNom() + " a " + cible.getPV() + " PV restants.");
        } else {
            Affichage.afficherErreur("Tu as raté " + cible.getNom() + "!");
        }



    }
    public void equiper(Entite entite) {
        if (entite.isJoueur()){
            Affichage.affichage("Choisis un objet à équiper : ");
            String inventaire = entite.afficherInventaire();
            if (inventaire.equals("Ton inventaire est vide.")) {
                Affichage.afficherErreur("Tu n'as pas d'objet à équiper.");
                return;
            }
            Affichage.affichage(inventaire);
            int choix = scanner.nextInt();
            while (choix < 0 || choix >= entite.getInventaire().size()) {
                Affichage.afficherErreur("Choix invalide. Veuillez choisir un nombre valide.");
                choix = scanner.nextInt();
            }
            Equipement equipement = entite.getInventaire().get(choix);
            if (equipement.isArmure()) {
                entite.equiperArmure(equipement);
                Affichage.affichage("Tu as équipé " + equipement.getNom() + ".");
            } else if (equipement.isArme()) {
                entite.equiperArme(equipement);
                Affichage.affichage("Tu as équipé " + equipement.getNom() + ".");
            }
        }
    }
    public void deplacement(Entite entite, String pos) {
        int[] position = parsePosition(pos);
        int x = position[0];
        int y = position[1];

        if (!isPositionValide(x, y)) {
            Affichage.afficherErreur("Position invalide. Veuillez entrer une nouvelle position : ");
            return;
        }

        if (getEntiteSurCase(x, y) != null) {
            Affichage.afficherErreur("Une entité occupe déjà cette position.");
            return;
        }
        if (_positions.distanceEntre(entite, position) > entite.getCaracteristiques().getVitesse()/3) {
            Affichage.afficherErreur("Trop loin.");
            return;
        }
        deplacerEntite(entite, x, y);
        Affichage.affichage(entite.getPseudo() + "s'est déplacé à " + pos + ".");
    }
    public void ramasser(Entite entite, String pos) {
    }

    public void deplacerEntite(Entite entite, int x, int y) {
        if (isPositionValide(x, y)) {
            int[] anciennePosition = _positions.getPositionEntite().get(entite);
            if (anciennePosition != null) {
                _positions.getPositionEntite().remove(entite);
                _positions.ajouterEntite(entite, new int[]{x, y});
                _carte[anciennePosition[0]][anciennePosition[1]] = " . ";
            }
        } else {
            Affichage.afficherErreur("Position invalide pour ce déplacement.");
        }
    }

    public int getNumeroDonjon(){
        return _nombre;
    }

    public Entite getEntiteSurCase(int x, int y) {
        for (Map.Entry<Entite, int[]> entry : _positions.getPositionEntite().entrySet()) {
            int[] position = entry.getValue();
            if (position[0] == x && position[1] == y) {
                return entry.getKey();
            }
        }
        return null;
    }

    public Positions getPositions() {
        return _positions;
    }

    public int getNumero() {
        return _nombre;
    }
}

