package com.dylan.oc;

public class ModeDefenseur extends CodeGame {


    private int codeSecret;//Le nombre a trouvé
    private int testCode;//Un test de code secret
    private String indication;//Indication de l'utilisateur


    //Constructeur


    public ModeDefenseur(int codeSecret, int testCode, String indication) {
        this.codeSecret = codeSecret;
        this.testCode = testCode;
        this.indication = indication;
    }

    //Méthodes

    public void check(){

        String strCodeSecret = Integer.toString(codeSecret);//Transforme le nombre secret en String
        String strTestCode = Integer.toString(testCode);//Transforme le nombre saisie en String

        for (int i = 0; i < strCodeSecret.length(); i++) {//Boucle pour traité tout les caractère de la String

            String chiffreTest = strTestCode.substring(i);//Prend 1 par 1 les caractère de la chaine strNbrUser


        }

    }
}
