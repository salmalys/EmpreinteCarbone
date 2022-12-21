package consocarbone;
				/**
				 * Une Alimentation est un poste de consommation qui s'interesse a l'impact alimentaire
				 *
				 */
				//setteurs sur txboeuf et txvege 

				public class Alimentation extends ConsoCarbone{
				    private double txBoeuf;
				    private double txVege;
				    
				    private final double c1 =8;
				    private final double c2 =1.6;
				    private final double c3 =.9;
				    
				    /**
				     * Constructeur par defaut de la classe
				     * @param tB initialise a 0
				     * @param tV initialise a 0
				     */
				    
				    public Alimentation() {
					    this.txBoeuf = 0.0;
					    this.txVege = 0.0;
					    this.impact = calculImpact();
					    
				    }
				    
					 /**
				     * Constructeur de la classe
				     * @param tB
				     * @param tV
				     */
					
				    public Alimentation (double tB, double tV) {
				    	this.txBoeuf = tB;
				    	this.txVege = tV; 
				    	this.impact = calculImpact();
				    }
					
				  /**
				   * Getter du taux de boeuf 
				   * @return taux de boeuf
				   */
				    
				    public double gettxBoeuf() {
						return txBoeuf;
					}

					
					  /**
					   * Setter du taux de boeuf
					   * Apres avoir mis à jour le taux de boeuf, on recalcul l'impact alimentaire
					   */
					    
				    
					public void settxBoeuf(double txBoeuf) {
						this.txBoeuf = txBoeuf;
						this.impact = calculImpact();
					}
				    
					  /**
					   * Getter du tauxvegetarien
					   */
					    			
				    public double gettxVege() {
						return txVege;
					}

				    /**
					   * Setter du taux vegetarien
					   *Puis recalcul l'impact alimentaire
					   */
 
					public void settxVege(double txVege) {
						this.txVege = txVege;
						this.impact = calculImpact();
					}
				    
				    /**
				     * obtient l'impact calcule a partir d'une formule
				     * @return impact alimentaire
				     */
				  
				    @Override
				    public double calculImpact() {
				    	this.impact = c1 * this.txBoeuf + c2 * (1 - this.txVege - this.txBoeuf)+ c3 * this.txVege;
				    	return this.impact;
				    }
				    
				   /**
				    * affiche l'empreinte carbonne moyenne alimenatire d'un francais
				    * @see ConsoCarbone#empCarbMoy()
				    */ 
				   public static void empCarbMoy() {
					    ConsoCarbone.empCarbMoy();
					   
					    String unite = "kg CO2eq/an";
						System.out.printf("Viandes et Poissons : 1 144 %s\n", unite);
						System.out.printf("Produits laitiers et oeufs : 408 %s\n", unite);
						System.out.printf("Autres : 538 %s\n", unite);
						System.out.printf("Boissons : 263 %s\n", unite);
					}	   
				   
				   /**
				    * affiche l'impact alimenataire de cet utilisateur
				    * @see ConsoCarbone#toString()
				    */
				   @Override
				   public String toString() {
					   return "L'impact de votre alimentation est de : " + Math.round(this.impact*100.0)/100.0 + " TCO2eq";
				   }
				   
				   /**
				    * Reecriture de la methode clone de la classe object pour cree un nouveau poste d'alimentation avec les meme argument que l'objet clone
				    * @return nouvel object clone 
				    */
				   
			
				   
				   
				}
