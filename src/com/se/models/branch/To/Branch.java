package com.se.models.branch.To;

public class Branch {

    public Branch(){

    }

    private int id;
    private int bank_id;
    private  String name;
    private  String address;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBank_id() {
        return bank_id;
    }

    public void setBank_id(int bank_id) {
        this.bank_id = bank_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", bank_id=" + bank_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
