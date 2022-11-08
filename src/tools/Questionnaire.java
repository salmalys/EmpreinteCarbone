package tools;

import java.util.*;

public class Questionnaire {
	
	static final String[] NOM_POSTE = {"Logement", "Alimentation", "BienConso", "Transport"};
	
	static final String[] QST_LOGEMENT = {"Quelle est la superficie de votre appartement ?", "Quelle est la classe energetique ?"};
	static final String[] QST_ALIMENTATION = {"Quel est votre taux de repas a base de boeuf ?", "Quel est votre taux de repas vegetariens ?"};
	static final String[] QST_BIENCONSO = {"Quel est le montant de vos depenses annuelles ?"};
	
	static final String[][] QUESTION = {QST_LOGEMENT, QST_ALIMENTATION, QST_BIENCONSO};
	
	
	public static String[][] commencer() {
		
		String[][] reponses = new String[10][10];
		
        Scanner sc = new Scanner(System.in);
		
        for (int i = 0 ; i< NOM_POSTE.length ; i++) {
        	System.out.println("\nPoste de consommation: " + NOM_POSTE[i]);
        	
        	for (int j = 0; j< QUESTION[i].length; j++) {
        		System.out.printf("Q%d: %s", j+1, QUESTION[i][j]);
        		reponses[i][j] = sc.nextLine();
        	}
        	
        }
        System.out.println("\n");
		sc.close();
		
		return reponses;
	}


}
