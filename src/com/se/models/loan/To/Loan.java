package com.se.models.loan.To;

public class Loan {

    public Loan(){

    }

    private int id;
    private int customer_id;
    private  int type;
    private  int amount;

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", type=" + type +
                ", amount=" + amount +
                '}';
    }
}
