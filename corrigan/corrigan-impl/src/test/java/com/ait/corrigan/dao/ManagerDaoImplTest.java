package com.ait.corrigan.dao;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.ait.corrigan.models.user.Manager;
import com.ait.corrigan.services.ManagerService;
import com.ait.corrigan.services.ManagerServiceImpl;

public class ManagerDaoImplTest {
	ManagerDAO dao;
	
    @Before
    public void setUp(){
        dao = mock(ManagerDAO.class);
    }
    @Test
    public void testAddManager(){
        try {
            ManagerService service = new ManagerServiceImpl(dao);
            Manager manager = new Manager();
            manager.setManagerName("John");
            manager.setManagerSurname("Handy");
            when(dao.addManager(manager)).thenReturn(1l);
            long id = service.addManager(manager);
            assertEquals(id, 1);
        }catch (Exception e){
            fail();
        }
    }
    
}
