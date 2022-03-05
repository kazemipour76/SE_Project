package com.se;

import com.se.models.account.Bl.AccountBL;
import com.se.models.account.To.Account;
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
                                    System.out.println("id is :" + "" + branch1.getId());
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
                                    System.out.println("id is :" + "" + branch1.getId());
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
                    System.out.println("Add Customer [1]");
                    System.out.println("List Customer [2]");
                    System.out.println("Delete Customer [3]");
                    System.out.println("Edit Customer [4]");
                    System.out.println("Account for Customer [5]");
                    System.out.println("Loan for Customer [6]");
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
                                ArrayList<Branch> branches = new ArrayList<>();
                                int idBranch = 0;
                                String nameBranch = null;
                                branches = branchBL.searchByName(scanner.next());
                                for (Branch branch1 : branches) {
                                    idBranch = branch1.getId();
                                    nameBranch = branch1.getName();
                                }
                                customer1.setBranch_id(idBranch);

                                CustomerBL customerBL1 = new CustomerBL();
                                customerBL1.addCustomer(customer1);


                                ArrayList<Customer> customers = new ArrayList<>();
//                                BranchBL branchBL = new BranchBL();
                                customers = customerBL1.getCustomer();
                                for (Customer item : customers) {
                                    System.out.println("id is :" + "" + item.getId());
                                    System.out.println("name is :" + item.getName());
                                    System.out.println("code meli is :" + item.getNational_code());
                                    System.out.println("nameBranch is :" + nameBranch);
                                    System.out.println("-----------------------------------");
                                }
                                break;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        case 2:
                            try {
                                ArrayList<Customer> customers = new ArrayList<>();
                                BranchBL branchBL = new BranchBL();
                                CustomerBL customerBL1 = new CustomerBL();
                                Branch branch = new Branch();
                                customers = customerBL1.getCustomer();
                                for (Customer item : customers) {
                                    branch = branchBL.find(item.getBranch_id());
                                    System.out.println("id is :" + "" + item.getId());
                                    System.out.println("name is :" + item.getName());
                                    System.out.println("code meli is :" + item.getNational_code());
                                    System.out.println("nameBranch is :" + branch.getName());
                                    System.out.println("-----------------------------------");
                                }
                                break;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        case 3:
                            try {
                                CustomerBL customerBL1 = new CustomerBL();
                                Customer customer1 = new Customer();
                                System.out.print("Enter national_code: ");
                                customer1 = customerBL1.searchCustomer(scanner.next());
                                if (customer1 == null) {
                                    System.out.println(" national_code not found ");

                                } else {
                                    customerBL1.delete(customer1.getId());
                                }

                                break;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        case 4:
                            try {
                                CustomerBL customerBL1 = new CustomerBL();
                                Customer customer1 = new Customer();
                                System.out.print("Enter national_code: ");
                                customer1 = customerBL1.searchCustomer(scanner.next());

                                if (customer1.getNational_code() == null) {
                                    System.out.println(" national_code not found ");

                                } else {
                                    BranchBL branchBL = new BranchBL();
                                    Customer customer2 = new Customer();
                                    System.out.print("Enter name: ");
                                    customer1.setName(scanner.next());
                                    System.out.print("Enter pass: ");
                                    customer1.setPassword(scanner.next());
                                    System.out.print("Enter national_code: ");
                                    customer1.setNational_code(scanner.next());
//                                    System.out.print("Enter nameBranchBank: ");
//                                    ArrayList <Branch> b2ranches =new ArrayList<>();
//                                    int idBranch=0;
//                                    String nameBranch=null;
//                                    branches= branchBL.searchByName(scanner.next());
//                                    if(branches==null){
//                                        System.out.println("nameBranchBank not Found ");
//                                        break;
//                                    }
//                                    for (Branch branch1 : branches) {
//                                        idBranch= branch1.getId();
//                                        nameBranch= branch1.getName();
//                                    }
//                                    customer1.setBranch_id(idBranch);
                                    int res = customerBL1.update(customer1, customer1.getId());
                                    if (res == 0) {
                                        System.out.println(" pleas try again");

                                    } else {
                                        System.out.println(" edit ok");

                                    }
                                }

                                break;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        case 5:
                            System.out.println("Open Account [1]");
                            System.out.println("List Account [2]");
                            System.out.println("show balance [3]");
                            System.out.println("add balance [4]");
                            System.out.println("Withdrawal from a Bank َAccount [5]");
                            System.out.println("close Account [7]");
                            int numAccount = scanner.nextInt();
                            switch (numAccount) {
                                case 1:
                                    int type;
                                    System.out.println("for type longTerm [1] OR for type shortTerm [2]");
                                    type = scanner.nextInt();

                                    try {
                                        AccountBL accountBL = new AccountBL();
                                        Account account = new Account();
                                        account.setType(type);
                                        System.out.println("enter national_code for select customer");
                                        Customer customer1 = customerBL.searchCustomer(scanner.next());
                                        if (customer1 == null) {
                                            System.out.println(" national_code not found ");
                                            break;

                                        } else {
                                            account.setCustomer_id(customer1.getId());

                                        }
                                        System.out.println("enter amount deposit ");
                                        account.setBalance(scanner.nextInt());


                                        Account account1 = accountBL.addAccount(account);
                                        if (account1 == null) {
                                            System.out.println("tye a gain ");

                                        } else {
                                            System.out.println(" open account successfully  ");
                                            break;

                                        }

                                        break;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                case 2:
                                    try {
                                        ArrayList<Account> accounts = new ArrayList<>();
                                        AccountBL accountBL = new AccountBL();
                                        CustomerBL customerBL1 = new CustomerBL();
                                        Customer customers = new Customer();
                                        accounts = accountBL.getAccount();
                                        for (Account item : accounts) {
                                            Customer customer1 = customerBL1.find(item.getCustomer_id());
                                            System.out.println("Customer is :" + customer1.getName());
                                            System.out.println("id is :" + "" + item.getId());
                                            if (item.getType() == 2)
                                                System.out.println("type is :shortTerm ");
                                            if (item.getType() == 1)
                                                System.out.println("type is :longTerm ");
                                            System.out.println("balance is :" + item.getBalance());
                                            System.out.println("-----------------------------------");
                                        }
                                        break;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                case 3:
                                    try {
                                        AccountBL accountBL = new AccountBL();
                                        ArrayList<Account> accounts = new ArrayList<>();
                                        Customer customer1 = new Customer();
                                        CustomerBL customerBL1 = new CustomerBL();

                                        System.out.print("Enter national_code: ");
                                        customer1 = customerBL1.searchCustomer(scanner.next());

                                        if (customer1.getNational_code() == null) {
                                            System.out.println(" national_code not found ");

                                        } else {
                                            accounts = accountBL.searchAccount(customer1.getId());
                                            for (Account account1 : accounts) {
                                                if (account1.getType() == 2)
                                                    System.out.println("type is :shortTerm ");
                                                if (account1.getType() == 1)
                                                    System.out.println("type is :longTerm ");
                                                System.out.println(" balance is : "+account1.getBalance());

                                            }
                                           }

                                            break;
                                        } catch(Exception e){
                                            e.printStackTrace();
                                        }
                                    }

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