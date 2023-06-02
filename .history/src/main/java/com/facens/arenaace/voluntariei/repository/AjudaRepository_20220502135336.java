package com.facens.arenaace.voluntariei.repository;

import com.facens.arenaace.voluntariei.entity.Ajuda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AjudaRepository extends JpaRepository<Ajuda,Integer> {
    
}
