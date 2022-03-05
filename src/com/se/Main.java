package com.se;

import com.se.models.account.Bl.AccountBL;
import com.se.models.customer.Bl. CustomerBL;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        CustomerBL customerBL = new CustomerBL();


        try {
            AccountBL accountBL = new AccountBL();
            accountBL.delete(1, 1);
            Account account = accountBL.searchAccount(1, 1);
            account.setBalance(20000);
            account.setType(3);
            accountBL.update(account, 1);
            System.out.println(account);
            ------------------------------------------------------------------
        } catch (Exception e) {

        }
    }
}