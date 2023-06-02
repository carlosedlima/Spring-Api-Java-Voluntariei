
package com.facens.arenaace.voluntariei.services.impl;
import java.util.ArrayList;
import java.util.List;

import com.facens.arenaace.voluntariei.dto.AjudaDTO;
import com.facens.arenaace.voluntariei.entity.Ajuda;
import com.facens.arenaace.voluntariei.repository.AjudaRepository;
import com.facens.arenaace.voluntariei.services.usecase.AjudaServiceUseCase;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AjudaServiceImpl implements AjudaServiceUseCase {
    
    private final AjudaRepository ajudaRepository;
    

    @Override
    public ArrayList<AjudaDTO> obtertodas() {
       ArrayList<AjudaDTO> dados = new ArrayList<>();
    
    
       List<Ajuda> ajudas = ajudaRepository.findAll();
       ajudas.forEach(a -> {
           dados.add(AjudaDTO
           .builder()
           .titulo(a.getTitulo())
           .descricao(a.getDescricao())
           .build());
       });

       return dados;
    }
    
}
