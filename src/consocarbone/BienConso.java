package consocarbone;

/** 
 * Un BienConso est un poste de consommation qui s'interesse aux depenses du consommateur
 * */


public class BienConso extends ConsoCarbone implements Cloneable {

	private double montant;

	/**
	 * Constructeur par defaut qui initialise le montant des depenses a zero et recalcul l'impact
	 */

	public BienConso() { 
		montant = 0;
		this.impact = calculImpact();
	}

	/**
	 * Constructeur de la classe BienConso et recalcul l'impact
	 * @param montant montant des depenses
	 */

	public BienConso(double montant) {
		this.montant = montant;
		this.impact = calculImpact();
	}

	/**
	 * Calcul de l'impact bien consommateur. 
	 * Une tonne de CO2eq est equivalente a 1750e de depenses.
	 * @return l'impact BienConso
	 */

	@Override 
	public double calculImpact() {
		this.impact = this.montant / 1750;
		return this.impact;
	}

	/**
	 * Getters du montant
	 * @return le montant des depense anuelle
	 */

	public double getMontant() {return montant;}

	/**
	 * Setter du montant et recalcul l'impact
	 * @param montant : nouveau montant
	 */

	public void setMontant(double montant) {
		this.montant = montant;
		this.impact = calculImpact();
	}

	/**
	 * Affiche l'empreinte carbonne moyenne d'un francais vis a vis de son alimentation
	 *  @see ConsoCarbone#empCarbMoy()
	 */

	public static void empCarbMoy() {
		ConsoCarbone.empCarbMoy();

		String unite = "kg CO2eq/an";
		System.out.printf("Achat et usages Internet et technologies : 1 180 %s\n", unite);
		System.out.printf("Autres biens et services : 682 %s\n", unite);
		System.out.printf("Habillement : 763 %s\n", unite);
	}	

	/**
	 * Affiche l'impact BienConso de cet utilisateur
	 * @return L'impact ecrit a l'ecran
	 * @see ConsoCarbone#toString()
	 */

	public String toString() {return "L'impact de vos depenses annuelles est de : " + Math.round(this.impact*100.0)/100.0 + " TCO2eq";}

	/**
	 * Redefinition de la methode clone pour un bienConso de la classe Objet.
	 * Copie les attributs du bienconso.
	 * @return Le nouvel objet bien consommateur.
	 */

	@Override
	public Object clone() {
		return new BienConso(montant);
	}


}
