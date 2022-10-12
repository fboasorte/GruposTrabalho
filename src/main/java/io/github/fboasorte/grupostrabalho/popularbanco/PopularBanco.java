/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package io.github.fboasorte.grupostrabalho.popularbanco;

import io.github.fboasorte.grupostrabalho.endereco.Endereco;
import io.github.fboasorte.grupostrabalho.endereco.TipoLogradouro;
import io.github.fboasorte.grupostrabalho.grupo.Atuacao;
import io.github.fboasorte.grupostrabalho.grupo.Grupo;
import io.github.fboasorte.grupostrabalho.pessoa.Pessoa;
import io.github.fboasorte.grupostrabalho.pessoa.PessoaBeanLocal;
import io.github.fboasorte.grupostrabalho.telefone.Telefone;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author felipe
 */
@Singleton
@Startup
public class PopularBanco implements PopularBancoLocal {

    @Inject
    private PessoaBeanLocal pessoaBean;

    @PostConstruct
    @Override
    public void popularBanco() {
        // Primeira pessoa
        Pessoa pessoa1 = new Pessoa();

        pessoa1.setNome("Ana Zaira");
        pessoa1.setEmail("ana@mail.com");
        pessoa1.setNascimento(LocalDate.of(2001, Month.JANUARY, 1));

        Endereco endereco1 = new Endereco(
                TipoLogradouro.RUA,
                "1",
                1111,
                "Humberto"
        );

        pessoa1.setEndereco(endereco1);

        pessoa1.setTelefones(List.of(
                new Telefone((byte) 11, 11111111),
                new Telefone((byte) 12, 12121212),
                new Telefone((byte) 13, 13131313)
        ));

        // Segunda Pessoa
        Pessoa pessoa2 = new Pessoa();

        pessoa2.setNome("Beatriz Yana");
        pessoa2.setEmail("beatriz@mail.com");
        pessoa2.setNascimento(LocalDate.of(2002, Month.FEBRUARY, 2));

        Endereco endereco2 = new Endereco(
                TipoLogradouro.AVENIDA,
                "2",
                2222,
                "Doisberto"
        );

        pessoa2.setEndereco(endereco2);

        pessoa2.setTelefones(List.of(
                new Telefone((byte) 22, 22222222)
        ));

        // Terceira pessoa
        Pessoa pessoa3 = new Pessoa();

        pessoa3.setNome("Cecília Xerxes");
        pessoa3.setEmail("cecilia@mail.com");
        pessoa3.setNascimento(LocalDate.of(2003, Month.MARCH, 3));

        Endereco endereco3 = new Endereco(
                TipoLogradouro.AVENIDA,
                "3",
                3333,
                "Trêsberto"
        );

        pessoa3.setEndereco(endereco3);

        // Quarta Pessoa
        Pessoa pessoa4 = new Pessoa();

        pessoa4.setNome("Débora Wendel");
        pessoa4.setEmail("debora@mail.com");
        pessoa4.setNascimento(LocalDate.of(2004, Month.APRIL, 4));

        Endereco endereco4 = new Endereco(
                TipoLogradouro.AVENIDA,
                "4",
                4444,
                "Quatroberto"
        );

        pessoa4.setEndereco(endereco4);

        pessoa4.setTelefones(List.of(
                new Telefone((byte) 44, 44444444),
                new Telefone((byte) 45, 45454545)
        ));

        // Grupos
        Grupo grupo1 = new Grupo("Estudo I", false);
        Grupo grupo2 = new Grupo("Estudo II", true);
        Grupo grupo3 = new Grupo("Estudo III", false);
        Grupo grupo4 = new Grupo("Estudo IV", true);

        grupo1.setLider(pessoa1);
        grupo2.setLider(pessoa2);
        grupo3.setLider(pessoa3);
        grupo4.setLider(pessoa2);

        pessoa1.setGrupos(List.of(
                grupo1
        )
        );

        pessoa2.setGrupos(List.of(
                grupo1,
                grupo2,
                grupo4
        ));

        pessoa3.setGrupos(List.of(
                grupo1,
                grupo3
        ));

        pessoa4.setGrupos(List.of(
                grupo1,
                grupo2,
                grupo3,
                grupo4
        ));

        // Atuacao
        pessoa1.setAtuacoes(List.of(
                new Atuacao(
                        LocalDate.of(2011, 1, 1),
                        LocalDate.of(2021, 11, 11),
                        grupo1),
                new Atuacao(
                        LocalDate.of(2012, 1, 1),
                        LocalDate.of(2022, 11, 11),
                        grupo1)
        ));

        pessoa2.setAtuacoes(List.of(
                new Atuacao(
                        LocalDate.of(2012, 1, 2),
                        LocalDate.of(2021, 1, 12),
                        grupo1),
                new Atuacao(
                        LocalDate.of(2012, 1, 2),
                        grupo2),
                new Atuacao(
                        LocalDate.of(2012, 1, 4),
                        LocalDate.of(2012, 1, 14),
                        grupo4)
        ));

        pessoa3.setAtuacoes(List.of(
                new Atuacao(
                        LocalDate.of(2013, 1, 3),
                        LocalDate.of(2021, 1, 13),
                        grupo1),
                new Atuacao(
                        LocalDate.of(2012, 1, 3),
                        LocalDate.of(2023, 1, 13),
                        grupo3),
                new Atuacao(
                        LocalDate.of(2012, 1, 4),
                        LocalDate.of(2012, 1, 14),
                        grupo4)
        ));

        pessoa4.setAtuacoes(List.of(
                new Atuacao(
                        LocalDate.of(2014, 1, 4),
                        LocalDate.of(2021, 1, 14),
                        grupo1),
                new Atuacao(
                        LocalDate.of(2012, 1, 2),
                        grupo2),
                new Atuacao(
                        LocalDate.of(2012, 1, 3),
                        LocalDate.of(2023, 1, 13),
                        grupo3),
                new Atuacao(
                        LocalDate.of(2012, 1, 4),
                        LocalDate.of(2012, 1, 14),
                        grupo4)
        ));

        pessoaBean.save(pessoa1);
        pessoaBean.save(pessoa2);
        pessoaBean.save(pessoa3);
        pessoaBean.save(pessoa4);
    }
}
