package com.ait.corrigan.services;

import com.ait.corrigan.dao.AddressDAO;
import com.ait.corrigan.dao.AddressDAOImpl;
import com.ait.corrigan.exception.CorriganException;
import com.ait.corrigan.models.user.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;


public class AddressServiceImpl implements AddressService{
    private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private AddressDAO addressDao;

    public AddressServiceImpl() {
        addressDao = new AddressDAOImpl();
    }

    public AddressServiceImpl(AddressDAO addressDao) {
        this.addressDao = addressDao;
    }

    public long addAddress(Address address){
        return addressDao.addAddress(address);
    }

    public long updateAddress(Address address){
        return addressDao.updateAddress(address);
    }
    public void deleteAddress(long customerId){
        addressDao.deleteAddress(customerId);
    }

    public Address getAddress(long customerId){
        try {
            return addressDao.getAddress(customerId);
        } catch (SQLException e) {
            throw new CorriganException(e.getMessage());
        }
    }

    public List<Address> getAddresses(){
        try {
            return addressDao.getAddresses();
        } catch (SQLException e) {
            throw new CorriganException(e.getMessage());
        }
    }

}