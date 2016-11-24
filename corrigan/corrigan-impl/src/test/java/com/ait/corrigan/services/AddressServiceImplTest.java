package com.ait.corrigan.services;

import com.ait.corrigan.dao.AddressDAO;
import com.ait.corrigan.dao.CustomerDao;
import com.ait.corrigan.dao.CustomerDaoImpl;
import com.ait.corrigan.dao.PaymentDao;
import com.ait.corrigan.models.user.Address;
import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressServiceImplTest {

	AddressDAO dao;
	
    @Before
    public void setUp(){
        dao = mock(AddressDAO.class);
    }
    @Test
    public void testAddCustomer(){
        try {
            AddressDAO dao = mock(AddressDAO.class);
            AddressService service = new AddressServiceImpl(dao);
            Address address = new Address();
            address.setAdressLine1("Athlone");
            address.setAdressLine2("Westmeath");
            when(dao.addAddress(address)).thenReturn(1l);
            long id = service.addAddress(address);
            assertEquals(id, 1);
        }catch (Exception e){
            fail();
        }
}
}