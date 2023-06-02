package com.facens.arenaace.voluntariei.repository;

import com.facens.arenaace.voluntariei.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Boolean findUsuarioByEmailAndSenhaLike (String email,String senha);
}
