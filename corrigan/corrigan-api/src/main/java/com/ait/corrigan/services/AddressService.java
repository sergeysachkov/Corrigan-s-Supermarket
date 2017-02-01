package com.ait.corrigan.services;

import com.ait.corrigan.models.user.Address;
import com.ait.corrigan.models.user.PaymentDetails;

import java.util.List;

public interface AddressService {

    long addAddress(Address address);
    long updateAddress(Address address);
    void deleteAddress(long customerId);
    Address getAddress(long customerId);
    List<Address> getAddresses();

}