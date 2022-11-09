package consocarbone;
//si ca marche pas je meurs

public class Alimentation extends ConsoCarbone{
    public double txBoeuf;
    public double txVege;
    
    final double c1 =8;
    final double c2 =1.6;
    final double c3 =.9;
    
    public Alimentation (double tB, double tV) {
    	this.txBoeuf = tB;
    	this.txVege = tV; 
    }
    
    @Override public double getImpact() {
    	this.impact = c1 * this.txBoeuf + c2 * (1 - this.txVege - this.txBoeuf)+ c3 * this.txVege;
    	return this.impact;
    }
    
   
   public static void empCarbMoy() {
	    ConsoCarbone.empCarbMoy();
	   
	    String unite = "kg CO2eq/an";
		System.out.printf("Viandes et Poissons : 1 144 %s\n", unite);
		System.out.printf("Produits laitiers et oeufs : 408 %s\n", unite);
		System.out.printf("Autres : 538 %s\n", unite);
		System.out.printf("Boissons : 263 %s\n", unite);
	}	   
   
   public String toString() {
	   return "\n\nL'impact de votre alimentation est de : " + Math.round(getImpact()*100.0)/100.0 + " TCO2eq\n";
   }
   
   
   
}
