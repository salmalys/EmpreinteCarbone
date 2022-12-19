package tools;
import java.util.Arrays;


public class Verif {
	
	public static boolean testCe(String str) {
		String[] values = {"A", "B", "C", "D", "E", "F","G"};
		
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
