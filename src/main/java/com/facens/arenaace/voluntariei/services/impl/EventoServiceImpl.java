package com.facens.arenaace.voluntariei.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.facens.arenaace.voluntariei.dto.AjudaDTO;
import com.facens.arenaace.voluntariei.dto.EventoDTO;
import com.facens.arenaace.voluntariei.entity.Ajuda;
import com.facens.arenaace.voluntariei.entity.Evento;
import com.facens.arenaace.voluntariei.entity.Ong;
import com.facens.arenaace.voluntariei.exceptions.RegraNegocioException;
import com.facens.arenaace.voluntariei.repository.EventoRepository;
import com.facens.arenaace.voluntariei.repository.OngRepository;
import com.facens.arenaace.voluntariei.services.usecase.EventoServiceUseCase;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventoServiceImpl implements EventoServiceUseCase {

    private final EventoRepository eventoRepository;
    private final OngRepository ongRepository;

    @Override
    public Evento salvar(EventoDTO dto) {
        
        Ong ong  = ongRepository.findById(dto.getOng())
        .orElseThrow(()-> new RegraNegocioException("CODIGO DE ONG NÃO ENCONTRADO"));

        Evento evento = new Evento();
        
        evento.setNome(dto.getNome());
        evento.setDescricao(dto.getDescricao());
        evento.setData(dto.getData());
        evento.setOng(ong);


        return eventoRepository.save(evento);
    }

    @Override
    public EventoDTO obterEventoPorID(Integer id) {
        return  eventoRepository.findById(id).map(e -> EventoDTO
                .builder()
                .nome(e.getNome())
                .data(e.getData())
                .descricao(e.getDescricao())
                .ong(e.getOng().getId())
                .build()).orElseThrow(()-> new RegraNegocioException("Evento não encontrado"));
    }

    @Override
    public void remover(Integer id) {
        eventoRepository.deleteById(id);
    }

    @Override
    public void editar(Integer id, EventoDTO dto) {

    }

    @Override
    public ArrayList<EventoDTO> obterEventos() {
        ArrayList<EventoDTO> dados = new ArrayList<>();


        List<Evento> eventos = eventoRepository.findAll();
        eventos.forEach(e -> {
            dados.add(EventoDTO
                    .builder()
                    .nome(e.getNome())
                    .data(e.getData())
                    .descricao(e.getDescricao())
                    .ong(e.getOng().getId())
                    .build());
        });

        return dados;
    }
    
}
