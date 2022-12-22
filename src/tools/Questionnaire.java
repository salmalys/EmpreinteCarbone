package tools;

import java.util.*;
import consocarbone.*;
import java.util.ArrayList;

/**
 * gere l'affichage des questions sur la console et alimente la liste des postes a partir des reponses
 *
 */

public class Questionnaire {

	/**
	 * Tableau comprenant le nom des postes 
	 */

	static final String[] NOM_POSTE = {"Logement", "Alimentation", "BienConso","Mail","Transport"};

	/**
	 * Question sur le poste logement
	 */

	static final String[] QST_LOGEMENT = {"Combien de logement avez vous ?","Quelle est la superficie de votre appartement en m^2?","Quelle est la classe energetique ?"};

	/**
	 *  Question sur le poste alimentaire
	 */

	static final String[] QST_ALIMENTATION = {"Quel est votre taux de repas a base de boeuf ?", "Quel est votre taux de repas vegetariens ?"};

	/**
	 *  Question sur le poste bien consommateur
	 */

	static final String[] QST_BIENCONSO = {"Quel est le montant de vos depenses annuelles en euros ?"};

	/**
	 *  Question sur le poste de mail
	 */

	static final String[] QST_MAIL = {"Combien avez vous de mail envoyes depuis un an?", "Combien avez vous de mails recus depuis un an?"};

	/**
	 *  Question sur le poste transport
	 */

	static final String[] QST_TRANSPORT = {"Combien de voiture avez vous ?","Quelle est la taille de votre voiture?","Quel est vos nombre de kilometre a l'annee ?","Quelle est la duree de conservation de votre vehicule ?"};

	/**
	 * Tableau comprenant toutes les questions
	 */
	static final String[][] QUESTION = {QST_LOGEMENT, QST_ALIMENTATION, QST_BIENCONSO,QST_MAIL, QST_TRANSPORT};

	/**
	 * Nombre d'attributs pour chaque poste
	 */
	static final int[] nbAtt = {2,2,1,2,3};

	/**
	 * Lance le questionnaire pour chaque poste et alimente la liste des postes a partir des reponses 
	 * @param sc reponse insctire sur la console par l'utilisateur
	 * @return la liste des postes
	 */

	public static ArrayList<ConsoCarbone> commencer(Scanner sc) {
		ArrayList<ConsoCarbone> listPostes = new ArrayList<ConsoCarbone>();

		for (int i = 0 ; i< NOM_POSTE.length ; i++) {
			System.out.println("\nPoste "+ NOM_POSTE[i]);
			String[] line = questionPoste(sc,NOM_POSTE[i],QUESTION[i],nbAtt[i]);
			Traitement.readConso(line,listPostes);
		}
		System.out.println("Fin du questionnaire\n");

		sc.close();
		return listPostes;
	}

	/**
	 * Affiche les questions du poste et stocke les reponses dans un tableau 
	 * @param nomPoste pour lequel on a besoin de reponse
	 * @param qPoste dans le tableau Question
	 * @param nbAtt nombre de reponses que l'on va avoir
	 * @return toutes les reponses aux questions de l'utilisateur en fonction du poste entree en parametre
	 */

	public static String[] questionPoste(Scanner sc, String nomPoste, String[] qPoste, int nbAtt) {
		String[] line = null;
		if((nomPoste == "Logement")||(nomPoste == "Transport")){
			System.out.println(qPoste[0]);
			String nbPosteVal = sc.nextLine();
			int nbPoste = Integer.parseInt(nbPosteVal);

			line = new String[2+nbPoste*nbAtt];

			line[0] = nomPoste;
			line[1] = nbPosteVal;

			int cpt = 2;
			for(int j = 0; j<nbPoste; j++) {
				System.out.println("\n"+nomPoste+" "+(j+1));
				for(int q = 1; q<qPoste.length; q++) {
					System.out.println(qPoste[q]);
					line[cpt] = sc.nextLine();
					cpt++;
				}
			}

		}
		else {
			line = new String[1+nbAtt];
			line[0] = nomPoste;
			int cpt = 1;
			for(int q = 0; q<qPoste.length; q++) {
				System.out.println(qPoste[q]);
				line[cpt] = sc.nextLine();
				cpt++;
			}
		}



		return line;
	}


}
