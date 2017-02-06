/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ait.corrigan.beans;

import com.ait.corrigan.models.shop.Category;
import org.junit.Test;

/**
 *
 * @author kfbb
 */
public class CategoryConverterTest {
    @Test
    public void converterTest(){
        CategoryConverter cc=new CategoryConverter();
        Category c=new Category(1, "1 cate 1 a");
        System.out.println(cc.getAsObject(null, null, cc.getAsString(null, null, c)));
    }
}
