package com.ait.corrigan.services;

import com.ait.corrigan.dao.ItemDao;
import com.ait.corrigan.models.shop.Item;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import static junit.framework.TestCase.fail;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ItemServiceImplTest {

    ItemDao dao;
    ItemService isrv;

    @Before
    public void setUp() {
        dao = mock(ItemDao.class);
        isrv = new ItemServiceImpl(dao);
    }

    @Test
    public void testAddItem() {
        try {
            Item item = new Item(1, "Some name", 12, "pack", "some text", 1.2, 2);
            dao.addItem(item);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testUpdateItem() {
        try {
            Item item = new Item(1, "Some name", 12, "pack", "some text", 1.2, 2);
            dao.updateItem(item);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetItem() {
        try {
            Item item;
            when(dao.getItem(1)).thenReturn(
                    new Item(1, "Some name", 12, "pack", "some text", 1.2, 2)
            );
            item = isrv.getItem(1);
            TestCase.assertNotNull(item);
            TestCase.assertEquals(
                    new Item(1, "Some name", 12, "pack", "some text", 1.2, 2),
                    item
            );
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetCatalogue() {
        try {
            List<Item> resultItems, mockItems;
            mockItems = new ArrayList<Item>();
            mockItems.add(
                    new Item(1, "Some name", 12, "pack", "some text", 1.2, 2)
            );
            mockItems.add(
                    new Item(2, "Some other name", 12, "pack", "some other text", 3.2, 1)
            );
            when(dao.getAllItems()).thenReturn(mockItems);
            resultItems = isrv.getCatalogue();
            TestCase.assertNotNull(resultItems);
            TestCase.assertEquals(mockItems, resultItems);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetCategory() {
        try {
            List<Item> resultItems, mockItems;
            mockItems = new ArrayList<Item>();
            mockItems.add(
                    new Item(1, "Some name", 12, "pack", "some text", 1.2, 2)
            );
            mockItems.add(
                    new Item(2, "Some other name", 12, "pack", "some other text", 3.2, 1)
            );
            when(dao.getItemsByCategory("Food")).thenReturn(mockItems);
            resultItems = isrv.getCategory("Food");
            TestCase.assertNotNull(resultItems);
            TestCase.assertEquals(mockItems, resultItems);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testDeleteItem() {
        try {
            Item item = new Item(1, "Some name", 12, "pack", "some text", 1.2, 2);
            dao.updateItem(item);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
}
