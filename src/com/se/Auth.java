//package com.se;
//
//import com.grf.db.Utils.Hash;
//import com.grf.db.model.bl.UserBL;
//import com.grf.db.model.to.User;
//import com.se.models.customer.Bl.CustomerBL;
//import com.se.models.customer.To.Customer;
//
//import java.lang.reflect.InvocationTargetException;
//import java.sql.SQLException;
//
//public class Auth {
//
//    private Customer customer;
//    private CustomerBL customerBL;
//
//    public Auth() throws ClassNotFoundException {
//        customerBL = new CustomerBL();
//    }
//
//    public int getId() {
//        if (customer != null) {
//            return customer.getId();
//        }
//        return 0;
//    }
//
//    public Customer getUser() {
//        return customer;
//    }
//
//    public boolean check() {
//        if (customer != null) {
//            return true;
//        }
//        return false;
//    }
//
//    public boolean login(String username, String password) throws SQLException {
//        Customer customer = customerBL.findByUsername(username);
//        if (user != null) {
//            if (user.getPassword().equals(Hash.MD5(password.trim()))) {
//                this.user = user;
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public void logout() {
//        user = null;
//    }
//
//    public void register(String username, String password) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
//        userBL.register(username, Hash.MD5(password.trim()));
//    }
//
//    public boolean hasUser(String username) throws SQLException {
//        User user = userBL.findByUsername(username);
//        if (user != null) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//
//}
