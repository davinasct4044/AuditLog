package org.auditlog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AuditServiceTest {
    @Test
    void deveRegistrarEvento() {
        Usuario usuario = new Usuario("Geovanne", "193.123.200.199");
        EventoAuditoria evento1 = new EventoAuditoria(usuario, TipoAcao.LOGIN, TipoRecurso.PEDIDO);

        AuditService servico = new AuditService();

        servico.registrarEvento(evento1);

        assertEquals(1, servico.listarEventos().size());

    }

    @Test
    void deveRejeitarEventoNulo() {
        AuditService servico = new AuditService();

        assertThrows(IllegalArgumentException.class, () -> {
            servico.registrarEvento(null);
        }

        );

    }
}
