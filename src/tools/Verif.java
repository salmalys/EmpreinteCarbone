package tools;
import java.util.Arrays;

/**
 * Classe contenant les methodes pour verifier chaque arguments des postes de consommmation
 */

public class Verif {
	
	/**
	 * Verifie si str est bien une classe energetique
	 * @param str
	 * @return boolean pour savoir si le test est reussi ou non
	 */
	public static boolean testCe(String str) {
		String[] values = {"A", "B", "C", "D", "E", "F","G"};
		
		if (Arrays.asList(values).contains(str)) 
			return true;
		
		return false;		
	}
	/**
	 * Verifie si str est une bien dans l'une des deux tailles
	 * @param str
	 * @return boolean pour savoir si le test est reussi ou non
	 */
	
	public static boolean testTaille(String str) {
		String[] values = {"P", "G"};
		
		if (Arrays.asList(values).contains(str)) 
			return true;
		
		return false;		
	}
	
	/**
	 * Verifie si str est bien un entier positif
	 * @param str
	 * @return boolean pour savoir si le test est reussi ou non
	 */
	
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
	/**
	 * Verifie si str est un taux, donc inclut entre 0 et 1
	 * @param str
	 * @return boolean pour savoir si le test est reussi ou non
	 */
	
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
