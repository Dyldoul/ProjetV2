package com.dylan.oc;

import java.util.Random;

public class Ordinateur extends Regle{

    Random random = new Random();//Création de la variable aléatoire
    private int nombreOrdi;

    //Getters & Setters

    public int getNombreOrdi() {
        return nombreOrdi;
    }

    public void setNombreOrdi(int nombreOrdi) {
        this.nombreOrdi = nombreOrdi;
    }

    //Constructeur


    public Ordinateur(int nombreDeChiffre, int nombreEssai) {
        super(nombreDeChiffre, nombreEssai);

        String strNombreOrdi = "";//String pour rassembler tout les chiffre aléatoire

        for (int i = 0; i < nombreDeChiffre; i++){//On ne dépasse pas la param utilisateur

            int c = random.nextInt(9);

            strNombreOrdi += c;//Ajoute 1 par 1 les chiffre aléatoire a la String

        }

        nombreOrdi = Integer.parseInt(strNombreOrdi);//Convertit la String en Integer

    }
}
