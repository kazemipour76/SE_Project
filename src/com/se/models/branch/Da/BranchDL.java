package com.se.models.branch.Da;

import com.se.models.branch.To.Branch;
import com.se.models.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;

public class BranchDL extends ConnectionDB{

    public BranchDL() throws ClassNotFoundException {
    }

    public ArrayList<Branch> branchList() throws SQLException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM  branch_bank");
        ArrayList<Branch> branches = new ArrayList<>();

        try {
            while (resultSet.next()) {
                Branch branch = new Branch();
                branch.setId(resultSet.getInt(1));
                branch.setName(resultSet.getString(2));
                branch.setAddress(resultSet.getString(3));
                branch.setBank_id(resultSet.getInt(4));
                branches.add(branch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection(connection);
        return branches;
    }

    public ArrayList<Branch>  searchByBankId(int bank_id) throws SQLException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM  branch_bank where bank_id = " + bank_id);
        ArrayList<Branch> branches = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Branch branch = new Branch();
                branch.setId(resultSet.getInt(1));
                branch.setName(resultSet.getString(2));
                branch.setAddress(resultSet.getString(3));
                branch.setBank_id(resultSet.getInt(4));
                branches.add(branch);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        closeConnection(connection);
        return branches;
    }

    public Branch insertBranch(Branch branch) throws SQLException {
        Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO  branch_bank(name,address,bank_id) VALUES(?,?,?)");
        statement.setString(1, branch.getName());
        statement.setString(2, branch.getAddress());
        statement.setInt(3, branch.getBank_id());
        statement.executeUpdate();
        closeConnection(connection);
        return branch;
    }

    public int editBranch(Branch branch) throws SQLException {


        Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE  branch_bank SET name= ?, address = ?  where id =?");
        statement.setString(1, branch.getName());
        statement.setString(2, branch.getAddress());
        statement.setInt(3, branch.getId());
        int rowEffect =  statement.executeUpdate();
        closeConnection(connection);
        return rowEffect;
    }

    public void deleteBranch(int id) throws SQLException {
        Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM  branch_bank where id = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
        closeConnection(connection);
    }



    public void deleteByIdAndBankId(int id, int bank_id) throws SQLException {
        Connection connection = createConnection();
        PreparedStatement st = connection.prepareStatement("DELETE FROM  branch_bank WHERE  id = ? AND bank_id = ?");
        st.setInt(1, id);
        st.setInt(2, bank_id);
        st.executeUpdate();
        closeConnection(connection);
    }


    public Branch find(int id) throws SQLException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM  branch_bank where id = " + id);
        Branch branch = new Branch();
        try {
            if (resultSet.next()) {
                branch.setId(resultSet.getInt(1));
                branch.setName(resultSet.getString(2));
                branch.setAddress(resultSet.getString(3));
                branch.setBank_id(resultSet.getInt(4));
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        closeConnection(connection);
        return branch;
    }



}




