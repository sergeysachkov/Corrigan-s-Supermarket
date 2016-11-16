package com.ait.corrigan.services;

import com.ait.corrigan.dao.CustomerDao;
import com.ait.corrigan.dao.CustomerDaoImpl;
import com.ait.corrigan.models.user.PaymentDetails;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerServiceImplTest {
    CustomerDao dao;

    @Before
    public void setUp(){
        dao = mock(CustomerDaoImpl.class);
    }
    @Test
    public void testAddPaymentDetails(){
        try {
            CustomerDao dao = mock(CustomerDaoImpl.class);
            CustomerServiceImpl service = new CustomerServiceImpl(dao);
            PaymentDetails paymentDetails = new PaymentDetails();
            paymentDetails.setCardNo("1111111111111111");
            paymentDetails.setCvv2("111");
            doNothing().when(dao).addPaymentDetails(1, paymentDetails);
            service.addPaymentDetails(1, paymentDetails);
        }catch (Exception e){
            fail();
        }
    }

    @Test
    public void testAddPaymentDetailsCardNoFailNumeric(){
        try {
            CustomerServiceImpl service = new CustomerServiceImpl(dao);
            PaymentDetails paymentDetails = new PaymentDetails();
            paymentDetails.setCardNo("abs");
            doNothing().when(dao).addPaymentDetails(1, paymentDetails);
            service.addPaymentDetails(1, paymentDetails);
            fail();
        }catch (Exception e){
            //test pass
        }
    }

    @Test
    public void testAddPaymentDetailsCardNoFailLength(){
        try {
            CustomerServiceImpl service = new CustomerServiceImpl(dao);
            PaymentDetails paymentDetails = new PaymentDetails();
            paymentDetails.setCardNo("12345");
            doNothing().when(dao).addPaymentDetails(1, paymentDetails);
            service.addPaymentDetails(1, paymentDetails);
            fail();
        }catch (Exception e){
            //test pass
        }
    }

    @Test
    public void testAddPaymentDetailsCardNo(){
        try {
            CustomerServiceImpl service = new CustomerServiceImpl(dao);
            PaymentDetails paymentDetails = new PaymentDetails();
            paymentDetails.setCardNo("1111111111111111");
            paymentDetails.setCvv2("111");
            doNothing().when(dao).addPaymentDetails(1, paymentDetails);
            service.addPaymentDetails(1, paymentDetails);
        }catch (Exception e){
            fail();
        }
    }

    @Test
    public void testAddPaymentDetailsCCV2FailNumeric(){
        try {
            CustomerServiceImpl service = new CustomerServiceImpl(dao);
            PaymentDetails paymentDetails = new PaymentDetails();
            paymentDetails.setCardNo("1111111111111111");
            paymentDetails.setCardNo("abc");
            doNothing().when(dao).addPaymentDetails(1, paymentDetails);
            service.addPaymentDetails(1, paymentDetails);
            fail();
        }catch (Exception e){
            //test pass
        }
    }

    @Test
    public void testAddPaymentDetailsCVV2FailLength(){
        try {
            CustomerServiceImpl service = new CustomerServiceImpl(dao);
            PaymentDetails paymentDetails = new PaymentDetails();
            paymentDetails.setCardNo("1111111111111111");
            paymentDetails.setCardNo("1234");
            doNothing().when(dao).addPaymentDetails(1, paymentDetails);
            service.addPaymentDetails(1, paymentDetails);
            fail();
        }catch (Exception e){
            //test pass
        }
    }

    @Test
    public void testAddPaymentDetailsCVV2(){
        try {
            CustomerServiceImpl service = new CustomerServiceImpl(dao);
            PaymentDetails paymentDetails = new PaymentDetails();
            paymentDetails.setCardNo("1111111111111111");
            paymentDetails.setCvv2("123");
            doNothing().when(dao).addPaymentDetails(1, paymentDetails);
            service.addPaymentDetails(1, paymentDetails);
        }catch (Exception e){
            fail();
        }
    }
}
