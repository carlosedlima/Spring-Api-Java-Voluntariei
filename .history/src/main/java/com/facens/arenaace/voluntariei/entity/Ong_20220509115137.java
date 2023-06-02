package com.facens.arenaace.voluntariei.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ongs")
public class Ong {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String cnpj;
    @OneToMany(mappedBy="ong")
    private List<Evento> eventos;
    
    public Ong() {
    }

    public Ong(int id, String nome, String email, String senha, String cnpj, List<Evento> eventos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cnpj = cnpj;
        this.eventos = eventos;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    @Override
    public String toString() {
        return "Ong [cnpj=" + cnpj + ", email=" + email + ", eventos=" + eventos + ", id=" + id + ", nome=" + nome
                + ", senha=" + senha + "]";
    }
}
