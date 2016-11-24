package com.ait.corrigan.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class AddressDaoImplTest {
	
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
	
	//======test address is present=======
	@Test
	public  void testGetAddress(){
		AddressDAOImpl i=new AddressDAOImpl();
		try{
			assertNotNull(i.getAddress(1));
		}catch (Exception e) {
			fail("No Exception expected .....");
			e.printStackTrace();
		}
	}
	
}