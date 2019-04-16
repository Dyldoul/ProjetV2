package com.dylan.oc;

public class ModeDefenseur extends CodeGame {


    private int codeSecret;//Le nombre a trouvé
    private int testCode;//Un test de code secret
    private int codePrecedent;//Le code tester précédement

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

    public void setCodePrecedent(int codePrecedent) {
        this.codePrecedent = codePrecedent;
    }

    //Constructeur


    public ModeDefenseur(int codeSecret, int testCode) {
        this.codeSecret = codeSecret;
        this.testCode = testCode;
    }

    //Méthodes

    public void nouveauTestCode(String indicationUser){

        String strTestCode = Integer.toString(testCode);//Transforme le nombre en String
        int nouveauChiffre;
        String strNouveauCode = "";

        for (int i = 0; i < strTestCode.length(); i++) {//Boucle pour traité tout les caractère de la String

            String caracIndicUser = indicationUser.substring(i);
            String chiffreTest = strTestCode.substring(i);

            int chfrTest = Integer.parseInt(chiffreTest);

            if (caracIndicUser == "+"){

                nouveauChiffre = random.nextInt(9-chfrTest)+chfrTest;
                //nouveauChiffre = random.nextInt(chfrTest-1);
                String strNouveauChiffre = Integer.toString(nouveauChiffre);
                strNouveauCode += strNouveauChiffre;

            } else if (caracIndicUser == "-"){

                nouveauChiffre = random.nextInt(chfrTest-1);
                //nouveauChiffre = random.nextInt(9-chfrTest)+chfrTest;
                String strNouveauChiffre = Integer.toString(nouveauChiffre);
                strNouveauCode += strNouveauChiffre;

            } else if (caracIndicUser == "="){

                nouveauChiffre = chfrTest;
                String strNouveauChiffre = Integer.toString(nouveauChiffre);
                strNouveauCode += strNouveauChiffre;

            }

            //String strNouveauChiffre = Integer.toString(nouveauChiffre);
            //strNouveauCode += strNouveauChiffre;

        }

        testCode = Integer.parseInt(strNouveauCode);

    }
}
