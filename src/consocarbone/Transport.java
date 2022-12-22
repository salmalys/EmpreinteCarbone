package consocarbone;

/**
 * poste de consommation carbone induit par la possesion d'une voiture 
 */

public class Transport extends ConsoCarbone {
	private boolean possede;
	private Taille taille;
	private int kilomAnnee;
	private int amortissement;

	/**
	 * Constructeur par defaut de la classe transport
	 */

	public Transport() {}

	/**
	 * Constructeur de la classe transport pour un utilisateur qui n'a pas de voiture et calcul l'impact
	 * @param possede false
	 */

	public Transport(boolean possede) {
		this.possede = possede;
		this.taille = null;
		this.kilomAnnee = 0;
		this.amortissement = 0;
		this.impact = calculImpact();
	}

	/**
	 * Constructeur de la classe transport pour un utilisateur qui a une voiture, puis calcul l'impact
	 * @param possede true
	 * @param taille taille de la voiture
	 * @param km nombre de kilomettre a l'annee
	 * @param amortissement = amortissement de la voiture
	 */

	public Transport(boolean possede, Taille taille, int km, int amortissement) {
		this.possede = possede;
		this.taille = taille;
		this.kilomAnnee = km;
		this.amortissement = amortissement;
		this.impact = calculImpact();
	}

	/**
	 * Getter de l'attribut possede
	 * @return l'attribut possede
	 */

	public boolean getpossede() {return possede;}

	/**
	 * Setter lorsque possede devient false, remet a null les objets et a zero les entiers, puis recalcul l'impact
	 * @param possede false
	 */

	public void setpossede(boolean possede) {
		this.possede = possede;
		this.taille = null;
		this.kilomAnnee = 0;
		this.amortissement = 0;
		this.impact = calculImpact();
	}

	/**
	 * Setter des attributs lorsque possede est a true, et recalcul l'immpact
	 * @param possede une voiture ou non
	 * @param taille taille de la voiture
	 * @param km kilommettre a l'annee
	 * @param amortissement amortissement de la voiture
	 */

	public void setpossede(boolean possede,Taille taille, int km, int amortissement) {
		this.possede = possede;
		this.taille = taille;
		this.kilomAnnee = km;
		this.amortissement = amortissement;
		this.impact = calculImpact();
	}

	/**
	 * Getter de l'attribut taille
	 * @return la taille de la voiture
	 */

	public Taille getTaille() {return taille;}

	/**
	 * Setter de la taille et recalcul l'impact
	 * @param taille de la voiture
	 */

	public void setTaille(Taille taille) {
		this.taille = taille;
		this.impact = calculImpact();
	}

	/**
	 * Getter du nombre de killommetre a l'annee
	 * @return le nombre de killometre
	 */

	public int getKm() {return kilomAnnee;}

	/**
	 * Setter du nombre de killometre a l'annee et recalcul l'impact
	 * @param km kilometre a l'annee de la voiture
	 */

	public void setKm(int km) {
		this.kilomAnnee = km;
		this.impact = calculImpact();
	}

	/**
	 * Getter de l'amortissement de la voiture de l'utilisateur
	 * @return l'amortissement 
	 */
	public int getAmortissement() {return amortissement;}

	/**
	 * Setter de l'amortissement et recalcul l'impact
	 * @param amortissement amortissement de la voiture
	 */
	public void setAmortissement(int amortissement) {
		this.amortissement = amortissement;
		this.impact = calculImpact();
	}

	/**
	 * Obtient l'impact calcule a partir d'une formule
	 * @return impact transport
	 */

	@Override
	public double calculImpact() {
		if (this.possede == false)  this.impact = 0;
		else {
			this.impact = this.kilomAnnee * 1.93 * Math.pow(10,-4) + this.taille.getConsVoit()/this.amortissement;
		}
		return this.impact;
	}

	/**
	 * Affiche l'empreinte carbonne moyenne de transport d'un francais
	 * @see ConsoCarbone#empCarbMoy()
	 */ 

	public static void empCarbMoy() {
		String unite = "kg CO2eq/an";
		System.out.printf("Voiture : 1 972 %s\n", unite);
		System.out.printf("Avion : 480 %s\n", unite);
		System.out.printf("Fret et messagerie : 383 %s\n", unite);
		System.out.printf("Train et bus : 85 %s\n", unite);
	}	 

	/**
	 * Affiche l'impact de transport de cet utilisateur
	 * @see ConsoCarbone#toString()
	 */

	@Override public String toString() {return "L'impact de vos moyens de transport est de : " + Math.round(this.impact*100.0)/100.0 + " TCO2eq"; }

	/**
	 * Reecriture de la methode clone de la classe object pour cree un nouveau poste d'alimentation avec les meme argument que l'objet clone
	 * @return nouvel object clone 
	 */

	@Override
	public Object clone() {
		if (this.possede) return new Transport(true,taille,kilomAnnee,amortissement);
		return new Transport(false);
	}
}

