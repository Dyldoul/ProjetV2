package com.dylan.oc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Joueur joueur1 = new Joueur("Dylan");

        Scanner scan = new Scanner(System.in);
        int choixMenu; //Variable de navigation dans le menu
        char exit; // Variable pour quitter un jeu ou non a la fin

        do { // Menu de Départ
            System.out.println("Bienvenue "+joueur1.getNom()+" !");
            System.out.println("1 - Code secret");
            System.out.println("2 - Quitter");
            System.out.println("---------------------------------------------------");
            choixMenu = scan.nextInt();

            switch (choixMenu) {

                case 1:
                    CodeGame jeu = new CodeGame();
                    do {//Menu du jeu

                        System.out.println();
                        System.out.println("Que voulez-vous faire ?");
                        System.out.println("1 - Jouer");
                        System.out.println("2 - Paramétrer");
                        System.out.println("3- Retour");
                        System.out.println("---------------------------------------------------");
                        choixMenu = scan.nextInt();

                        switch (choixMenu) {

                            case 1://Menu des mode de jeux

                                System.out.println("A quel mode voulez-vous jouer ?");
                                System.out.println("1 - Mode Challenger (Vous devez trouver le nombre secret)");
                                System.out.println("2 - Mode Défenseur (vous devez définir le code secret)");
                                System.out.println("3 - Mode Duel (le premier qui trouve le nombre secret de l'autre a gagné)");
                                System.out.println("---------------------------------------------------");
                                choixMenu = scan.nextInt();

                                switch (choixMenu) {//Choix du mode

                                    case 1:// Lancement du jeu Challenger

                                        do {
                                            System.out.println("Mode Challenger Activé");
                                            jeu.nombreAlea();
                                            System.out.println();
                                            System.out.println("NOMBRE SECRET ACTIVE");
                                            System.out.println("Serez-vous assez fort pour le trouver ?");

                                            do {//Boucle tans que l'on a pas trouvé le nombre secret

                                                System.out.println();
                                                System.out.println("Il vous reste "+jeu.getNombreEssai()+" essais");
                                                System.out.println("Veuillez entrer un nombre a " + jeu.getNombreDeChiffre() + " chiffres");
                                                System.out.println("--------------------------------------------------");
                                                joueur1.setNombreJoueur(scan.nextInt());
                                                ModeChallenger challenger1 = new ModeChallenger(jeu.getNombreOrdi(),joueur1.getNombreJoueur());
                                                challenger1.check();
                                                jeu.setNombreEssai(jeu.getNombreEssai()-1);
                                                System.out.println();



                                            } while (joueur1.getNombreJoueur() != jeu.getNombreOrdi() && jeu.getNombreEssai() >= 0);//Condition de sortie du jeu

                                            if (jeu.getNombreEssai() < 0) {

                                                System.out.println();
                                                System.out.println("Vous avez perdu ! Vous n'avez pas trouvé le code secret a temps !");

                                            } else {
                                                System.out.println();
                                                System.out.println("Félicitation vous avez trouvé le nombre secret !");
                                            }
                                            System.out.println();
                                            System.out.println("Voulez-vous recommencer ? O/N");
                                            scan.nextLine();
                                            String str = scan.nextLine();
                                            exit = str.charAt(0);

                                        } while (exit != 'N' && exit == 'O'); //Recommencer ou non le jeu

                                        System.out.println();

                                        break;

                                    case 2://Lancement du jeu Défenseur

                                        System.out.println("Mode Défenseur activé");
                                        System.out.println();
                                        System.out.println("Veuillez entrer votre code secret à "+jeu.getNombreDeChiffre()+" chiffres :");


                                        break;

                                    case 3://Lancement du jeu Duel

                                        System.out.println("Mode Duel activé");
                                        System.out.println();

                                        break;

                                }//Fin du switch du mode

                                break;

                            case 2: //Paramétrer le jeu

                                do {

                                    System.out.println("Que voulez vous paramétrer ?");
                                    System.out.println("1 - Nombre de chiffre a trouver");
                                    System.out.println("2 - Nombre d'essais");
                                    System.out.println("5 - Retour");
                                    System.out.println("--------------------------------------------------");
                                    choixMenu = scan.nextInt();

                                    switch (choixMenu){

                                        case 1 :

                                            int nombreChiffre;
                                            System.out.println("Combien de chiffre voulez vous trouver ?");
                                            nombreChiffre = scan.nextInt();
                                            jeu.paramNbrChiffre(nombreChiffre);
                                            System.out.println();
                                            System.out.println("Vous allez chercher un nombre a "+jeu.getNombreDeChiffre()+" chiffre");
                                            System.out.println();
                                            break;

                                        case 2 :

                                            int nombreEssais;
                                            System.out.println("Combien d'essais voudriez vous ?");
                                            nombreEssais = scan.nextInt();
                                            jeu.paramNbrEssais(nombreEssais);
                                            System.out.println();
                                            System.out.println("Vous avez maintenant "+jeu.getNombreEssai()+" essais pour trouver le code secret !");
                                            System.out.println();
                                            break;

                                    }

                                    System.out.println();

                                } while (choixMenu != 5);//Sortir menu paramètre

                                break;


                        }//Fin du switch du menu jeu

                    } while (choixMenu != 3);//Sortir du menu du jeu CodeGame

            }//Fin du switch du menu de départ

        } while (choixMenu != 2);//Sortir du menu de départ

        System.out.println("Au revoir ^^");

    }
}