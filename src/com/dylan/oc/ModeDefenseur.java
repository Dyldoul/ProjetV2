package com.dylan.oc;

public class ModeDefenseur extends CodeGame {


    private int codeSecret;//Le nombre a trouvé
    private int testCode;//Un test de code secret
    private String codePrecedent;//Le code tester précédement

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

    public void setCodePrecedent(String codePrecedent) {
        this.codePrecedent = codePrecedent;
    }


    //Constructeur


    public ModeDefenseur(int codeSecret, int testCode) {
        this.codeSecret = codeSecret;
        this.testCode = testCode;
    }

    //Méthodes

    public void check(String indicationUser){

        String strTestCode = Integer.toString(testCode);//Transforme le nombre saisie en String

        for (int i = 0; i < strTestCode.length(); i++) {//Boucle pour traité tout les caractère de la String

            String chiffreTest = strTestCode.substring(i);//Prend 1 par 1 les caractère de la chaine strNbrUser




        }

    }
}
