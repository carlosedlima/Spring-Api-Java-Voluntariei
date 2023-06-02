package com.facens.arenaace.voluntariei.controller;

import java.util.ArrayList;

import com.facens.arenaace.voluntariei.dto.LoginDTO;
import com.facens.arenaace.voluntariei.dto.UsuarioDTO;
import com.facens.arenaace.voluntariei.entity.Usuario;
import com.facens.arenaace.voluntariei.services.usecase.UsuarioServiceUseCase;

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
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioServiceUseCase usuarioService;

    public UsuarioController(UsuarioServiceUseCase usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public Boolean login(@RequestBody LoginDTO login){
        return usuarioService.login(login);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save (@RequestBody UsuarioDTO dto){
        Usuario usuario = usuarioService.salvar(dto);
        return usuario.getId();
    }

    @GetMapping("{id}")
    public UsuarioDTO getById(@PathVariable Integer id){
        return usuarioService.obterUsuarioPorId(id);
    }

    @GetMapping
    public ArrayList<UsuarioDTO>  getAll(){
        return usuarioService.obterUsuarios();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Integer id){
        usuarioService.remover(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void edit(@PathVariable Integer id, @RequestBody UsuarioDTO dto){
        usuarioService.editar(id,dto);
    }
}