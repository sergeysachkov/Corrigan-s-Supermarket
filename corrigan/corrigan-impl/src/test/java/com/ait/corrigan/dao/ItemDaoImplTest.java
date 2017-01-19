package com.ait.corrigan.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ait.corrigan.models.shop.Item;

public class ItemDaoImplTest {

	/*
	
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
	//=====test get items by category fruit======
	
	@Test
	public void testGetItemsByCategory(){
		ItemDaoImpl i=new ItemDaoImpl();
		 List<Item> allItems = new ArrayList<Item>();
		try{
			allItems=i.getItemsByCategory("fruit");
			System.out.println(allItems.get(0).getName());
			assertEquals("apples", allItems.get(0).getName());
		}catch (Exception e) {
			fail("No Exception expected .....");
			e.printStackTrace();
		}
	}
	
	//=====test get items by category vegetables======
	@Test
	public void testGetItemsByCategory2(){
		ItemDaoImpl i=new ItemDaoImpl();
		 List<Item> allItems = new ArrayList<Item>();
		try{
			allItems=i.getItemsByCategory("vegetables");
			System.out.println(allItems.get(0).getName());
			assertEquals("lemons", allItems.get(0).getName());
		}catch (Exception e) {
			fail("No Exception expected .....");
			e.printStackTrace();
		}
	}
	
*/
}
