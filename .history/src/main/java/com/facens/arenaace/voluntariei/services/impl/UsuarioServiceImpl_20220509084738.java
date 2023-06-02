package com.facens.arenaace.voluntariei.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.facens.arenaace.voluntariei.dto.LoginDTO;
import com.facens.arenaace.voluntariei.dto.LoginResponseDTO;
import com.facens.arenaace.voluntariei.dto.UsuarioDTO;
import com.facens.arenaace.voluntariei.entity.Usuario;
import com.facens.arenaace.voluntariei.exceptions.RegraNegocioException;
import com.facens.arenaace.voluntariei.repository.UsuarioRepository;
import com.facens.arenaace.voluntariei.services.usecase.UsuarioServiceUseCase;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioServiceUseCase {

    private final UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public Usuario salvar(UsuarioDTO dto) {

        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setNome(dto.getNome());
        usuario.setSenha(dto.getSenha());
        usuario.setCpf(dto.getCpf());

        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioDTO obterUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id).map(u -> {
            return UsuarioDTO
                    .builder()
                    .email(u.getEmail())
                    .nome(u.getNome())
                    .cpf(u.getCpf())
                    .build();
        })
                .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado"));
    }

    @Override
    @Transactional
    public void remover(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void editar(Integer id, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado"));

        usuario.setEmail(dto.getEmail());
        usuario.setNome(dto.getNome());
        usuario.setSenha(dto.getSenha());
        usuario.setCpf(dto.getCpf());

        usuarioRepository.save(usuario);

    }

    @Override
    public ArrayList<UsuarioDTO> obterUsuarios() {
        ArrayList<UsuarioDTO> dados = new ArrayList<>();

        List<Usuario> usuarios = usuarioRepository.findAll();
        usuarios.forEach(u -> {
            dados.add(
                    UsuarioDTO
                            .builder()
                            .email(u.getEmail())
                            .nome(u.getNome())
                            .cpf(u.getCpf())
                            .build());
        });
        return dados;
    }

    @Override
    public String login(LoginDTO login) {
        String email = login.getEmail();
        String senha = login.getSenha();

        List<Usuario> usuarios = usuarioRepository.findAll();

        for(Usuario u:usuarios){
            if(u.getEmail().equals(email) && u.getSenha().equals(senha)){
                return "OK";
            }
        }
        
        return "FAIL";
    }
}
