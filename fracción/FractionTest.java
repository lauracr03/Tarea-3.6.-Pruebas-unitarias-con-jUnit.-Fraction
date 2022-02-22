package fracción;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FractionTest {
	Fraction unCuarto;
	Fraction unMedio;
	Fraction dosTercios;
	
	@BeforeEach
	void setUp() throws Exception {
		unCuarto = new Fraction(1, 4);
		unMedio = new Fraction(1, 2);
		dosTercios = new Fraction(2, 3);
	}

	@Test
	void testHashCode() {
		assertDoesNotThrow(()->{
			unCuarto.hashCode();
			unMedio.hashCode();
			dosTercios.hashCode();
		});
		
	}
	

	@Test
	void testFraction() {
		assertDoesNotThrow(()->{
			Fraction negativa = new Fraction(-1, 2);
			assertEquals(-1, negativa.getNumerator());
			assertEquals(2, negativa.getDenominator());
		});
		assertThrows(ArithmeticException.class, ()->{
			new Fraction(1,0);
		});
		assertThrows(ArithmeticException.class, ()->{
			new Fraction(2,0);
		});
		assertThrows(ArithmeticException.class, ()->{
			new Fraction(3,0);
		});
	}
			

	

	@Test
	void testGetNumerator() {
		assertEquals(1, unCuarto.getNumerator());
		assertEquals(1, unMedio.getNumerator());
		assertEquals(2, dosTercios.getNumerator());
	}

	@Test
	void testGetDenominator() {
		assertEquals(4, unCuarto.getDenominator());
		assertEquals(2, unMedio.getDenominator());
		assertEquals(3, dosTercios.getDenominator());
	}

	@Test
	void testToString() {
		assertEquals("1/4", unCuarto.toString());
		assertEquals("1/2", unMedio.toString());
		assertEquals("2/3", dosTercios.toString());
	}

	@Test
	void testCompareTo() {
		assertEquals(1*2-1*4, unCuarto.compareTo(unMedio));
		assertEquals(1*3-2*4, unCuarto.compareTo(dosTercios));
		assertEquals(2*2-1*3, dosTercios.compareTo(unMedio));
	}
	@Test
	void testClone() {
		assertDoesNotThrow(()->{
			unCuarto.clone();
			unMedio.clone();
			dosTercios.clone();
		});
	}

	@Test
	void testEqualsObject() {
		assertEquals(true, unCuarto.equals(unCuarto));
		assertEquals(false, unCuarto.equals(unMedio));
		assertEquals(false, unCuarto.equals(dosTercios));
	}

	@Test
	void testResult() {
		assertEquals(0.25, unCuarto.result());
		assertEquals(0.5, unMedio.result());
	}

	@Test
	void testMultiplyInt() {
		assertDoesNotThrow(()->{
			unCuarto.multiply(3);
		});
		assertDoesNotThrow(()->{
			dosTercios.multiply(3);
		});
	}

	@Test
	void testMultiplyFraction() {
		assertDoesNotThrow(()->{
			unCuarto.multiply(dosTercios);
		});
		assertDoesNotThrow(()->{
			dosTercios.multiply(unCuarto);
		});
	}

	@Test
	void testDivide() {
		assertDoesNotThrow(()->{
			unCuarto.divide(dosTercios);
		});
		assertDoesNotThrow(()->{
			unCuarto.divide(unMedio);
		});
		assertDoesNotThrow(()->{
			unMedio.divide(dosTercios);
		});
	}

	@Test
	void testAdd() {
		assertDoesNotThrow(()->{
			unCuarto.add(dosTercios);
		});
		assertDoesNotThrow(()->{
			unMedio.add(dosTercios);
		});
		assertDoesNotThrow(()->{
			dosTercios.add(unMedio);
		});
	}

	@Test
	void testSubtract() {
		assertDoesNotThrow(()->{
			unCuarto.subtract(dosTercios);
		});
		assertDoesNotThrow(()->{
			unMedio.subtract(dosTercios);
		});
		assertDoesNotThrow(()->{
			dosTercios.subtract(unMedio);
		});
	}
	 @Test
	void testSimplify() {
		Fraction seisNovenos= new Fraction(6,9);
		assertEquals(2, seisNovenos.getNumerator());
		assertEquals(3, seisNovenos.getDenominator());
		Fraction ochoDoceavos = new Fraction(8, 12);
		assertEquals(2, ochoDoceavos.getNumerator());
		assertEquals(3, ochoDoceavos.getDenominator());
	}
	

}


