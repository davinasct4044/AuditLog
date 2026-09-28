package org.auditlog;

public class Main {
    public static void main(String[] args) {
        Usuario davi = new Usuario("Davi", "199.199.188.199");
        EventoAuditoria evento = new EventoAuditoria(davi, TipoAcao.LOGIN, TipoRecurso.SISTEMA);
        System.out.println(evento);

    }
}
