package consoCarbone;

public class Transport extends ConsoCarbone {
   boolean possede;
   Taille taille;
   int kilomAnnee;
   int amortissement;
   
   public Transport(boolean possede) {
	   this.possede = possede;   
   }
   
   public Transport(boolean possede, Taille taille, int km, int amortissement) {
	   this.possede = possede;
	   this.taille = taille;
	   this.kilomAnnee = km;
	   this.amortissement = amortissement;
   }
   
   @Override public double getImpact(){
	   if (this.possede == false)  this.impact = 0;
	   else {
		   this.impact = this.kilomAnnee * 1.93 * Math.pow(10,-4) + this.taille.getConsVoit();
	   }
	   return this.impact;
   }
   
   public static void empCarbMoy() {
	    String unite = "kg CO2eq/an";
		System.out.printf("Voiture : 1 972 %s\n", unite);
		System.out.printf("Avion : 480 %s\n", unite);
		System.out.printf("Fret et messagerie : 383 %s\n", unite);
		System.out.printf("Train et bus : 85 %s\n", unite);
	}	 
   
   @Override public String toString() {
	   return "Votre impact de transport est de : " + getImpact();
   }
   
}

