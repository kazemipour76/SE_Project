package com.se.models.branch.Bl;


import com.se.models.branch.Da.BranchDL;
import com.se.models.branch.To.Branch;
import com.se.models.loan.Da.LoanDA;
import com.se.models.loan.To.Loan;

import java.sql.SQLException;
import java.util.ArrayList;

public class BranchBL {

    private BranchDL branchDL;
    public BranchBL() throws ClassNotFoundException {
        branchDL = new BranchDL();
    }


    public ArrayList<Branch> getBranch() throws Exception {
        ArrayList<Branch> branches = branchDL.branchList();
        return branches;
    }

    public void addBranch(Branch branche) throws Exception {
        branchDL.insertBranch(branche);
//        return branche1;
    }

    public Branch searchBranch(int id,int bank_id) throws Exception {
        Branch branch  = null;
        ArrayList<Branch> branches = branchDL.searchByBankId(bank_id);
        for (Branch branch1 : branches) {
            if (branch1.getId()==id) {
                branch = branch1;
            }
        }
        return branch;
    }


    public Branch find(int id) throws SQLException, ClassNotFoundException {

        Branch branch = branchDL.find(id);
        return branch;

    }

    public void update( Branch branch ,int bank_id) throws SQLException, ClassNotFoundException {
        if (branch != null && branch.getBank_id() == bank_id) {
            branchDL.editBranch(branch);
        }
//        return account;
    }
    public void delete(int id, int bank_id) throws SQLException {
        branchDL.deleteByIdAndBankId(id, bank_id);
    }
    public void delete(int id) throws SQLException {
        branchDL.deleteBranch(id);
    }

    public ArrayList<Branch> searchByName(String name) throws SQLException {
        return branchDL.searchByName(name);
    }








}
