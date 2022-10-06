package consoCarbone;

public class Alimentation extends ConsoCarbone{
    public double txBoeuf;
    public double txVege;
    public double impact;
    
    final double c1 =8;
    final double c2 =1.6;
    final double c3 =.9;
    
    public Alimentation (double tB, double tV) {
    	this.txBoeuf = tB;
    	this.txVege = tV; 
    }
    
    public void setImpact() {
    	this.impact = c1 * this.txBoeuf + c2 * (1 - this.txVege - this.txBoeuf) + c3 * this.txVege;
    }
    
   public double getImpact() {
	   return this.impact;
   }
   
   public static void empCarbMoy() {
	    String unite = "kg CO2eq/an";
		System.out.printf("Viandes et Poissons : 1 144 %s\n", unite);
		System.out.printf("Produits laitiers et oeufs : 408 %s\n", unite);
		System.out.printf("Autres : 538 %s\n", unite);
		System.out.printf("Boissons : 263 %s\n", unite);
	}	   
   
}
