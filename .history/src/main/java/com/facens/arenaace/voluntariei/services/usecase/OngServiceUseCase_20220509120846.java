package com.facens.arenaace.voluntariei.services.usecase;

import java.util.ArrayList;

import com.facens.arenaace.voluntariei.dto.LoginDTO;
import com.facens.arenaace.voluntariei.dto.OngDTO;
import com.facens.arenaace.voluntariei.dto.ResponseDTO;
import com.facens.arenaace.voluntariei.entity.Ong;

public interface OngServiceUseCase {
    Ong salvar(OngDTO dto);
    OngDTO obterOngsPorId(Integer id);
    void remover(Integer id);
    void editar(Integer id, OngDTO dto);
    ArrayList<OngDTO> obterOngs();
    String login(LoginDTO loginDTO);
}
