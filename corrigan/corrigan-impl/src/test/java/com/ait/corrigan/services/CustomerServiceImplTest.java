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
 public void setUp(){
	        dao = mock(CustomerDao.class);
	      
}
 public void testCheckCustomer(){
	 CustomerDao first = mock(CustomerDao.class);
	 
	 try {

	       CustomerDao.checkCustomer("A123","loginin");

          } catch (Exception e) {

	  fail();
    
 }
 }
	 public void testCheckCustomer2(){
		 CustomerDao first = mock(CustomerDao.class);
		 
		 try {

		       CustomerDao.checkCustomer(" ","loginin");
		       fail();

	          } catch (Exception e) {	  
	    
	 }
	 
	 
	 
 
 }
}