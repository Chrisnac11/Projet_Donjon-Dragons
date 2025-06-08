package jeu;

import jeu.entites.*;
import jeu.entites.races.*;
import jeu.entites.classes.*;

import jeu.entites.Personnage;
import jeu.objets.*;
import jeu.support.Affichage;
import jeu.support.ListeEquipement;
import jeu.support.supportJeu;

import static jeu.support.supportJeu.parsePosition;
import static jeu.support.supportJeu.scanner;


import java.util.*;

    public class MaitreDuJeu {
        private Donjon _donjon;
        private List<Entite> _EntiteparInit;
        private List<Equipement> _listeEquipement;
        private ListeEquipement _infoobjet;
        private Entite _entiteCourrante;
        private int _tour;
        private boolean _conditionVictoire;

    public MaitreDuJeu() {
        _EntiteparInit = new ArrayList<>();
        _listeEquipement = new ArrayList<>();
        _infoobjet = new ListeEquipement();
        _conditionVictoire = false;
    }

    public void creerPersonnages(){
        Affichage.affichage("Combien de Joueur ? (1-4) : ");
        int nbPlayers = scanner.nextInt();
        while (nbPlayers < 1 || nbPlayers > 4) {
            Affichage.afficherErreur("Nombre de joueur invalide, Choisissez un nombre entre 1 et 4 : ");
            nbPlayers = scanner.nextInt();
        }

        for (int i = 0; i < nbPlayers; i++) {
            Affichage.affichage("Joueur " + (i + 1) + ", entrez votre nom : ");
            String nom = scanner.next();

            Race RaceJoueur = null;
            while (RaceJoueur == null) {
                Affichage.affichage("Choisissez votre race (1-Nain, 2-Elfe, 3-Halfelin, 4-Humain) : ");
                int choixrace = scanner.nextInt();
                switch (choixrace) {
                    case 1 -> RaceJoueur = new Nain();
                    case 2 -> RaceJoueur = new Elfe();
                    case 3 -> RaceJoueur = new Halfelin();
                    case 4 -> RaceJoueur = new Humain();
                    default -> Affichage.afficherErreur("Choix invalide. Veuillez réessayer.");
                }
            }

            ClassePersonnage ClasseJoueur = null;
            while (ClasseJoueur == null) {
                Affichage.affichage("Choisissez votre classe (1-Clerc, 2-Roublard, 3-Guerrier, 4-Magicien) : ");
                int choixclasse = scanner.nextInt();
                switch (choixclasse) {
                    case 1 -> ClasseJoueur = new Clerc();
                    case 2 -> ClasseJoueur = new Roublard();
                    case 3 -> ClasseJoueur = new Guerrier();
                    case 4 -> ClasseJoueur = new Magicien();
                    default -> Affichage.afficherErreur("Choix invalide. Veuillez réessayer.");
                }
            }

            Personnage Joueur = new Personnage(nom, RaceJoueur, ClasseJoueur);
            _EntiteparInit.add(Joueur);
        }
    }
    public void CreerMonstres(){
        Scanner scanner = new Scanner(System.in);

        Affichage.affichage("MJ, Veux tu créer des monstres ? (Si ce n'est pas le cas, des monstres prédéfinis apparaitront) (O/N)");
        String choix = scanner.next();
        if (choix.equalsIgnoreCase("O")) {
            Affichage.affichage("Combien de monstres ? (1-4) : ");
            int nbMonstres = scanner.nextInt();
            Map<String, Integer> accMonstres = new HashMap<>();
            while (nbMonstres < 1 || nbMonstres > 4) {
                Affichage.afficherErreur("Nombres de monstres invalide, choisis un nombre entre 1 et 4 : ");
                nbMonstres = scanner.nextInt();
            }
            for (int i = 0; i < nbMonstres; i++) {
                Affichage.affichage("Entre la race du monstre : ");
                String espece = scanner.next();
                Affichage.affichage("Entre la classe d'armure du monstre : ");
                int ClasseArmure = scanner.nextInt();
                Affichage.affichage("Entre la portee d'attaque du monstre, nombre de dés, et leur valeurs (exemple, 1 2 6 pour 1 de portee et 2d6 dégat) : ");
                int portee = scanner.nextInt();
                int nbDes = scanner.nextInt();
                int jetdegat = scanner.nextInt();
                Arme arme;
                if (portee == 1) {
                    arme = new ArmeCaC("MonstreCac", portee, nbDes ,jetdegat);
                } else {
                    arme = new ArmeDistance("MonstreDistance", portee, nbDes, jetdegat);
                }
                int nb = accMonstres.getOrDefault(espece, 0) + 1;
                accMonstres.put(espece, nb);

                Monstre monstre = new Monstre(espece, nb, arme, ClasseArmure);
                _EntiteparInit.add(monstre);
            }
        }
        else {
            System.out.println("Application des monstres par défault");
            _EntiteparInit.add(new Monstre("squig", 1, new ArmeCaC("MonstreCac", 1, 1,6),10));
            _EntiteparInit.add(new Monstre("squig", 2, new ArmeCaC("MonstreCac", 1, 1,6),10));
            _EntiteparInit.add(new Monstre("Gretchin", 1, new ArmeDistance("MonstreDistance", 12, 1,4),10));
        }
    }
    public void creerEqupement(){
        Scanner scanner = new Scanner(System.in);
        Affichage.affichage("Combien d'objet ? (1-5) : ");
        int nbEquipment = scanner.nextInt();
        while (nbEquipment < 1 || nbEquipment > 5) {
            Affichage.afficherErreur("Nombre d'objets invalide, choisis un nombre entre 1 et 5 : ");
            nbEquipment = scanner.nextInt();
        }

        Affichage.affichage("Voici la liste des objets disponnibles : ");
        for (Equipement equipement : _infoobjet.getEquipments()) {
            int n = _infoobjet.getEquipments().indexOf(equipement);
            Affichage.affichage("(" + n + ")" + equipement.toString());
        }
        for (int i = 0; i < nbEquipment; i++) {
            Affichage.affichage("Entre le numero de l'equipement à ajouter: ");
            int equipment = scanner.nextInt();
            while (equipment < 0 || equipment > _infoobjet.getEquipments().size()) {
                Affichage.afficherErreur("Numero invalide, choisis un nombre entre 0 et " + (_infoobjet.getEquipments().size() - 1) + " : ");
                equipment = scanner.nextInt();
            }
            Equipement Equipementchoisie = _infoobjet.getEquipments().get(equipment);
            _listeEquipement.add(Equipementchoisie);
        }
    }
    public void creerDonjon(int nb) {
        Scanner scanner = new Scanner(System.in);

        Affichage.affichage("MJ, Entre la taille du Donjon ([L]argeur [H]auteur) : ");
        int largeur = scanner.nextInt();
        int hauteur = scanner.nextInt();
        while (largeur < 15 || largeur > 26 || hauteur < 15 || hauteur > 26) {
            Affichage.afficherErreur("La carte doit être entre 15 et 26 cases de large et de haut");
            Affichage.affichage("Entre la taille du Donjon ([L]argeur [H]auteur) : ");
            largeur = scanner.nextInt();
            hauteur = scanner.nextInt();
        }
        _donjon = new Donjon(largeur, hauteur, nb);
    }
    public void setDonjon() {
        _tour = 1;
        Map<Entite, Integer> initCarte = new HashMap<>();
        for (Entite entite : _EntiteparInit) {
            initCarte.put(entite, entite.getInitiative() + supportJeu.lancer(1, 20));
        }

        _EntiteparInit.sort((e1, e2) -> initCarte.get(e2) - initCarte.get(e1));
        Affichage.affichage("Voici la liste des joueurs et des monstres de la partie : ");
        for (Entite entite : _EntiteparInit) {
            Affichage.affichage(entite.toString());
        }

        Affichage.affichage("MJ, veux tu placer les entités manuellement ? (O/N)");
        String choix = scanner.next();
        if (choix.equalsIgnoreCase("O")) {
            for (Entite entite : _EntiteparInit) {
                Affichage.affichage("Entre la position de" + entite.toString() + " ([A-Z]x) : ");
                String position = scanner.next();
                int[] pos = parsePosition(position);
                int x = pos[0];
                int y = pos[1];
                while (!_donjon.isPositionValide(x, y)) {
                    Affichage.afficherErreur("Position invalide. Entre une nouvelle position : ");
                    position = scanner.next();
                    pos = parsePosition(position);
                    x = pos[0];
                    y = pos[1];
                }
                _donjon.ajouterEntite(x, y, entite);
            }
        }
        else {
            _donjon.setEntiteAleatoirement(_EntiteparInit);
        }

        Affichage.affichage("MJ, veux tu placer les objets manuellement ? (O/N)");
        choix = scanner.next();
        if (choix.equalsIgnoreCase("O")) {
            for (Equipement equipement : _listeEquipement) {
                Affichage.affichage("Enter the position of " + equipement + " ([A-Z]x) : ");
                String position = scanner.next();
                int[] pos = parsePosition(position);
                int x = pos[0];
                int y = pos[1];
                while (!_donjon.isPositionValide(x, y)) {
                    Affichage.afficherErreur("Position invalide. Entre une nouvelle position : ");
                    position = scanner.next();
                    pos = parsePosition(position);
                    x = pos[0];
                    y = pos[1];
                }
                _donjon.ajouterEquipement(x, y, equipement);
            }
        }
        else {
            _donjon.setEquipementAleatoirement(_listeEquipement);
        }

        Affichage.affichage("MJ, veux tu placer les obstacles manuellement ? (O/N)");
        choix = scanner.next();
        if (choix.equalsIgnoreCase("O")) {
            Affichage.affichage("Combien ?");
            int nbObstacles = scanner.nextInt();
            for (int i = 0; i < nbObstacles; i++) {
                Affichage.affichage("Entre la position de l'obstacle " + (i + 1) + " ([A-Z]x) : ");
                String position = scanner.next();
                int[] pos = parsePosition(position);
                int x = pos[0];
                int y = pos[1];
                while (!_donjon.isPositionValide(x, y)) {
                    Affichage.afficherErreur("Position invalide. Entre une nouvelle position : ");
                    position = scanner.next();
                    pos = parsePosition(position);
                    x = pos[0];
                    y = pos[1];
                }
                _donjon.ajouterObstacle(x, y);
            }
        }
        else {
            _donjon.setObstaclesAleatoirement();
        }
    }

    public void creerPartie() {
        Affichage.affichage("----Préparation de la partie----");
        creerPersonnages();
        CreerMonstres();
        creerEqupement();
        creerDonjon(1);
        setDonjon();
        Affichage.affichage("----Démarrage de la partie----");
    }

    private void DonjonSuivant(List<Entite> entiteparInit) {
        int nouveaNbDonjon = _donjon.getNumeroDonjon()+1;
        if (nouveaNbDonjon > 3) {
            return;
        }
        Affichage.affichage("Vous avez réussi à tuer tous les monstres de cette étage, Bravo !");
        Affichage.affichage("Soin des joueurs...");
        for (Entite entite : entiteparInit) {
            if (entite.isJoueur()) {
                entite.setPV(entite.getMaxPV()- entite.getPV());
            }
        }
        Affichage.affichage("Les joueurs sont dorénavant en pleine frome ^^");
        Affichage.affichage("Et maintenant....");
        Affichage.affichage("----Prochain étage !----");
        CreerMonstres();
        creerEqupement();
        creerDonjon(nouveaNbDonjon);
        setDonjon();
    }

    public void jouer() {
        while (!_conditionVictoire && _donjon.getNumeroDonjon() <= 3) {
            for (int indexEntiteCourrante = 0; indexEntiteCourrante < _EntiteparInit.size(); ) {
                _entiteCourrante = _EntiteparInit.get(indexEntiteCourrante);
                if (!_entiteCourrante.isVivant()) {
                    _EntiteparInit.remove(indexEntiteCourrante);
                    continue;
                }
                tour(indexEntiteCourrante);
                indexEntiteCourrante++;
            }
            _tour++;
            if (tousMonstresMorts() && _donjon.getNumeroDonjon() < 3) {
                DonjonSuivant(_EntiteparInit);
            } else if (tousMonstresMorts() && _donjon.getNumeroDonjon() == 3) {
                _conditionVictoire = true;
            }
            if (tousJoueursMorts()){
                Affichage.afficherErreur("Vous avez perdu la partie.");
                return;
            }
        }
        if (_conditionVictoire) {
            Affichage.succesAffichage("Bien jouer, vous avez gagnez !");
        }
    }

    public void tour(int NumEntiteCourrante){
        Affichage.AfficherInfo(this);
        _entiteCourrante = _EntiteparInit.get(NumEntiteCourrante);
        for (int action = 3 ; action > 0; action--) {
            Affichage.AfficherCarte(_donjon);
            Affichage.AfficherInfoEntite(_entiteCourrante);

            Affichage.AfficherMenuAction(_entiteCourrante, action);
            String choix = scanner.next();
            String choixaction = scanner.next();
            Affichage.affichage("Tu as choisie: " + choix + " " + choixaction);
            switch (choix) {
                case "att" -> _donjon.attaquer(_entiteCourrante, choixaction);
                case "equ" -> _donjon.equiper(_entiteCourrante);
                case "deplacement" -> _donjon.deplacement(_entiteCourrante, choixaction);
                case "ramasser" -> Affichage.affichage("pickup");
                case "com" -> Affichage.affichage(choixaction);
                case "MJ" -> Affichage.affichage(choixaction);
                default -> Affichage.afficherErreur("Choix invalide. Veuillez réessayer.");
            }

            Affichage.affichage("Appuyez sur n'importe quelle touche pour continuer...");
            scanner.nextLine();
            scanner.nextLine();
            _EntiteparInit.removeIf(entite -> entite.getPV() <= 0 && entite.isMonstre());

            if (tousMonstresMorts()){
                return;
            }
        }

        Affichage.EffacerAffichage();
    }

    private boolean tousJoueursMorts() {
        for (Entite entite : _EntiteparInit) {
            if (entite.isJoueur() && entite.getPV() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean tousMonstresMorts() {
        for (Entite entite : _EntiteparInit) {
            if (entite.isMonstre()) {
                return false;
            }
        }
        return true;
    }

    public List<Entite> getEntiteparInit() {
        return _EntiteparInit;
    }
    public int getTour(){
        return _tour;
    }
    public Entite getEntiteCourrante() {
        return _entiteCourrante;
    }
    public int getNbDonjon() {
        return _donjon.getNumeroDonjon();
    }

}
