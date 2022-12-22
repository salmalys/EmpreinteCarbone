package test;
import consocarbone.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LogementTest {
	private static Logement aUnderTest;
	private static Logement bUnderTest;

	@BeforeEach
	public void setUpTests() {
		aUnderTest = new Logement(200,CE.A);
		bUnderTest = new Logement(350,CE.C);
	}
	
	@AfterEach
	public void restoreAfterTests() {
		aUnderTest = null;
		bUnderTest = null;
	}

	@Test
	void calculImpact_logement_returnsValueImpact() {
		double res = aUnderTest.calculImpact();
		assertEquals(1 ,res);
	}

	@Test
	void setImpact_logement_returnsInt() {
		aUnderTest.setSuperficie(350);
		bUnderTest.setCe(CE.A);
		int res = aUnderTest.compareTo(bUnderTest);
		assertEquals(0,res);

	}

}
