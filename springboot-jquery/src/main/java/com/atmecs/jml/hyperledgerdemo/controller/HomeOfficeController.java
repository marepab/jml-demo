package com.atmecs.jml.hyperledgerdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.atmecs.jml.hyperledgerdemo.models.HomeOffice;
import com.atmecs.jml.hyperledgerdemo.models.Officer;
import com.atmecs.jml.hyperledgerdemo.models.Role;

@Controller
public class HomeOfficeController {
	private RestTemplate restTemplate = new RestTemplate();
	private String homeOfficeResourceUrl = "http://localhost:3000/api/HomeOffice";
	private String officerResourceUrl = "http://localhost:3000/api/Officer";
	private RoleController roleController = new RoleController();

	@RequestMapping("/home-offices")
	public ModelAndView getAllHomeOffices() {
		List<HomeOffice> homeOffices = getAllHomeOfficesList();
		ModelAndView mav = new ModelAndView("nopcc-home-offices");
		mav.addObject("homeOffices", homeOffices);
		return mav;
	}

	public List<HomeOffice> getAllHomeOfficesList() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<List<HomeOffice>> response = restTemplate.exchange(homeOfficeResourceUrl, HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<HomeOffice>>() {    				
		});
		List<HomeOffice> homeOffices = response.getBody();
		return homeOffices;
	}
	
	@RequestMapping("/getOffice/{homeOfficeId}")
	public ModelAndView getHomeOfficeById(@PathVariable("homeOfficeId") String homeOfficeId) {
		List<Officer> officers = getAllOfficers();
		System.out.println(officers);
    	List<Officer> homeOfficeOfficers = new ArrayList<>();    	
    	for (Officer officer: officers) {
    		if (officer.getHomeOffice().equals("resource:org.atmecs.poc.HomeOffice#"+homeOfficeId)) {
    			homeOfficeOfficers.add(officer);
    		}
    	}
    	ModelAndView mav = new ModelAndView("home-office");
    	List<HomeOffice> homeOffices = getAllHomeOfficesList();
    	String homeOfficeName = "";
    	for (HomeOffice homeOffice: homeOffices) {
    		if (homeOffice.getHomeOfficeId().equals(homeOfficeId)) {
    			homeOfficeName = homeOffice.getHomeOfficeName();
    		}
    	}
    	mav.addObject("homeOfficeName", homeOfficeName);
    	mav.addObject("homeOfficeOfficers", homeOfficeOfficers);
    	return mav;
	}
	
	@RequestMapping("/getOfficer/{officerId}")
	public ModelAndView getOfficerById(@PathVariable("officerId") String officerId) {
		Officer officer = getOfficerDetailsById(officerId);
		String roleName = officer.getRoleName();
		Role roleDetails = roleController.getRoleDetailsByName(roleName);		
		
    	ModelAndView mav = new ModelAndView("view-officer");    	
    	mav.addObject("homeOfficeOfficer", officer);
    	mav.addObject("roleDetails", roleDetails);
    	return mav;
	}

	public Officer getOfficerDetailsById(String officerId) {
		HttpHeaders headers = new HttpHeaders();
    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    	HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<Officer> response = restTemplate.
    			exchange(officerResourceUrl+"/"+officerId, HttpMethod.GET, entity, Officer.class);
		return response.getBody();
	}

	@RequestMapping(value= "/createOfficer", method = RequestMethod.POST)
    public String createOfficer(@ModelAttribute Officer officer){

        HttpEntity<Officer> request = new HttpEntity<>(officer);
        ResponseEntity<Officer> response = restTemplate
          .exchange(officerResourceUrl, HttpMethod.POST, request, Officer.class);
        return "redirect:/getOffice/" + officer.getHomeOffice().split("#")[1];
    }
	
	@RequestMapping(value= "/openCreateOfficer", method = RequestMethod.GET)
    public ModelAndView openCreateOfficer(){
		// rolesnames list to mav
		// statuyslist to mav
		// create-officer.jsp can copy from create role
		ModelAndView mav = new ModelAndView("create-officer");
		return mav;
    }
	
	@RequestMapping(value= "/openUpdateOfficer", method = RequestMethod.GET)
    public ModelAndView openUpdateOfficer(@PathVariable("officerId") String officerId){
		// rolesnames list to mav
		// statuyslist to mav
		// update-officer.jsp - can copy from view-officer
		Officer officer = getOfficerDetailsById(officerId);
    	ModelAndView mav = new ModelAndView("update-officer");    	
    	mav.addObject("homeOfficeOfficer", officer);
    	return mav;
    }
	
	@RequestMapping(value= "/updateOfficer", method = RequestMethod.PUT)
    public String updateOfficer(@ModelAttribute Officer officer){

        HttpEntity<Officer> request = new HttpEntity<>(officer);
        ResponseEntity<Officer> response = restTemplate
          .exchange(officerResourceUrl, HttpMethod.PUT, request, Officer.class);
        return "redirect:/getOffice/" + officer.getHomeOffice().split("#")[1];
    }
	
	public List<Officer> getAllOfficers() {
		HttpHeaders headers = new HttpHeaders();
    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    	HttpEntity<?> entity = new HttpEntity<>(headers);

    	ResponseEntity<List<Officer>> response = restTemplate.
    			exchange(officerResourceUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Officer>>() {    				
    			});
		return response.getBody();
	}
	
	
	
	
}
