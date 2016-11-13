package com.ait.corrigan.services;

import com.ait.corrigan.dao.CustomerDao;
import com.ait.corrigan.dao.CustomerDaoImpl;
import com.ait.corrigan.models.user.PaymentDetails;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerServiceImplTest {

    @Test
    public void testAddPaymentDetails(){
        try {
            CustomerDao dao = mock(CustomerDaoImpl.class);
            CustomerServiceImpl service = new CustomerServiceImpl(dao);
            doNothing().when(dao).addPaymentDetails(1, new PaymentDetails());
            service.addPaymentDetails(1, new PaymentDetails());
        }catch (Exception e){
            fail();
        }
    }
}
