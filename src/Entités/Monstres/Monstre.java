package Entités.Monstres;

import Entités.Caractéristiques.CaractéristiquesMonstre;

public class Monstre {
    private int id;
    private String espece;
    private CaractéristiquesMonstre caracteristiques;

    public Monstre(int id, String espece, CaractéristiquesMonstre caracteristiques) {
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

    public CaractéristiquesMonstre getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(CaractéristiquesMonstre caracteristiques) {
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