package br.edu.utfpr.td.tsi.mybankproject.services;

import br.edu.utfpr.td.tsi.mybankprojectclients.utils.InternalErrorException;
import br.edu.utfpr.tsi.td.mybankprojectloan.domains.Loan;
import br.edu.utfpr.tsi.td.mybankprojectloan.domains.Parcel;

import java.util.Calendar;
import java.util.List;

public class LoanService {
    private final LoanService loanService;

    public LoanService(LoanService loanService) {
        this.loanService = loanService;
    }

    public Loan criar(Loan loan) throws InternalErrorException {
        try{
            return loanService.criar(loan);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void atualizar(int id, Loan loan) throws InternalErrorException {
        try{
            loanService.atualizar(id, loan);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    public void remover(int id) throws InternalErrorException {
        try{
            loanService.remover(id);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Loan buscar(int id) throws InternalErrorException {
        try{
            return loanService.buscar(id);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Loan buscarPorCliente(int id) throws InternalErrorException {
        try{
            return loanService.buscarPorCliente(id);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void pagarParcela(int id) throws InternalErrorException {
        try{
            loanService.pagarParcela(id);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void pagarParcela(int id, int qtd) throws InternalErrorException {
        try{
            loanService.pagarParcela(id, qtd);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void quitar(int id) throws InternalErrorException {
        try{
            loanService.quitar(id);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public List<Parcel> getParcelasPendentes(int id) throws InternalErrorException {
        try{
            return loanService.getParcelasPendentes(id);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public List<Parcel> getParcelasPagas(int id) throws InternalErrorException {
        try{
            return loanService.getParcelasPagas(id);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public double getValorParcela(int id) throws InternalErrorException {
        try{
            return loanService.getValorParcela(id);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public double getValorTotal(int id) throws InternalErrorException {
        try{
            return loanService.getValorTotal(id);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public double getValorPago(int id) throws InternalErrorException {
        try{
            return loanService.getValorPago(id);
        }catch (InternalErrorException e){
            throw new InternalErrorException(e.getMessage());
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public double getValorPendente(int id) throws InternalErrorException {
        try{
            return loanService.getValorPendente(id);
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
