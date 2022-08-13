package com.prashanth.olx.reprository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prashanth.olx.Entity.Categories;

public interface CategoriesReprository extends JpaRepository<Categories,Integer> {

}
