package com.dylan.oc.CodeGame;

public class Joueur{

    private String nom;
    private int nombreJoueur;
    private String indicationJoueur;


    //Getters & Setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombreJoueur() {
        return nombreJoueur;
    }

    public void setNombreJoueur(int nombreJoueur) {
        this.nombreJoueur = nombreJoueur;
    }

    public String getIndicationJoueur() {
        return indicationJoueur;
    }

    public void setIndicationJoueur(String indicationJoueur) {
        this.indicationJoueur = indicationJoueur;
    }

    //Constructeurs

    public Joueur(String nom) {

        this.nom = nom;

    }


}
