/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.fboasorte.grupostrabalho.resources.grupo;

import io.github.fboasorte.grupostrabalho.resources.grupo.Grupo;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author felipe
 */
@Entity
public class Atuacao implements Serializable {
    @Id
    private Long id;
    
    private LocalDate inicio;
    
    private LocalDate termino;
    
    private Grupo grupo;
}
