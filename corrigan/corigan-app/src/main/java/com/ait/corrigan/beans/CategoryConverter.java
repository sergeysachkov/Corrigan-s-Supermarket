/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ait.corrigan.beans;

import com.ait.corrigan.models.shop.Category;
import com.ait.corrigan.services.CategoryService;
import com.ait.corrigan.services.CategoryServicesImpl;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author kfbb
 */
@FacesConverter(forClass = Category.class)
public class CategoryConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }
        try {
            String strId=submittedValue.replaceFirst(": \\w+", "");
            String name=submittedValue.replaceFirst("\\d+: ", "");
            return new Category(Integer.parseInt(strId),name);
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(submittedValue + " is not a valid Category ID"), e);
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object modelValue) {
        if (modelValue == null) {
            return "";
        }

        if (modelValue instanceof Category) {
            return ((Category)modelValue).getCateID()+": "+((Category)modelValue).getCate_name();
        } else {
            throw new ConverterException(new FacesMessage(modelValue + " is not a valid Category"));
        }
    }

}
