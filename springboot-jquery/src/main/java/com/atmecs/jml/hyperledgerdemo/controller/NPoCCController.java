package com.atmecs.jml.hyperledgerdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.atmecs.jml.hyperledgerdemo.models.Role;

@Controller
public class NPoCCController {    
    @RequestMapping("/nopcc")
    public ModelAndView getNoPCCDetails(){
    	RoleController roleController = new RoleController();
    	List<Role> roles = roleController.getAllRolesAsResponseEntity();
    	ModelAndView mav = new ModelAndView("nopcc");
    	mav.addObject("roles", roles);
    	return mav;
    }
}