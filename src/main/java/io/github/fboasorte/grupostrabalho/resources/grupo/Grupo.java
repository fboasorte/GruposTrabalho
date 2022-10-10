/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.fboasorte.grupostrabalho.resources.grupo;

import io.github.fboasorte.grupostrabalho.resources.pessoa.Pessoa;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author felipe
 */

@Entity
public class Grupo implements Serializable {
    @Id
    private Long id;
    
    @Column(length = 65)
    private String nome;
    
    private Boolean ativo = true;
    
    @OneToOne
    private Pessoa lider;
}
