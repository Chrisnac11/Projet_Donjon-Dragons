package Entités.Monstres;

import Entités.Caractéristiques.CaracteristiquesMonstre;

public class Monstre {
    private int id;
    private String espece;
    private CaracteristiquesMonstre caracteristiques;

    public Monstre(int id, String espece, CaracteristiquesMonstre caracteristiques) {
        this.id = id;
        this.espece = espece;
        this.caracteristiques = caracteristiques;
    }

    public int getId() {
        return id;
    }

    public String getEspece() {
        return espece;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public CaracteristiquesMonstre getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(CaracteristiquesMonstre caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public void attaquer() {
        // à faire
    }

    @Override
    public String toString() {
        return "Monstre{" +
                "id=" + id +
                ", espece='" + espece + '\'' +
                ", caracteristiques=" + caracteristiques +
                '}';
    }
}