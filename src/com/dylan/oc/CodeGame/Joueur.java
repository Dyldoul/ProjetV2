package com.dylan.oc.CodeGame;

public class Joueur{

    private int nombreJoueur;
    private String indicationJoueur;


    //Getters & Setters



    public int getNombreJoueur() {
        return nombreJoueur;
    }

    public String getIndicationJoueur() {
        return indicationJoueur;
    }

    public void setIndicationJoueur(String indicationJoueur) {
        this.indicationJoueur = indicationJoueur;
    }

    //Constructeurs

    public Joueur() {

    }

    //Méthodes

    /**
     * Permet de pouvoir prendre en compte un zéro saisie en chiffre 1 et de définir le nombreJoueur
     * @param nombreSaisie Le nombre saisie par le joueur
     */
    public void checkNombreJoueur(int nombreSaisie){

        String strNombreSaisie = Integer.toString(nombreSaisie); //Le nombre saisie devient une String
        String[] tabNombreSaisie = new String[100];
        String strNombreJoueur ="";

        for (int i = 0; i < strNombreSaisie.length(); i++){

            String strUnNombreSaisie = strNombreSaisie.substring(i,i+1);
            tabNombreSaisie[i] = strUnNombreSaisie;
            strNombreJoueur += tabNombreSaisie[i];
        }

        nombreJoueur = Integer.parseInt(strNombreJoueur);//Le nombre saisie devient le nombre joueur

    }

}
