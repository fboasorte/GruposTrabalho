/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package io.github.fboasorte.grupostrabalho;

import io.github.fboasorte.grupostrabalho.dto.MembroDto;
import io.github.fboasorte.grupostrabalho.grupo.Grupo;
import io.github.fboasorte.grupostrabalho.pessoa.PessoaBeanLocal;
import io.github.fboasorte.grupostrabalho.pessoa.Pessoa;
import io.github.fboasorte.grupostrabalho.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

/**
 *
 * @author felipe
 */
@Transactional
@WebServlet(name = "Relatorios", urlPatterns = {"/Relatorios"})
public class RelatoriosServlet extends HttpServlet {

    @Inject
    private PessoaBeanLocal pessoaBean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RelatoriosServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Consultas</h1>");

            //<editor-fold defaultstate="collapsed" desc="Questao 1">
            List<Pessoa> pessoasTodasQuery = pessoaBean.findAllPessoaQuery();
            out.println(Util.formatarImprimir("1-a) Quais as pessoas (dados completos) cadastradas?", pessoasTodasQuery));

            List<Pessoa> pessoasTodasTyped = pessoaBean.findAllPessoaTyped();
            out.println(Util.formatarImprimir("1-b) Quais as pessoas (dados completos) cadastradas?", pessoasTodasTyped));

            List<Pessoa> pessoasTodasNamed = pessoaBean.findAllPessoaNamed();
            out.println(Util.formatarImprimir("1-c) Quais as pessoas (dados completos) cadastradas?", pessoasTodasNamed));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 2">
            List<String> nomesPessoasQuery = pessoaBean.findNomePessoaQuery();
            out.println(Util.formatarImprimir("2-a) Quais os nomes das pessoas?", nomesPessoasQuery));

            List<String> nomesPessoasTyped = pessoaBean.findNomePessoaTyped();
            out.println(Util.formatarImprimir("2-b) Quais os nomes das pessoas?", nomesPessoasTyped));

            List<String> nomesPessoasNamed = pessoaBean.findNomePessoaNamed();
            out.println(Util.formatarImprimir("2-c) Quais os nomes das pessoas?", nomesPessoasNamed));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 3">
            List<Pessoa> pessoasNomeEnderecoQuery = pessoaBean.findNomeEnderecoQuery();
            out.println(Util.formatarImprimir("3-a) Quais as pessoas (nome) e seus respectivos endere??os (dados completos)?", pessoasNomeEnderecoQuery));

            List<Pessoa> pessoasNomeEnderecoTyped = pessoaBean.findNomeEnderecoTyped();
            out.println(Util.formatarImprimir("3-b) Quais as pessoas (nome) e seus respectivos endere??os (dados completos)?", pessoasNomeEnderecoTyped));

            List<Object[]> pessoasNomeEnderecoNamed = pessoaBean.findNomeEnderecoNamed();
            out.println(Util.formatarImprimir("3-c) Quais as pessoas (nome) e seus respectivos endere??os (dados completos)?", pessoasNomeEnderecoNamed));
//            
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 4">
            List<Pessoa> pessoasInAvendaQuery = pessoaBean.findPessoaInAvenidaQuery();
            out.println(Util.formatarImprimir("4-a) Quais pessoas (dados completos) moram em avenidas?", pessoasInAvendaQuery));

            List<Pessoa> pessoasInAvendaTyped = pessoaBean.findPessoaInAvenidaTyped();
            out.println(Util.formatarImprimir("4-b) Quais as pessoas (dados completos) cadastradas?", pessoasInAvendaTyped));

            List<Pessoa> pessoasInAvendaNamed = pessoaBean.findPessoaInAvenidaNamed();
            out.println(Util.formatarImprimir("4-c) Quais as pessoas (dados completos) cadastradas?", pessoasInAvendaNamed));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 5">
            List<Pessoa> pessoasNotPracaQuery = pessoaBean.findPessoaNotPracaQuery();
            out.println(Util.formatarImprimir("5-a) Quais pessoas (dados completos) n??o moram em pra??as?", pessoasNotPracaQuery));

            List<Pessoa> pessoasNotPracaTyped = pessoaBean.findPessoaNotPracaTyped();
            out.println(Util.formatarImprimir("5-b) Quais as pessoas (dados completos) cadastradas?", pessoasNotPracaTyped));

            List<Pessoa> pessoasNotPracaNamed = pessoaBean.findPessoaNotPracaNamed();
            out.println(Util.formatarImprimir("5-c) Quais as pessoas (dados completos) cadastradas?", pessoasNotPracaNamed));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 6">
            List<Object[]> pessoaNomeTelefoneQuery = pessoaBean.findPessoaNomeTelefoneQuery();
            out.println(Util.formatarImprimir("6-a) Quais pessoas (nomes) e seus respectivos telefones (dados completos)?", pessoaNomeTelefoneQuery));

            List<Object[]> pessoaNomeTelefoneTyped = pessoaBean.findPessoaNomeTelefoneTyped();
            out.println(Util.formatarImprimir("6-b) Quais pessoas (nomes) e seus respectivos telefones (dados completos)?", pessoaNomeTelefoneTyped));

            List<Object[]> pessoaNomeTelefoneNamed = pessoaBean.findPessoaNomeTelefoneNamed();
            out.println(Util.formatarImprimir("6-c) Quais pessoas (nomes) e seus respectivos telefones (dados completos)?", pessoaNomeTelefoneNamed));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 7">
            List<Pessoa> pessoasPorData = pessoaBean.findPessoaByDate(
                    LocalDate.of(2001, Month.APRIL, 1),
                    LocalDate.of(2004, Month.APRIL, 30));

            out.println(Util.formatarImprimir("7) Quais as pessoas (dados completos) que nasceram entre abril de 2001 e abril de 2004?",
                    pessoasPorData));

//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 8">
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 9">
            List<Pessoa> pessoasTelefoneVazio = pessoaBean.findPessoaTelefoneVazio();

            out.println(Util.formatarImprimir("9) Quais pessoas (dados completos) n??o possuem telefone?",
                    pessoasTelefoneVazio));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 10">
            List<String> telefonesPorPessoa = pessoaBean.findQuantidadeTelefonesPorPessoa();

            out.println(Util.formatarImprimir("10) Quantos telefones cada pessoa (nome) tem?",
                    telefonesPorPessoa));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 11">
            List<Grupo> gruposInativos = pessoaBean.findGruposInativos();

            out.println(Util.formatarImprimir("11) Quais grupos (dados completos) n??o est??o ativos?",
                    gruposInativos));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 12">
            List<String[]> lideresGrupos = pessoaBean.findLideresGrupos();

            out.println(Util.formatarImprimir("12) Quais s??o os l??deres (nomes) dos grupos (nomes)?",
                    lideresGrupos));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 13">
            List<String> membrosGrupo = pessoaBean.findMembrosGrupo("Estudo IV");

            out.println(Util.formatarImprimir("13) Quais s??o os membros (nomes) do grupo com nome ???Estudo IV??? com ordena????o alfab??tica\n"
                    + "inversa?",
                    membrosGrupo));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 14">
            List<Grupo> gruposBeatriz = pessoaBean.findGruposPorLider("Beatriz Yana");

            out.println(Util.formatarImprimir("14) Quais s??o os grupos (dados completos) liderados por ???Beatriz Yana????",
                    gruposBeatriz));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 15">
            List<Object[]> atuacaoGrupos = pessoaBean.findDatasAtuacaoGrupo("Cec??lia Xerxes");

            out.println(Util.formatarImprimir("15) Quais s??o as datas de in??cio e de t??rmino da atua????o e os grupos (nomes) nos quais ???Cec??lia\n"
                    + "Xerxes??? ?? membro?",
                    atuacaoGrupos));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 16">
            List<Grupo> grupoPorNome = pessoaBean.findGrupoByNome("II");

            out.println(Util.formatarImprimir("16) Quais s??o os grupos (dados completos) que cont??m ???II??? em seus nomes?",
                    grupoPorNome));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 17">
            List<Object[]> nomeGrupoQuantidadeMembros = pessoaBean.findNomeGrupoQuantidadeMembros();

            out.println(Util.formatarImprimir("17) Quais s??o os grupos (nomes) e os respectivos totais de membros distintos j?? alocados?",
                    nomeGrupoQuantidadeMembros));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 18">
            List<Object[]> nomeGrupoTotalAtuacoes = pessoaBean.findNomeGrupoPorTotalAtuacoes(3L);

            out.println(Util.formatarImprimir("18) Quais grupos (nomes) t??m 3 ou mais atua????es de membros e quanto s??o esses totais de atua????es?",
                    nomeGrupoTotalAtuacoes));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 19">
            List<String> nomePessoaPorDataEntradaEmGrupo = pessoaBean.findNomePessoaPorDataEntradaEmGrupo(1L, LocalDate.of(2012, Month.JANUARY, 1));

            out.println(Util.formatarImprimir("19) Quais membros (nomes) entraram a partir de 2012 no primeiro grupo?",
                    nomePessoaPorDataEntradaEmGrupo));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 20">
            List<MembroDto> membrosDto = pessoaBean.findMembroDto(LocalDate.of(2012, Month.JANUARY, 1));

            out.println(Util.formatarImprimir("20) Quais os grupos (nomes), membros (nomes) e as respectivas datas de entrada daqueles que\n"
                    + "entraram a partir de 2012 em qualquer grupo?",
                    membrosDto));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 21">
            List<String[]> gruposEPessoaSemDataTermino = pessoaBean.findGruposEPessoaSemDataTermino();

            out.println(Util.formatarImprimir("21) Quais os grupos (nomes) e respectivos membros (nomes) que n??o possuem data de t??rmino de\n"
                    + "atua????o em seus grupos?",
                    gruposEPessoaSemDataTermino));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 22">
            List<String[]> liderMembrosGrupos = pessoaBean.findLiderMembrosGrupos();

            out.println(Util.formatarImprimir("22) Quais s??o os grupos (nomes) e l??deres (nomes) com respectivos membros (nomes)?",
                    liderMembrosGrupos));
//</editor-fold>

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
