package tools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


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
	
	public static boolean testReponses(ArrayList<String> tab) {
		int i = 0;
		int nbLogement = 0;
		int nbTransport = 0;
		
		Iterator<String> l =  tab.iterator();
		while(l.hasNext()){
			//logement
			if (i == 0) {
				nbLogement = Integer.parseInt(l.next());
				for (int j = 0; j<nbLogement; j++) {
					if (testNumericPositif(l.next())&&(testCe(l.next()))) {}
					else return false;
					i += 2;
				}
			}
			//alimentation
			if(i == nbLogement*2 +1) {
				if (testTaux(l.next())&&(testTaux(l.next()))) {}
				else return false;
				i += 2;
			}
			if(i == nbLogement*2 +3) {
				if(testNumericPositif(l.next()));
				else return false;
				i++;
			}
			
			if(i == nbLogement*2 +4) {
				nbTransport = Integer.parseInt(l.next());
				for (int j = 0; j<nbTransport; j++) {
					if (testTaille(l.next())&&(testNumericPositif(l.next()))&&(testNumericPositif(l.next()))) {}
					else return false;
					i += 3;
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
	
	public static boolean testTaille(String str) {
		String[] values = {"P", "G"};
		
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
