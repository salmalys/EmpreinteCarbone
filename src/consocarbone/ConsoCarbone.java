package consocarbone;

public abstract class ConsoCarbone implements Comparable<ConsoCarbone> {
	//String nomPoste;
	protected double impact;
    int id;
    static int nbId;
    
    public ConsoCarbone() {
    	this.id = ++nbId;
    }

    public abstract double getImpact();
    
    public void setImpact(double impact) {
    	this.impact = impact;
    }
    
   
    @Override 
    public int compareTo(ConsoCarbone c) {
    	if (this.impact == c.impact) return 0;
    	else if (this.impact > c.impact) return 1;
    	else return -1;
    }
    
    public static void empCarbMoy() {
    	System.out.println("L'empreinte carbonne moyenne d'un.e francais.e pour ce poste est:");
    }
    
    
    
    
    
}
