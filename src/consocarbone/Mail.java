package consocarbone;

/**
 * Poste Mail
 */

public class Mail extends ConsoCarbone {
	private int nbMailEnv;
	private int nbMailStock;
	private final double c1 = 0.000004;
	private final double c2 = 0.00001;

	/**
	 * Constructeur par defaut 
	 */
	public Mail() {
		this.nbMailEnv = 0;
		this.nbMailStock = 0;
	}

	/**
	 * Constructeur de la classe Mail
	 * @param nbE nombre de mail envoye par an
	 * @param nbS nombre de mail stocke
	 */

	public Mail (int nbE, int nbS) {
		this.nbMailEnv = nbE;
		this.nbMailStock = nbS;
		this.impact = calculImpact();
	}

	/**
	 * Getter du nombre de mail envoye
	 * @return nombre de mail envoye
	 */
	public int getNbMailEnv() {return nbMailEnv;}

	/**
	 * Setter du nombre de mail envoye, puis recalcul l'impact
	 * @param nbMailEnv nombre de mail envoye de l'utilisateur
	 */
	public void setNbMailEnv(int nbMailEnv ) {
		this.nbMailEnv = nbMailEnv;
		this.impact = calculImpact();
	}

	/**
	 * Getter du nombre de mail stocke
	 * @return nombre de mail stocke
	 */
	public int getNbMailStock() {return nbMailStock;}

	/**
	 * Setter du nombre de mail stocke, et raclcul l'impact
	 * @param nbMailStock nombre de mail stocke dans la boite mail
	 */
	public void setNbMailStock(int nbMailStock) {
		this.nbMailStock = nbMailStock;
		this.impact = calculImpact();
	}

	/**
	 * Obtient l'impact calcule a partir d'une formule et de deux constantes
	 * @return l'impact des mails de l'utilisateur
	 */

	@Override 
	public double calculImpact() {
		this.impact = c1 * nbMailEnv + c2 * nbMailStock;
		return this.impact;
	}

	/**
	 * Affiche l'empreinte carbonne moyenne des mails d'un francais
	 * @see ConsoCarbone#empCarbMoy()
	 */ 

	public static void empCarbMoy() {
		ConsoCarbone.empCarbMoy();
		String unite = "mails/an";
		System.out.printf("Mail envoyes : 14 000 %s\n", unite);
		System.out.printf("Mail stocke : 25 000 %s\n", unite);
	}

	/**
	 * Affiche l'impact des mails de cet utilisateur
	 * @see ConsoCarbone#toString()
	 */

	@Override
	public String toString() {return "L'impact de vos mails est de : " + Math.round(this.impact*100.0)/100.0 + " TCO2eq";}

	/**
	 * Reecriture de la methode clone de la classe object pour cree un nouveau poste de mail avec les meme argument que l'objet clone
	 * @return nouvel object clone 
	 */

	@Override
	public Object clone() {
		return new Mail(nbMailEnv,nbMailStock);
	}

}
