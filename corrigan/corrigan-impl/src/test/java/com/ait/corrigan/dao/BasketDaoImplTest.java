package com.ait.corrigan.dao;

import org.junit.Assert;
import org.junit.Test;


public class BasketDaoImplTest {
	@Test
	public void CreateDbConnection(){
		BasketDaoImpl basketDao=new BasketDaoImpl();
		Assert.assertTrue("BasketDaoImpl instantiation failed.",basketDao!=null);
	}
}
