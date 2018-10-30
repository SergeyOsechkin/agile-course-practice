package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KursakovEvgenyTest {
    @Test
    public void canAddRealComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(2, 0);
        ComplexNumber z2 = new ComplexNumber(2, 0);

        ComplexNumber result = z1.add(z2);

        ComplexNumber expected = new ComplexNumber(4, 0);
        assertEquals(expected, result);
    }

    @Test
    public void canMultiplyComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(1.5, -2.5);
        ComplexNumber z2 = new ComplexNumber(-1, 3);

        ComplexNumber result = z1.multiply(z2);

        ComplexNumber expected = new ComplexNumber(6, 7);
        assertEquals(expected, result);
    }

    @Test
    public void canMultiplyWithZero() {
        ComplexNumber z1 = new ComplexNumber(100, 200);
        ComplexNumber z2 = new ComplexNumber(0, 0);

        ComplexNumber result = z1.multiply(z2);

        ComplexNumber expected = new ComplexNumber(0, 0);
        assertEquals(expected, result);
    }
}
