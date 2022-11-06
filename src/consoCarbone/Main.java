package consoCarbone;
import java.util.Scanner;

public class Main {
	
	public static CE testCe(String str) {
		switch(str) {
			case "A": return CE.A; 
			case "B": return CE.B; 
			case "C": return CE.C; 
			case "D": return CE.D; 
			case "E": return CE.E; 
			case "F": return CE.F; 
			default: System.out.println("La valeur saisie n'est pas une classe energetique"); System.exit(1); return null;
		}		
	}
	
	public static int testSuperficie(String str) {
		Integer intValue = 0;
		try {
			intValue = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			System.out.println("La valeur de superficie saisie n'est pas numerique");
			System.exit(1);
		}
		if (intValue < 0) {
			System.out.println("La valeur de superficie saisie n'est pas positive.");
			System.exit(1);
		}
		return intValue;	
	}
	
	public static double testMontant(String str) {
		Double val = 0.;
		try {
			val = Double.parseDouble(str);
		} catch (NumberFormatException e) {
			System.out.println("La valeur du montant saisie n'est pas numerique");
			System.exit(1);
		}
		if (val < 0) {
			System.out.println("La valeur du montant saisie n'est pas positive.");
			System.exit(1);
		}
		return val;	
	}
	
	public static double testTaux(String str) {
		Double val = 0.;
		try {
			val = Double.parseDouble(str);
		} catch (NumberFormatException e) {
			System.out.println("La valeur de superficie saisie n'est pas numerique");
			System.exit(1);
		}
		if (!(0 <= val && val <= 1)) {
			System.out.println("La valeur saisie n'est pas un taux.");
			System.exit(1);
		}
		return val;
	}
	
	public static void main(String[] args) {
		int superficie;
		CE ce;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Poste de consommation Logement:");
		System.out.println("Quelle est la superficie de votre appartement ?");
		
		String strSuperficie = sc.nextLine();
		
		System.out.println("Quelle est la classe energetique ?");
		String strCe = sc.nextLine();
		
		superficie = testSuperficie(strSuperficie);
		ce = testCe(strCe);
		
		
		Logement l = new Logement(superficie,ce);
		System.out.println(l.toString());
		Logement.empCarbMoy();
		
		
		double tVege, tBoeuf;
		
		System.out.println("Poste de consommation Alimentation:");
		
		System.out.println("Quel est le taux de repas a base de boeuf ?");
		String strTboeuf = sc.nextLine();
		
		System.out.println("Quel est le taux de repas vegetariens ?");
		String strTvege = sc.nextLine();
		
		tVege = testTaux(strTvege);
		tBoeuf = testTaux(strTboeuf);
		
		Alimentation a = new Alimentation(tBoeuf,tVege);
		System.out.println(a.getImpact());
		Alimentation.empCarbMoy();
		
		double montant;
		System.out.println("Poste de consommation BienConso:");
		
		System.out.println("Quel est votre montant des depenses annuelles ?");
		String strMontant = sc.nextLine();
		
		sc.close();
		
		montant = testMontant(strMontant);
		
		BienConso b = new BienConso(montant);
		System.out.println(b.getImpact());
		BienConso.empCarbMoy();
	}

}
