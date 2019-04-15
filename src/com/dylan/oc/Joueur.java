package com.dylan.oc;

public class Joueur{

    private String nom;
    private int nombreJoueur;


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


    //Constructeurs

    public Joueur(String nom) {

        this.nom = nom;

    }


}
