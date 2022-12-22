package consocarbone;

/**
 * poste de consommation induit par les services publics (identique pour tous les utilisateurs)
 */

public final class ServicesPublics extends ConsoCarbone {

	/**
	 * Instance unique pre-initialisee
	 */

	private static final ServicesPublics INSTANCE = new ServicesPublics();

	/**
	 * Constructeur par defaut de la classe
	 */

	private ServicesPublics() {this.impact = calculImpact();}

	/** 
	 * Methode qui calcul l'impact qui est toujours le meme pour chaque utilisateur
	 * @return l'impact des services publics de l'utilisateur
	 */

	@Override
	public double calculImpact() {
		this.impact = 1.5;
		return this.impact;
	}

	/**
	 * Acces a l'instance unique du singleton 
	 * @return L'instance
	 */

	public static ServicesPublics getInstance() {return INSTANCE;}

	/**
	 * Affiche l'impact des services publics de cet utilisateur
	 * @see ConsoCarbone#toString()
	 */

	@Override 
	public String toString() {return "L'impact de vos services publics est de : 1.5 TCO2eq";}

}
