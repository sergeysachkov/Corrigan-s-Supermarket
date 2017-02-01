package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.PaymentDetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 11/17/2016.
 */
public class PaymentDaoImpl implements PaymentDao{

    public long addPaymentDetails(long customerId, PaymentDetails paymentDetails) throws SQLException {
        if(getPaymentDetailByCardNo(paymentDetails.getCardNo()) != null){
            throw new SQLException("Record with card number {} already exists", paymentDetails.getCardNo());
        }
        try(Connection connection = DaoUtil.getConnection();
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
        return getPaymentDetailByCardNo(paymentDetails.getCardNo()).getId();
    }
    
    public long updatePaymentDetails(long customerId, PaymentDetails paymentDetails) throws SQLException{
        
        try(Connection connection = DaoUtil.getConnection();
            PreparedStatement stmt=connection.prepareStatement("UPDATE payment SET card_type=?, card_no=?, exp_date=?, cvv2=?, card_holder=? where idpayment=?"
                   ,Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, paymentDetails.getType().name());
            stmt.setString(2, paymentDetails.getCardNo());
            stmt.setDate(3, new Date(paymentDetails.getExpireDate().getTime()));
            stmt.setString(4, paymentDetails.getCvv2());
            stmt.setString(5, paymentDetails.getCardHolder());
            stmt.setLong(6, customerId);
            stmt.executeUpdate();
		}
        
        return getPaymentDetailByCardNo(paymentDetails.getCardNo()).getId();
    }


    public List<PaymentDetails> getPaymentDetails(long customerId) throws SQLException {
        List<PaymentDetails> paymentDetails = new ArrayList<>();
        try(Connection connection = DaoUtil.getConnection();
            PreparedStatement stmt=connection.prepareStatement("select * from payment where customer=?")) {
            stmt.setLong(1, customerId);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                PaymentDetails paymentDetail = new PaymentDetails();
                paymentDetail.setType(PaymentDetails.CardType.valueOf(resultSet.getString("card_type")));
                paymentDetail.setCardHolder(resultSet.getString("card_holder"));
                paymentDetail.setCardNo(resultSet.getString("card_no"));
                paymentDetail.setCvv2(resultSet.getString("cvv2"));
                paymentDetail.setExpireDate(resultSet.getDate("exp_date"));
                paymentDetails.add(paymentDetail);
            }
        }
        return paymentDetails;
    }

    public List<String> getPaymentCards(long customerId) throws SQLException{
        List<String> paymentDetails = new ArrayList<>();
        try(Connection connection = DaoUtil.getConnection();
            PreparedStatement stmt=connection.prepareStatement("select card_no from payment where customer=?")) {
            stmt.setLong(1, customerId);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                paymentDetails.add(resultSet.getString("card_no"));
            }
        }
        return paymentDetails;
    }

    public PaymentDetails getPaymentDetail(long id) throws SQLException {
        PaymentDetails paymentDetail = new PaymentDetails();
        try(Connection connection = DaoUtil.getConnection();
            PreparedStatement stmt=connection.prepareStatement("select * from payment where idpayment=?")) {
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                paymentDetail.setType(PaymentDetails.CardType.valueOf(resultSet.getString("card_type")));
                paymentDetail.setCardHolder(resultSet.getString("card_holder"));
                paymentDetail.setCardNo(resultSet.getString("card_no"));
                paymentDetail.setCvv2(resultSet.getString("cvv2"));
                paymentDetail.setExpireDate(resultSet.getDate("exp_date"));

            }
        }
        return paymentDetail;
    }

    public PaymentDetails getPaymentDetailByCardNo(String cardNo) throws SQLException {
        try(Connection connection = DaoUtil.getConnection();
            PreparedStatement stmt=connection.prepareStatement("select * from payment where card_no=?")) {
            stmt.setString(1, cardNo);
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                PaymentDetails paymentDetail = new PaymentDetails();
                paymentDetail.setId(resultSet.getLong("idpayment"));
                paymentDetail.setType(PaymentDetails.CardType.valueOf(resultSet.getString("card_type")));
                paymentDetail.setCardHolder(resultSet.getString("card_holder"));
                paymentDetail.setCardNo(resultSet.getString("card_no"));
                paymentDetail.setCvv2(resultSet.getString("cvv2"));
                paymentDetail.setExpireDate(resultSet.getDate("exp_date"));
                return paymentDetail;

            }
        }
        return null;
    }

    public void deletePaymentDetails(long customerId, long paymentDetailsId){}
}
