package br.edu.utfpr.td.tsi.mybankproject.services;

import br.edu.utfpr.td.tsi.mybankprojectclients.controllers.PessoaFisicaController;
import br.edu.utfpr.td.tsi.mybankprojectclients.controllers.PessoaJuridicaController;
import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaFisica;
import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaJuridica;

import java.util.List;

public class ClientService {
    private PessoaJuridicaController juridica;
    private PessoaFisicaController fisica;

    public ClientService() {
        this.juridica = new PessoaJuridicaController();
        this.fisica = new PessoaFisicaController();
    }

    //generate methods criar, atualizar, deletar, listar, buscar
    public PessoaFisica criar(PessoaFisica pessoa) {
        return fisica.criar(pessoa);
    }
    public PessoaJuridica criar(PessoaJuridica pessoa) {
        return juridica.criar(pessoa);
    }

    public int atualizar(int id, PessoaFisica pessoa) {
        return fisica.atualizar(id, pessoa);
    }
    public int atualizar(int id, PessoaJuridica pessoa) {
        return juridica.atualizar(id, pessoa);
    }

    public void deletarFisica(int id) {
        fisica.remover(id);
    }
    public void deletarJuridica(int id) {
        juridica.remover(id);
    }

    public List<PessoaFisica> listarFisica() {
        return fisica.buscar();
    }

    public List<PessoaJuridica> listarJuridica() {
        return juridica.buscar();
    }

    public List<PessoaFisica> buscarFisica(int id) {
        return fisica.buscar(id);
    }

    public List<PessoaJuridica> buscarJuridica(int id) {
        return juridica.buscar(id);
    }



}
