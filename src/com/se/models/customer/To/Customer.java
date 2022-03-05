package com.se.models.customer.To;

public class Customer {

    public  Customer(){

    }

    private int id;
    private int branch_id;
    private  String name;
    private  String password;
    private  String national_code;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNational_code() {
        return national_code;
    }

    public void setNational_code(String national_code) {
        this.national_code = national_code;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", branch_id=" + branch_id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", national_code='" + national_code + '\'' +
                '}';
    }

}
