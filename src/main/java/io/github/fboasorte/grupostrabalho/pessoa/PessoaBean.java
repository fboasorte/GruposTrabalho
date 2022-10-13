/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package io.github.fboasorte.grupostrabalho.pessoa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author felipe
 */
@Stateless
public class PessoaBean implements PessoaBeanLocal {

    @PersistenceContext(unitName = "GruposTrabalhoPU")
    private EntityManager entityManager;

    @Override
    public void save(Pessoa pessoa) {
        entityManager.persist(pessoa);
    }

    @Override
    public List<Pessoa> findAllPessoaQuery() {
        Query q = entityManager.createQuery(
                "SELECT p FROM Pessoa p");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> findAllPessoaTyped() {
        TypedQuery q = entityManager.createQuery(
                "SELECT p FROM Pessoa p",
                Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> findAllPessoaNamed() {
        return entityManager.createNamedQuery(
                "Pessoa.findAll",
                Pessoa.class)
                .getResultList();
    }
    
    @Override
    public List<String> findNomePessoaQuery() {
        Query q = entityManager.createQuery(
                "SELECT p.nome FROM Pessoa p");
        return (List<String>) q.getResultList();
    }
    
    @Override
    public List<String> findNomePessoaTyped() {
        TypedQuery q = entityManager.createQuery(
                "SELECT p.nome FROM Pessoa p",
                String.class);
        return q.getResultList();
    }
    
    @Override
    public List<String> findNomePessoaNamed() {
        return entityManager.createNamedQuery(
                "Pessoa.findNome",
                String.class)
                .getResultList();
    }
    
    @Override
    public List<Pessoa> findNomeEnderecoQuery() {
        Query q = entityManager.createQuery(
                "SELECT p.nome, p.endereco FROM Pessoa p");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> findNomeEnderecoTyped() {
        TypedQuery q = entityManager.createQuery(
                "SELECT p.nome, p.endereco FROM Pessoa p",
                Object[].class);
        return q.getResultList();
    }

    @Override
    public List<Object[]> findNomeEnderecoNamed() {
        return entityManager.createNamedQuery(
                "Pessoa.findNomeEndereco",
                Object[].class)
                .getResultList();
    }
    
    @Override
    public List<Pessoa> findPessoaInAvenidaQuery() {
        Query q = entityManager.createQuery(
                "SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro = 1");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> findPessoaInAvenidaTyped() {
        TypedQuery q = entityManager.createQuery(
                "SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro = 1",
                Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> findPessoaInAvenidaNamed() {
        return entityManager.createNamedQuery(
                "Pessoa.findPessoaInAvenida",
                Pessoa.class)
                .getResultList();
    }
    
    @Override
    public List<Pessoa> findPessoaNotPracaQuery() {
        Query q = entityManager.createQuery(
                "SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro != 2");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> findPessoaNotPracaTyped() {
        TypedQuery q = entityManager.createQuery(
                "SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro != 2",
                Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> findPessoaNotPracaNamed() {
        return entityManager.createNamedQuery(
                "Pessoa.findPessoaNotPraca",
                Pessoa.class)
                .getResultList();
    }
}
