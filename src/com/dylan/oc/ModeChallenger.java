package com.dylan.oc;

public class ModeChallenger extends CodeGame{


    private int codeSecret;//Le nombre a trouvé
    private int testCode;//Un test de code secret


    //Getters & Setters

    public int getCodeSecret() {
        return codeSecret;
    }

    public void setCodeSecret(int codeSecret) {
        this.codeSecret = codeSecret;
    }

    public int getTestCode() {
        return testCode;
    }

    public void setTestCode(int testCode) {
        this.testCode = testCode;
    }


    //Constructeurs


    public ModeChallenger() {
    }

    public ModeChallenger(int codeSecret, int testCode) {
        this.codeSecret = codeSecret;
        this.testCode = testCode;
    }

    //Méthodes


    /**
     * Compare le nombre saisie avec le code secret
     */
    public void check(){

        String strCodeSecret = Integer.toString(codeSecret);//Transforme le nombre secret en String
        String strTestCode = Integer.toString(testCode);//Transforme le nombre saisie en String
        String strIndication = "";//Initialisation de la ligne d'indication

        for (int i = 0; i < strCodeSecret.length(); i++){//Boucle pour traité tout les caractère de la String

            String chiffreSecret = strCodeSecret.substring(i,i+1);//Prend 1 par 1 les caractère de la chaine strNbrCache
            String chiffreTest = strTestCode.substring(i,i+1);//Prend 1 par 1 les caractère de la chaine strNbrUser

            int chfrSec = Integer.parseInt(chiffreSecret);//Passe la String chiffreSecret en int
            int chfrTest = Integer.parseInt(chiffreTest);//Passe la String chiffreUser en int

            if ( chfrTest > chfrSec) {//Si réponse trop haute

                strIndication += "-";//Ajouter un -

            } else if ( chfrTest < chfrSec) {//Si réponse trop bas

                strIndication += "+";//Ajouter un +

            } else {//Si réponse OK

                strIndication += "=";//Ajouter un =

            }

        }

        System.out.println(strIndication);//Affiche la ligne composé de + - =

    }

}
