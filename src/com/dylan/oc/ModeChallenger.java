package com.dylan.oc;

public class ModeChallenger extends CodeGame{


    private int codeSecret;//Le nombre a trouvé
    private int testCode;//Un test de code secret


    //Constructeur

    public ModeChallenger(int codeSecret, int testCode) {
        this.codeSecret = codeSecret;
        this.testCode = testCode;
    }

    //Méthodes


    /**
     * Compare le nombre saisie avec le nombre caché
     * @param reponseUtilisateur Nombre saisie par l'utilisateur
     */
    public void checkOrdi(int reponseUtilisateur, CodeGame jeu1){

        String strCodeSecret = Integer.toString(codeSecret);//Transforme le nombre secret en String
        String strNbrUser = Integer.toString(reponseUtilisateur);//Transforme le nombre saisie en String
        String strIndication = "";//Initialisation de la ligne d'indication

        for (int i = 0; i < strCodeSecret.length(); i++){//Boucle pour traité tout les caractère de la String

            String chiffreSecret = strCodeSecret.substring(i);//Prend 1 par 1 les caractère de la chaine strNbrCache
            String chiffreUser = strNbrUser.substring(i);//Prend 1 par 1 les caractère de la chaine strNbrUser

            int chfrSec = Integer.parseInt(chiffreSecret);//Passe la String chiffreSecret en int
            int chfrUser = Integer.parseInt(chiffreUser);//Passe la String chiffreUser en int

            if ( chfrUser > chfrSec) {//Si réponse trop haute

                strIndication += "-";//Ajouter un -

            } else if ( chfrUser < chfrSec) {//Si réponse trop bas

                strIndication += "+";//Ajouter un +

            } else {//Si réponse OK

                strIndication += "=";//Ajouter un =

            }

        }

        System.out.println(strIndication);//Affiche la ligne composé de + - =

    }

}
