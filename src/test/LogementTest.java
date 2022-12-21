package test;
import consocarbone.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe de test pour la classe Logement
 */

class LogementTest {
	private static Logement aUnderTest;
	private static Logement bUnderTest;

	/**
	 * Setter de deux postes de logement ayant respectivement 200 de superficie et A pour classe energetique, et 350 de classe C
	 */

	@BeforeEach
	public void setUpTests() {
		aUnderTest = new Logement(200,CE.A);
		bUnderTest = new Logement(350,CE.C);
	}

	/**
	 * Met a null les deux objet instancier avant chaque test
	 */

	@AfterEach
	public void restoreAfterTests() {
		aUnderTest = null;
		bUnderTest = null;
	}

	/**
	 * Test de la methode calculImpact du logement
	 */

	@Test
	void calculImpact_logement_returnsValueImpact() {
		double res = aUnderTest.calculImpact();
		assertEquals(1 ,res);
	}

	/**
	 * Test des methodes set et compareTo de la classe Logement
	 * On fait en sorte que les deux objets cree aient les memes valeurs d'attributs, pour ensuite verifier qu'ils sont egaux
	 */

	@Test
	void setImpact_logement_returnsInt() {
		aUnderTest.setSuperficie(350);
		bUnderTest.setCe(CE.A);
		int res = aUnderTest.compareTo(bUnderTest);
		assertEquals(0,res);

	}

}
