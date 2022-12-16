package consocarbone;

public class Transport extends ConsoCarbone {
   private boolean possede;
   private Taille taille;
   private int kilomAnnee;
   private int amortissement;
   
   public Transport() {}
   
   public Transport(boolean possede) {
	   this.possede = possede;   
   }
   
   
   public Transport(boolean possede, Taille taille, int km, int amortissement) {
	   this.possede = possede;
	   this.taille = taille;
	   this.kilomAnnee = km;
	   this.amortissement = amortissement;
   }
   
   public boolean getpossede() {
		return possede;
	}

	public void setpossede(boolean possede) {
		this.possede = possede;
		this.taille = null;
		this.kilomAnnee = 0;
		this.amortissement = 0;
		this.getImpact();
	}
	
    public void setpossede(boolean possede,Taille taille, int km, int amortissement) {
			this.possede = possede;
			this.taille = taille;
			this.kilomAnnee = km;
			this.amortissement = amortissement;
			this.getImpact();
		}
   
    public Taille getTaille() {
 		return taille;
 	}

 	public void setTaille(Taille taille) {
 		this.taille = taille;
 		this.getImpact();
 	}
 	
    public int getKm() {
 		return kilomAnnee;
 	}

 	public void setKm(int km) {
 		this.kilomAnnee = km;
 		this.getImpact();
 	}
	
    public int getAmortissement() {
 		return amortissement;
 	}

 	public void setSuperficie(int amortissement) {
 		this.amortissement = amortissement;
 		this.getImpact();
 	}
 	
   @Override 
   public double getImpact(){
	   if (this.possede == false)  this.impact = 0;
	   else {
		   this.impact = this.kilomAnnee * 1.93 * Math.pow(10,-4) + this.taille.getConsVoit()/this.amortissement;
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
	   return "\n\nL'impact de vos moyens de transport est de : " + Math.round(getImpact()*100.0)/100.0 + " TCO2eq\n";
   }
   
}

