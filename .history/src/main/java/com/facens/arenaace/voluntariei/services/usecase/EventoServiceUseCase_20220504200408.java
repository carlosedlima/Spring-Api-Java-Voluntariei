package com.facens.arenaace.voluntariei.services.usecase;

import java.util.ArrayList;

import com.facens.arenaace.voluntariei.dto.EventoDTO;
import com.facens.arenaace.voluntariei.entity.Evento;

public interface EventoServiceUseCase {
    Evento salvar(EventoDTO dto);
    EventoDTO obterEventoPorID(Integer id);
    void remover(Integer id);
    void editar(Integer id, EventoDTO dto);
    ArrayList<EventoDTO> obterEventos();
}

