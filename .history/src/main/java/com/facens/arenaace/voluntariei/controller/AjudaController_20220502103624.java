package com.facens.arenaace.voluntariei.controller;

import java.util.List;

import com.facens.arenaace.voluntariei.entity.Ajuda;
import com.facens.arenaace.voluntariei.repository.AjudaRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ajuda")
public class AjudaController {

    private AjudaRepository ajudaRepository;

    public AjudaController(AjudaRepository ajudaRepository) {
        this.ajudaRepository = ajudaRepository;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Ajuda> find(){
        return ajudaRepository.findAll();
    }

}
