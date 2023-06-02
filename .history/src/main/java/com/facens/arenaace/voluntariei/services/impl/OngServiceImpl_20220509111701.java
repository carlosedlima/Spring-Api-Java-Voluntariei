package com.facens.arenaace.voluntariei.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.facens.arenaace.voluntariei.dto.LoginDTO;
import com.facens.arenaace.voluntariei.dto.OngDTO;
import com.facens.arenaace.voluntariei.dto.ResponseDTO;
import com.facens.arenaace.voluntariei.entity.Ong;
import com.facens.arenaace.voluntariei.exceptions.RegraNegocioException;
import com.facens.arenaace.voluntariei.repository.OngRepository;
import com.facens.arenaace.voluntariei.services.usecase.OngServiceUseCase;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OngServiceImpl implements OngServiceUseCase {
    private final OngRepository ongRepository;

    @Override
    @Transactional
    public Ong salvar(OngDTO dto) {

        Ong ong = new Ong();
        ong.setEmail(dto.getEmail());
        ong.setNome(dto.getNome());
        ong.setSenha(dto.getSenha());
        ong.setCnpj(dto.getCnpj());

        return ongRepository.save(ong);
    }

    @Override
    public OngDTO obterOngsPorId(Integer id) {
        return ongRepository.findById(id).map(u -> {
            return OngDTO
                    .builder()
                    .email(u.getEmail())
                    .nome(u.getNome())
                    .cnpj(u.getCnpj())
                    .build();
        })
                .orElseThrow(() -> new RegraNegocioException("Ong não encontrado"));
    }

    @Override
    @Transactional
    public void remover(Integer id) {
        ongRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void editar(Integer id, OngDTO dto) {
        Ong ong = ongRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Ong não encontrado"));

        ong.setEmail(dto.getEmail());
        ong.setNome(dto.getNome());
        ong.setSenha(dto.getSenha());
        ong.setCnpj(dto.getCnpj());

        ongRepository.save(ong);

    }

    @Override
    public ArrayList<OngDTO> obterOngs() {
        ArrayList<OngDTO> dados = new ArrayList<>();

        List<Ong> ongs = ongRepository.findAll();
        ongs.forEach(u -> {
            dados.add(
                    OngDTO
                            .builder()
                            .email(u.getEmail())
                            .nome(u.getNome())
                            .cnpj(u.getCnpj())
                            .build());
        });
        return dados;
    }

    @Override
    public ResponseDTO login(LoginDTO login) {
        String email = login.getEmail();
        String senha = login.getSenha();
        
        List<Ong> ongs = ongRepository.findAll();

        for(Ong o: ongs){
            if(o.getEmail().equals(email) && o.getSenha().equals(senha)){
                ResponseDTO responseDTO = new ResponseDTO();
                responseDTO.setResposta("OK");
                return responseDTO;
            }
        }
        
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResposta("FAIL");
        return responseDTO;
    }
}
