package com.facens.arenaace.voluntariei.services.usecase;

import java.util.ArrayList;

import com.facens.arenaace.voluntariei.dto.LoginDTO;
import com.facens.arenaace.voluntariei.dto.UsuarioDTO;
import com.facens.arenaace.voluntariei.entity.Usuario;

public interface UsuarioServiceUseCase {
    Usuario salvar(UsuarioDTO dto);
    UsuarioDTO obterUsuarioPorId(Integer id);
    void remover(Integer id);
    void editar(Integer id, UsuarioDTO dto);
    ArrayList<UsuarioDTO> obterUsuarios();
    Boolean login(LoginDTO loginDTO);
}