/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ait.corrigan.dao;

import org.junit.Before;

/**
 *
 * @author Joshua<iyezi@hotmail.com>
 */
public class OrderDaoImplIT {
    private OrderDao odao;
    private DaoTestHelper helper = new DaoTestHelper();
    @Before public void setUp(){
        odao=new OrderDaoImpl();
        helper.executeQueryUpdate("table.customer.create");
    }
}
