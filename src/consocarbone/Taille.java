package consocarbone;

/**
 * Enumeration Taille, qui a deux attributs P et G correspondant a une petite et grande voiture
 */
public enum Taille {
    P(4.2),G(19);
	
	private double consVoit;
	
	/**
	 * Set la consommation de la voiture
	 * @param consVoit
	 */
	
	Taille(double consVoit){this.consVoit = consVoit;}
	
	/**
	 * Getter de la consommation de la voiture
	 * @return la consommation de la voiture de l'utilisateur
	 */
	
	public double getConsVoit() {return consVoit;}
}
