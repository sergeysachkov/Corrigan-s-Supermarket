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

 public void testCheckCustomer(){
	 CustomerDao first = mock(CustomerDao.class);
	 
	 try {

		 first.checkCustomer("A123","loginin");

          } catch (Exception e) {

	  fail();
    
 }
 }
	 public void testCheckCustomer2(){
		 CustomerDao first = mock(CustomerDao.class);
		 
		 try {

			 first.checkCustomer(" ","loginin");
		       fail();

	          } catch (Exception e) {	  
	    
	 }
 }

	    
	    @Test
	    public void testAddCustomerFailOnPhoneNumber(){
	        try {
	            CustomerServiceImpl service = new CustomerServiceImpl(dao);
	            Customer customer = new Customer();
	            customer.setPhoneNumber("This should be a number");
	            doNothing().when(dao).addCustomer(customer);
	            service.addCustomer(customer);
	            fail();
	        }catch (Exception e){
	            //test pass
	        }
	    }
	    
	    @Test
	    public void testAddCustomerFailOnEmail(){
	        try {
	            CustomerServiceImpl service = new CustomerServiceImpl(dao);
	            Customer customer = new Customer();
	            customer.setEmail("myemailatexample.com");
	            doNothing().when(dao).addCustomer(customer);
	            service.addCustomer(customer);
	            fail();
	        }catch (Exception e){
	            //test pass
	        }
	    }
	    
	    @Test
	    public void testCustomerPresent(){
	        try {
	            CustomerDao dao = mock(CustomerDao.class);
	            CustomerService service = new CustomerServiceImpl(dao);
	            Customer customer = new Customer();
	            customer.setCustomerName("John");
	            customer.setCustomerSurname("Jones");
	            customer.setCustomerLogin("admin");
	            customer.setPassword("admin");
	            customer.setPhoneNumber("0987654321");
	            customer.setEmail("jhandy@gmail.com");
	            when(dao.addCustomer(customer)).thenReturn(1l);
	            long id = service.addCustomer(customer);
	            assertEquals(id, 1);
	        }catch (Exception e){
	            fail();
	        }}
	    
	    @Test
	    public void testUpdateCustomer(){
	        try {
	            CustomerDao dao = mock(CustomerDao.class);
	            CustomerService service = new CustomerServiceImpl(dao);
	            Customer customer = new Customer();
	            customer.setCustomerName("John");
	            customer.setCustomerSurname("Jones");
	            customer.setCustomerLogin("admin");
	            customer.setPassword("admin");
	            customer.setPhoneNumber("0987654321");
	            customer.setEmail("jhandy@gmail.com");
	            when(dao.addCustomer(customer)).thenReturn(1l);
	            service.addCustomer(customer);
	            String name = customer.getCustomerName();
	            assertEquals(name, "John");
	        }catch (Exception e){
	            fail();
	        }}

}