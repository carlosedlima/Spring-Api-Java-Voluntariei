package com.facens.arenaace.voluntariei.controller;

import java.util.ArrayList;

import com.facens.arenaace.voluntariei.dto.AjudaDTO;
import com.facens.arenaace.voluntariei.services.usecase.AjudaServiceUseCase;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ajudas")
public class AjudaController {
    

    private AjudaServiceUseCase ajudaServiceUseCase;
    
    public AjudaController(AjudaServiceUseCase ajudaServiceUseCase) {
        this.ajudaServiceUseCase = ajudaServiceUseCase;
    }

    @GetMapping
    public ArrayList<AjudaDTO> getAll(){
        return ajudaServiceUseCase.obtertodas();
    }

}
