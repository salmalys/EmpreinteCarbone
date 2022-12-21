package test;
import consocarbone.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlimentationTest {
	//pas mettre de commentaires sur la javadoc
	private static Alimentation aUnderTest;
	private static Alimentation bUnderTest;

	
	@BeforeEach
	public void setUpTests() {
		aUnderTest = new Alimentation(0.4,0.6);
		bUnderTest = new Alimentation(0.7, 0.1);
	}

	@AfterEach
	public void restoreAfterTests() {
		aUnderTest = null;
	    bUnderTest = null;
	}

	@Test
	void calculImpact_alimentation_returnsValueImpact() {
		double res = aUnderTest.calculImpact();
		assertEquals(3.74 ,res);
	}

	@Test
	void compareTo_alimentation_returnsInterger() {
		aUnderTest.getImpact();
		bUnderTest.getImpact();
		int res = aUnderTest.compareTo(bUnderTest);
		assertEquals(-1,res);
	}
	
}
