package consoCarbone;

public class Main {

	public static void main(String[] args) {
		Logement l = new Logement(1200,CE.C);
		l.setImpact();
		System.out.println(l.getImpact());
		Logement.empCarbMoy();
		
		Alimentation a = new Alimentation(0.2,0.1);
		a.setImpact();
		System.out.println(a.getImpact());
		Alimentation.empCarbMoy();
		


	}

}
