package com.se.models.loan.Da;

import com.se.models.loan.To.Loan;
import com.se.models.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;

public class LoanDA extends ConnectionDB{

    public LoanDA() throws ClassNotFoundException {
    }

    public ArrayList<Loan> accountsList() throws SQLException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM loan");
        ArrayList<Loan> loans = new ArrayList<>();

        try {
            while (resultSet.next()) {
                Loan loan = new Loan();
                loan.setId(resultSet.getInt(1));
                loan.setType(resultSet.getInt(2));
                loan.setAmount(resultSet.getInt(3));
                loan.setCustomer_id(resultSet.getInt(4));
                loans.add(loan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection(connection);
        return loans;
    }

    public ArrayList<Loan>  searchByCustomerId(int customer_id) throws SQLException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM loan where customer_id = " + customer_id);
        ArrayList<Loan> loans = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Loan loan = new Loan();
                loan.setId(resultSet.getInt(1));
                loan.setType(resultSet.getInt(2));
                loan.setAmount(resultSet.getInt(3));
                loan.setCustomer_id(resultSet.getInt(4));
                loans.add(loan);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        closeConnection(connection);
        return loans;
    }

    public Loan insertLoan(Loan loan) throws SQLException {
        Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO loan(type,amount,customer_id) VALUES(?,?,?)");
        statement.setInt(1, loan.getType());
        statement.setInt(2, loan.getAmount());
        statement.setInt(3, loan.getCustomer_id());
        statement.executeUpdate();
        closeConnection(connection);
        return loan;
    }

    public int editLoan(Loan loan) throws SQLException {


        Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE loan SET type= ?, amount = ?  where id =?");
        statement.setInt(1, loan.getType());
        statement.setInt(2, loan.getAmount());
        statement.setInt(3, loan.getId());

        int rowEffect =  statement.executeUpdate();
        closeConnection(connection);
        return rowEffect;
    }

    public void deleteLoan(int id) throws SQLException {
        Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM loan where id = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
        closeConnection(connection);
    }



    public void deleteByIdAndCustomerId(int id, int customer_id) throws SQLException {
        Connection connection = createConnection();
        PreparedStatement st = connection.prepareStatement("DELETE FROM loan WHERE  id = ? AND customer_id = ?");
        st.setInt(1, id);
        st.setInt(2, customer_id);
        st.executeUpdate();
        closeConnection(connection);
    }


    public Loan find(int id) throws SQLException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM loan where id = " + id);
        Loan loan = new Loan();
        try {
            if (resultSet.next()) {
                loan.setId(resultSet.getInt(1));
                loan.setType(resultSet.getInt(2));
                loan.setAmount(resultSet.getInt(3));
                loan.setCustomer_id(resultSet.getInt(4));
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        closeConnection(connection);
        return loan;
    }



}




