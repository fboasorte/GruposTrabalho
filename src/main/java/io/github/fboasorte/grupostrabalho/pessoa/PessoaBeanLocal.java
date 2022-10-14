/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package io.github.fboasorte.grupostrabalho.pessoa;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author felipe
 */
@Local
public interface PessoaBeanLocal {

    public void save(Pessoa pessoa);

    //<editor-fold defaultstate="collapsed" desc="Questao 1">
    public List<Pessoa> findAllPessoaQuery();

    public List<Pessoa> findAllPessoaTyped();

    public List<Pessoa> findAllPessoaNamed();
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 2">
    public List<String> findNomePessoaQuery();

    public List<String> findNomePessoaTyped();

    public List<String> findNomePessoaNamed();
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 3">
    public List<Pessoa> findNomeEnderecoQuery();

    public List<Pessoa> findNomeEnderecoTyped();

    public List<Object[]> findNomeEnderecoNamed();
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 4">
    public List<Pessoa> findPessoaInAvenidaQuery();

    public List<Pessoa> findPessoaInAvenidaTyped();

    public List<Pessoa> findPessoaInAvenidaNamed();
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 5">
    public List<Pessoa> findPessoaNotPracaQuery();

    public List<Pessoa> findPessoaNotPracaTyped();

    public List<Pessoa> findPessoaNotPracaNamed();
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 6">
    public List<Object[]> findPessoaNomeTelefoneQuery();

    public List<Object[]> findPessoaNomeTelefoneTyped();

    public List<Object[]> findPessoaNomeTelefoneNamed();
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Questao 7">
    public List<Pessoa> findPessoaByDate(LocalDate dataInicio, LocalDate dataFim);

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Questao 8">
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Questao 9">
    public List<Pessoa> findPessoaTelefoneVazio();
//</editor-fold>
    
    public List<String> findQuantidadeTelefonesPorPessoa();
}
