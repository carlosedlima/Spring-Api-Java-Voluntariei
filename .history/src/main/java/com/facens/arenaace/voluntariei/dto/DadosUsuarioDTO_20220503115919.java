package com.facens.arenaace.voluntariei.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosUsuarioDTO {
    private String nome;
    private String email;
    private String cpf;
}
