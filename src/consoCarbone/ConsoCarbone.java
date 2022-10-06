package consoCarbone;

public class ConsoCarbone  {
	String nomPoste;
	double impact;
    int id;
    static int nbId;
    
    public ConsoCarbone() {
    	this.id = ++nbId;
    }
    
}
