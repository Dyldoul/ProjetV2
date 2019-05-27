package com.dylan.oc.CodeGame;

import java.util.Random;

public class CodeGame {

    Random random = new Random();//Création de la variable aléatoire

    private int nombreOrdi;//Nombre de l'ordinateur
    private int nombreDeChiffre = 4;//Nombre de chiffre composant le nombre secret par défault
    private int nombreEssai = 10;//Nombre d'éssais par défault
    private boolean modeDeveloppeur = false;//Activation mode développeur

    //Getters & Setters

    public boolean isModeDeveloppeur() {
        return modeDeveloppeur;
    }

    public int getNombreOrdi() {
        return nombreOrdi;
    }

    public int getNombreEssai() {
        return nombreEssai;
    }

    public void setNombreEssai(int nombreEssai) {
        this.nombreEssai = nombreEssai;
    }

    public int getNombreDeChiffre() {
        return nombreDeChiffre;
    }

    //Constructeur

    public CodeGame() {



    }

    //Méthodes

    /**
     * Active le mode Développeur
     */
    public void modeDevActive(){
        modeDeveloppeur = true;
    }


    /**
     * Désactive le mode Developpeur
     */
    public void modeDevOff(){ modeDeveloppeur = false; }

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

    public void nombreAleatoire(){

        String strNombreOrdi = "";//String pour rassembler tout les chiffre aléatoire
        int[] tabNombreOrdi =new int[getNombreDeChiffre()];

        for (int i = 0; i < nombreDeChiffre; i++){//On ne dépasse pas la param utilisateur

            int chiffre = random.nextInt(9);
            tabNombreOrdi[i] += chiffre;//Met le chiffre dans un tableau

            strNombreOrdi += tabNombreOrdi[i];//Ajoute 1 par 1 les chiffre aléatoire a la String

        }

        nombreOrdi = Integer.parseInt(strNombreOrdi);//Convertit la String en Integer

    }

}
