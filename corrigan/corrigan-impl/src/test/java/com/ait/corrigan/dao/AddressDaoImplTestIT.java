package com.ait.corrigan.dao;

import com.ait.corrigan.dao.*;
import com.ait.corrigan.models.user.Address;
import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.services.AddressService;
import com.ait.corrigan.services.AddressServiceImpl;
import com.ait.corrigan.services.CustomerService;
import com.ait.corrigan.services.CustomerServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class AddressDaoImplTestIT {

    private long customerId;
    private DaoTestHelper helper = new DaoTestHelper();
    @Before
    public void setUp() {
        helper.executeQueryUpdate("table.customer.create");
        helper.executeQueryUpdate("table.address.create");
        customerId = helper.createCustomer();
    }

    @Test
    public void testAddAddress() {
        try {
            AddressDAO dao = new AddressDAOImpl();
            AddressService service = new AddressServiceImpl(dao);
            Address address = new Address();
            address.setAdressLine1("Athlone");
            address.setAdressLine2("Westmeath");
            address.setCustomerId(customerId);
            long id = service.addAddress(address);
            assertEquals(id, 1);
        } catch (Exception e) {
            fail();
        }
    }



    @After
    public void tearDown(){
        helper.executeQueryUpdate("table.address.drop");
        helper.executeQueryUpdate("table.customer.drop");
    }
}