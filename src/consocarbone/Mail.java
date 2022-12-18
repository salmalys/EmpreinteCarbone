package consocarbone;

public class Mail extends ConsoCarbone {
    private int nbMailEnv;
    private int nbMailStock;
    private final double c1 = 0.000004;
    private final double c2 = 0.00001;
    
    
    public Mail() {}

    public Mail (int nbE, int nbS) {
           this.nbMailEnv = nbE;
           this.nbMailStock = nbS;
    }
    
    public int getNbMailEnv() {return nbMailEnv;}
    public void setNbMailEnv(int nbMailEnv ) {this.nbMailEnv = nbMailEnv;}

    public int getNbMailStock() {return nbMailStock;}
    public void setNbMailStock(int nbMailStock) {this.nbMailStock = nbMailStock;}

    @Override 
	public double getImpact() {
           this.impact = c1 * nbMailEnv + c2 * nbMailStock;
           return this.impact;
    }

    public static void empCarbMoy() {
    ConsoCarbone.empCarbMoy();
    String unite = "/an";
           System.out.printf("Mail envoyes : 14 000 %s\n", unite);
           System.out.printf("Mail stocke : 25 000 %s\n", unite);
    }

    @Override
    public String toString() {
              return "\n\nL'impact de vos mails est de : " + Math.round(this.impact*100.0)/100.0 + " TCO2eq\n";
    }
    
}


