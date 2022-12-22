package consocarbone;

/**
 * Enumeration Taille composee de 2 instances {P,G} representant une petite ou grande voiture
 */
public enum Taille {
	/**
	 * Taille d'une petite voiture avec une production de 4.2tCO2
	 */
    P(4.2),
    /**
     * Taille d'une grande voiture ayant une production de 19tCO2
     */
    G(19);
	
	private double consVoit;
	
	/**
	 * Set la consommation de la voiture
	 * @param consVoit consommation de la voiture de l'utilisateur
	 */
	
	Taille(double consVoit){this.consVoit = consVoit;}
	
	/**
	 * Getter de la consommation de la voiture
	 * @return La consommation de la voiture de l'utilisateur
	 */
	
	public double getConsVoit() {return consVoit;}
}
