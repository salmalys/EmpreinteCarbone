package consocarbone;

public abstract class ConsoCarbone implements Comparable<ConsoCarbone> {
	//String nomPoste;
	/**
	 * impact carbonique du poste de consommation
	 */
	protected double impact;
	/**
	 * id du poste de consommation
	 */
    private int id;
    /**
     * nombre total de postes de consommation
     */
    private static int nbId;
    
    /**
     * Constructeur de la classe
     */
    public ConsoCarbone() {
    	this.id = ++nbId;
    }
    
    public abstract double getImpact();
    
    public void setImpact(double impact) {
    	this.impact = impact;
    }
    
    public int getId() {return id;}
   
   /**
    * compare le poste avec le poste A
    * @param poste A
    * @return 0 si l'impact est le meme, 1 si l'impact du poste est strictement superieur a celui du poste A et -1 sinon
    */
    
    
    @Override 
    public int compareTo(ConsoCarbone c) {
    	if (this.impact == c.impact) return 0;
    	else if (this.impact > c.impact) return 1;
    	else return -1;
    }
    

    /**
     * affiche l'empreinte carbone moyenne d'un francais pour un poste de consommation donne
     */
    public static void empCarbMoy() {
    	System.out.println("L'empreinte carbonne moyenne d'un.e francais.e pour ce poste est:");
    }
    
    /**
     * methode abstraite 
     * @return String valeur de l'impact du poste de cet utilisateur 
     */
    public abstract String toString();
    
}
