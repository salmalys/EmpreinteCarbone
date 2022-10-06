package consoCarbone;
import java.util.HashMap;
import java.util.Map;

public class Logement extends ConsoCarbone {
    public int superficie;
    public CE ce;
    public double impact;

    public Logement(int s,CE ce) {
    	this.superficie = s;
    	this.ce = ce;
    }

	public void setImpact() {
		Map <CE, Double> dict = new HashMap<>();
		dict.put(CE.A,0.005);
		dict.put(CE.B,0.01);
		dict.put(CE.C,0.02);
		dict.put(CE.D,0.035);
		dict.put(CE.E,0.055);
		dict.put(CE.F,0.08);
		dict.put(CE.G,0.1);
		this.impact = dict.get(this.ce) * this.superficie;
	}
	
	public double getImpact() {
		return this.impact;
	}
	
	public static void empCarbMoy() {
		String unite = "kg CO2eq/an";
		System.out.printf("Energie et utilites : 1 696 %s\n", unite);
		System.out.printf("Construction & gros entretien : 675 %s\n", unite);
		System.out.printf("Equipement des logements : 335 %s\n", unite);
	}
	
}



