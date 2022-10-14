/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package io.github.fboasorte.grupostrabalho.pessoa;

import io.github.fboasorte.grupostrabalho.dto.MembroDto;
import io.github.fboasorte.grupostrabalho.grupo.Grupo;
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

    //<editor-fold defaultstate="collapsed" desc="Questao 11">
    @Override
    public List<Grupo> findGruposInativos() {
        return (List<Grupo>) entityManager
                .createQuery("SELECT g FROM Grupo g WHERE g.ativo = false")
                .getResultList();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 12">
    @Override
    public List<String[]> findLideresGrupos() {
        return (List<String[]>) entityManager
                .createQuery("SELECT g.nome, g.lider.nome FROM Grupo g")
                .getResultList();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 13">
    @Override
    public List<String> findMembrosGrupo(String nomeGrupo) {
        String query = "SELECT a.pessoa.nome FROM Atuacao a WHERE a.grupo.nome = :nomeGrupo ORDER BY a.pessoa.nome DESC";
        return (List<String>) entityManager
                .createQuery(query)
                .setParameter("nomeGrupo", nomeGrupo)
                .getResultList();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 14">
    @Override
    public List<Grupo> findGruposPorLider(String nomeLider) {
        String query = "SELECT g FROM Pessoa p, IN (p.grupos) g WHERE p.nome = :nomeLider";
        return (List<Grupo>) entityManager
                .createQuery(query)
                .setParameter("nomeLider", nomeLider)
                .getResultList();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 15">
    @Override
    public List<Object[]> findDatasAtuacaoGrupo(String nomeMembro) {
        String query = "SELECT g.nome, a.inicio, a.termino FROM Grupo g, IN (g.atuacoes) a WHERE a.pessoa.nome = :nomeMembro";
        return (List<Object[]>) entityManager
                .createQuery(query)
                .setParameter("nomeMembro", nomeMembro)
                .getResultList();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 16">
    @Override
    public List<Grupo> findGrupoByNome(String nomeGrupo) {
        String query = "SELECT g FROM Grupo g WHERE g.nome LIKE :nomeGrupo";
        return (List<Grupo>) entityManager
                .createQuery(query)
                .setParameter("nomeGrupo", '%' + nomeGrupo + '%')
                .getResultList();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 17">
    @Override
    public List<Object[]> findNomeGrupoQuantidadeMembros() {
        String query = "SELECT g.nome, COUNT(DISTINCT a.pessoa.id) FROM Grupo g, IN (g.atuacoes) a GROUP BY g.nome";
        return (List<Object[]>) entityManager
                .createQuery(query)
                .getResultList();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 18">
    @Override
    public List<Object[]> findNomeGrupoPorTotalAtuacoes(Long total) {
        String query = "SELECT g.nome, COUNT(a.id) FROM Grupo g, IN (g.atuacoes) a GROUP BY g.nome HAVING COUNT(a.id) >= :total";
        return (List<Object[]>) entityManager
                .createQuery(query)
                .setParameter("total", total)
                .getResultList();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 19">
    @Override
    public List<String> findNomePessoaPorDataEntradaEmGrupo(Long grupoId, LocalDate dataInicio) {
        String query = "SELECT DISTINCT a.pessoa.nome FROM Atuacao a WHERE a.grupo.id = :grupoId AND a.inicio >= :dataInicio";
        return (List<String>) entityManager
                .createQuery(query)
                .setParameter("grupoId", grupoId)
                .setParameter("dataInicio", dataInicio)
                .getResultList();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 20">
    @Override
    public List<MembroDto> findMembroDto(LocalDate dataInicio) {
        String query = "SELECT new io.github.fboasorte.grupostrabalho.dto.MembroDto(a.grupo.nome, a.inicio, a.pessoa.nome) FROM Atuacao a WHERE a.inicio >= :dataInicio";
        return (List<MembroDto>) entityManager
                .createQuery(query)
                .setParameter("dataInicio", dataInicio)
                .getResultList();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 21">
    @Override
    public List<String[]> findGruposEPessoaSemDataTermino() {
        String query = "SELECT a.grupo.nome, a.pessoa.nome FROM Atuacao a WHERE a.termino IS NULL";
        return (List<String[]>) entityManager
                .createQuery(query)
                .getResultList();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 22">
    @Override
    public List<String[]> findLiderMembrosGrupos() {
        String query = "SELECT g.nome, g.lider.nome, p.nome FROM Atuacao a JOIN a.grupo g JOIN a.pessoa p ORDER BY g.nome, g.lider.nome, p.nome";
        return (List<String[]>) entityManager
                .createQuery(query)
                .getResultList();

    }
//</editor-fold>
}
