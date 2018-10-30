package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class MoskalenkoViktorTest {
    @Test
    public void canMultiplyComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(-1, 3);
        ComplexNumber z2 = new ComplexNumber(-2, 4);

        // Act
        ComplexNumber result = z1.multiply(z2);
        ComplexNumber expected = new ComplexNumber(-10, -10);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void checkCommutativityOfMultiplication() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(2, 3);
        ComplexNumber z2 = new ComplexNumber(-4, -2);

        // Act
        ComplexNumber x = z1.multiply(z2);
        ComplexNumber y = z2.multiply(z1);

        // Assert
        assertEquals(x, y);
    }

    @Test
    public void checkCommutativityOfAddition() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(2, 3);
        ComplexNumber z2 = new ComplexNumber(-4, -2);

        // Act
        ComplexNumber x = z1.add(z2);
        ComplexNumber y = z2.add(z1);

        // Assert
        assertEquals(x, y);
    }
}
