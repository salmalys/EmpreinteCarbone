package consoCarbone;

//design pattern singleton 

public final class ServicesPublics extends ConsoCarbone {
	
	
	private ServicesPublics() {
	}
	
	public void setImpact() {
		this.impact = 1.5;
	}
//private static final ServicesPublics INSTANCE = new ServicesPublics();
	
}
