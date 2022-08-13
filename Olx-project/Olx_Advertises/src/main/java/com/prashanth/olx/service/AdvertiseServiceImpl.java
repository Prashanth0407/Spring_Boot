package com.prashanth.olx.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prashanth.olx.Entity.Advertises;
import com.prashanth.olx.Entity.AdvertisesResponse;
import com.prashanth.olx.reprositry.AdvertisesReprositry;
import com.prashanth.olx.reprositry.AdvertisesSpecification;

@Service
public class AdvertiseServiceImpl implements AdvertisesService {
	
	@Autowired
	AdvertisesReprositry advertisesreprository;

	@Autowired
	RestTemplate restTemplate;
	//adding the details using postmethod
	@Override
	public AdvertisesResponse getNewAdvertise(Advertises advertises) {
		Advertises savedAdv=advertisesreprository.save(advertises);
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(savedAdv.getStatus()));
		String status=getStatusResponse(params);
		params.put("id",String.valueOf(savedAdv.getCategory()));
		String category=getCategoryResponse(params);
		AdvertisesResponse adver=getAdvertisesApiResponse(savedAdv,category,status);
		return adver;
	}
     
	//updating details using putmethod
	@Override
	public AdvertisesResponse updateAdvertise(int id, Advertises advertise) {
		Advertises updateAdv=advertisesreprository.save(advertise);
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(updateAdv.getStatus()));
		String status=getStatusResponse(params);
		params.put("id",String.valueOf(updateAdv.getCategory()));
		String category=getCategoryResponse(params);
		AdvertisesResponse adverupdate=getAdvertisesApiResponse(updateAdv,category,status);
		return adverupdate;
	}
    
	//fetching the details by id 
	@Override
	public AdvertisesResponse getById(int id) {
		Advertises adv=null;
		Optional<Advertises> advId= advertisesreprository.findById(id);
		if(advId.isPresent()) {
			adv=advId.get();
			
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(adv.getStatus()));
		String status=getStatusResponse(params);
		params.put("id",String.valueOf(adv.getCategory()));
		String category=getCategoryResponse(params);
		AdvertisesResponse adverId=getAdvertisesApiResponse(adv,category,status);
		return adverId;
	}
   
	//deleting the data
	@Override
	public boolean delete(int id) {
		    advertisesreprository.deleteById(id);
		    if( advertisesreprository.findById(id) == null) {
		    	return true;
		    }
		return false;
	}
	
	
	//connecting the Advertises class and AdvertisesResponse
	private AdvertisesResponse getAdvertisesApiResponse(Advertises ad,String catag,String status) {

		AdvertisesResponse advertisesApiResponse = new AdvertisesResponse();
		advertisesApiResponse.setId(ad.getId());
		advertisesApiResponse.setCategory(catag);
		advertisesApiResponse.setCreatedDate(ad.getCreatedDate());
		advertisesApiResponse.setDescription(ad.getDescription());
		advertisesApiResponse.setModifiedDate(ad.getModifiedDate());
		advertisesApiResponse.setPrice(ad.getPrice());
		advertisesApiResponse.setStatus(status);
		advertisesApiResponse.setTitle(ad.getTitle());
		advertisesApiResponse.setUsername(ad.getUsername());
		return advertisesApiResponse;

		}
	//fetching all the details
	@Override
	public List<AdvertisesResponse> getAllAdvertiseResponse() {
		Advertises adv=null;
		List<AdvertisesResponse> advlist=new ArrayList<>();
		     List<Advertises> advertises=advertisesreprository.findAll();
		     for(int i=0;i<advertises.size();i++) {
		     adv=advertises.get(i);
		     Map<String, String> params = new HashMap<String, String>();
		     params.put("id", String.valueOf(adv.getStatus()));
		     String status= getStatusResponse(params);
		     params.put("id", String.valueOf(adv.getCategory()));
		     String catag=getCategoryResponse(params);
		    advlist.add(getAdvertisesApiResponse(adv,catag,status));
		     }
		    return advlist;
	}
	
	
	//connecting the Status
	private String getStatusResponse(Map<String,String> params) {
	
	 String status= restTemplate.getForObject("http://OLX-MASTERDATA/advertise/status/{id}", String.class, params);
	 return status;
	}
	
	//connecting the category
	private String getCategoryResponse(Map<String,String> params) {
		
		 String category= restTemplate.getForObject("http://OLX-MASTERDATA/advertise/categories/{id}", String.class, params);
		 return category;
		}
    public List<AdvertisesResponse> getByFilter(AdvertisesSerachCritera searchcriteria ){
    	Advertises adv=null;
    	List<AdvertisesResponse> advlist=new ArrayList<>();
    	Specification<Advertises> advSpecification=AdvertisesSpecification.craeteAdvertiseSpesification(searchcriteria);
		List<Advertises> advertises= advertisesreprository.findAll(advSpecification);
		 for(int i=0;i<advertises.size();i++) {
		     adv=advertises.get(i);
		     Map<String, String> params = new HashMap<String, String>();
		     params.put("id", String.valueOf(adv.getStatus()));
		     String status= getStatusResponse(params);
		     params.put("id", String.valueOf(adv.getCategory()));
		     String catag=getCategoryResponse(params);
		    advlist.add(getAdvertisesApiResponse(adv,catag,status));
		     }
    	return  advlist;
    }
	
}
