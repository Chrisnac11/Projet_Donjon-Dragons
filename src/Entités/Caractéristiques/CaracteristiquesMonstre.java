package Entités.Caractéristiques;

public class CaracteristiquesMonstre {
    private int classeArmure;
    private String attaque;

    public CaracteristiquesMonstre(int classeArmure, String attaque) {
        this.classeArmure = classeArmure;
        this.attaque = attaque;
    }

    public int getClasseArmure() {
        return classeArmure;
    }

    public void setClasseArmure(int classeArmure) {
        this.classeArmure = classeArmure;
    }

    public String getAttaque() {
        return attaque;
    }

    public void setAttaque(String attaque) {
        this.attaque = attaque;
    }

    @Override
    public String toString() {
        return "CaractéristiqueMonstre{" +
                "classeArmure=" + classeArmure +
                ", attaque='" + attaque + '\'' +
                '}';
    }
}