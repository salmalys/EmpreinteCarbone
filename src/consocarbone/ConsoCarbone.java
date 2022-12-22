package consocarbone;

/** 
 * poste de consommation carbone generique 
 */

public abstract class ConsoCarbone implements Comparable<ConsoCarbone> {

	/**
	 *Impact carbonique du poste de consommation
	 */

	protected double impact;
	private int id;
	private static int nbId;

	/**
	 * Constructeur par defaut de la classe
	 */

	public ConsoCarbone() {
		impact = 0;
		this.id = ++nbId;
	}

	/**
	 * Methode abstraite utilise dans toutes les classes implementant ConsoCarbone, permettant de calculer l'impact
	 * @return Un double etant la valeur de l'impact de cet objet pour un poste precis
	 */

	public abstract double calculImpact();
	
    /**
     * Getter de l'impact
     * @return l'impact
     */
	
	public double getImpact() {return this.impact;}

	/**
	 *Setter de l'impact
	 *@param impact Impact de l'objet
	 */

	public void setImpact(double impact) {this.impact = impact;}

	/**
	 * Getter de l'identificateur du ConsoCarbonne
	 * @return L'identificateur de ce ConsoCarbone
	 */

	public int getId() {return id;}

	/**
	 * Methode permettant de calculer l'empreinte 
	 * @return L'empreinte de l'objet
	 */

	public double calculerEmpreinte() {return this.impact;}

	/**
	 * On compare l'impact de l'objet avec l'impact d'un objet passer en parametre
	 * @param c un poste de consommation carbone 
	 * @return 0 si l'impact est le meme, 1 si l'impact du poste est strictement superieur a celui du poste passe en parametre et -1 sinon
	 */
	
	@Override 
	public int compareTo(ConsoCarbone c) {
		if (this.impact == c.impact) return 0;
		else if (this.impact > c.impact) return 1;
		else return -1;
	}

	/**
	 * Affiche l'empreinte carbone moyenne d'un francais pour un poste de consommation donne
	 */

	public static void empCarbMoy() {System.out.println("L'empreinte carbonne moyenne d'un.e francais.e pour ce poste est:");}

	/**
	 * Methode abstraite definit dans toutes les classes implementant ConsoCarbone
	 * @return String valeur de l'impact du poste de cet utilisateur 
	 */

	public abstract String toString();

}
