package com.se.models.account.To;

public class Account {

    public Account(){

    }

    private int id;
    private int customer_id;
    private  int type;
    private  int balance;
//    private static final int interestFree = 1;
//    private static final int shortTerm = 2;
//    private static final int longTerm = 3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", type=" + type +
                ", balance=" + balance +
                '}';
    }
}
