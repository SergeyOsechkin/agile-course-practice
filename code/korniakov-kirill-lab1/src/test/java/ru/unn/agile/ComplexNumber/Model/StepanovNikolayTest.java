package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class StepanovNikolayTest {
    @Test
    public void canCompareComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(3, 2);
        ComplexNumber z2 = new ComplexNumber(-3, 2);

        assertFalse(z1.equals(z2));
    }

    @Test
    public void canConvertToString() {
        ComplexNumber z1 = new ComplexNumber(10, -6);

        assertEquals("10.0 - 6.0i", z1.toString());
    }

    @Test
    public void canAddComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(3, 3);
        ComplexNumber z2 = new ComplexNumber(2, -2);

        ComplexNumber z3 = z1.add(z2);

        assertEquals(new ComplexNumber(5, 1), z3);
    }

    @Test
    public void canMultiplyComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(54, 101);
        ComplexNumber z2 = new ComplexNumber(32, 63);

        ComplexNumber z3 = z1.multiply(z2);

        assertEquals(new ComplexNumber(-4635, 6634), z3);
    }


}
