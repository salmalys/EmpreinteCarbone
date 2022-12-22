package consocarbone;

/**
 * poste de consommation concernant un logement
 */

public class Logement extends ConsoCarbone implements Cloneable {
	private int superficie;
	private CE ce;

	/**
	 * Constructeur par defaut de la classe
	 */

	public Logement() {
		superficie = 0;
		ce = null;
	}

	/**
	 * Constructeur de la classe Logement
	 * @param s superficie du logement
	 * @param ce Classe energetique de la classe
	 */

	public Logement(int s,CE ce) {
		this.superficie = s;
		this.ce = ce;
		this.impact = calculImpact();
	}

	/**
	 * Getter de la superficie
	 * @return superficie
	 */

	public int getSuperficie() {return superficie;}

	/**
	 * Set la superficie puis rappel la methode pour calculer l'impact avec cette superficie
	 * @param superficie nouvelle superficie
	 */

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
		this.impact = calculImpact();
	}

	/**
	 * Getter de la classe energetique
	 * @return la nouvelle classe energetique
	 */

	public CE getCe() {return ce;}

	/**
	 * Setter de la classe energetique puis recalcul l'impact avec cette nouvelle classe energetique
	 * @param ce Nouvelle classe energetique du poste
	 */

	public void setCe(CE ce) {
		this.ce = ce;
		this.impact = calculImpact();
	}

	/**
	 * Obtient l'impact en multipliant le coefficient de la classe energetique par la superficie
	 * @return l'impact du logement
	 */

	@Override
	public double calculImpact() {
		this.impact = this.ce.getCoeff() * this.superficie;
		return this.impact;
	}

	/**
	 * Affiche l'empreinte carbonne moyenne d'un logement d'un francais
	 * @see ConsoCarbone#empCarbMoy()
	 */

	public static void empCarbMoy() {
		ConsoCarbone.empCarbMoy();
		String unite = "kg CO2eq/an";
		System.out.printf("Energie et utilites : 1 696 %s\n", unite);
		System.out.printf("Construction & gros entretien : 675 %s\n", unite);
		System.out.printf("Equipement des logements : 335 %s\n", unite);
	}

	/**
	 * Affiche l'impact du logement de cet utilisateur
	 * @see ConsoCarbone#toString()
	 */

	public String toString() {return "L'impact de votre logement est de : " + Math.round(this.impact*100.0)/100.0 + " TCO2eq";}

	/**
	 * Reecriture de la methode clone de la classe Objet pour un Logement
	 * @return 1 ou une erreur 
	 */

	@Override
	public Object clone() {
		return new Logement(superficie,ce);
	}

}



