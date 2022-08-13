package com.prashanth.olx.reprositry;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.prashanth.olx.Entity.Advertises;

@Repository
public interface AdvertisesReprositry extends JpaRepository<Advertises, Integer> {

	List<Advertises> findByPrice(Double price);
	
	List<Advertises> findByTitle(String title);
	
	
	List<Advertises> findAll(@Nullable Specification<Advertises> spec );
	
}
