package com.prashanth.olx.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prashanth.olx.Entity.AdvStatus;
import com.prashanth.olx.Entity.Categories;
import com.prashanth.olx.service.AdvStatusService;
import com.prashanth.olx.service.CategoriesService;

@RestController
@RequestMapping("/advertise")
public class MasterDataController {
 
	@Autowired
	AdvStatusService as;
	
	@Autowired
	CategoriesService cs;
	
	 @GetMapping("/status")
	 ResponseEntity<List<AdvStatus>> getAllStatus(){
		 return new ResponseEntity<>(as.getAllStatus(),HttpStatus.OK);
	 }
	 
	 @GetMapping("/status/{id}")
	 ResponseEntity<String> addAllStatus(@PathVariable Integer id){
		 return new ResponseEntity<>(as.getByStatusId(id),HttpStatus.OK);
	 }
	 @GetMapping("/categories/{id}")
	 ResponseEntity<String> addAllCategories(@PathVariable Integer id){
		 return new ResponseEntity<>(cs.getCategoriesById(id),HttpStatus.CREATED);
	 }
	 @GetMapping("/categories")
	 ResponseEntity<List<Categories>> getAllCategories(){
		 return new ResponseEntity<>(cs.getAllCategories(),HttpStatus.CREATED);
	 }
}

