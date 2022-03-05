package com.se.models.account.Da;

import com.se.models.account.To.Account;
import com.se.models.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;

public class AccountDA extends ConnectionDB{

    public AccountDA() throws ClassNotFoundException {
    }


    // --------------------------- crud ----------------------------------- //

    public ArrayList<Account> accountsList() throws SQLException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM account");
        ArrayList<Account> customers = new ArrayList<>();

        try {
            while (resultSet.next()) {
                Account customer = new Account();
                customer.setId(resultSet.getInt(1));
                customer.setType(resultSet.getInt(2));
                customer.setBalance(resultSet.getInt(3));
                customer.setCustomer_id(resultSet.getInt(4));
                customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection(connection);
        return customers;
    }

    public ArrayList<Account>  searchByCustomerId(int customer_id) throws SQLException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM account where customer_id = " + customer_id);
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt(1));
                account.setType(resultSet.getInt(2));
                account.setBalance(resultSet.getInt(3));
                account.setCustomer_id(resultSet.getInt(4));
                accounts.add(account);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        closeConnection(connection);
        return accounts;
    }

    public Account insertAccount(Account account) throws SQLException {
        Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO account(type,balance,customer_id) VALUES(?,?,?)");
        statement.setInt(1, account.getType());
        statement.setInt(2, account.getBalance());
        statement.setInt(3, account.getCustomer_id());
        statement.executeUpdate();
        closeConnection(connection);
        return account;
    }

    public int editAccount(Account account) throws SQLException {


        Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE account SET type= ?, balance = ?  where id =?");
        statement.setInt(1, account.getType());
        statement.setInt(2, account.getBalance());
        statement.setInt(3, account.getId());

        int rowEffect =  statement.executeUpdate();
        closeConnection(connection);
        return rowEffect;
    }

    public void deleteAccount(int id) throws SQLException {
        Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM account where id = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
        closeConnection(connection);
    }



    public int deleteByIdAndCustomerId(int type, int customer_id) throws SQLException {
        Connection connection = createConnection();
        PreparedStatement st = connection.prepareStatement("DELETE FROM account WHERE  type = ? AND customer_id = ?");
        st.setInt(1, type);
        st.setInt(2, customer_id);
        st.executeUpdate();
        int status=st.executeUpdate();
        closeConnection(connection);
        return status;
    }


    public Account find(int id) throws SQLException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM account where id = " + id);
        Account account = new Account();
        try {
            if (resultSet.next()) {
                account.setId(resultSet.getInt(1));
                account.setType(resultSet.getInt(2));
                account.setBalance(resultSet.getInt(3));
                account.setCustomer_id(resultSet.getInt(4));
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        closeConnection(connection);
        return account;
    }

}




