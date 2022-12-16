package tools;

import java.util.*;

public class Questionnaire {
	
	static final String[] NOM_POSTE = {"Logement", "LogementBis", "Alimentation", "BienConso","Transport", "TransportBis"};
	
	static final String[] QST_LOGEMENT1 = {"Combien de logement avez vous"}
	static final String[] QST_LOGEMENT2 ={"Quelle est la superficie de votre appartement en m^2?", "Quelle est la classe energetique ?"};
	static final String[] QST_ALIMENTATION = {"Quel est votre taux de repas a base de boeuf ?", "Quel est votre taux de repas vegetariens ?"};
	static final String[] QST_BIENCONSO = {"Quel est le montant de vos depenses annuelles en euros ?"};
	static final String[] QST_TRANSPORT1 = {"Combien de voiture avez vous ?"};
	static final String[] QST_TRANSPORT2 = {"Quelle est la taille de votre voiture?", "Quel est vos nombre de kilometre a l'annee ?", "Quelle est la duree de conservation de votre vehicule ?"};
	
	static final String[][] QUESTION = {QST_LOGEMENT1,QST_LOGEMENT2, QST_ALIMENTATION, QST_BIENCONSO, QST_TRANSPORT1, QST_TRANSPORT2};
	
	
	public static String[][] commencer() {
		
		String[][] reponses = new String[3][3];
		
        Scanner sc = new Scanner(System.in);
		
        for (int i = 0 ; i< NOM_POSTE.length ; i++) {
        	System.out.println("\nPoste de consommation: " + NOM_POSTE[i]);
        	
        	for (int j = 0; j< QUESTION[i].length; j++) {  //pour ne pas poser les quetions si il n'a pas de voiture 
			if ((i ==4)& (QUESTION[i][j] == 0){
				reponses[i][j] == null;
			}
			else {
        		System.out.printf("Q%d: %s", j+1, QUESTION[i][j]);
        		reponses[i][j] = sc.nextLine();
			    }
        	}
        }
		sc.close();
		
		return reponses;
	}


}
