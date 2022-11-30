package consocarbone;

//design pattern singleton 

public final class ServicesPublics extends ConsoCarbone {
	
	private static final ServicesPublics INSTANCE = new ServicesPublics();
	
	private ServicesPublics() {
	}
	
	@Override
	public double getImpact() {
		this.impact = 1.5;
		return this.impact;
	}
	
	public static ServicesPublics getInstance() {
		return INSTANCE;
	}

	@Override 
	 public String toString() {
		   return "\n\nL'impact de vos services publics est de : 1,5 TCO2eq\n";
	   }
	
}
