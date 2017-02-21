package com.ait.corrigan.dao;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

import org.junit.Test;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;
import com.ait.corrigan.services.CustomerService;
import com.ait.corrigan.services.CustomerServiceImpl;
import com.ait.corrigan.services.PaymentService;
import com.ait.corrigan.services.PaymentServiceImpl;

public class CustomerDaoImplTestIT {

    private DaoTestHelper helper = new DaoTestHelper();

    @Before
    public void setUp(){
        helper.executeQueryUpdate("table.customer.create");
    }


    //=====test get all customers====
    @Test
    public void testGetAllCustomer() {
        CustomerDaoImpl i = new CustomerDaoImpl();
        try {
            helper.createCustomer();
            assertNotNull(i.getCustomers());
        } catch (Exception e) {
            fail("No Exception expected .....");
            e.printStackTrace();
        }
    }

    @Test
    public void testCheckCustomer() {
        CustomerDaoImpl first = new CustomerDaoImpl();

        try {
            helper.createCustomer();
            first.checkCustomer("A123", "loginin");

        } catch (Exception e) {

            assertSame("Invild value", e.getMessage());

        }
    }

    @Test
    public void testCheckCustomer2() {
        CustomerDao first = mock(CustomerDao.class);
        helper.createCustomer();
        boolean exists = first.checkCustomer(" ", "loginin");
        assertEquals(exists, false);
    }

    @After
    public void tearDown(){
        helper.executeQueryUpdate("table.customer.drop");
    }
}
