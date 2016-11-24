package com.ait.corrigan.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

public class CustomerDaoImplTest {
	@Ignore
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
	@Ignore
	//======test customer is present=======
	@Test
	public  void testGetCustomer(){
		CustomerDaoImpl i=new CustomerDaoImpl();
		try{
			assertNotNull(i.getCustomerByID(1));
		}catch (Exception e) {
			fail("No Exception expected .....");
			e.printStackTrace();
		}
	}

	
	//=====test get all items====
	@Ignore
	@Test
	public void testGetAllCustomer(){
		CustomerDaoImpl i=new CustomerDaoImpl();
		try{
			assertNotNull(i.getCustomers());
		}catch (Exception e) {
			fail("No Exception expected .....");
			e.printStackTrace();
		}
	}
}
