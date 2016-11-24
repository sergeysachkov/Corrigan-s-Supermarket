package com.ait.corrigan.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ait.corrigan.models.shop.Category;

public class CategoryDAOImplTest {


/*	// assert size of array with the number of cat in the db = PASS
	@Test
	public void testGetAllCategories() {
		CategoryDAOImpl c = new CategoryDAOImpl();
		List<Category> allCat = new ArrayList<Category>();
		try {
			allCat = c.getAllCategories();
			assertEquals(3, allCat.size());
		} catch (Exception e) {
			fail("No Exception expected .....");
			e.printStackTrace();
		}
	}

	// assert category fruit exists in the BD = PASS
	@Test
	public void testGetOneCategory() {
		CategoryDAOImpl c = new CategoryDAOImpl();
		List<Category> allCat = new ArrayList<Category>();
		try {
			allCat = c.getAllCategories();
			assertEquals("fruit", allCat.get(0).getCate_name());
		} catch (SQLException e) {
			fail("No Exception expected .....");
			e.printStackTrace();
		}
	}

	// catch indexOutOfBounds at index 100 = PASS
	@Test
	public void testCategoryIndexOutOfBounds() {
		CategoryDAOImpl c = new CategoryDAOImpl();
		List<Category> allCat = new ArrayList<Category>();
		try {
			allCat = c.getAllCategories();
			assertEquals("fruit", allCat.get(100).getCate_name());
			fail("Exception expected .....");
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			fail("IndexOutOfBounds should be thrown");
			e.printStackTrace();
		}
	}
*/

	// assert size of array with the number of cat in the db = PASS
	@Test
	public void testGetAllCategories() {
		CategoryDAOImpl c = new CategoryDAOImpl();
		List<Category> allCat = new ArrayList<Category>();
		try {
			allCat = c.getAllCategories();
			assertEquals(3, allCat.size());
		} catch (Exception e) {
			fail("No Exception expected .....");
			e.printStackTrace();
		}
	}

	// assert category fruit exists in the BD = PASS
	@Test
	public void testGetOneCategory() {
		CategoryDAOImpl c = new CategoryDAOImpl();
		List<Category> allCat = new ArrayList<Category>();
		try {
			allCat = c.getAllCategories();
			assertEquals("fruit", allCat.get(0).getCate_name());
		} catch (SQLException e) {
			fail("No Exception expected .....");
			e.printStackTrace();
		}
	}

	// catch indexOutOfBounds at index 100 = PASS
	@Test
	public void testCategoryIndexOutOfBounds() {
		CategoryDAOImpl c = new CategoryDAOImpl();
		List<Category> allCat = new ArrayList<Category>();
		try {
			allCat = c.getAllCategories();
			assertEquals("fruit", allCat.get(100).getCate_name());
			fail("Exception expected .....");
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			fail("IndexOutOfBounds should be thrown");
			e.printStackTrace();
		}
	}


}
