//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenue dans DOOnjon et Dragons");
        Race elfes = new Race("elfes");
        Classe roublards = new Classe("roublards");
        Caractéristiques stat = new Caractéristiques();
        Personnage bob = new Personnage("bob", elfes, roublards, stat);

        stat.AfficherStat();
    }
}
