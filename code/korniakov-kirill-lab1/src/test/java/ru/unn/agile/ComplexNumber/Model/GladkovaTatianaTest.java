package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GladkovaTatianaTest {
    private final double delta = 0.001;

    @Test
    public void canAddComplexNumber() {
        ComplexNumber z1 = new ComplexNumber(1, 1);
        ComplexNumber z2 = new ComplexNumber(1, 1);
        ComplexNumber z3 = z1.add(z2);

        assertEquals(new ComplexNumber(2, 2), z3);
    }

    @Test
    public void twoComplexNumbersAreEquals() {
        ComplexNumber z1 = new ComplexNumber(1, 1);
        ComplexNumber z2 = new ComplexNumber(1, 1);

        assertTrue(z1.equals(z2));
    }

    @Test
    public void realComplexNumberIsCorrect() {
        ComplexNumber z1 = new ComplexNumber(1, 1);

        assertEquals(1, z1.getReal(), delta);
    }
}
