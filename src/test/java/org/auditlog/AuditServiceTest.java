package org.auditlog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class    AuditServiceTest {
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

    @Test
    void deveRejeitarUsuarioNulo() {

        assertThrows(IllegalArgumentException.class, () -> {
                    EventoAuditoria evento = new EventoAuditoria(null, TipoAcao.LOGIN, TipoRecurso.SISTEMA);
                }
        );

    }

    @Test
    void deveRejeitarAcaoNula() {
        Usuario usuario = new Usuario("Felipe", "199.199.188.177");

        assertThrows(IllegalArgumentException.class, () -> {
                    EventoAuditoria evento = new EventoAuditoria(usuario, null, TipoRecurso.SISTEMA);
                }
        );

    }

    @Test
    void deveRejeitarRecursoNulo() {
        Usuario usuario = new Usuario("Felipe", "199.199.188.177");

        assertThrows(IllegalArgumentException.class, () -> {
                    EventoAuditoria evento = new EventoAuditoria(usuario, TipoAcao.LOGIN, null);
                }
        );

    }

    @Test
    void deveBuscarEventosPorUsuario() {
        Usuario exemplo1 = new Usuario("Exemplo1", "199.199.188.177");
        Usuario exemplo2 = new Usuario("Exemplo2", "199.199.188.177");
        Usuario exemplo3 = new Usuario("Exemplo3", "199.199.188.177"); // <--- deve retornar esse e o de baixo.
        Usuario exemplo4 = new Usuario("Exemplo3", "199.199.188.177"); // <---


        EventoAuditoria evento1 = new EventoAuditoria(exemplo1,TipoAcao.LOGIN, TipoRecurso.PRODUTO);
        EventoAuditoria evento2 = new EventoAuditoria(exemplo2, TipoAcao.LOGIN, TipoRecurso.PRODUTO);
        EventoAuditoria evento3 = new EventoAuditoria(exemplo3, TipoAcao.LOGOUT, TipoRecurso.PRODUTO);
        EventoAuditoria evento4 = new EventoAuditoria(exemplo4, TipoAcao.LOGOUT, TipoRecurso.PRODUTO);

        AuditService servico = new AuditService();

        servico.registrarEvento(evento1);
        servico.registrarEvento(evento2);
        servico.registrarEvento(evento3);
        servico.registrarEvento(evento4);

        assertEquals(2, servico.buscarEventosPorUsuario("Exemplo3").size());

    }

    @Test
    void deveBuscarEventosPorAcao() {
        Usuario exemplo1 = new Usuario("Exemplo1", "199.199.188.177");
        Usuario exemplo2 = new Usuario("Exemplo2", "199.199.188.177");
        Usuario exemplo3 = new Usuario("Exemplo3", "199.199.188.177");
        Usuario exemplo4 = new Usuario("Exemplo3", "199.199.188.177");


        EventoAuditoria evento1 = new EventoAuditoria(exemplo1,TipoAcao.LOGIN, TipoRecurso.PRODUTO);
        EventoAuditoria evento2 = new EventoAuditoria(exemplo2, TipoAcao.LOGIN, TipoRecurso.PRODUTO);
        EventoAuditoria evento3 = new EventoAuditoria(exemplo3, TipoAcao.LOGOUT, TipoRecurso.PRODUTO);// <---
        EventoAuditoria evento4 = new EventoAuditoria(exemplo4, TipoAcao.LOGOUT, TipoRecurso.PRODUTO);// <---

        AuditService servico = new AuditService();

        servico.registrarEvento(evento1);
        servico.registrarEvento(evento2);
        servico.registrarEvento(evento3);
        servico.registrarEvento(evento4);

        assertEquals(2, servico.buscarEventosPorAcao(TipoAcao.LOGOUT).size());

    }

    @Test
    void deveBuscarEventosPorRecurso() {
        Usuario exemplo1 = new Usuario("Exemplo1", "199.199.188.177");
        Usuario exemplo2 = new Usuario("Exemplo2", "199.199.188.177");
        Usuario exemplo3 = new Usuario("Exemplo3", "199.199.188.177");
        Usuario exemplo4 = new Usuario("Exemplo3", "199.199.188.177");


        EventoAuditoria evento1 = new EventoAuditoria(exemplo1,TipoAcao.LOGIN, TipoRecurso.PRODUTO);// <---
        EventoAuditoria evento2 = new EventoAuditoria(exemplo2, TipoAcao.LOGIN, TipoRecurso.PRODUTO);// <---
        EventoAuditoria evento3 = new EventoAuditoria(exemplo3, TipoAcao.LOGOUT, TipoRecurso.PRODUTO);// <---
        EventoAuditoria evento4 = new EventoAuditoria(exemplo4, TipoAcao.LOGOUT, TipoRecurso.PRODUTO);// <---

        AuditService servico = new AuditService();

        servico.registrarEvento(evento1);
        servico.registrarEvento(evento2);
        servico.registrarEvento(evento3);
        servico.registrarEvento(evento4);

        assertEquals(4, servico.buscarEventosPorRecurso(TipoRecurso.PRODUTO).size());

    }

    @Test
    void deveImpedirAlteracaoDaListaDeEventos() {
        Usuario usuario = new Usuario("Davi", "192.168.0.1");
        EventoAuditoria evento = new EventoAuditoria(
                usuario,
                TipoAcao.LOGIN,
                TipoRecurso.SISTEMA
        );

        AuditService servico = new AuditService();
        servico.registrarEvento(evento);

        assertThrows(UnsupportedOperationException.class, () -> {
            servico.listarEventos().clear();
        });
    }

    @Test
    void eventoDevePossuirData() {
        Usuario usuario = new Usuario("Davi", "192.168.0.1");

        EventoAuditoria evento = new EventoAuditoria(
                usuario,
                TipoAcao.LOGIN,
                TipoRecurso.SISTEMA
        );

        assertNotNull(evento.getData());
    }
}
