package fpmislata.aceptaElReto102;

import org.junit.jupiter.api.*; // Importar todas las anotaciones de JUnit
import static org.junit.jupiter.api.Assertions.*; // Importar todas las aserciones de JUnit

public class CaesarCipherTest {

    CaesarCipher caesarCipher;

    @BeforeEach
    void setUp() {
        caesarCipher = new CaesarCipher(2, "hola");
    }

    @Test
    @DisplayName("Testing constructor")
    void constructor() {

        assertEquals(2, caesarCipher.getDisplacement());
        assertEquals("hola", caesarCipher.getMessage());

    }

    @Test
    @DisplayName("Testing cipher method")
    void cipher() {

        assertAll(
                () -> assertEquals("jqnc", caesarCipher.cipher(2, "hola")),
                () -> assertEquals("fmjy", caesarCipher.cipher(-2, "hola")));
    }

    @Test
    @DisplayName("Testing other characters")
    void otherCharacters() {

        assertAll(
                () -> assertEquals("jqnc, ¿swé vcn?", caesarCipher.cipher(2, "hola, ¿qué tal?")),
                () -> assertEquals("fmjy, ¿osé ryj?", caesarCipher.cipher(-2, "hola, ¿qué tal?")));
    }
}