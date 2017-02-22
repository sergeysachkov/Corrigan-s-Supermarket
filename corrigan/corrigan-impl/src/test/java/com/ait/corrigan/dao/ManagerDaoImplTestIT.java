package com.ait.corrigan.dao;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.*;

import com.ait.corrigan.models.user.Manager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagerDaoImplTestIT {

	private DaoTestHelper helper = new DaoTestHelper();

	@Before
	public void setUp() {
		helper.executeQueryUpdate("table.manager.create");
	}

	@Test
	public void testLoginManager() {
		ManagerDaoImpl manager = new ManagerDaoImpl();
		try {
			Manager manager1 = new Manager();
			manager1.setManagerLogin("admin");
			manager1.setManagerPassword("admin");
			manager.addManager(manager1);
			assertEquals(true, manager.checkManager("admin", "admin"));
		} catch (Exception e) {
			fail("No Exception expected .....");
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() {
		helper.executeQueryUpdate("table.manager.drop");
	}
}
