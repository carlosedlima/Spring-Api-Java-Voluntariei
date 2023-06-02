package com.facens.arenaace.voluntariei.controller;

import java.util.ArrayList;

import com.facens.arenaace.voluntariei.dto.OngDTO;
import com.facens.arenaace.voluntariei.entity.Ong;
import com.facens.arenaace.voluntariei.services.usecase.OngServiceUseCase;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ong")
public class OngController {
    private OngServiceUseCase ongService;

    public OngController(OngServiceUseCase ongService) {
        this.ongService = ongService;
    }

    @GetMapping("{email}/{senha}")
    public Boolean login(@PathVariable String email, @PathVariable String senha){
        return ongService.login(email, senha);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save (@RequestBody OngDTO dto){
        Ong ong = ongService.salvar(dto);
        return ong.getId();
    }

    @GetMapping("{id}")
    public OngDTO getById(@PathVariable Integer id){
        return ongService.obterOngsPorId(id);
    }

    @GetMapping
    public ArrayList<OngDTO>  getAll(){
        return ongService.obterOngs();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Integer id){
        ongService.remover(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void edit(@PathVariable Integer id, @RequestBody OngDTO dto){
        ongService.editar(id,dto);
    }
}