package com.prashanth.olx.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prashanth.olx.Entity.Advertises;
import com.prashanth.olx.Entity.AdvertisesResponse;
import com.prashanth.olx.reprositry.AdvertisesReprositry;
import com.prashanth.olx.service.AdvertisesSerachCritera;
import com.prashanth.olx.service.AdvertisesService;

@RestController
@RequestMapping("/advertise")
public class AdvertiseControler {
	
	@Autowired
	AdvertisesService advertiseservice;
	
	@Autowired
	AdvertisesReprositry advertisesrepo;
	
	@PostMapping
	 ResponseEntity<AdvertisesResponse> getNewAdvertises(@RequestBody Advertises advertises){
		return new ResponseEntity<>(advertiseservice.getNewAdvertise(advertises),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<AdvertisesResponse> updateAdvertise(@PathVariable int id, @RequestBody Advertises advertises ){
		return new ResponseEntity<>(advertiseservice.updateAdvertise(id, advertises),HttpStatus.CREATED);
	}
	
	@GetMapping
	ResponseEntity<List<AdvertisesResponse>> getAllAdvertiseResponse(){
		return new ResponseEntity<>(advertiseservice.getAllAdvertiseResponse(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<AdvertisesResponse> getIdAdvetise(@PathVariable int id){
		return new ResponseEntity<>(advertiseservice.getById(id),HttpStatus.OK);
	}
    
	@DeleteMapping("/{id}")
	ResponseEntity<Boolean> delete(@PathVariable int id){
		return new ResponseEntity<>(advertiseservice.delete(id),HttpStatus.OK);
	}
	@GetMapping("/search")
	List<AdvertisesResponse> getByFilter(
			@RequestParam(required =false) Optional<String> title,
			@RequestParam(required = false) Optional<String> category,
			@RequestParam(required = false) Optional<Double> minprice,
			@RequestParam(required = false) Optional<Double> maxprice,
			@RequestParam(required = false) Optional<String> username){
		
		AdvertisesSerachCritera searchcriteria = AdvertisesSerachCritera.builder()
			 .title(title).category(category).minprice(minprice)
			 .maxprice(maxprice).username(username).build();

		return advertiseservice.getByFilter(searchcriteria);
			
	}
	
	
}
