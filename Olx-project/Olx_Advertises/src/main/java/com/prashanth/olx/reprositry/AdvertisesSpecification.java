package com.prashanth.olx.reprositry;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.prashanth.olx.Entity.Advertises;
import com.prashanth.olx.Entity.Advertises_;
import com.prashanth.olx.service.AdvertisesSerachCritera;

public class AdvertisesSpecification {
       private AdvertisesSpecification() {
    	   
       }
       
       public static Specification<Advertises> craeteAdvertiseSpesification(AdvertisesSerachCritera searchcritera){
    	return  priceRateBetween(searchcritera.getMaxprice(),searchcritera.getMinprice()).or(postedBy(searchcritera.getUsername()))
    			.or(categoryEqualsTo(searchcritera.getCategory())).or(titleEqualsTo(searchcritera.getTitle()));
       }
       
       
     public static Specification<Advertises> titleEqualsTo(Optional<String> title)  {
    	  return(root,query,builder) -> {
    		  return title.map(name -> builder.equal(root.get(Advertises_.title),String.valueOf(name))
    				  ).orElse(null);
    	  };
     }
     public static Specification<Advertises> categoryEqualsTo(Optional<String> category){
    	 return(root,query,builder) ->{
    		 return category.map(name ->builder.equal(root.get(Advertises_.category),String.valueOf(name)))
    				 .orElse(null);
    	 };
     }
     public static Specification<Advertises> postedBy(Optional<String> username){
    	 return(root,query,builder) ->{
    		 return username.map(name ->builder.equal(root.get(Advertises_.username),String.valueOf(name)))
    	    .orElse(null);
     };
     }
     
     public static Specification<Advertises> priceRateBetween(Optional<Double> optional,Optional<Double> optional2){
    	 return(root,query,builder) -> {
    		 return optional.map(min ->{
    			 return optional2.map(max ->builder.between(root.get(Advertises_.price), min, max)).orElse(null);
    				 
    			 }).orElse(null);
    		 };
    	 }
     }
       
       
       

