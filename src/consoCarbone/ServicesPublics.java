package consoCarbone;

//design pattern singleton 

public final class ServicesPublics extends ConsoCarbone {
	
	
	private ServicesPublics() {
	}
	
	public double getImpact() {
		this.impact = 1.5;
		return this.impact;
	}
//private static final ServicesPublics INSTANCE = new ServicesPublics();
	
}
