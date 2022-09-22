package br.edu.utfpr.td.tsi.mybankproject.services;

import br.edu.utfpr.td.tsi.mybankprojectclients.controllers.PessoaFisicaController;
import br.edu.utfpr.td.tsi.mybankprojectclients.controllers.PessoaJuridicaController;
import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaFisica;
import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaJuridica;
import br.edu.utfpr.td.tsi.mybankprojectclients.models.IPessoaFisicaDAO;
import br.edu.utfpr.td.tsi.mybankprojectclients.models.IPessoaJuridicaDAO;
import br.edu.utfpr.td.tsi.mybankprojectclients.models.PessoaFisicaDAO;
import br.edu.utfpr.td.tsi.mybankprojectclients.models.PessoaJuridicaDAO;
import br.edu.utfpr.td.tsi.mybankprojectclients.utils.InternalErrorException;

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
    public PessoaFisica criar(PessoaFisica pessoa) throws InternalErrorException {
        try{
            return fisica.criar(pessoa);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    public PessoaJuridica criar(PessoaJuridica pessoa) throws InternalErrorException {
        try{
            return juridica.criar(pessoa);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public int atualizar(int id, PessoaFisica pessoa) throws InternalErrorException {
        try{
            return fisica.atualizar(id, pessoa);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    public int atualizar(int id, PessoaJuridica pessoa) throws InternalErrorException {
        try {
            return juridica.atualizar(id, pessoa);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    public void deletarFisica(int id) throws InternalErrorException {
            try{
            fisica.remover(id);

            }catch (InternalErrorException e){
                throw new InternalErrorException(e.getMessage());
            }catch (NullPointerException e){
                throw new NullPointerException(e.getMessage());
            }
            catch (IllegalArgumentException e){
                throw new IllegalArgumentException(e.getMessage());
            }
    }
    public void deletarJuridica(int id) throws InternalErrorException {
        try{
            juridica.remover(id);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public List<PessoaFisica> listarFisica() throws InternalErrorException {
        try{
            return fisica.buscar();
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public List<PessoaJuridica> listarJuridica() throws InternalErrorException {
        try{
            return juridica.buscar();
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public List<PessoaFisica> buscarFisica(int id) throws InternalErrorException {
        try{
            return fisica.buscar(id);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public List<PessoaJuridica> buscarJuridica(int id) throws InternalErrorException {
        try{
            return juridica.buscar(id);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public List<PessoaJuridica> buscarJuridica(String nome) throws InternalErrorException {
        try{
            return juridica.buscar(nome);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public List<PessoaFisica> buscarFisica(String nome) throws InternalErrorException {
        try{
            return fisica.buscar(nome);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public List<PessoaFisica> buscarFisicaCPF(String cpf) throws InternalErrorException {
        try{
            return fisica.buscarPorCpf(cpf);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public PessoaJuridica buscarJuridicaCNPJ(String cnpj) throws InternalErrorException {
        try{
            return (PessoaJuridica) juridica.buscarPorCnpj(cnpj);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }



}
