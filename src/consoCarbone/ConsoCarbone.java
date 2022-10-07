package consoCarbone;

public abstract class ConsoCarbone implements Comparable<ConsoCarbone> {
	String nomPoste;
	double impact;
    int id;
    static int nbId;
    
    public ConsoCarbone() {
    	this.id = ++nbId;
    }
    
    public double getImpact() {
 	   return this.impact;
    }
    
    public abstract void setImpact();
    
    @Override public int compareTo(ConsoCarbone c) {
    	if (this.impact == c.impact) return 0;
    	else if (this.impact > c.impact) return 1;
    	else return -1;
    }
    
    
    
    
    
}
