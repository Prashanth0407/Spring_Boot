package com.prashanth.olx.service;

import java.util.List;

import com.prashanth.olx.Entity.Categories;

public interface CategoriesService {

  public List<Categories> getAllCategories();

 public String getCategoriesById(Integer id );
 
}
