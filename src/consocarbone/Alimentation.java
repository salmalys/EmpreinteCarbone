package consocarbone;

/**
 * Une Alimentation est un poste de consommation qui s'interesse a l'impact alimentaire
 *
 */
//setteurs sur txboeuf et txvege 

public class Alimentation extends ConsoCarbone{
	/**
	 * taux de repas a base de boeuf 
	 */
    public double txBoeuf;
    /**
     * taux de repas vegetariens
     */
    public double txVege;
    
    final double c1 =8;
    final double c2 =1.6;
    final double c3 =.9;
    
    /**
     * Constructeur de la classe
     * @param tB
     * @param tV
     */
    public Alimentation (double tB, double tV) {
    	this.txBoeuf = tB;
    	this.txVege = tV; 
    	//calcul impact ??
    }
    
    //fonction qui met a jour ??
    
    /**
     * obtient l'impact calcule a partir d'une formule
     * @return impact alimentaire
     */
    @Override public double getImpact() {
    	this.impact = c1 * this.txBoeuf + c2 * (1 - this.txVege - this.txBoeuf)+ c3 * this.txVege;
    	return this.impact;
    }
    
   /**
    * affiche l'empreinte carbonne moyenne alimenatire d'un francais
    * @see ConsoCarbone#empCarbMoy()
    */ 
   public static void empCarbMoy() {
	    ConsoCarbone.empCarbMoy();
	   
	    String unite = "kg CO2eq/an";
		System.out.printf("Viandes et Poissons : 1 144 %s\n", unite);
		System.out.printf("Produits laitiers et oeufs : 408 %s\n", unite);
		System.out.printf("Autres : 538 %s\n", unite);
		System.out.printf("Boissons : 263 %s\n", unite);
	}	   
   
   /**
    * affiche l'impact alimenataire de cet utilisateur
    * @see ConsoCarbone#toString()
    */
   @Override
   public String toString() {
	   return "\n\nL'impact de votre alimentation est de : " + Math.round(getImpact()*100.0)/100.0 + " TCO2eq\n";
   }
   
   
   
}
