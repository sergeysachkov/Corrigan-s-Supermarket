package com.ait.corrigan.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ait.corrigan.models.shop.Item;

public class ItemDaoImplTestIT {

	private DaoTestHelper helper = new DaoTestHelper();
	@Before
	public void setUp() {
		helper.executeQueryUpdate("table.categories.create");
		helper.executeQueryUpdate("table.items.create");
	}

	//======test item present=======
	@Test
	public  void testGetItem(){
		ItemDaoImpl i=new ItemDaoImpl();
		try{
			long id = createItem("some");
			assertNotNull(i.getItem(id));
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
			long id = createItem("some");
			assertNull(i.getItem(id+10));
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
			createItem("some");
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
			createItem("fruit");
			allItems=i.getItemsByCategory("fruit");
			System.out.println(allItems.get(0).getName());
			assertEquals("apple", allItems.get(0).getName());
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
			createItem("vegetables");
			allItems=i.getItemsByCategory("vegetables");
			System.out.println(allItems.get(0).getName());
			assertEquals("apple", allItems.get(0).getName());
		}catch (Exception e) {
			fail("No Exception expected .....");
			e.printStackTrace();
		}
	}

	private long createItem(String category){
		ItemDaoImpl i=new ItemDaoImpl();
		CategoryDAOImpl c = new CategoryDAOImpl();
		long id = DaoUtil.getUniqueId();
		Item item = new Item();
		item.setItemID(id);
		item.setCate_name(category);
		item.setCateID(1);
		item.setDescription("Desc");
		item.setName("apple");
		item.setPrice(100);
		item.setStock_q(100);
		try {
			c.addCategory(1, category);
			i.addItem(item);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	@After
	public void tearDown() {
		helper.executeQueryUpdate("table.items.drop");
		helper.executeQueryUpdate("table.categories.drop");
	}
}
