package com.dylan.oc;

public class Regle {

    private int nombreDeChiffre;//Nombre de chiffre composant le nombre secret
    private int nombreEssai;//Nombre d'éssais

    //Getters & Setters


    public int getNombreDeChiffre() {
        return nombreDeChiffre;
    }

    public void setNombreDeChiffre(int nombreDeChiffre) {
        this.nombreDeChiffre = nombreDeChiffre;
    }

    public int getNombreEssai() {
        return nombreEssai;
    }

    public void setNombreEssai(int nombreEssai) {
        this.nombreEssai = nombreEssai;
    }

    //Constructeur


    public Regle(int nombreDeChiffre, int nombreEssai) {
        this.nombreDeChiffre = nombreDeChiffre;
        this.nombreEssai = nombreEssai;
    }
}
