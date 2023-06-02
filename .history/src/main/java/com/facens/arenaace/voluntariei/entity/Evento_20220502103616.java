package com.facens.arenaace.voluntariei.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    private String nome;
    private String descricao;
    private Date data;
    @ManyToOne
    @JoinColumn(name = "ong_id")
    private Ong ong;

    public Evento(int id, String nome, String descricao, Date data, Ong ong) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.ong = ong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Ong getOng() {
        return ong;
    }

    public void setOng(Ong ong) {
        this.ong = ong;
    }

    @Override
    public String toString() {
        return "Evento [data=" + data + ", descricao=" + descricao + ", id=" + id + ", nome=" + nome + ", ong=" + ong
                + "]";
    }

    
}
