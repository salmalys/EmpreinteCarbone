package consocarbone;

//design pattern singleton 
/**
 * Classe service publics : poste de consommation carbone induit par les services publics.
 * Tous les francais ont la meme empreinte pour ce poste
 * Il a donc un design patttern singleton
 *
 */

public final class ServicesPublics extends ConsoCarbone {
	
	/**
	 * instance unique pre-initialisee
	 */
	private static final ServicesPublics INSTANCE = new ServicesPublics();
	/**
	 * Constructeur par defaut de la classe
	 */
	private ServicesPublics() {
		this.impact = calculImpact();
	}
	
	/** 
     * @return l'impact des services publics de l'utilisateur
	 */
	
	@Override
	public double calculImpact() {
		this.impact = 1.5;
		return this.impact;
	}
	/**
	 * Acces a l'instance unique du singleton 
	 * @return l'instance
	 */
	
	public static ServicesPublics getInstance() {
		return INSTANCE;
	}
	 /**
	  * affiche l'impact des services publics de cet utilisateur
	  * @see ConsoCarbone#toString()
	  */

	@Override 
	 public String toString() {
		   return "L'impact de vos services publics est de : 1.5 TCO2eq";
	}
	
    /**
    * Reecriture de la methode clone de la classe object pour cree un nouveau poste de service public avec les meme argument que l'objet clone
    * @return nouvel object clone 
    */
	
	   
	
}
