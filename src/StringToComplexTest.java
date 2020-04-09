import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringToComplexTest {

    @Test
    void convert() {
        String minusMinus = "-24.5-3.2i";
        String minusPlus = "-83.11  + 86.2i";
        String minusZero = "-724.22";
        String plusMinus = "923.2-23i";
        String plusPlus = "23.2 +2i";
        String plusZero = "232.221";
        String zeroMinus = "-232.34i";
        String zeroPlus = "204.3i";
        String zero = "0";
        ComplexNumber minusMinusComplex = StringToComplex.convert(minusMinus);
        assertEquals(-24.5, minusMinusComplex.realPart);
        assertEquals(-3.2, minusMinusComplex.imaginaryPart);
        ComplexNumber minusPlusComplex = StringToComplex.convert(minusPlus);
        assertEquals(-83.11, minusPlusComplex.realPart);
        assertEquals(86.2, minusPlusComplex.imaginaryPart);
        ComplexNumber minusZeroComplex = StringToComplex.convert(minusZero);
        assertEquals(-724.22, minusZeroComplex.realPart);
        assertEquals(0, minusZeroComplex.imaginaryPart);
        ComplexNumber plusMinusComplex = StringToComplex.convert(plusMinus);
        assertEquals(923.2, plusMinusComplex.realPart);
        assertEquals(-23, plusMinusComplex.imaginaryPart);
        ComplexNumber plusPlusComplex = StringToComplex.convert(plusPlus);
        assertEquals(23.2, plusPlusComplex.realPart);
        assertEquals(2, plusPlusComplex.imaginaryPart);
        ComplexNumber plusZeroComplex = StringToComplex.convert(plusZero);
        assertEquals(232.221, plusZeroComplex.realPart);
        assertEquals(0, plusZeroComplex.imaginaryPart);
        ComplexNumber zeroMinusComplex = StringToComplex.convert(zeroMinus);
        assertEquals(0, zeroMinusComplex.realPart);
        assertEquals(-232.34, zeroMinusComplex.imaginaryPart);
        ComplexNumber zeroPlusComplex = StringToComplex.convert(zeroPlus);
        assertEquals(0, zeroPlusComplex.realPart);
        assertEquals(204.3, zeroPlusComplex.imaginaryPart);
        ComplexNumber zeroComplex = StringToComplex.convert(zero);
        assertEquals(0, zeroComplex.realPart);
        assertEquals(0, zeroComplex.imaginaryPart);
    }
}