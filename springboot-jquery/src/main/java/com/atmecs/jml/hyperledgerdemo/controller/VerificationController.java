package com.atmecs.jml.hyperledgerdemo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.atmecs.jml.hyperledgerdemo.models.Officer;
import com.atmecs.jml.hyperledgerdemo.models.Test;
import com.atmecs.jml.hyperledgerdemo.models.Training;
import com.atmecs.jml.hyperledgerdemo.models.Verifier;

@Controller
public class VerificationController {
	
	private RestTemplate restTemplate = new RestTemplate();
	private String hospitalResourceUrl = "http://localhost:3000/api/Hospital";
	private String roadLicenseAuthorityResourceUrl = "http://localhost:3000/api/RoadLicenseAuthority";
	private String dogLicenseAuthorityResourceUrl = "http://localhost:3000/api/DogLicenseAuthority";
	
	public List<String> getAllVerifersNames() {
		HttpHeaders headers = new HttpHeaders();
    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    	HttpEntity<?> entity = new HttpEntity<>(headers);

    	ResponseEntity<List> response = restTemplate.
    			exchange(hospitalResourceUrl, HttpMethod.GET, entity, List.class);    	
    	List<Verifier> hospitalVerifiers = response.getBody();
    	ResponseEntity<List> roadLicenseAuthorityResponse = restTemplate.
    			exchange(roadLicenseAuthorityResourceUrl, HttpMethod.GET, entity, List.class);    	
    	List<Verifier> roadLicenseAuthorityVerifiers = response.getBody();
    	ResponseEntity<List> dogLicenseAuthorityResponse = restTemplate.
    			exchange(dogLicenseAuthorityResourceUrl, HttpMethod.GET, entity, List.class);    	
    	List<Verifier> dogLicenseAuthorityVerifiers = response.getBody();
    	List<Verifier> finalList = new ArrayList<>();
    	finalList.addAll(hospitalVerifiers);
    	finalList.addAll(dogLicenseAuthorityVerifiers);
    	finalList.addAll(roadLicenseAuthorityVerifiers);
		List<String> namesList = new ArrayList<>();
		for (Verifier verifier: finalList) {
			namesList.add(verifier.getVerifierName());
		}
    	return namesList;
	}
	
	@RequestMapping(value= "/getVerifications/{verifierName}", method = RequestMethod.GET)
	public ModelAndView getAllHomeOffices(@PathVariable("verifierName") String verifierName) {
		HomeOfficeController homeOfficeController = new HomeOfficeController();
		List<Officer> allOfficers = homeOfficeController.getAllOfficers();
		Set<Officer> pendingOfficers = new HashSet<>();
		for (Officer officer : allOfficers) {
			Test [] tests = officer.getTests();
			for (Test test: tests) {
				if (verifierName.equals(test.getVerifierName())) {
					pendingOfficers.add(officer);
				}				
			}
			Training [] trainings = officer.getTrainings();
			for (Training training: trainings) {
				if (verifierName.equals(training.getVerifierName())) {
					pendingOfficers.add(officer);
				}
			}
		}

		ModelAndView mav = new ModelAndView("verifer-view");
		mav.addObject("pendingOfficers", pendingOfficers);
		mav.addObject("verifierName", verifierName);
		return mav;
	} 

}
