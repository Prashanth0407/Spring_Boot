package com.prashanth.olx.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashanth.olx.Entity.Categories;
import com.prashanth.olx.reprository.CategoriesReprository;

@Service
public class CategoriesServiceImpl implements CategoriesService {
     
	@Autowired
	CategoriesReprository cr;
	@Override
	public List<Categories> getAllCategories() {
	
		return cr.findAll();
	}
	
    @Override
    public String getCategoriesById(Integer id) {
           Optional<Categories> cat=cr.findById(id);
           String category=cat.get().getCategory();
           return category;
           
    }

}
