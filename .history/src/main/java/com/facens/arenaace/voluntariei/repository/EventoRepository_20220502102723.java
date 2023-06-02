package com.facens.arenaace.voluntariei.repository;

import com.facens.arenaace.voluntariei.entity.Evento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento,Integer> {
    
}
