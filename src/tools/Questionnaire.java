package tools;

import java.util.*;

public class Questionnaire {
	
	static final String[] NOM_POSTE = {"Logement", "Alimentation", "BienConso"};
	
	static final String[] QST_LOGEMENT = {"Quelle est la superficie de votre appartement en m^2?", "Quelle est la classe energetique ?"};
	static final String[] QST_ALIMENTATION = {"Quel est votre taux de repas a base de boeuf ?", "Quel est votre taux de repas vegetariens ?"};
	static final String[] QST_BIENCONSO = {"Quel est le montant de vos depenses annuelles en euros ?"};
	
	static final String[][] QUESTION = {QST_LOGEMENT, QST_ALIMENTATION, QST_BIENCONSO};
	
	
	public static String[][] commencer() {
		
		String[][] reponses = new String[3][3];
		
        Scanner sc = new Scanner(System.in);
		
        for (int i = 0 ; i< NOM_POSTE.length ; i++) {
        	System.out.println("\nPoste de consommation: " + NOM_POSTE[i]);
        	
        	for (int j = 0; j< QUESTION[i].length; j++) {
        		System.out.printf("Q%d: %s", j+1, QUESTION[i][j]);
        		reponses[i][j] = sc.nextLine();
        	}
        }
		sc.close();
		
		return reponses;
	}


}
