package com.ait.corrigan.services;

import com.ait.corrigan.dao.*;
import com.ait.corrigan.models.user.Address;
import com.ait.corrigan.models.user.Customer;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class AddressServiceImplTestIT {

	private long customerId;
    @Before
    public void setUp(){
       createUserTable();
       createAddressTable();
        createCustomer();
    }

    private void createCustomer() {
        CustomerDao dao = new CustomerDaoImpl();
        CustomerService service = new CustomerServiceImpl(dao);
        Customer customer = new Customer();
        customer.setCustomerName("John");
        customer.setCustomerSurname("Handy");
        customer.setCustomerDateOfBirth(new Date(System.currentTimeMillis()));
        dao.addCustomer(customer);
        customerId = service.addCustomer(customer);
    }

    @Test
    public void testAddAddress(){
        try {
            AddressDAO dao = new AddressDAOImpl();
            AddressService service = new AddressServiceImpl(dao);
            Address address = new Address();
            address.setAdressLine1("Athlone");
            address.setAdressLine2("Westmeath");
            address.setCustomerId(customerId);
            dao.addAddress(address);
            long id = service.addAddress(address);
            assertEquals(id, 1);
        }catch (Exception e){
            fail();
        }
}

private void createUserTable(){
    try(Connection connection = DaoUtil.getConnection();
        PreparedStatement stmt=connection.prepareStatement("CREATE TABLE customer ( " +
                "  idcustomer int(11) NOT NULL AUTO_INCREMENT, " +
                "  customer_name varchar(45) DEFAULT NULL, " +
                "  customer_surname varchar(45) DEFAULT NULL, " +
                "  customer_login varchar(45) DEFAULT NULL, " +
                "  password varchar(45) DEFAULT NULL, " +
                "  phone_number varchar(45) DEFAULT NULL, " +
                "  email varchar(45) DEFAULT NULL, " +
                "  date_of_birth date DEFAULT NULL, " +
                "  PRIMARY KEY (idcustomer), " +
                "  UNIQUE KEY customer_login_UNIQUE (customer_login), " +
                "  UNIQUE KEY phone_number_UNIQUE (phone_number), " +
                "  UNIQUE KEY email_UNIQUE (email)" +
                ");")
    ) {
        stmt.executeUpdate();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

private void createAddressTable(){
        try(Connection connection = DaoUtil.getConnection();
            PreparedStatement stmt=connection.prepareStatement("CREATE TABLE address (" +
                    "adress_id int(11) NOT NULL AUTO_INCREMENT, " +
                    "  adress_line_1 varchar(45) DEFAULT NULL, " +
                    "  adress_line_2 varchar(45) DEFAULT NULL, " +
                    "  town varchar(45) DEFAULT NULL, " +
                    "  county varchar(45) DEFAULT NULL, " +
                    "  eircode varchar(45) DEFAULT NULL, " +
                    "  customer int(11) NOT NULL, " +
                    "  PRIMARY KEY (adress_id)," +
                    "  CONSTRAINT customer_add FOREIGN KEY (customer) REFERENCES customer (idcustomer)" +
                    ");");
        ) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}