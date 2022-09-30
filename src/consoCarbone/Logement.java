package consoCarbone;
import java.util.HashMap;
import java.util.Map;
//TO_DOOS
public class Logement extends ConsoCarbone {
    public int superficie;
    private CE ce;
    private double impactL;

    public Logement(int s,CE ce) {
    	this.superficie = s;
    	this.ce = ce;
    }

	public void setImpactL() {
		Map <CE, Double> dict = new HashMap<>();
		dict.put(CE.A,0.005);
		dict.put(CE.B,0.01);
		dict.put(CE.C,0.02);
		dict.put(CE.D,0.035);
		dict.put(CE.E,0.055);
		dict.put(CE.F,0.08);
		dict.put(CE.G,0.1);
		this.impactL = dict.get(this.ce) * this.superficie;
	}
	
	public double getImpactL() {
		return this.impactL;
	}
	
	public static void cabMoyLogement() {
		System.out.println ("Energie et utilites = 1 696 ");
		System.out.println ("Construction & gros entretien = 675 ");
		System.out.println ("Equipement des logements = 335");
	}
	
	public static void main(String args[]) {
		Logement l = new Logement(1200,CE.C);
		l.setImpactL();
		System.out.println(l.getImpactL());
		cabMoyLogement();
	
}
}



