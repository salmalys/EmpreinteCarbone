package tools;
import java.util.Arrays;

/**
 * Classe contenant les methodes pour verifier que chaque arguments des postes de consommmation sont appropries
 */

public class Verif {

	/**
	 * Verifie si str est bien une classe energetique
	 * @param str : String a verifier
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
	 * @param str : String a verifier
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
	 *@throw les valeurs non entieres
	 * @param str : String a verifier
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
	 * @throw les valeurs de type autre que double
	 * @param str : String a verifier
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
