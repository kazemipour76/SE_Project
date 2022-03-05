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


    public ArrayList<Account> getAccount() throws Exception {
        ArrayList<Account> customers = accountDA.accountsList();
        return customers;
    }

    public Account addAccount(Account account) throws Exception {

        Account account1 = accountDA.insertAccount(account);
        return account1;
    }

    public  ArrayList<Account> searchAccount(int customer_id) throws Exception {
        Account account = null;
        ArrayList<Account> accounts = accountDA.searchByCustomerId(customer_id);
//        for (Account account1 : accounts) {
//            if (account1.getId()==id) {
//                account = account1;
//
//            }
//        }
        return accounts;
    }
    public  Account searchAccount(int type ,int customer_id) throws Exception {
        Account account = null;
        ArrayList<Account> accounts = accountDA.searchByCustomerId(customer_id);
        for (Account account1 : accounts) {
            if (account1.getType()==type) {
                account = account1;

            }else {
                account = null;
            }
        }
        return account;
    }


public Account find(int id) throws SQLException, ClassNotFoundException {

    Account account = accountDA.find(id);
        return account;

}

    public int update(Account account ,int customer_id) throws SQLException, ClassNotFoundException {
        if (account != null && account.getCustomer_id() == customer_id) {
        accountDA.editAccount(account);
            return 1;

        }
        return 0;
    }
    public int delete(int type, int customer_id) throws SQLException {
       int status= accountDA.deleteByIdAndCustomerId(type, customer_id);
       return status;
    }
    public void delete(int id) throws SQLException {
        accountDA.deleteAccount(id);
    }







}
