package com.dylan.oc.CodeGame;

public class ModeDefenseur extends CodeGame {


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

    //Constructeur


    public ModeDefenseur() {
    }

    public ModeDefenseur(int codeSecret, int testCode) {
        this.codeSecret = codeSecret;
        this.testCode = testCode;
    }

    //Méthodes

    public void nouveauTestCode(String indicationUser){

        String strTestCode = Integer.toString(testCode);//Transforme le nombre en String
        int nouveauChiffre;
        String strNouveauCode = "";
        String[] tableauChiffre = new String[getNombreDeChiffre()];

        for (int i = 0; i < strTestCode.length(); i++) {//Boucle pour traité tout les caractère de la String

            String caracIndicUser = indicationUser.substring(i,i+1);
            String chiffreTest = strTestCode.substring(i,i+1);

            int chfrTest = Integer.parseInt(chiffreTest);

            if (caracIndicUser.equals("+")){

                nouveauChiffre = random.nextInt(9-chfrTest)+chfrTest;//le chiffre testé devient le minimum a rechercher
                String strNouveauChiffre = Integer.toString(nouveauChiffre);
                tableauChiffre[i] = strNouveauChiffre;
                strNouveauCode += tableauChiffre[i];

            } else if (caracIndicUser.equals("-")){

                nouveauChiffre = random.nextInt(chfrTest-1);//le chiffre testé devient le maximum a rechercher
                String strNouveauChiffre = Integer.toString(nouveauChiffre);
                tableauChiffre[i] = strNouveauChiffre;
                strNouveauCode += tableauChiffre[i];

            } else if (caracIndicUser.equals("=")){

                nouveauChiffre = chfrTest;
                String strNouveauChiffre = Integer.toString(nouveauChiffre);
                tableauChiffre[i] = strNouveauChiffre;
                strNouveauCode += tableauChiffre[i];

            }

        }

        testCode = Integer.parseInt(strNouveauCode);

    }
}
