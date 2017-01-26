package com.ait.corrigan.services;

import com.ait.corrigan.dao.OrderDao;
import com.ait.corrigan.exception.CorriganException;
import com.ait.corrigan.models.user.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

/**
 * Created by root on 1/21/2017.
 */
public class PayServiceImpl implements PayService{
    private OrderDao dao = new OrderDaoImpl();
    private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    public long createOrderAndPay(Order order){
        try {
            long orderId = dao.addOrder(order);
            //todo pay for order here
            return orderId;
        } catch (SQLException e) {
            logger.error("Error occurred!", e);
            throw new CorriganException(e.getMessage());
        }
    }
}
