package consocarbone;

/**
 * Enumeration CE composee de 7 instances {A,B,C,D,E,F,G} representant les differentes classes energetiques
 *
 */

public enum CE {
	/**
	 * Classe energetique A ayant pour coefficient 0.005
	 */
	A(0.005),
	/**
	 * Classe energetique B ayant pour coefficient 0.01
	 */
	B(0.01),
	/**
	 * Classe energetique C ayant pour coefficient 0.02
	 */
	C(0.02),
	/**
	 * Classe energetique D ayant pour coefficient 0.035
	 */
	D(0.035),
	/**
	 * Classe energetique E ayant pour coefficient 0.055
	 */
	E(0.055),
	/**
	 * Classe energetique F ayant pour coefficient 0.08
	 */
	F(0.08),
	/**
	 * Classe energetique G ayant pour coefficient 0.1
	 */
	G(0.1);

	private final double coeff;

	/**
	 * Consructeur de l'enumeration
	 * @param coeff coefficient du logement
	 */

	CE(double coeff){this.coeff = coeff;}

	/**
	 * getter du coefficient
	 * @return le coefficient
	 */

	public double getCoeff() {return coeff;}
}
