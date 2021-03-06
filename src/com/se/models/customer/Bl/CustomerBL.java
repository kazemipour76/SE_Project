package com.se.models.customer.Bl;


import com.se.models.customer.Da.CustomerDA;
import com.se.models.customer.To.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBL {


    private CustomerDA customerDA;
    public CustomerBL() throws ClassNotFoundException {
        customerDA = new CustomerDA();
    }


    public ArrayList<Customer> getCustomer() throws Exception {
        ArrayList<Customer> Customers = customerDA.customerList();
        return Customers;
    }

    public Customer addCustomer(Customer Customer) throws Exception {

        Customer Customer1 = customerDA.insertCustomer(Customer);
        return Customer1;
    }

    public Customer searchCustomer(String national_code) throws Exception {
        Customer customer = customerDA.searchByNationalCode(national_code);
        if (customer==null){
            return null;
        }else {

            return customer;
        }
    }

    public Customer searchBranchId(int id, int branch_id) throws Exception {
        Customer customer = null;
        ArrayList <Customer>  customers= customerDA.searchBranchId(branch_id);
        for (Customer Customer1 : customers) {
            if (Customer1.getId()==id) {
                customer = Customer1;

            }
        }
        return customer;
    }

    public Customer find(int id) throws SQLException, ClassNotFoundException {

        Customer customer = customerDA.find(id);

        return customer;

    }

    public int update(Customer customer ,int id) throws SQLException, ClassNotFoundException {
        int res=0;
        if (customer != null && customer.getId() == id) {
           res=  customerDA.editCustomer(customer);
        }
        return res;
    }
    public void delete(int id, int customer_id) throws SQLException {
        customerDA.deleteByIdAndBranchId(id, customer_id);
    }
    public void delete(int id) throws SQLException {
        customerDA.deleteCustomer(id);
    }






}
