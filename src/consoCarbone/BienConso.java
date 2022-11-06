package consoCarbone;

public class BienConso extends ConsoCarbone {
   public double montant;
   public double impact;
   
   public BienConso(double montant) {
	   this.montant = montant;
   }
   
   @Override public double getImpact() {
   	this.impact = this.montant / 1750;
   	return this.impact;
   }
   
   public static void empCarbMoy() {
	    String unite = "kg CO2eq/an";
		System.out.printf("Achat et usages Internet et technologies : 1 180 %s\n", unite);
		System.out.printf("Autres biens et services : 682 %s\n", unite);
		System.out.printf("Habillement : 763 %s\n", unite);
	}	   
   
   public String toString() {
	   return "Votre impact de bienConso est de : " + getImpact();
   }
}
