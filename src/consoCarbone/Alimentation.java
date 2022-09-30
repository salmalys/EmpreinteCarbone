package consoCarbone;

public class Alimentation extends ConsoCarbone{
    public double txBoeuf;
    public double txVege;
    private double impactA;
    static double a=8;
    static double b=1.6;
    static double c=.9;
    
    public Alimentation (double tB, double tV) {
    	this.txBoeuf = tB;
    	this.txVege = tV;
 
    }
    
    public void setImpactA() {
    	this.impactA = a * this.txBoeuf + b * (1 - this.txVege - this.txBoeuf) + c * this.txVege;
    }
    
   public double getImpactA() {
	   return this.impactA;
   }
   
   public static void cabMoyAlimentation() {
		System.out.println("Viandes et Poissons = 1 144 ");
		System.out.println("Produits laitiers et oeufs = 408 ");
		System.out.println("Autres = 538");
		System.out.println("Boissons = 263");
	}
   
	
	public static void main(String args[]) {
		Alimentation a = new Alimentation(0.2,0.1);
		a.setImpactA();
		System.out.println(a.getImpactA());
		cabMoyAlimentation();
		
	}
	   
   
}
