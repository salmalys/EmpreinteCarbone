package consocarbone;

public class BienConso extends ConsoCarbone {
   private double montant;
   
   public BienConso() {}
   
   public BienConso(double montant) {this.montant = montant;}
   
   @Override 
   public double getImpact() {
   	this.impact = this.montant / 1750;
   	return this.impact;
   }
   
   public double getMontant() {
	return montant;
   }

   public void setMontant(double montant) {
	this.montant = montant;
   }
   
   
   /**
    * affiche l'empreinte carbonne moyenne d'un francais vis a vis de son alimentation
    */
   public static void empCarbMoy() {
	    ConsoCarbone.empCarbMoy();
	   
	    String unite = "kg CO2eq/an";
		System.out.printf("Achat et usages Internet et technologies : 1 180 %s\n", unite);
		System.out.printf("Autres biens et services : 682 %s\n", unite);
		System.out.printf("Habillement : 763 %s\n", unite);
	}	   
   
   public String toString() {
	   return "\n\nL'impact de vos depenses annuelles est de : " + Math.round(this.impact*100.0)/100.0 + " TCO2eq\n";
   }
   
   @Override
   public Object clone() {
		try {
			BienConso b = (BienConso) super.clone();
			return b;
		}
		catch (CloneNotSupportedException e){
			throw new InternalError();
		}
   }
   
}
