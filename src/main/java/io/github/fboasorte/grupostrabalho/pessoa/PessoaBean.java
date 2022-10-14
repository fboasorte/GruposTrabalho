/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package io.github.fboasorte.grupostrabalho.pessoa;

import java.time.LocalDate;
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

    //<editor-fold defaultstate="collapsed" desc="Questao 1">
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
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 2">
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
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 3">
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
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 4">
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
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 5">
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
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 6">
    @Override
    public List<Object[]> findPessoaNomeTelefoneQuery() {
        Query q = entityManager.createQuery(
                "SELECT p.nome, t FROM Pessoa p, IN (p.telefones) t");
        return (List<Object[]>) q.getResultList();
    }

    @Override
    public List<Object[]> findPessoaNomeTelefoneTyped() {
        TypedQuery q = entityManager.createQuery(
                "SELECT p.nome, t FROM Pessoa p, IN (p.telefones) t",
                Object[].class);
        return q.getResultList();
    }

    @Override
    public List<Object[]> findPessoaNomeTelefoneNamed() {
        return entityManager.createNamedQuery(
                "Pessoa.findPessoaNomeTelefone",
                Object[].class)
                .getResultList();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 7">
    public List<Pessoa> findPessoaByDate(LocalDate dataInicio, LocalDate dataFim) {
        Query q = entityManager.createQuery(
                "SELECT p FROM Pessoa p WHERE p.nascimento BETWEEN :dataInicio AND :dataFim")
                .setParameter("dataInicio", dataInicio)
                .setParameter("dataFim", dataFim);
        return (List<Pessoa>) q.getResultList();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 8">
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Questao 9">
    @Override
    public List<Pessoa> findPessoaTelefoneVazio() {
        Query q = entityManager.createQuery(
                "SELECT p FROM Pessoa p WHERE p.telefones IS EMPTY");
        return (List<Pessoa>) q.getResultList();
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Questao 10">
    @Override
    public List<String> findQuantidadeTelefonesPorPessoa() {
        return (List<String>) entityManager
                // "select c,count(c) from Conta c group by c.id"
                .createQuery("SELECT p.nome, count(t.id) FROM Pessoa p, IN (p.telefones) t GROUP BY p.nome")
                .getResultList();
    }
//</editor-fold>
}
