package fpmislata.aceptaElReto103;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HerenciaTest {

    @Test
    @DisplayName("Evaluate polynomial")

    public void evaluatePolynomial() {
        double x = 0.25;
        int[] coefficients = { 1, 2, 3, 4 };

        assertEquals(4.890625, Herencia.evaluatePolynomial(x, coefficients));
    }

    @Test
    @DisplayName("Calculate area")
    public void calculateArea() {
        int[] coefficients = { 1, 2, 3, 4 };
        int rectangles = 4;

        assertEquals(1, Herencia.calculateArea(coefficients, rectangles));
    }
}
