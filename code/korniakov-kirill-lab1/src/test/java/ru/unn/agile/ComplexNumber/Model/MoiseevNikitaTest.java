package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class MoiseevNikitaTest {
    @Test
    public void canInstantiateComplexNumber() {
        ComplexNumber z = new ComplexNumber(0, 0);

        assertNotNull(z);
    }

    @Test
    public void canAddComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(1, 2);
        ComplexNumber z2 = new ComplexNumber(3, 4);
        ComplexNumber expectedSum = new ComplexNumber(4, 6);

        ComplexNumber sum = z1.add(z2);

        assertEquals(expectedSum, sum);
    }

    @Test
    public void doesEqualsReturnTrueForIdenticalComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(42, 24);
        ComplexNumber z2 = new ComplexNumber(42, 24);

        assertEquals(z1, z2);
    }
}

