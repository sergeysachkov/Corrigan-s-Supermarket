package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;

import java.sql.*;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao{

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/corrigan","root","2585");
        return con;
    }
    public long addCustomer(Customer customer){return 0;}
    public long updateCustomer(Customer customer){return 0;}
    public void deleteCustomer(long customerId){}
    public Customer getCustomer(long customerId){
        return null;
    }

    public boolean checkCustomer(String user, String password){return false;}

    public void addPaymentDetails(long customerId, PaymentDetails paymentDetails) throws SQLException, ClassNotFoundException {
        try(Connection connection = getConnection();
        PreparedStatement stmt=connection.prepareStatement("INSERT INTO payment (customer, card_type,card_no,exp_date, cvv2, card_holder) " +
                "VALUES (?, ?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setLong(1, customerId);
            stmt.setString(2, paymentDetails.getType().name());
            stmt.setString(3, paymentDetails.getCardNo());
            stmt.setDate(4, new Date(paymentDetails.getExpireDate().getTime()));
            stmt.setString(5, paymentDetails.getCvv2());
            stmt.setString(6, paymentDetails.getCardHolder());
            stmt.executeUpdate();
        }
    }


    public List<PaymentDetails> getPaymentDetails(long customerId){
        return null;
    }
    public void deletePaymentDetails(long customerId, long paymentDetailsId){}
}
