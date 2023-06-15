package com.chris.dojosandninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chris.dojosandninjas.models.Dojo;
import com.chris.dojosandninjas.models.Ninja;
import com.chris.dojosandninjas.services.DojoService;
import com.chris.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	public final DojoService dojoServ;
	public final NinjaService ninjaServ;
	
	public HomeController(DojoService dojoServ, NinjaService ninjaServ) {
		this.dojoServ = dojoServ;
		this.ninjaServ = ninjaServ;
	}
	
	@RequestMapping("/dojos/new")
	public String createDojo(@ModelAttribute("newDojo") Dojo dojo) {
		return "dojo/create.jsp";
	}
	
	@PostMapping("/dojos/process")
	public String processDojo(@Valid @ModelAttribute("newDojo") Dojo newDojo, BindingResult result) {
		if(result.hasErrors()) {
			return "dojo/create.jsp";
		}
		dojoServ.create(newDojo);
		return "redirect:/dojos/new";
	}
	
	@RequestMapping("ninjas/new")
	public String createNinja(@ModelAttribute("newNinja") Ninja ninja, Model model) {
		model.addAttribute("allDojos", dojoServ.findAll());
		return "ninja/create.jsp";
	}
	
	@PostMapping("/ninjas/process")
	public String processNinja(@Valid @ModelAttribute("newNinja") Ninja newNinja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allDojos", dojoServ.findAll());
			return "ninja/create.jsp";
		}
		ninjaServ.create(newNinja);
		return "redirect:/ninjas/new";
	}
	
	@RequestMapping("/dojos/{id}")
	public String displayOneDojo(@PathVariable("id") Long id, Model model) {
		Dojo oneDojo = dojoServ.getOne(id);
		model.addAttribute("oneDojo", oneDojo);
		return "dojo/displayOne.jsp";
	}
	

}
