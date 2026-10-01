package org.auditlog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UsuarioTest {

    @Test
    void deveAceitarIpValido() {
        assertDoesNotThrow(() -> {
            new Usuario("Davi", "192.168.0.1");
        });
    }

    @Test
    void deveRejeitarIpInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("Davi", "256.168.0.1");
        });
    }
}