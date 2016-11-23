package com.ait.corrigan.dao;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class CustomerDaoImplTest {
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
			 
			 
		
		
		
}
