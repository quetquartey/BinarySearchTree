import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FractionTest {
	Fraction frac;

	@Before
	public void setUp() throws Exception {

		frac = new Fraction("3/4");
	}


	@Test
	public void testFractionNotNull() throws NumberFormatExpressionException {
		assertNotNull("should not be null", new Fraction("3/4"));
	}

	@Test
	public void testNumeratorNotNull() {
		assertSame("should be same", 3, frac.getNumerator());
	}
	
	@Test
	public void testDenominatorNotNull() {
		assertSame("should be same", 4, frac.getDenominator());
	}
	
	@Test(expected = NumberFormatExpressionException.class) 
	public void testExceptionThrown4WrongFormat() throws NumberFormatExpressionException {
		Fraction tstFrac = new Fraction("3/4/8");
	}
	
	@Test(expected = NumberFormatExpressionException.class) 
	public void testExceptionThrown4ZeroDenominator() throws NumberFormatExpressionException {
		Fraction tstFrac = new Fraction("5/0");
	}
	
	@Test
	public void testToString() {
		assertEquals("failure - strings are not equal", "3/4", frac.toString());
	}
	
	@Test
	public void testCompareTo() throws NumberFormatExpressionException {
		Fraction frac2 = new Fraction("7/8");
		assertTrue("failure - should be true", frac2.compareTo(frac) > 0);
	}
}
