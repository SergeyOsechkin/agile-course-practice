package ru.unn.agile.complexnumber.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProninaMariaTest {
    @Test
    public void isAdditionOfComplexNumbersCommutative() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(1, 2);
        ComplexNumber z2 = new ComplexNumber(2, 1);

        // Act
        ComplexNumber x = z1.add(z2);
        ComplexNumber y = z2.add(z1);

        // Assert
        assertEquals(x, y);
    }

    @Test
    public void isMultiplicationOfComplexNumbersCommutative() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(1, 3);
        ComplexNumber z2 = new ComplexNumber(4, 1);

        // Act
        ComplexNumber x = z1.multiply(z2);
        ComplexNumber y = z2.multiply(z1);

        // Assert
        assertEquals(x, y);
    }

    @Test
    public void isAdditionOfComplexNumbersAssociative() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(5, 3);
        ComplexNumber z2 = new ComplexNumber(7, 1);
        ComplexNumber z3 = new ComplexNumber(3, 10);

        // Act
        ComplexNumber x = z1.add(z2.add(z3));
        ComplexNumber y = (z1.add(z2)).add(z3);

        // Assert
        assertEquals(x, y);
    }

    @Test
    public void iMultiplicationOfComplexNumbersAssociative() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(4, 3);
        ComplexNumber z2 = new ComplexNumber(2, 1);
        ComplexNumber z3 = new ComplexNumber(3, 10);

        // Act
        ComplexNumber x = z1.multiply(z2.multiply(z3));
        ComplexNumber y = (z1.multiply(z2)).multiply(z3);

        // Assert
        assertEquals(x, y);
    }
}
