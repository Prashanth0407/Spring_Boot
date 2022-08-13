package com.prashanth.olx.service;

import java.util.Optional;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class AdvertisesSerachCritera {
	
	
	private Optional<String> title;
	private Optional<String> category;
	private Optional<Double> maxprice;
	private Optional<Double> minprice;
	private Optional<String> description;
	private Optional<String> username;
	

}
