package com.se;

import com.se.models.account.Bl.AccountBL;
import com.se.models.branch.Bl.BranchBL;
import com.se.models.branch.To.Branch;
import com.se.models.customer.Bl.CustomerBL;
import com.se.models.customer.To.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        CustomerBL customerBL = new CustomerBL();
        Scanner scanner = new Scanner(System.in);


        String userName;
        String password;
        int id = 0;

        while (true) {
            System.out.println("برای ورود به بخش شعبه عدد 1 را وارد کنید");
            System.out.println("برای ورود به بخش مشتری عدد 2 را وارد کنید");

            int key = scanner.nextInt();
            switch (key) {
                case 1:
                    System.out.println("add branch [1]");
                    System.out.println("List branch [2]");
                    int Numbranch = scanner.nextInt();
                    switch (Numbranch) {
                        case 1:
                            try {
                                Branch branch = new Branch();
                                System.out.print("Enter name: ");
                                branch.setName(scanner.next());
                                System.out.print("Enter address: ");
                                branch.setAddress(scanner.next());
                                branch.setBank_id(1);

                                BranchBL branchBL = new BranchBL();
                                branchBL.addBranch(branch);

                                ArrayList<Branch> branches = new ArrayList<>();
//                                BranchBL branchBL = new BranchBL();
                                branches = branchBL.getBranch();
                                for (Branch branch1 : branches) {
                                    System.out.println("id is :"+""+ branch1.getId());
                                    System.out.println("name is :" + branch1.getName());
                                    System.out.println("address is :" + branch1.getAddress());
                                    System.out.println("-----------------------------------");

                                }

                                break;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        case 2:
                            try {
                                ArrayList<Branch> branches = new ArrayList<>();
                                BranchBL branchBL = new BranchBL();
                                branches = branchBL.getBranch();
                                for (Branch branch1 : branches) {
                                    System.out.println("id is :"+""+ branch1.getId());
                                    System.out.println("name is :" + branch1.getName());
                                    System.out.println("address is :" + branch1.getAddress());
                                    System.out.println("-----------------------------------");

                                }
                                break;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }


                    }
                case 2:
                    System.out.println("add Customer [1]");
                    System.out.println("List Customer [2]");
                    int customer = scanner.nextInt();
                    switch (customer) {
                        case 1:
                            try {
//                                Branch branchCustomer = new Branch();
                                BranchBL branchBL = new BranchBL();
                                Customer customer1 = new Customer();
                                System.out.print("Enter name: ");
                                customer1.setName(scanner.next());
                                System.out.print("Enter pass: ");
                                customer1.setPassword(scanner.next());
                                System.out.print("Enter national_code: ");
                                customer1.setNational_code(scanner.next());
                                System.out.print("Enter nameBranchBank: ");
                                ArrayList <Branch> branches =new ArrayList<>();
                                int idBranch=0;
                                String nameBranch=null;
                                branches= branchBL.searchByName(scanner.next());
                                for (Branch branch1 : branches) {
                                    idBranch= branch1.getId();
                                    nameBranch= branch1.getName();
                                }
                                customer1.setBranch_id(idBranch);

                                CustomerBL customerBL1 = new CustomerBL();
                                customerBL1.addCustomer(customer1);


                                ArrayList<Customer> customers = new ArrayList<>();
//                                BranchBL branchBL = new BranchBL();
                                customers = customerBL1.getCustomer();
                                for (Customer item : customers) {
                                    System.out.println("id is :"+""+ item.getId());
                                    System.out.println("name is :" + item.getName());
                                    System.out.println("code meli is :" + item.getNational_code());
                                    System.out.println("nameBranch is :" + nameBranch);
                                    System.out.println("-----------------------------------");

                                }

                                break;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

//                        case 2:
//                            try {
//                                ArrayList<Branch> branches = new ArrayList<>();
//                                BranchBL branchBL = new BranchBL();
//                                branches = branchBL.getBranch();
//                                for (Branch branch1 : branches) {
//                                    System.out.println("id is :"+""+ branch1.getId());
//                                    System.out.println("name is :" + branch1.getName());
//                                    System.out.println("address is :" + branch1.getAddress());
//                                    System.out.println("-----------------------------------");
//
//                                }
//                                break;
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }


                    }
            }
        }


//            AccountBL accountBL = new AccountBL();
//            accountBL.delete(1, 1);
//            Account account = accountBL.searchAccount(1, 1);
//            account.setBalance(20000);
//            account.setType(3);
//            accountBL.update(account, 1);
//            System.out.println(account);

    }
}