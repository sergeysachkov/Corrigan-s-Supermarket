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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author kfbb
 */
public class AddItemBeanTest {
//    private 

    private ItemService isrv;
    private CategoryService csrv;
    private AddItemBean bean;
    private static final double delta = 0.001;
    private static final String submitRedirect = "manageStock?faces-redirect=true";
    private Item mItem1;
    private Category mCategory1;
    private Category mCategory2;
    private Category mCategory3;
    private List<Category> mCategories;

    public AddItemBeanTest() {
    }

    @Before
    public void setUp() {
        isrv = mock(ItemService.class);
        csrv = mock(CategoryService.class);
        bean = new AddItemBean(isrv, csrv);
        mItem1 = new Item(1, "initialItemName", 1, "bag", "some text", 4.99, 1);

        mCategory1 = new Category(42, "Fruit");
        mCategory2 = new Category(17, "Bakery");
        mCategory3 = new Category(53, "Grocery");

        mCategories = new ArrayList<>();
        mCategories.add(mCategory1);
        mCategories.add(mCategory2);
        mCategories.add(mCategory3);

        when(isrv.getItem(1)).thenReturn(mItem1);
        when(csrv.getAllCategories()).thenReturn(mCategories);

        bean.initItem();
    }

    /**
     * Test of initItem method, of class AddItemBean.
     */
    @Test
    public void testInitItem() {
        System.out.println("initItem");
        Long id = bean.getItemId();
        Assert.assertNotNull("Invalid item id", id);
        Assert.assertTrue(id > 0);
    }

    /**
     * Test of getCategory, setCategory method, of class AddItemBean.
     */
    @Test
    public void testGetSetCategory() {
        System.out.println("get/setCategory");
        bean.setCategory(mCategory1);
        Assert.assertEquals(mCategory1, bean.getCategory());
    }

    /**
     * Test of getCategoryList method, of class AddItemBean.
     */
    @Test
    public void testGetCategoryList() {
        System.out.println("getCategoryList");
        Assert.assertEquals(mCategories, bean.getCategoryList());
    }

    /**
     * Test of getItemId, setItemId method, of class AddItemBean.
     */
    @Test
    public void testGetSetItemId() {
        System.out.println("getSetItemId");
        long id = 4228342364l;
        bean.setItemId(id);
        Assert.assertEquals(id, bean.getItemId());
    }

    /**
     * Test of getName, setName method, of class AddItemBean.
     */
    @Test
    public void testGetSetName() {
        System.out.println("getSetName");
        bean.setName(mItem1.getName());
        Assert.assertEquals(mItem1.getName(), bean.getName());
    }

    /**
     * Test of getQuantity, setQuantity method, of class AddItemBean.
     */
    @Test
    public void testGetSetQuantity() {
        System.out.println("getSetQuantity");
        bean.setQuantity(mItem1.getStock_q());
        Assert.assertEquals(mItem1.getStock_q(), bean.getQuantity());
    }

    /**
     * Test of getUnit, setUnit method, of class AddItemBean.
     */
    @Test
    public void testGetSetUnit() {
        System.out.println("getSetUnit");
        bean.setUnit(mItem1.getUnit_of_measure());
        Assert.assertEquals(mItem1.getUnit_of_measure(), bean.getUnit());
        
    }


    /**
     * Test of getDescription, setDescription method, of class AddItemBean.
     */
    @Test
    public void testGetSetDescription() {
        System.out.println("getSetDescription");
        bean.setDescription(mItem1.getDescription());
        Assert.assertEquals(mItem1.getDescription(), bean.getDescription());
    }

    /**
     * Test of getPrice, setPrice method, of class AddItemBean.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        bean.setPrice(mItem1.getPrice());
        Assert.assertEquals(mItem1.getPrice(), bean.getPrice(), delta);
    }

    /**
     * Test of submit method, of class AddItemBean.
     */
    @Test
    public void testSubmit() {
        Assert.assertEquals(submitRedirect, bean.submit());
    }

}
