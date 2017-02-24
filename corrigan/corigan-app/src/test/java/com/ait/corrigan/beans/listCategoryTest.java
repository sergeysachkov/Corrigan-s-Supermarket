package com.ait.corrigan.beans;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import com.ait.corrigan.dao.CategoryDAOImpl;
import com.ait.corrigan.dao.DaoUtil;
import com.ait.corrigan.dao.StockControlDaoImpl;
import com.ait.corrigan.models.shop.Category;
import com.ait.corrigan.models.shop.Item;
import com.ait.corrigan.services.CategoryService;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class listCategoryTest {
	private CategoryService csrv;
	 private AddCategoryBean bean;
	 private ListCategoryBean bean1;
	 private  Category category;
	
	/* @Before
	 public void setup(){
		 
		 csrv = mock(CategoryService.class);
		 bean1 = new ListCategoryBean();
		 bean1.setCateId(1);
		 category = new Category(1,"cc");
		  when(csrv.getCategory(1)).thenReturn(category);
	        bean1.populateCategory();
	 }
	/* @Test
	public void testpopulateCategory() {
		 System.out.println("populateCategory");
		 Category mockCategory = new Category(1,"cc");
	        assertEquals(mockCategory, bean1.getCategoryList());
	}*/
	 /*
	 @Test
	    public void testGetCategoryList() {
	        System.out.println("getCategoryList");
	        List<Category> mockCategories = new ArrayList<>();
	        mockCategories.add(new Category());
	        
	        when(csrv.getAllCategories()).thenReturn(mockCategories);
	        assertEquals(mockCategories, bean1.getCategoryList());
	    }
*/
	 
	 
		//========test connection=====
	/*		@Test
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
			@Test
			public void testCheckSTlogin(){
				StockControlDaoImpl  sc = new StockControlDaoImpl();
				 
				 try {

					 sc.checkStockControl("chris","admin");

			          } catch (Exception e) {

			        	 assertSame("Invild value", e.getMessage());
			    
			 }
			 }	
			
			@Test
				 public void testCheckCustomer2(){
					 StockControlDaoImpl  sc = new StockControlDaoImpl();
				 
					 try {

						 sc.checkStockControl("hello","loginin");
					       fail();

				          } catch (Exception e) {	 
				        	  assertNotSame("Invild value", e.getMessage());
				          }
				    
				 }
				 
				 
			
			
			

	 @Test
	 public void testGetCategory() {
	        System.out.println("getCategory");

	        CategoryDAOImpl i = new CategoryDAOImpl();
	        try{
				assertNotNull(i.getCategory(1));
			}catch (Exception e) {
				fail("No Exception expected .....");
				e.printStackTrace();
			}  
	       
	 
    }
 
	 @Test
	 public void testGetCategores() {
	        System.out.println("getCategores");

	        CategoryDAOImpl i = new CategoryDAOImpl();
	        try{
				assertNotNull(i.getAllCategories());
			}catch (Exception e) {
				fail("No Exception expected .....");
				e.printStackTrace();
			}  
	       
    } 
	 
	/* @Test
	 
	 public void testAddCategores() {
		    System.out.println("addCategores");
	        CategoryDAOImpl i = new CategoryDAOImpl();
	       
	        try{
	        	
	        	assertEquals(i.addCategory(category));
			}catch (Exception e) {
				fail("No Exception expected .....");
				e.printStackTrace();
			}  

	 } 
	 
	 public void testupdateCategory() {
	        System.out.println("updateCategory");
	        CategoryDAOImpl i = new CategoryDAOImpl();
	        try{
	        	assertEquals(i.deleteCategory());
			}catch (Exception e) {
				fail("No Exception expected .....");
				e.printStackTrace();
			}  

	 } 

*/	 
}

