package org.auditlog;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class EventoAuditoria {
    private Usuario usuario;
    private TipoAcao acao;
    private TipoRecurso recurso;
    private LocalDateTime data = LocalDateTime.now();

    public EventoAuditoria(Usuario usuario, TipoAcao acao, TipoRecurso recurso) {
        this.usuario = usuario;
        this.acao = acao;
        this.recurso = recurso;
    }

    @Override
    public String toString() {
        return "Evento de Auditoria\n"
                + "-------------------\n"
                + "Usuário: " + usuario + "\n"
                + "Ação: " + acao + "\n"
                + "Recurso: " + recurso + "\n"
                + "Data: " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss:SS"));
    }

}
