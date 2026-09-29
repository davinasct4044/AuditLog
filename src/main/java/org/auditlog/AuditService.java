package org.auditlog;

import java.util.ArrayList;

public class AuditService {
    private ArrayList<EventoAuditoria> listaDeEventos = new ArrayList<>();

    public void registrarEvento(EventoAuditoria eventoAuditoria) {
        listaDeEventos.add(eventoAuditoria);
    }

    public ArrayList<EventoAuditoria> listarEventos() {
        return listaDeEventos;
    }
    public ArrayList<EventoAuditoria> buscarEventosPorUsuario(String nome) {
        ArrayList<EventoAuditoria> buscalistaDeEventos = new ArrayList<>();
        for (EventoAuditoria i : listaDeEventos) {
            if (i.getUsuario().getNome().equals(nome)) {
                buscalistaDeEventos.add(i);
            }
        }
        return buscalistaDeEventos;
    }
    public ArrayList<EventoAuditoria> buscarEventosPorAcao(TipoAcao acao) {
        ArrayList<EventoAuditoria> buscalistaDeEventos = new ArrayList<>();
        for (EventoAuditoria i : listaDeEventos) {
            if (i.getAcao().equals(acao)) {
                buscalistaDeEventos.add(i);
            }
        }
        return buscalistaDeEventos;
    }
    public ArrayList<EventoAuditoria> buscarEventosPorRecurso(TipoRecurso recurso) {
        ArrayList<EventoAuditoria> buscalistaDeEventos = new ArrayList<>();
        for (EventoAuditoria i : listaDeEventos) {
            if (i.getRecurso().equals(recurso)) {
                buscalistaDeEventos.add(i);
            }
        }
        return buscalistaDeEventos;
    }
}
