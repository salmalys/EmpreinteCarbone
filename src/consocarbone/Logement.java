package consocarbone;

/**
 * Un logement est un poste de consommation qui s'interesse a l'impact de leurs logement en fonction de leur classe energetique et de leur superficie
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
	 * Constructeur de la classe 
	 * @param s : superficie du logement
	 * @param ce : Classe energetique de la classe
	 */

	public Logement(int s,CE ce) {
		this.superficie = s;
		this.ce = ce;
		this.impact = calculImpact();
	}

	/**
	 * getter de la superficie
	 * @return superficie
	 */

	public int getSuperficie() {return superficie;}

	/**
	 * Set la superficie puis rappel la methode pour calculer l'impact avec cette superficie
	 * @param superficie
	 */

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
		this.impact = calculImpact();
	}

	/**
	 * getter de la classe energetique
	 * @return la classe energetique
	 */

	public CE getCe() {return ce;}

	/**
	 * setter de la classe energetique
	 * Recalcul l'impact avec cette nouvelle classe energetique
	 * @param ce
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
	 * affiche l'empreinte carbonne moyenne d'un logement d'un francais
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
	 * affiche l'impact du logement de cet utilisateur
	 * @see ConsoCarbone#toString()
	 */

	public String toString() {return "L'impact de votre logement est de : " + Math.round(this.impact*100.0)/100.0 + " TCO2eq";}

	/**
	 * Reecriture de la methode clone de la classe Objet pour un Logement
	 * @return 1 ou une erreur 
	 */

	@Override
	public Object clone() {
		try {
			return super.clone();
		}
		catch (CloneNotSupportedException e){
			throw new InternalError();
		}
	}

}



