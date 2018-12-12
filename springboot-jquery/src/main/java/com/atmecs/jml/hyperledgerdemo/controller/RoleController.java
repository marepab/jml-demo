package com.atmecs.jml.hyperledgerdemo.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.atmecs.jml.hyperledgerdemo.models.Role;

@Controller
public class RoleController { 
	
	private RestTemplate restTemplate = new RestTemplate();
	String roleResourceUrl = "http://localhost:3000/api/Role";
	
    @RequestMapping(value= "/createRole", method = RequestMethod.POST)
    public String createRole(@ModelAttribute Role role){

        role.setRoleName(role.getRoleName().toUpperCase());
        HttpEntity<Role> request = new HttpEntity<>(role);
        ResponseEntity<Role> response = restTemplate
          .exchange(roleResourceUrl, HttpMethod.POST, request, Role.class);
        return "redirect:/nopcc";
    }
    
    @RequestMapping(value = "/getAllRoles", method= RequestMethod.GET)
    public ModelAndView getAllRoles() {
    	List<Role> roles = getAllRolesAsResponseEntity();
    	ModelAndView mav = new ModelAndView("nopcc");
    	mav.addObject("roles", roles);
    	return mav;    	
    }
    
    @RequestMapping(value = "/getRole/{roleName}", method= RequestMethod.GET)
    public ModelAndView getRoleByName(@PathVariable("roleName") String roleName) {
    	Role role = getRoleDetailsByName(roleName);
    	ModelAndView mav = new ModelAndView("view-role");
    	mav.addObject("role", role);
    	mav.addObject("roleName", role.getRoleName());
    	return mav;    	
    }

	public Role getRoleDetailsByName(String roleName) {
		HttpHeaders headers = new HttpHeaders();
    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    	HttpEntity<?> entity = new HttpEntity<>(headers);
    	UriComponents uri = UriComponentsBuilder
                .fromHttpUrl(roleResourceUrl+"/{roleName}")
                .buildAndExpand(roleName);

    	String urlString = uri.toUriString();
    	ResponseEntity<Role> response = restTemplate.
    			exchange(urlString, HttpMethod.GET, entity, Role.class);
    	Role role = response.getBody();
		return role;
	}

	public List<Role> getAllRolesAsResponseEntity() {
		HttpHeaders headers = new HttpHeaders();
    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    	HttpEntity<?> entity = new HttpEntity<>(headers);
    	ResponseEntity<List> response = restTemplate.
    			exchange(roleResourceUrl, HttpMethod.GET, entity, List.class);
    	return response.getBody();
	}
}