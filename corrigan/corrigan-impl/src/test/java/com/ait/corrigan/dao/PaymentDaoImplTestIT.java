package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;
import com.ait.corrigan.services.CustomerService;
import com.ait.corrigan.services.CustomerServiceImpl;
import com.ait.corrigan.services.PaymentService;
import com.ait.corrigan.services.PaymentServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

/**
 * Created by root on 11/17/2016.
 */
public class PaymentDaoImplTestIT {

    PaymentDao dao;
    private DaoTestHelper helper = new DaoTestHelper();

    @Before
    public void setUp(){
        dao = new PaymentDaoImpl();
        helper.executeQueryUpdate("table.customer.create");
        helper.executeQueryUpdate("table.payment.create");
    }
    @Test
    public void testAddPaymentDetails(){
        try {
            long custId = helper.createCustomer();
            PaymentDetails paymentDetails = new PaymentDetails();
            paymentDetails.setCardNo("1111111111111111");
            paymentDetails.setCvv2("111");

            paymentDetails.setType(PaymentDetails.CardType.MASTERCARD);
            paymentDetails.setExpireDate(new Date(System.currentTimeMillis()));
            paymentDetails.setCardHolder("admin admin");

            long id = dao.addPaymentDetails(custId, paymentDetails);
            assertTrue(id > 0);
        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }


}
