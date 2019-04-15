package com.dylan.oc;

import java.util.Random;

public class CodeGame {

    Random random = new Random();//Création de la variable aléatoire

    private int nombreOrdi;//Nombre de l'ordinateur
    private int nombreDeChiffre = 4;//Nombre de chiffre composant le nombre secret par défault
    private int nombreEssai = 10;//Nombre d'éssais par défault

    //Getters & Setters

    public int getNombreOrdi() {
        return nombreOrdi;
    }

    public int getNombreEssai() {
        return nombreEssai;
    }

    public void setNombreEssai(int nombreEssai) {
        this.nombreEssai = nombreEssai;
    }

    //Constructeur

    public CodeGame() {



    }

    //Méthodes

    /**
     * Paramètre le nombre de chiffre a trouver
     * @param nombreUtilisateur Le nombre definit par l'utilisateur
     */
    public void paramNbrChiffre(int nombreUtilisateur) {

        this.nombreDeChiffre = nombreUtilisateur;


    }

    /**
     * Paramètre le nombre d'essais
     * @param essaiUtilisateur Nombre d'essais voulu
     */
    public void paramNbrEssais(int essaiUtilisateur){

        this.nombreEssai = essaiUtilisateur;

    }

    public void nombreAlea(){

        String strNombreOrdi = "";//String pour rassembler tout les chiffre aléatoire

        for (int i = 0; i < nombreDeChiffre; i++){//On ne dépasse pas la param utilisateur

            int c = random.nextInt(9);

            strNombreOrdi += c;//Ajoute 1 par 1 les chiffre aléatoire a la String

        }

        nombreOrdi = Integer.parseInt(strNombreOrdi);//Convertit la String en Integer

    }

}
