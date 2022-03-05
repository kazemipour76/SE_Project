package com.se.models.loan.Bl;


import com.se.models.loan.Da.LoanDA;
import com.se.models.loan.To.Loan;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoanBL {

    private LoanDA loanDA;
    public LoanBL() throws ClassNotFoundException {
        loanDA = new LoanDA();
    }


    public ArrayList<Loan> getLoan() throws Exception {
        ArrayList<Loan> loans = loanDA.accountsList();
        return loans;
    }

    public Loan addLoan(Loan loan) throws Exception {

        Loan loan1 = loanDA.insertLoan(loan);
        return loan1;
    }

    public ArrayList<Loan> searchLoan(int customer_id) throws Exception {
        Loan loan = null;
        ArrayList<Loan> loans = loanDA.searchByCustomerId(customer_id);

        return loans;
    }


    public Loan find(int id) throws SQLException, ClassNotFoundException {

        Loan loan = loanDA.find(id);
        return loan;

    }

    public void update(Loan loan ,int customer_id) throws SQLException, ClassNotFoundException {
        if (loan != null && loan.getCustomer_id() == customer_id) {
            loanDA.editLoan(loan);
        }
//        return account;
    }
    public void delete(int id, int customer_id) throws SQLException {
        loanDA.deleteByIdAndCustomerId(id, customer_id);
    }
    public void delete(int id) throws SQLException {
        loanDA.deleteLoan(id);
    }









}
