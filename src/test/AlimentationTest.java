package test;
import consocarbone.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe permettant de tester les methodes de la classe Alimentation
 *
 */

class AlimentationTest {
	private static Alimentation aUnderTest;
	private static Alimentation bUnderTest;

	/**
	 * Set deux postes Alimentaire ayant respectivement comme taux boeuf 0.4 et 0.7 et comme taux vegetarien 0.6 et 0.1
	 */
	
	@BeforeEach
	public void setUpTests() {
		aUnderTest = new Alimentation(0.4,0.6);
		bUnderTest = new Alimentation(0.7, 0.1);
	}

	/**
	 * Met a null les objet setter au depart de chaque test
	 */

	@AfterEach
	public void restoreAfterTests() {
		aUnderTest = null;
		bUnderTest = null;
	}

	/**
	 * Test qui calcul l'impact alimentaire du premier poste alimentaire
	 * Verifie que la valeur vaut bien une certaine valeur calcule grace a la formule a la main
	 */
	
	@Test
	void calculImpact_alimentation_returnsValueImpact() {
		double res = aUnderTest.calculImpact();
		assertEquals(3.74 ,res);
	}

	/**
	 * Test qui verifie la methode comparaTo, et compare les deux impacts alimentaires 
	 */

	@Test
	void compareTo_alimentation_returnsInterger() {
		aUnderTest.getImpact();
		bUnderTest.getImpact();
		int res = aUnderTest.compareTo(bUnderTest);
		assertEquals(-1,res);
	}

}
