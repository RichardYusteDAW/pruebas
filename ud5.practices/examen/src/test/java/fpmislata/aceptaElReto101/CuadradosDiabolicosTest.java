package fpmislata.aceptaElReto101;

import org.junit.jupiter.api.*; // Importar todas las anotaciones de JUnit
import static org.junit.jupiter.api.Assertions.*; // Importar todas las aserciones de JUnit

public class CuadradosDiabolicosTest {
    CuadradosDiabolicos cuadrados;

    @Test
    @DisplayName("Testing the constructor")
    public void constructor() {
        int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        cuadrados = new CuadradosDiabolicos(array);

        assertEquals(array, cuadrados.getArray());
    }

    @Nested
    class Diabolico {
        @Test
        @DisplayName("Testing is diabolic")
        public void isDiabolic() {
            int[][] array = { { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } };
            cuadrados = new CuadradosDiabolicos(array);

            assertTrue(cuadrados.esDiabolico());
        }

        @Test
        @DisplayName("Testing is not diabolic")
        public void isNotDiabolic() {
            int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
            cuadrados = new CuadradosDiabolicos(array);

            assertFalse(cuadrados.esDiabolico());
        }
    }

    @Nested
    class Esoterico {

        @DisplayName("Es esotérico impar")
        public void isEsotericOdd() {
            int[][] array = { { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } };
            cuadrados = new CuadradosDiabolicos(array);

            assertTrue(cuadrados.esEsoterico());
        }

        @DisplayName("Es esotérico par")
        public void isEsotericEven() {
            int[][] array = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
            cuadrados = new CuadradosDiabolicos(array);

            assertTrue(cuadrados.esEsoterico());
        }

        @Test
        @DisplayName("No es esotérico impar")
        public void isNotEsotericOdd() {
            int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
            cuadrados = new CuadradosDiabolicos(array);

            assertFalse(cuadrados.esEsoterico());
        }

        @Test
        @DisplayName("No es esotérico par")
        public void isNotEsotericEven() {
            int[][] array = { { 5, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
            cuadrados = new CuadradosDiabolicos(array);

            assertFalse(cuadrados.esEsoterico());
        }
    }
}