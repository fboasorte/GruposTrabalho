/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package io.github.fboasorte.grupostrabalho.endereco;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author felipe
 */
@Stateless
public class EnderecoBean implements EnderecoBeanLocal {

    @PersistenceContext(unitName = "GruposTrabalhoPU")
    private EntityManager entityManager;

    @Override
    public void save(Endereco pessoa) {
        entityManager.persist(pessoa);
    }

    @Override
    public Endereco find(Long id) {
        return entityManager.find(Endereco.class, id);
    }
}
