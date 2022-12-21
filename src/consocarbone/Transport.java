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
	   this.impact = calculImpact();
   }
   
   public boolean getpossede() {
		return possede;
	}

	public void setpossede(boolean possede) {
		this.possede = possede;
		this.taille = null;
		this.kilomAnnee = 0;
		this.amortissement = 0;
		this.impact = calculImpact();
	}
	
    public void setpossede(boolean possede,Taille taille, int km, int amortissement) {
			this.possede = possede;
			this.taille = taille;
			this.kilomAnnee = km;
			this.amortissement = amortissement;
			this.impact = calculImpact();
		}
   
    public Taille getTaille() {
 		return taille;
 	}

 	public void setTaille(Taille taille) {
 		this.taille = taille;
 		this.impact = calculImpact();
 	}
 	
    public int getKm() {
 		return kilomAnnee;
 	}

 	public void setKm(int km) {
 		this.kilomAnnee = km;
 		this.impact = calculImpact();
 	}
	
    public int getAmortissement() {
 		return amortissement;
 	}

 	public void setAmortissement(int amortissement) {
 		this.amortissement = amortissement;
 		this.impact = calculImpact();
 	}
 	
  
   @Override
   public double calculImpact() {
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
	   return "L'impact de vos moyens de transport est de : " + Math.round(this.impact*100.0)/100.0 + " TCO2eq";
   }
   
   @Override
   public Object clone() {
		try {
			return super.clone();
		}
		catch (CloneNotSupportedException e){
			throw new InternalError();
		}
   }

   
}

