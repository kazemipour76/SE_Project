package com.se.models.account.Bl;


import com.se.models.account.Da.AccountDA;
import com.se.models.account.To.Account;

import java.sql.SQLException;
import java.util.ArrayList;

public class AccountBL {

    private AccountDA accountDA;
    public AccountBL() throws ClassNotFoundException {
        accountDA = new AccountDA();
    }


    public ArrayList<Account> getCustomer() throws Exception {
        ArrayList<Account> customers = accountDA.accountsList();
        return customers;
    }

    public Account addAccount(Account account) throws Exception {

        Account account1 = accountDA.insertAccount(account);
        return account1;
    }

    public Account searchAccount(int id,int customer_id) throws Exception {
        Account account = null;
        ArrayList<Account> accounts = accountDA.searchByCustomerId(customer_id);
        for (Account account1 : accounts) {
            if (account1.getId()==id) {
                account = account1;

            }
        }
        return account;
    }


public Account find(int id) throws SQLException, ClassNotFoundException {

    Account account = accountDA.find(id);
        return account;

}

    public void update(Account account ,int customer_id) throws SQLException, ClassNotFoundException {
        if (account != null && account.getCustomer_id() == customer_id) {
        accountDA.editAccount(account);
        }
//        return account;
    }
    public void delete(int id, int customer_id) throws SQLException {
        accountDA.deleteByIdAndCustomerId(id, customer_id);
    }
    public void delete(int id) throws SQLException {
        accountDA.deleteAccount(id);
    }







}
