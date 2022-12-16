package consocarbone;


public class Logement extends ConsoCarbone {
    private int superficie;
    private CE ce;
    
    public Logement() {}
    
    public Logement(int s,CE ce) {
    	this.superficie = s;
    	this.ce = ce;
    }
    
    public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
		this.getImpact();
	}

	public CE getCe() {
		return ce;
	}

	public void setCe(CE ce) {
		this.ce = ce;
		this.getImpact();
	}


	@Override
	public double getImpact() {
		this.impact = this.ce.getCoeff() * this.superficie;
		return this.impact;
	}
	

	public static void empCarbMoy() {
		ConsoCarbone.empCarbMoy();
		
		String unite = "kg CO2eq/an";
		System.out.printf("Energie et utilites : 1 696 %s\n", unite);
		System.out.printf("Construction & gros entretien : 675 %s\n", unite);
		System.out.printf("Equipement des logements : 335 %s\n", unite);
	}
	
	public String toString() {
		   return "\n\nL'impact de votre logement est de : " + Math.round(getImpact()*100.0)/100.0 + " TCO2eq\n";
	   }
	
	  @Override
	   public Object clone() {
			try {
				Logement l = (Logement) super.clone();
				return l;
			}
			catch (CloneNotSupportedException e){
				throw new InternalError();
			}
	   }
	   
	
}



