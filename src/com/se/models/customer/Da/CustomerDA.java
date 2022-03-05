package com.se.models.customer.Da;

import com.se.models.ConnectionDB;
import com.se.models.customer.To.Customer;
import com.se.models.loan.To.Loan;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDA extends ConnectionDB {

    public CustomerDA() throws ClassNotFoundException {
    }

    // --------------------------- crud ----------------------------------- //

    public ArrayList<Customer> customerList() throws SQLException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt(1));
                customer.setName(resultSet.getString(2));
                customer.setNational_code(resultSet.getString(3));
                customer.setPassword(resultSet.getString(4));
                customer.setBranch_id(resultSet.getInt(5));
                customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection(connection);
        return customers;
    }

    public Customer searchById(int id) throws SQLException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM customer where id = " + id);
        Customer customer = new Customer();
        try {
            if (resultSet.next()) {
                customer.setId(resultSet.getInt(1));
                customer.setName(resultSet.getString(2));
                customer.setNational_code(resultSet.getString(3));
                customer.setPassword(resultSet.getString(4));
                customer.setBranch_id(resultSet.getInt(5));
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        closeConnection(connection);
        return customer;
    }

    public Customer insertCustomer(Customer customer) throws SQLException {
        Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO customer(name,national_code,password,branch_id) VALUES(?,?,?,?)");
//        statement.setInt(1, customer.getId());
        statement.setString(1, customer.getName());
        statement.setString(2, customer.getNational_code());
        statement.setString(3, customer.getPassword());
        statement.setInt(4, customer.getBranch_id());
        statement.executeUpdate();
        closeConnection(connection);
        return customer;
    }

    public int editCustomer(Customer customer) throws SQLException {


        Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE person SET name = ? , national_code= ?, password= ? where id = ?");
        statement.setString(1, customer.getName());
        statement.setString(2, customer.getNational_code());
        statement.setString(3, customer.getPassword());
        statement.setInt(4, customer.getBranch_id());

        int rowEffect = statement.executeUpdate();
        closeConnection(connection);
        return rowEffect;
    }

    public void deleteCustomer(int id) throws SQLException {
        Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM customer where id = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
        closeConnection(connection);
    }

    public void deleteByIdAndBranchId(int id, int branch_id) throws SQLException {
        Connection connection = createConnection();
        PreparedStatement st = connection.prepareStatement("DELETE FROM customer WHERE  id = ? AND branch_id = ?");
        st.setInt(1, id);
        st.setInt(2, branch_id);
        st.executeUpdate();
        closeConnection(connection);
    }


    public Customer searchByNationalCode(String national_code) throws SQLException {
        Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer WHERE national_code = ?");
        statement.setString(1, national_code);
        ResultSet resultSet = statement.executeQuery();
        Customer customer = new Customer();
        while (resultSet.next()) {
            customer.setId(resultSet.getInt(1));
            customer.setName(resultSet.getString(2));
            customer.setNational_code(resultSet.getString(3));
            customer.setPassword(resultSet.getString(4));
            customer.setBranch_id(resultSet.getInt(5));
        }
        closeConnection(connection);
        return customer;
    }

    public Customer find(int id) throws SQLException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM customer where id = " + id);
        Customer customer = new Customer();

        try {
            if (resultSet.next()) {
                customer.setId(resultSet.getInt(1));
                customer.setName(resultSet.getString(2));
                customer.setNational_code(resultSet.getString(3));
                customer.setPassword(resultSet.getString(4));
                customer.setBranch_id(resultSet.getInt(5));
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        closeConnection(connection);
        return customer;
    }

    public ArrayList<Customer> searchBranchId(int branch_id) throws SQLException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM customer where branch_id = " + branch_id);
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt(1));
                customer.setName(resultSet.getString(2));
                customer.setNational_code(resultSet.getString(3));
                customer.setPassword(resultSet.getString(4));
                customer.setBranch_id(resultSet.getInt(5));
                customers.add(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        closeConnection(connection);
        return customers;
    }

}




