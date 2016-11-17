package com.ait.corrigan.services;

import com.ait.corrigan.dao.PaymentDao;
import com.ait.corrigan.models.user.PaymentDetails;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

/**
 * Created by root on 11/17/2016.
 */
public class PaymentServiceImplTest {
    PaymentDao dao;

    @Before
    public void setUp(){
        dao = mock(PaymentDao.class);
    }
    @Test
    public void testAddPaymentDetails(){
        try {
            PaymentDao dao = mock(PaymentDao.class);
            PaymentService service = new PaymentServiceImpl(dao);
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
            PaymentServiceImpl service = new PaymentServiceImpl(dao);
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
            PaymentServiceImpl service = new PaymentServiceImpl(dao);
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
            PaymentServiceImpl service = new PaymentServiceImpl(dao);
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
            PaymentServiceImpl service = new PaymentServiceImpl(dao);
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
            PaymentServiceImpl service = new PaymentServiceImpl(dao);
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
            PaymentServiceImpl service = new PaymentServiceImpl(dao);
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
