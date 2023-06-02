package com.facens.arenaace.voluntariei.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OngDTO {
    private Integer id;
    private String nome;
    private String senha;
    private String email;
    private String cnpj;
}
