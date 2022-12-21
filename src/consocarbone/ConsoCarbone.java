package consocarbone;

/** 
 * Classe consoCarbonne qui implement l'interface Comparable
 */

public abstract class ConsoCarbone implements Comparable<ConsoCarbone> {

	/**
	 * impact carbonique du poste de consommation
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
	 * methode abstraite utilise dans toutes les classes implementant ConsoCarbone
	 * @return double etant la valeur de l'impact
	 */

	public abstract double calculImpact();

	public double getImpact() {return this.impact;}

	/**
	 *Setter de l'impact
	 *@param impact 
	 */

	public void setImpact(double impact) {this.impact = impact;}

	/**
	 * Getter de l'identificateur du ConsoCarbonne
	 * @return l'id
	 */

	public int getId() {return id;}

	/**
	 * Methode permettant de calculer l'empreinte 
	 * @return
	 */

	public double calculerEmpreinte() {return this.impact;}

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

	public static void empCarbMoy() {System.out.println("L'empreinte carbonne moyenne d'un.e francais.e pour ce poste est:");}

	/**
	 * methode abstraite 
	 * @return String valeur de l'impact du poste de cet utilisateur 
	 */

	public abstract String toString();

}
