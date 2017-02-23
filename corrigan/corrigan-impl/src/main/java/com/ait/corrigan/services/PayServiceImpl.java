package com.ait.corrigan.services;

import com.ait.corrigan.dao.OrderDaoImpl;
import com.ait.corrigan.dao.OrderDao;
import com.ait.corrigan.dao.PaymentDao;
import com.ait.corrigan.dao.PaymentDaoImpl;
import com.ait.corrigan.exception.CorriganException;
import com.ait.corrigan.models.user.Order;
import com.ait.corrigan.models.user.PaymentDetails;
import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 1/21/2017.
 */
public class PayServiceImpl implements PayService{
    private OrderDao orderDao = new OrderDaoImpl();
    private PaymentDao paymentDao = new PaymentDaoImpl();
    private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    public long createOrderAndPay(String cardNo, Order order){
        try {
            Stripe.apiKey = "sk_test_BxWD4Cw0CJ4n5GRnMqeSEFPz";
            //todo pay for order here need to decide on payment system.

            PaymentDetails paymentDetails = paymentDao.getPaymentDetailByCardNo(cardNo);
            final Map<String, Object> cardParams = new HashMap<>();
            cardParams.put("number", paymentDetails.getCardNo());
            Date expiryDate = paymentDetails.getExpireDate();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(expiryDate);
            cardParams.put("exp_month", calendar.get(Calendar.MONTH) + 1);
            cardParams.put("exp_year", calendar.get(Calendar.YEAR));
            cardParams.put("cvc", paymentDetails.getCvv2());
            cardParams.put("name", paymentDetails.getCardHolder());

            final Map<String, Object> chargeParams = new HashMap<>();
            //chargeParams.put("amount", order.getPrice());
            //todo replace when basket is integrated together with checkout page
            chargeParams.put("amount", "100");
            chargeParams.put("currency", "usd");
            chargeParams.put("card", cardParams);
            final Charge charge = Charge.create(chargeParams);
            long orderId = orderDao.addOrder(order);
            return orderId;
        } catch (SQLException | APIConnectionException | InvalidRequestException | AuthenticationException | APIException | CardException e) {
            logger.error("Error occurred!", e);
            throw new CorriganException(e.getMessage());
        } 
    }
}
