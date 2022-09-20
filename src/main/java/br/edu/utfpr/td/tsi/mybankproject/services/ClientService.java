package br.edu.utfpr.td.tsi.mybankproject.services;

import br.edu.utfpr.td.tsi.mybankprojectclients.controllers.PessoaFisicaController;
import br.edu.utfpr.td.tsi.mybankprojectclients.controllers.PessoaJuridicaController;
import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaFisica;
import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaJuridica;
import br.edu.utfpr.td.tsi.mybankprojectclients.models.IPessoaFisicaDAO;
import br.edu.utfpr.td.tsi.mybankprojectclients.models.IPessoaJuridicaDAO;
import br.edu.utfpr.td.tsi.mybankprojectclients.models.PessoaFisicaDAO;
import br.edu.utfpr.td.tsi.mybankprojectclients.models.PessoaJuridicaDAO;

import java.util.List;

public class ClientService {
    private PessoaJuridicaController juridica;
    private PessoaFisicaController fisica;

    private IPessoaJuridicaDAO pessoaJuridica;
    private IPessoaFisicaDAO pessoaFisica;

    
    public ClientService() {
    	this.pessoaJuridica = new PessoaJuridicaDAO();
    	this.pessoaFisica = new PessoaFisicaDAO();
    	
        this.juridica = new PessoaJuridicaController(pessoaJuridica);
        this.fisica = new PessoaFisicaController(pessoaFisica);
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
