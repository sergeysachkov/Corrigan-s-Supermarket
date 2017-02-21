package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.services.CustomerService;
import com.ait.corrigan.services.CustomerServiceImpl;
import com.ait.corrigan.utils.DBPropertyUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by esersac on 21/02/2017.
 */
public class DaoTestHelper {

    public void executeQueryUpdate(String name) {
        try (Connection connection = DaoUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(new DBPropertyUtil().getProperty(name));
        ) {
            stmt.executeUpdate();
        } catch (SQLException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public long createCustomer() {
        CustomerDao dao = new CustomerDaoImpl();
        CustomerService service = new CustomerServiceImpl(dao);
        Customer customer = new Customer();
        customer.setCustomerName("John");
        customer.setCustomerSurname("Handy");
        customer.setCustomerLogin("A123");
        customer.setPassword("loginin");
        customer.setCustomerDateOfBirth(new Date(System.currentTimeMillis()));
        return service.addCustomer(customer);
    }
}
