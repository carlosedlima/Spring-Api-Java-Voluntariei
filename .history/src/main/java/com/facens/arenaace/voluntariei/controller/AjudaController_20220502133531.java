package com.facens.arenaace.voluntariei.controller;

import java.util.ArrayList;
import java.util.List;

import com.facens.arenaace.voluntariei.dto.AjudaDTO;
import com.facens.arenaace.voluntariei.entity.Ajuda;
import com.facens.arenaace.voluntariei.repository.AjudaRepository;
import com.facens.arenaace.voluntariei.services.usecase.AjudaServiceUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ajuda")
public class AjudaController {
    

    private AjudaServiceUseCase ajudaServiceUseCase;
    
    public AjudaController(AjudaServiceUseCase ajudaServiceUseCase) {
        this.ajudaServiceUseCase = ajudaServiceUseCase;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<AjudaDTO> find(){
        return ajudaServiceUseCase.obtertodas();
    }

}
