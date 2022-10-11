/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.fboasorte.grupostrabalho.grupo;

import io.github.fboasorte.grupostrabalho.pessoa.Pessoa;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author felipe
 */
@Entity
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(length = 65)
    private String nome;

    private Boolean ativo = true;

    @OneToMany(mappedBy = "endereco",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Atuacao> atuacoes;

    @OneToOne(fetch = FetchType.LAZY, // padrão
            cascade = CascadeType.ALL)
    @JoinColumn(name = "lider_id")
    private Pessoa lider;

    public Grupo() {
        atuacoes = new java.util.ArrayList<>();
    }

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    public void setAtuacoes(List<Atuacao> atuacoes) {
        this.atuacoes = atuacoes;
    }

    public Pessoa getLider() {
        return lider;
    }

    public void setLider(Pessoa lider) {
        this.lider = lider;
    }

//</editor-fold>
}
