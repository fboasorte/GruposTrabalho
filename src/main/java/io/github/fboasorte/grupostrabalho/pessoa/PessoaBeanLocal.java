/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package io.github.fboasorte.grupostrabalho.pessoa;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author felipe
 */
@Local
public interface PessoaBeanLocal {
    public void save(Pessoa pessoa);
    
    public List<Pessoa> findAllPessoaQuery();
    
    public List<Pessoa> findAllPessoaTyped();
    
    public List<Pessoa> findAllPessoaNamed();
}
