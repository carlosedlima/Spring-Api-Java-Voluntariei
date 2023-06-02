package com.facens.arenaace.voluntariei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ajuda")
public class Ajuda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    private String tiutlo;
    private String descricao;

    public Ajuda(int id, String tiutlo, String descricao) {
        this.id = id;
        this.tiutlo = tiutlo;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTiutlo() {
        return tiutlo;
    }

    public void setTiutlo(String tiutlo) {
        this.tiutlo = tiutlo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
