package br.edu.utfpr.td.tsi.mybankproject.services;

import br.edu.utfpr.td.tsi.mybankprojectloan.*;
import br.edu.utfpr.tsi.td.mybankprojectloan.controllers.LoanController;
import br.edu.utfpr.tsi.td.mybankprojectloan.domains.Loan;

import java.util.Calendar;

public class LoanService {
    LoanController loanController = new LoanController();

    public LoanService() {}

    public Loan criar(int clientId, float value, Calendar date, int type, int parcels) {
        return loanController.criar(clientId, value, parcels, date, type);
    }

    public void atualizar(int id, Loan loan) {
        loanController.atualizar(id, loan);
    }

}
