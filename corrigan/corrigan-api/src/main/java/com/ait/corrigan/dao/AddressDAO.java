package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.Address;
import com.ait.corrigan.models.user.PaymentDetails;

import java.sql.SQLException;
import java.util.List;

public interface AddressDAO {

    long addAddress(Address address);
    long updateAddress(Address address);
    void deleteAddress(long customerId);
    Address getAddress(long customerId) throws SQLException;
    List<Address> getAddresses() throws SQLException;
}