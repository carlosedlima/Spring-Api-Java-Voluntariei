package com.facens.arenaace.voluntariei.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoDTO {
    private String nome;
    private String descricao;
    private Date data;
    private Integer ong;
}
