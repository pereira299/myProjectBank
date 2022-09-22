package br.edu.utfpr.td.tsi.mybankproject.services;

import java.util.List;

import br.edu.utfpr.tsi.td.mybankprojectloan.domains.Parcel;
import br.edu.utfpr.tsi.td.mybankprojectloan.domains.Loan;
import br.edu.utfpr.tsi.td.mybankprojectloan.models.ILoanDAO;
import br.edu.utfpr.tsi.td.mybankprojectloan.models.LoanDAO;
import br.edu.utfpr.td.tsi.mybankprojectclients.utils.InternalErrorException;
import br.edu.utfpr.tsi.td.mybankprojectloan.controllers.LoanController;

public class LoanService {
	
    private final LoanController loanController;
    private final ILoanDAO loanDao;

    public LoanService() {
        this.loanDao = new LoanDAO();
        this.loanController = new LoanController(loanDao);
    }

    public Loan criar(Loan loan) throws InternalErrorException {
        try{
        	/* TODO: */
            return loanController.criar(loan);
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void atualizar(int id, Loan loan) throws InternalErrorException {
        try{
        	loanController.atualizar(id, loan);
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    public void remover(int id) throws InternalErrorException {
        try{
        	loanController.remover(id);
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Loan buscar(int id) throws InternalErrorException {
        try{
            return loanController.buscar(id);
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public List<Loan> buscarPorCliente(int id) throws InternalErrorException {
        try{
            return loanController.buscarPorCliente(id);
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void pagarParcela(int id) throws InternalErrorException {
        try{
        	loanController.pagarParcela(id);
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void pagarParcela(int id, int qtd) throws InternalErrorException {
        try{
        	loanController.pagarParcela(id, qtd);
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void quitar(int id) throws InternalErrorException {
        try{
        	loanController.quitar(id);
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public List<Parcel> getParcelasPendentes(int id) throws InternalErrorException {
        try{
            return loanController.getParcelasPendentes(id);
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public List<Parcel> getParcelasPagas(int id) throws InternalErrorException {
        try{
            return loanController.getParcelasPagas(id);
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public double getValorParcela(int id) throws InternalErrorException {
        try{
            return loanController.getValorParcela(id);
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public double getValorTotal(int id) throws InternalErrorException {
        try{
            return loanController.getValorTotal(id);
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public double getValorPago(int id) throws InternalErrorException {
        try{
            return loanController.getValorPago(id);
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public double getValorPendente(int id) throws InternalErrorException {
        try{
            return loanController.getValorPendente(id);
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
