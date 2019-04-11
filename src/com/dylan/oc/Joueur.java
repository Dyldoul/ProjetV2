package com.dylan.oc;

public class Joueur extends Regle{

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

    public Joueur(int nombreDeChiffre, int nombreEssai, String nom, int nombreJoueur) {
        super(nombreDeChiffre, nombreEssai);
        this.nom = nom;
        this.nombreJoueur = nombreJoueur;
    }


}
