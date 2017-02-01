package com.ait.corrigan.dao;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Ignore;

import org.junit.Test;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;
import com.ait.corrigan.services.CustomerService;
import com.ait.corrigan.services.CustomerServiceImpl;
import com.ait.corrigan.services.PaymentService;
import com.ait.corrigan.services.PaymentServiceImpl;

public class CustomerDaoImplTest {
	
    

	
	//=====test get all customers====
	@Ignore
	//@Test
	public void testGetAllCustomer(){
		CustomerDaoImpl i=new CustomerDaoImpl();
		try{
			assertNotNull(i.getCustomers());
		}catch (Exception e) {
			fail("No Exception expected .....");
			e.printStackTrace();
		}
	}

	/*
	//========test connection=====
		@Test
		public  void testGetConnection(){
			Connection con=null;
			try {
				con=DaoUtil.getConnection();
				assertNotNull(con);
			} catch (SQLException e) {
				fail("No Exception expected .....");
				e.printStackTrace();
			}
			
		}
		
		public void testCheckCustomer(){
			 CustomerDaoImpl first = new CustomerDaoImpl();
			 
			 try {

			       CustomerDao.checkCustomer("A123","loginin");

		          } catch (Exception e) {

		        	 assertSame("Invild value", e.getMessage());
		    
		 }
		 }
			 public void testCheckCustomer2(){
				 CustomerDao first = mock(CustomerDao.class);
				 
				 try {

				       CustomerDao.checkCustomer(" ","loginin");
				       fail();

			          } catch (Exception e) {	 
			        	  assertNotSame("Invild value", e.getMessage());
			          }
			    
			 }
			 
			 
		
		
		*/

}
