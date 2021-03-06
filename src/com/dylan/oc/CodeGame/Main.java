package com.dylan.oc.CodeGame;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.Scanner;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        DOMConfigurator.configure("src/com/dylan/oc/Ressource/log4j2.xml");

        logger.info("Début du jeu");

        Joueur joueur1 = new Joueur();

        Scanner scan = new Scanner(System.in);
        int choixMenu; //Variable de navigation dans le menu
        char modeDev;//Variable pour acitvé le mode développeur
        int exit; // Variable pour quitter un jeu ou non a la fin
        String strNombreJoueur;//Pour controle de la saisie utilisateur
        CodeGame jeu = new CodeGame();

            do {//Menu du jeu

                logger.info("Menu du jeu");
                System.out.println("Que voulez-vous faire ?");
                System.out.println("1 - Jouer");
                System.out.println("2 - Paramétrer");
                System.out.println("5 - Quitter");
                System.out.println("---------------------------------------------------");
                choixMenu = scan.nextInt();
                logger.debug("choixMenu = "+choixMenu);

                    switch (choixMenu) {

                        case 1://Menu des mode de jeux

                            logger.info("Choix mode de jeux");

                            System.out.println("A quel mode voulez-vous jouer ?");
                            System.out.println("1 - Mode Challenger (Vous devez trouver le code secret)");
                            System.out.println("2 - Mode Défenseur (L'ordinateur doit trouver le code secret)");
                            System.out.println("3 - Mode Duel (Le premier qui trouve le code secret de l'autre a gagné)");
                            System.out.println("---------------------------------------------------");
                            choixMenu = scan.nextInt();
                            logger.debug("choixMenu = "+choixMenu);
                            int nbrEssaie;//Nombre d'essais possible

                            switch (choixMenu) {//Choix du mode

                                case 1:// Lancement du jeu Challenger

                                    logger.info("Mode Challenger Activé");


                                    do {//Boucle pour recommencer le jeu
                                        nbrEssaie = jeu.getNombreEssai();
                                        System.out.println("Mode Challenger Activé");
                                        jeu.nombreAleatoire();//L'ordinateur choisi un nombre aléatoire
                                        System.out.println();
                                        System.out.println("CODE SECRET ACTIVE");
                                        System.out.println("Serez-vous assez fort pour le trouver ?");

                                        do {//Boucle tans que l'on a pas trouvé le code secret

                                            if (jeu.isModeDeveloppeur()) {
                                                System.out.println("Le code secret est : " + jeu.getNombreOrdi());
                                            }
                                            System.out.println();
                                            System.out.println("Il vous reste " + nbrEssaie + " essais");
                                            System.out.println("Veuillez entrer un nombre a " + jeu.getNombreDeChiffre() + " chiffres");
                                            System.out.println("--------------------------------------------------");
                                            joueur1.checkNombreJoueur(scan.nextInt());
                                            strNombreJoueur = Integer.toString(joueur1.getNombreJoueur());//Pour le controle de la saisie

                                            if (strNombreJoueur.length() == jeu.getNombreDeChiffre()) {//Si nombre ok

                                                logger.info("Nombre de chiffre OK");
                                                ModeChallenger challenger1 = new ModeChallenger(jeu.getNombreOrdi(), joueur1.getNombreJoueur());
                                                challenger1.check();
                                                nbrEssaie--;
                                                System.out.println();

                                            } else if (strNombreJoueur.length() < jeu.getNombreDeChiffre()) {//Si nombre trop petit

                                                logger.debug("Nombre de chiffre donnée trop petit");
                                                System.out.println();
                                                System.out.println("Vous avez entrer un nombre trop petit");
                                                System.out.println();

                                            } else if (strNombreJoueur.length() > jeu.getNombreDeChiffre()) {//Si nombre trop grand

                                                logger.debug("Nombre de chiffre donnée trop grand");
                                                System.out.println();
                                                System.out.println("Vous avez entrer un nombre trop grand");
                                                System.out.println();

                                            }


                                        }
                                        while (joueur1.getNombreJoueur() != jeu.getNombreOrdi() && nbrEssaie >= 0);//Condition de sortie du jeu

                                        if (nbrEssaie < 0) {

                                            logger.info("Vous avez perdu");
                                            System.out.println();
                                            System.out.println("Vous avez perdu ! Vous n'avez pas trouvé le code secret a temps !");
                                            System.out.println("Le code secret étais : " + jeu.getNombreOrdi());
                                            System.out.println();

                                        } else {

                                            logger.info("Vous avez gagner");
                                            System.out.println();
                                            System.out.println("Félicitation vous avez trouvé le code secret !");
                                            System.out.println();
                                        }
                                        System.out.println();
                                        System.out.println("Voulez-vous recommencer ? 1-Oui / 2-Non");
                                        exit = scan.nextInt();
                                        logger.info("exit = " + exit);

                                    } while (exit != 2 && exit == 1); //Recommencer ou non le jeu


                                    System.out.println();

                                    break;

                                case 2://Lancement du jeu Défenseur

                                    logger.info("Mode Défenseur Activé");

                                    do {//Boucle pour recommencer le jeu

                                        nbrEssaie = jeu.getNombreEssai();
                                        System.out.println("Mode Défenseur activé");
                                        jeu.nombreAleatoire();
                                        System.out.println();

                                        do {//Boucle de vérifiaction de la taille du code secret de l'utilisateur

                                            System.out.println("Veuillez entrer votre code secret à " + jeu.getNombreDeChiffre() + " chiffres :");
                                            System.out.println("--------------------------------------------------");
                                            joueur1.checkNombreJoueur(scan.nextInt());
                                            strNombreJoueur = Integer.toString(joueur1.getNombreJoueur());
                                            ModeDefenseur defenseur1 = new ModeDefenseur(joueur1.getNombreJoueur(), jeu.getNombreOrdi());

                                            if (strNombreJoueur.length() == jeu.getNombreDeChiffre()) {

                                                do {//Boucle tans que l'ordinateur n'a pas trouvé le code secret de l'utilisateur

                                                    System.out.println();
                                                    System.out.println("Il reste " + nbrEssaie + " essais");
                                                    System.out.println("Votre code secret est : " + defenseur1.getCodeSecret());
                                                    System.out.println("L'ordinateur propose : " + defenseur1.getTestCode());
                                                    System.out.println("Donner lui une indication (+ - =)");
                                                    System.out.println("--------------------------------------------------");
                                                    scan.nextLine();
                                                    joueur1.setIndicationJoueur(scan.nextLine());
                                                    defenseur1.nouveauTestCode(joueur1.getIndicationJoueur());
                                                    nbrEssaie--;


                                                }
                                                while (defenseur1.getCodeSecret() != defenseur1.getTestCode() && nbrEssaie >= 0);

                                            } else if (strNombreJoueur.length() < jeu.getNombreDeChiffre()) {//Si nombre trop petit

                                                logger.debug("Nombre de chiffre donnée trop petit");
                                                System.out.println();
                                                System.out.println("Vous avez entrer un nombre trop petit");
                                                System.out.println();

                                            } else if (strNombreJoueur.length() > jeu.getNombreDeChiffre()) {//Si nombre trop grand

                                                logger.debug("Nombre de chiffre donnée trop grand");
                                                System.out.println();
                                                System.out.println("Vous avez entrer un nombre trop grand");
                                                System.out.println();

                                            }


                                        } while (strNombreJoueur.length() != jeu.getNombreDeChiffre());


                                        if (nbrEssaie < 0) {

                                            logger.info("Vous avez gagner");
                                            System.out.println();
                                            System.out.println("Félicitation l'ordinateur n'a pas réussi a trouver votre code secret !");
                                            System.out.println();

                                        } else {

                                            logger.info("Vous avez perdu");
                                            System.out.println();
                                            System.out.println("Malheureusement l'ordinateur a trouvé votre code secret");
                                            System.out.println();

                                        }

                                        System.out.println();
                                        System.out.println("Voulez-vous recommencer ? 1-Oui / 2-Non");
                                        exit = scan.nextInt();
                                        logger.info("exit = " + exit);

                                    } while (exit != 2 && exit == 1); //Recommencer ou non le jeu

                                    System.out.println();

                                    break;

                                case 3: //Lancement du mode Duel

                                    logger.info("Mode Duel Activé");

                                    do {//Boucle pour recommencer le jeu

                                        nbrEssaie = jeu.getNombreEssai();
                                        System.out.println("Mode Duel activé");
                                        System.out.println();
                                        ModeDefenseur defenseur1 = new ModeDefenseur();
                                        ModeChallenger challenger1 = new ModeChallenger();
                                        System.out.println("Jouer a tour de rôle ! Le premier a trouver le code secret de l'autre a gagner !");
                                        System.out.println("Vous jouer en premier !");
                                        jeu.nombreAleatoire();
                                        challenger1.setCodeSecret(jeu.getNombreOrdi());//Le nombre aléatoire deviens le code secret de l'ordinateur

                                        do {
                                            System.out.println("Veuillez entrer votre code secret à " + jeu.getNombreDeChiffre() + " chiffres :");
                                            System.out.println("--------------------------------------------------");
                                            joueur1.checkNombreJoueur(scan.nextInt());
                                            strNombreJoueur = Integer.toString(joueur1.getNombreJoueur());//Pour le controle de la saisie

                                            if (strNombreJoueur.length() < jeu.getNombreDeChiffre()) {//Si nombre entré trop petit

                                                logger.debug("Nombre de chiffre donnée trop petit");
                                                System.out.println();
                                                System.out.println("Vous avez entrer un nombre trop petit");
                                                System.out.println();

                                            } else if (strNombreJoueur.length() > jeu.getNombreDeChiffre()) {//Si nombre entré trop grand

                                                logger.debug("Nombre de chiffre donnée trop petit");
                                                System.out.println();
                                                System.out.println("Vous avez entrer un nombre trop grand");
                                                System.out.println();
                                            }

                                        } while (strNombreJoueur.length() != jeu.getNombreDeChiffre());//Jusqu'a la saisie correct

                                        defenseur1.setCodeSecret(joueur1.getNombreJoueur());//Le nombre saisie deviens le code secret du joueur
                                        jeu.nombreAleatoire();
                                        defenseur1.setTestCode(jeu.getNombreOrdi());//L'ordinateur teste un autre nombre aléatoire

                                        do { //Boucle tans que l'ordi ou l'utilisateur n'a pas trouver la solution

                                            System.out.println();
                                            System.out.println("Il reste " + nbrEssaie + " essais");
                                            System.out.println("Trouver le code secret de votre adversaire !");
                                            if (jeu.isModeDeveloppeur()) {
                                                System.out.println("Le nombre secret est : " + jeu.getNombreOrdi());
                                            }
                                            System.out.println("Veuillez entrer un nombre a " + jeu.getNombreDeChiffre() + " chiffres");
                                            System.out.println("--------------------------------------------------");

                                            if (strNombreJoueur.length() < jeu.getNombreDeChiffre()) {//Si nombre trop petit

                                                logger.debug("Nombre de chiffre donnée trop petit");
                                                System.out.println();
                                                System.out.println("Vous avez entrer un nombre trop petit");
                                                System.out.println("Veuillez en entrer un autre  à "+jeu.getNombreDeChiffre()+" chiffres");
                                                System.out.println();

                                            } else if (strNombreJoueur.length() > jeu.getNombreDeChiffre()) {//Si nombre trop grand

                                                logger.debug("Nombre de chiffre donnée trop grand");
                                                System.out.println();
                                                System.out.println("Vous avez entrer un nombre trop grand");
                                                System.out.println("Veuillez en entrer un autre  à "+jeu.getNombreDeChiffre()+" chiffres");
                                                System.out.println();

                                            } else if (strNombreJoueur.length() == jeu.getNombreDeChiffre()) {
                                                joueur1.checkNombreJoueur(scan.nextInt());
                                                challenger1.setTestCode(joueur1.getNombreJoueur());
                                                challenger1.check();
                                                System.out.println();
                                                System.out.println("--------------------------------------------------");
                                                System.out.println();
                                                System.out.println("L'ordinateur essaye de touver votre code !");
                                                System.out.println("Votre code secret est : " + defenseur1.getCodeSecret());
                                                System.out.println("L'ordinateur propose : " + defenseur1.getTestCode());
                                                System.out.println("Donner lui une indication (+ - =)");
                                                System.out.println("--------------------------------------------------");
                                                scan.nextLine();
                                                joueur1.setIndicationJoueur(scan.nextLine());
                                                defenseur1.nouveauTestCode(joueur1.getIndicationJoueur());
                                                nbrEssaie--;
                                                System.out.println();

                                            }

                                        } while (defenseur1.getCodeSecret() != defenseur1.getTestCode() && challenger1.getCodeSecret() != challenger1.getTestCode() && nbrEssaie >= 0);

                                        if (nbrEssaie < 0) {

                                            logger.info("Match Nul");
                                            System.out.println();
                                            System.out.println("Match nul ! Personne n'a trouvé le nombre secret de l'autre !");
                                            System.out.println();

                                        } else if (challenger1.getTestCode() == challenger1.getCodeSecret()) {

                                            logger.info("Vous avez gagner");
                                            System.out.println();
                                            System.out.println("Félicitation ! Vous avez trouvé le code secret de votre adversaire ^^");
                                            System.out.println();

                                        } else if (defenseur1.getCodeSecret() == defenseur1.getTestCode()) {

                                            logger.info("Vous avez perdu");
                                            System.out.println();
                                            System.out.println("L'ordinateur propose : " + defenseur1.getTestCode());
                                            System.out.println("Malheureusement l'ordinateur a trouvé votre code secret en premier ...");
                                            System.out.println();

                                        }

                                        System.out.println();
                                        System.out.println("Voulez-vous recommencer ? 1-Oui / 2-Non");
                                        exit = scan.nextInt();
                                        logger.info("exit = " + exit);

                                    } while (exit != 2 && exit == 1); //Recommencer ou non le jeu

                                    System.out.println();

                                break;


                            }//Fin du switch du mode

                        break;

                        case 2: //Paramétrer le jeu

                            logger.info("Parametre du jeu");

                            do {

                                System.out.println("Que voulez vous paramétrer ?");
                                System.out.println("1 - Nombre de chiffre a trouver");
                                System.out.println("2 - Nombre d'essais");
                                System.out.println("3 - Mode Développeur");
                                System.out.println("4 - Retour");
                                System.out.println("--------------------------------------------------");
                                choixMenu = scan.nextInt();
                                logger.debug("choixMenu = " + choixMenu);

                                switch (choixMenu){

                                    case 1 :

                                        logger.info("Paramètre nombre de chiffre");
                                        System.out.println();
                                        int nombreChiffre;
                                        System.out.println("Combien de chiffres voulez vous trouver ?");
                                        nombreChiffre = scan.nextInt();
                                        jeu.paramNbrChiffre(nombreChiffre);
                                        System.out.println();
                                        System.out.println("Vous allez chercher un nombre a "+jeu.getNombreDeChiffre()+" chiffres");
                                        logger.debug("nombreChiffre = "+nombreChiffre);
                                        System.out.println();
                                        break;

                                    case 2 :

                                        logger.info("Paramètre nombre d'essais");
                                        System.out.println();
                                        int nombreEssais;
                                        System.out.println("Combien d'essais voudriez vous ?");
                                        nombreEssais = scan.nextInt();
                                        jeu.paramNbrEssais(nombreEssais);
                                        System.out.println();
                                        System.out.println("Vous avez maintenant "+jeu.getNombreEssai()+" essais pour trouver le code secret !");
                                        logger.debug("nombreEssais ="+nombreEssais);
                                        System.out.println();
                                        break;

                                    case 3 :

                                        logger.info("Parametre Mode Developpeur");
                                        System.out.println();
                                        if (jeu.isModeDeveloppeur()) {
                                            System.out.println("Le mode développeur est actif !");
                                        } else {
                                            System.out.println("Le mode développeur est inactif !");
                                        }
                                        System.out.println();
                                        System.out.println("Voulez-vous activé le mode développeur ? o/n");
                                        scan.nextLine();
                                        String str = scan.nextLine();
                                        modeDev = str.charAt(0);
                                        logger.debug("modeDev = " + modeDev);
                                        if (modeDev == 'o'){

                                            jeu.modeDevActive();
                                            System.out.println("Le mode développeur est maintenant activé !");

                                        } else if (modeDev == 'n'){

                                            jeu.modeDevOff();
                                            System.out.println("Le mode développeur est maintenant desactivé !");

                                        }
                                 }

                                System.out.println();

                            } while (choixMenu != 4);//Sortir menu paramètre

                            break;

                    }//Fin du switch du menu jeu

            } while (choixMenu != 5);//Sortir du menu du jeu

        System.out.println();
        System.out.println("Au revoir ^^");

    }//Fin du switch du menu de départ

}
