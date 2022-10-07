package consoCarbone;


public class Logement extends ConsoCarbone {
    public int superficie;
    public CE ce;
    
    public Logement(int s,CE ce) {
    	this.superficie = s;
    	this.ce = ce;
    }

	@Override public void setImpact() {
		this.impact = this.ce.getCoeff() * this.superficie;
	}
	

	public static void empCarbMoy() {
		String unite = "kg CO2eq/an";
		System.out.printf("Energie et utilites : 1 696 %s\n", unite);
		System.out.printf("Construction & gros entretien : 675 %s\n", unite);
		System.out.printf("Equipement des logements : 335 %s\n", unite);
	}
	
	public String toString() {
		   return "Votre impact de logement est de : " + getImpact();
	   }
	
}



