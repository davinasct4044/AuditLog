package org.auditlog;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Usuario davi = new Usuario("Davi", "199.199.188.199");
        EventoAuditoria evento1 = new EventoAuditoria(davi, TipoAcao.LOGIN, TipoRecurso.PEDIDO);

        Usuario davi2 = new Usuario("Davi", "199.129.178.179");
        EventoAuditoria evento12 = new EventoAuditoria(davi, TipoAcao.LOGIN, TipoRecurso.SISTEMA);


        Usuario isaac = new Usuario("Isaac", "199.199.188.199");
        EventoAuditoria evento2 = new EventoAuditoria(isaac, TipoAcao.LOGIN, TipoRecurso.PEDIDO);

        Usuario geovanne = new Usuario("Geovanne", "199.199.188.199");
        EventoAuditoria evento3 = new EventoAuditoria(geovanne, TipoAcao.LOGOUT, TipoRecurso.SISTEMA);

        Usuario leonardo = new Usuario("Leonardo", "199.199.188.199");
        EventoAuditoria evento4 = new EventoAuditoria(leonardo, TipoAcao.LOGIN, TipoRecurso.PEDIDO);


        AuditService servico = new AuditService();
        servico.registrarEvento(evento1);
        servico.registrarEvento(evento2);
        servico.registrarEvento(evento3);
        servico.registrarEvento(evento4);
        servico.registrarEvento(evento12);

        List<EventoAuditoria> a = servico.buscarEventosPorRecurso(TipoRecurso.PEDIDO);
        System.out.println(a);

    }
}
