package com.ait.corrigan.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.ait.corrigan.models.shop.Item;
public class ItemDaoImplTest {
	

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
	
	//======test item present=======
	@Test
	public  void testGetItem(){
		ItemDaoImpl i=new ItemDaoImpl();
		try{
			assertNotNull(i.getItem(102));
		}catch (Exception e) {
			fail("No Exception expected .....");
			e.printStackTrace();
		}
	}
	
	//=====test item not present====
	
	@Test
	public  void testGetItemNot(){
		ItemDaoImpl i=new ItemDaoImpl();
		try{
			assertNull(i.getItem(200));
		}catch (Exception e) {
			fail("No Exception expected .....");
			e.printStackTrace();
		}
	}
	
	//=====test get all items====
	
	@Test
	public void testGetAllItems(){
		ItemDaoImpl i=new ItemDaoImpl();
		try{
			assertNotNull(i.getAllItems());
		}catch (Exception e) {
			fail("No Exception expected .....");
			e.printStackTrace();
		}
	}
}
