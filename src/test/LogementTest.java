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
		bUnderTest = new Logement(4000,CE.C);
	}

	@AfterEach
	public void restoreAfterTests() {
		aUnderTest = null;
		bUnderTest = null;
	}

	@Test
	void getImpact_logement_returnsValueImpact() {
		double res = aUnderTest.getImpact();
		assertEquals(1 ,res);
	}
	
	/*@Test
	void compareTo_logement_returnsInterger() {
		aUnderTest.getImpact();
		bUnderTest.getImpact();
		int res = aUnderTest.compareTo(bUnderTest);

	}*/

}
