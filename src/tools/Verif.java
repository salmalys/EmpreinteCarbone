package tools;
import java.util.Arrays;


public class Verif {
	
	public static boolean testReponses(String[][] reponses) {
		
		for(int i = 0; i < Questionnaire.NOM_POSTE.length; i ++) {
			for (int j = 0; j < Questionnaire.QUESTION[i].length; j++) {
				
				//test sur la superficie et le montant
				if ((i == 0 & j == 0) || (i == 2 & j == 1)) {
				       if (testNumericPositif(reponses[i][j]) == false) {
				    	   System.out.printf("\nLa valeur saisie %s a la question %d du poste %s n'est pas correcte", reponses[i][j], j+1, Questionnaire.NOM_POSTE[i]);
				    	   return false;}
				}
				
				//test sur la classe energetique
				if (i == 0 & j == 1){
				       if (testCe(reponses[i][j]) == false) {
				    	   System.out.printf("\nLa valeur saisie %s a la question %d du poste %s n'est pas correcte", reponses[i][j], j+1, Questionnaire.NOM_POSTE[i]);
				    	   return false;}
				}
				
				//test sur les taux des repas 
				if ((i == 1 & j == 0) || (i == 1 & j == 1)) {
				       if (testTaux(reponses[i][j]) == false) {
				    	   System.out.printf("\nLa valeur saisie %s a la question %d du poste %s n'est pas correcte", reponses[i][j], j+1, Questionnaire.NOM_POSTE[i]);
				    	   return false;}
				}
				
			}
		}
		return true;
}
	
	public static boolean testCe(String str) {
		String[] values = {"A", "B", "C", "D", "E", "F"};
		
		if (Arrays.asList(values).contains(str)) 
			return true;
		
		return false;		
	}
	
	public static boolean testNumericPositif(String str) {
		Integer intValue = 0;
		try {
			intValue = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		if (intValue < 0) {
			return false;
		}
		return true;	
	}
	
	public static boolean testTaux(String str) {
		Double val = 0.;
		try {
			val = Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return false;
		}
		if (!(0 <= val && val <= 1)) {
			return false;
		}
		return true;
	}
}
