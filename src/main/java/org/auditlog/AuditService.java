package org.auditlog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuditService {
    private List<EventoAuditoria> listaDeEventos = new ArrayList<>();

    public void registrarEvento(EventoAuditoria eventoAuditoria) {
        if (eventoAuditoria == null) {
            throw new IllegalArgumentException("é necessário ter um evento válido");
        }

        listaDeEventos.add(eventoAuditoria);
    }

    public List<EventoAuditoria> listarEventos() {
        return Collections.unmodifiableList(listaDeEventos);
    }

    public List<EventoAuditoria> buscarEventosPorUsuario(String nome) {
        ArrayList<EventoAuditoria> buscalistaDeEventos = new ArrayList<>();
        for (EventoAuditoria i : listaDeEventos) {
            if (i.getUsuario().getNome().equals(nome)) {
                buscalistaDeEventos.add(i);
            }
        }
        return buscalistaDeEventos;
    }

    public List<EventoAuditoria> buscarEventosPorAcao(TipoAcao acao) {
        ArrayList<EventoAuditoria> buscalistaDeEventos = new ArrayList<>();
        for (EventoAuditoria i : listaDeEventos) {
            if (i.getAcao() == acao) {
                buscalistaDeEventos.add(i);
            }
        }
        return buscalistaDeEventos;
    }

    public List<EventoAuditoria> buscarEventosPorRecurso(TipoRecurso recurso) {
        ArrayList<EventoAuditoria> buscalistaDeEventos = new ArrayList<>();
        for (EventoAuditoria i : listaDeEventos) {
            if (i.getRecurso() == recurso) {
                buscalistaDeEventos.add(i);
            }
        }
        return buscalistaDeEventos;
    }
}
