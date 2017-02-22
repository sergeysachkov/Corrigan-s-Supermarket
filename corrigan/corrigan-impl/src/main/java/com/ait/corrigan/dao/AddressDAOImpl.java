
package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;
import com.ait.corrigan.models.user.Address;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDAOImpl implements AddressDAO{

    public long addAddress(Address address){

    try(Connection connection = DaoUtil.getConnection();
        PreparedStatement stmt=connection.prepareStatement("INSERT INTO address (customer, adress_line_1, adress_line_2, town, county, eircode) " +
                "VALUES ( ?, ?,?,?,?, ?)", Statement.RETURN_GENERATED_KEYS)) {
    	stmt.setLong(1, address.getCustomerId());
    	stmt.setString(2, address.getAdressLine1());
        stmt.setString(3, address.getAdressLine2());
        stmt.setString(4, address.getTown());
        stmt.setString(5, address.getCounty());
        stmt.setString(6, address.getEircode());
        stmt.executeUpdate();
    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return 1;
}
    
    public long updateAddress(long customerId, Address address){

    try(Connection connection = DaoUtil.getConnection();
        PreparedStatement stmt=connection.prepareStatement("UPDATE address SET adress_line_1 = ?, adress_line_2 =?, town = ?, county = ?, eircode =? where adress_id = ?" 
        		, Statement.RETURN_GENERATED_KEYS)) {
        stmt.setString(1, address.getAdressLine1());
        stmt.setString(2, address.getAdressLine2());
        stmt.setString(3, address.getTown());
        stmt.setString(4, address.getCounty());
        stmt.setString(5, address.getEircode());
        stmt.setLong(6, customerId);
        
        stmt.executeUpdate();
    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return 1;
}
    public void deleteAddress(long customerId){}
    public Address getAddress(long customerId) throws SQLException {
        Address address = new Address();
        try(Connection connection = DaoUtil.getConnection();
            PreparedStatement stmt=connection.prepareStatement("select * from address where adress_id=?")) {
            stmt.setLong(1, customerId);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                address.setAdressLine1(resultSet.getString("adress_line_1"));
                address.setAdressLine2(resultSet.getString("adress_line_2"));
                address.setTown(resultSet.getString("town"));
                address.setCounty(resultSet.getString("county"));
                address.setEircode(resultSet.getString("eircode"));

            }
        }
        return address;
    }

    public List<Address> getAddresses() throws SQLException {
        List<Address> addresses = new ArrayList<>();
        try(Connection connection = DaoUtil.getConnection();
            PreparedStatement stmt=connection.prepareStatement("select * from address")) {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                Address address = new Address();
                address.setAdressLine1(resultSet.getString("address_line_1"));
                address.setAdressLine2(resultSet.getString("address_line_2"));
                address.setTown(resultSet.getString("town"));
                address.setCounty(resultSet.getString("county"));
                address.setEircode(resultSet.getString("eircode"));
                addresses.add(address);
            }
        }
        return addresses;
    }
    
    public Address getAddressByID(String ID) throws SQLException {
        try(Connection connection = DaoUtil.getConnection();
            PreparedStatement stmt=connection.prepareStatement("select * from address where adress_id=?")) {
            stmt.setString(1, ID);
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                Address address = new Address();
                address.setAdressId(resultSet.getLong("adress_id"));
                address.setAdressLine1(resultSet.getString("adress_line_1"));
                address.setAdressLine2(resultSet.getString("adress_line_2"));
                address.setTown(resultSet.getString("town"));
                address.setCounty(resultSet.getString("county"));
                address.setEircode(resultSet.getString("eircode"));
                return address;

            }
        }
        return null;
    }



}