
package jeu.support;
import jeu.MaitreDuJeu;
import jeu.Donjon;
import jeu.entites.Entite;

import static jeu.support.supportJeu.*;


public class Affichage {

    public static void affichage(String message) {
        System.out.println(message);
    }


    public static void afficherErreur(String message) {
        System.out.println(ROUGE + message + REINITIALISER);
    }

    public static void succesAffichage(String message) {
        System.out.println(VERT + message + REINITIALISER);
    }

    public static void AfficherInfo(MaitreDuJeu maitreDuJeu) {
        System.out.println("********************************************************************************");
        System.out.println("Donjon : "+ maitreDuJeu.getNbDonjon());
       ;
        System.out.println(maitreDuJeu.getEntiteCourrante().toString());
        System.out.println("********************************************************************************");


        System.out.println("Tour " + maitreDuJeu.getTour() + " : ");
        for (Entite entite : maitreDuJeu.getEntiteparInit()) {
            String prefixe = (entite == maitreDuJeu.getEntiteCourrante()) ? "-> " : "   ";
            System.out.println(prefixe + entite.getPseudo() + "   " + entite.toString() + " (" + entite.getPV() + "/" + entite.getMaxPV() + ")");
        }

    }

    public static void AfficherInfoEntite(Entite entiteCourrante) {
        System.out.println(entiteCourrante.toString());
        System.out.println(entiteCourrante.getInfo());
    }

    public static void AfficherCarte(Donjon donjon) {
        donjon.MajCarte();
    }

    public static void EffacerAffichage() {
        System.out.print("\n".repeat(50));
    }

    public static void AfficherMenuAction(Entite entiteCourrante, int actions) {
        System.out.println("-------------------------------");
        System.out.println(entiteCourrante.toString() + ", tu as encore" + actions + " actions pour ce tour.");
        System.out.println("Actions possible :");
        if (entiteCourrante.isMonstre()){
            System.out.println("  - Laissez le maître du jeu commenter l'action précédente (MJ <texte>)");
            System.out.println("  - Commente l'action précédente(com <texte>)");
            System.out.println("  - Attaque (att <position>)");
            System.out.println("  - Déplacement (deplacement <position>)");

        }else {
            System.out.println("  - Laissez le maître du jeu commenter l'action précédente (MJ <texte>)");
            System.out.println("  - Commente l'action précédente(com <texte>)");
            System.out.println("  - Attaque (att <position>)");
            System.out.println("  - Déplacement (deplacement <position>)");
            System.out.println("  - Voir l'inventaire pour équiper un objet (equ voir)");
            System.out.println("  - ramasser un objet (ramasser <numero objet>)");

        }
        System.out.println("-------------------------------");
    }
}
