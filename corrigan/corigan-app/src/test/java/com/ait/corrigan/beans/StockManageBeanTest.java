/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ait.corrigan.beans;

import com.ait.corrigan.models.shop.Category;
import com.ait.corrigan.models.shop.Item;
import com.ait.corrigan.services.CategoryService;
import com.ait.corrigan.services.ItemService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author kfbb
 */
public class StockManageBeanTest {

    private ItemService isrv;
    private CategoryService csrv;
    private StockManageBean bean;
   
    private Item mItem1;
    private static final double delta=0.001;
    private static final String updateRedirect="manageStock?faces-redirect=true";

    public StockManageBeanTest() {
    }

    @Before
    public void setUp() {
        isrv = mock(ItemService.class);
        csrv = mock(CategoryService.class);
        bean = new StockManageBean(isrv, csrv);
        bean.setItemId(1);
        mItem1 = new Item(1, "initialItemName", 1, "bag", "some text", 4.99, 1);
        when(isrv.getItem(1)).thenReturn(mItem1);
        bean.populateItem();
    }

    /**
     * Test of populateItem method, of class StockManageBean.
     */
    @Test
    public void testPopulateItem() {
        System.out.println("populateItem");
        Item mockItem = new Item(1, "initialItemName", 1, "bag", "some text", 4.99, 1);
        assertEquals(mockItem, bean.getItem());
    }

    /**
     * Test of getCategoryList method, of class StockManageBean.
     */
    @Test
    public void testGetCategoryList() {
        System.out.println("getCategoryList");
        List<Category> mockCategories = new ArrayList<>();
        mockCategories.add(new Category(1, "cate1"));
        mockCategories.add(new Category(2, "cate2"));
        when(csrv.getAllCategories()).thenReturn(mockCategories);
        assertEquals(mockCategories, bean.getCategoryList());
    }

    /**
     * Test of getCategory method, of class StockManageBean.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");

        Category mockCategory = new Category(1, "cate1");
        when(isrv.getItem(1l)).thenReturn(new Item(0, "ItemName", 0, "", "", Double.NaN, 1));
        when(csrv.getCategory(1l)).thenReturn(mockCategory);

        assertEquals(mockCategory, bean.getCategory());
    }

    /**
     * Test of setCategory method, of class StockManageBean.
     */
    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        Category mockCategory = new Category(1, "cate1");
        bean.setCategory(mockCategory);

        assertEquals(1l, bean.getItem().getCateID());
        assertEquals("cate1", bean.getItem().getCate_name());
    }

    /**
     * Test of getItems method, of class StockManageBean.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        
        List<Item> mockItems = new ArrayList<>();
        mockItems.add(new Item(1, "item 1", 1, "a", "some text", 2.33, 1));
        mockItems.add(new Item(2, "item 2", 1, "b", "some text", 3.79, 2));
        when(isrv.getCatalogue()).thenReturn(mockItems);
        
        assertEquals(mockItems, bean.getItems());
    }

    /**
     * Test of getItemId method, of class StockManageBean.
     */
    @Test
    public void testGetItemId() {
        System.out.println("getItemId");
        assertEquals(1l, bean.getItemId());
    }

    /**
     * Test of setItemId method, of class StockManageBean.
     */
    @Test
    public void testSetItemId() {
        System.out.println("setItemId");
        bean.setItemId(233);
        assertEquals(233, bean.getItemId());
    }

    /**
     * Test of getName method, of class StockManageBean.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        assertEquals(mItem1.getName(), bean.getName());
    }

    /**
     * Test of setName method, of class StockManageBean.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        bean.setName("someOtherName");
        assertEquals("someOtherName", bean.getName());
    }

    /**
     * Test of getQuantity method, of class StockManageBean.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        assertEquals(mItem1.getStock_q(), bean.getQuantity());
    }

    /**
     * Test of setQuantity method, of class StockManageBean.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int q=42;
        bean.setQuantity(q);
        assertEquals(q, bean.getQuantity());
    }

    /**
     * Test of getUnit method, of class StockManageBean.
     */
    @Test
    public void testGetUnit() {
        System.out.println("getUnit");
        assertEquals(mItem1.getUnit_of_measure(), bean.getUnit());
    }

    /**
     * Test of setUnit method, of class StockManageBean.
     */
    @Test
    public void testSetUnit() {
        System.out.println("setUnit");
        String u="Unit x";
        bean.setUnit(u);
        assertEquals(u, bean.getUnit());
    }

    /**
     * Test of getDescription method, of class StockManageBean.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        assertEquals(mItem1.getDescription(), bean.getDescription());
    }

    /**
     * Test of setDescription method, of class StockManageBean.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String d="Description text";
        bean.setDescription(d);
        assertEquals(d, bean.getDescription());
    }

    /**
     * Test of getPrice method, of class StockManageBean.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        assertEquals(mItem1.getPrice(), bean.getPrice(),delta);
    }

    /**
     * Test of setPrice method, of class StockManageBean.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double p=4.2;
        bean.setPrice(p);
        assertEquals(p, bean.getPrice(),delta);
    }

    /**
     * Test of doUpdate method, of class StockManageBean.
     */
    @Test
    public void testDoUpdate() {
        System.out.println("doUpdate");
        assertEquals(updateRedirect, bean.doUpdate());
    }

}
