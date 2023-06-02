package com.facens.arenaace.voluntariei.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AjudaDTO {
    private String titulo;
    private String descricao;
}
