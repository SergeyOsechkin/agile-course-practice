package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TishkinKonstantinTest {
    @Test
    public void canCompareComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(0.0, 1.0);
        ComplexNumber z2 = new ComplexNumber(0.0, 1.0);

        assertEquals(z1, z2);
    }

    @Test
    public void canMultiplyComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(5.0, 4.0);
        ComplexNumber z2 = new ComplexNumber(6.0, 3.0);

        ComplexNumber z = z1.multiply(z2);

        assertEquals(new ComplexNumber(18.0, 39.0), z);
    }

    @Test
    public void canMultiplyComplexNumberByZero() {
        ComplexNumber z1 = new ComplexNumber(2.0, 2.0);
        ComplexNumber z2 = new ComplexNumber(0.0, 0.0);

        ComplexNumber z = z1.multiply(z2);

        assertEquals(new ComplexNumber(0.0, 0.0), z);
    }
}
