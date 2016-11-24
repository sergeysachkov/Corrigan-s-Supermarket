package com.ait.corrigan.services;

import com.ait.corrigan.dao.CustomerDao;
import com.ait.corrigan.dao.CustomerDaoImpl;
import com.ait.corrigan.dao.PaymentDao;
import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerServiceImplTest {

	CustomerDao dao;
	
    @Before
    public void setUp(){
        dao = mock(CustomerDao.class);
    }
    @Test
    public void testAddCustomer(){
        try {
            CustomerDao dao = mock(CustomerDao.class);
            CustomerService service = new CustomerServiceImpl(dao);
            Customer customer = new Customer();
            customer.setCustomerName("John");
            customer.setCustomerSurname("Handy");
            when(dao.addCustomer(customer)).thenReturn(1l);
            long id = service.addCustomer(customer);
            assertEquals(id, 1);
        }catch (Exception e){
            fail();
        }
}
}