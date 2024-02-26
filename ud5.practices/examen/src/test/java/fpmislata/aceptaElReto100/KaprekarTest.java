package fpmislata.aceptaElReto100;

import org.junit.jupiter.api.*; // Importar todas las anotaciones de JUnit
import static org.junit.jupiter.api.Assertions.*; // Importar todas las aserciones de JUnit

public class KaprekarTest {
    private Kaprekar kaprekar;

    @BeforeEach
    void setUp() {
        kaprekar = new Kaprekar();
    }

    @Test
    @DisplayName("Test Kaprekar routine with the constant 6174")
    public void testKaprekarRoutineFor6174() {
        assertEquals(0, kaprekar.kaprekarRoutine(6174));
    }

    @Test
    @DisplayName("Test Kaprekar routine for repdigits")
    public void testKaprekarRoutineForRepdigit() {
        assertEquals(8, kaprekar.kaprekarRoutine(1111));
        assertEquals(8, kaprekar.kaprekarRoutine(2222));
    }

    @Test
    @DisplayName("Test Kaprekar routine for general cases")
    public void testKaprekarRoutineForGeneralCase() {
        assertEquals(3, kaprekar.kaprekarRoutine(3524));
        assertEquals(5, kaprekar.kaprekarRoutine(1121));
        assertEquals(7, kaprekar.kaprekarRoutine(1893));
    }
}