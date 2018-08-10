package com.carthurnau.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carthurnau.dojosninjas.models.Dojo;
import com.carthurnau.dojosninjas.models.Ninja;
import com.carthurnau.dojosninjas.services.dojoService;
import com.carthurnau.dojosninjas.services.ninjaService;

@Controller
public class dojoController {
	
	private final dojoService dojoService;
	
	private final ninjaService ninjaService;
	
	public dojoController(dojoService dojoService, ninjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}

	@RequestMapping("")
	public String index(Model model) {
		
		List<Dojo> allDojos = dojoService.findAll();
		model.addAttribute("allDojos",allDojos);
		
		Ninja ninja = new Ninja();
		model.addAttribute("ninja",ninja);
		
		return "index.jsp";
	}
	
	@RequestMapping("/dojos/new")
	public String newDojoForm(Model model) {
		
		//Create a dojo instance for the jsp to use for binding
		Dojo dojo = new Dojo();
		model.addAttribute("dojo",dojo);
		
		return "dojoForm.jsp";
	}
	
	@RequestMapping("/dojo/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		
		// get this dojo object
		Dojo dojo = dojoService.findById(id);
		model.addAttribute("dojo",dojo);
		
		// create a ninja instance for jsp to use to get ninja data
		Ninja ninja = new Ninja();
		model.addAttribute("ninja",ninja);
		
		return "showDojo.jsp";
		
	}
	
	@RequestMapping(value = "/processNewDojo", method = RequestMethod.POST)
	public String processNewDojo(Model model, @Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result ) {

		if (result.hasErrors()) {
			model.addAttribute("dojo",dojo);
			System.out.println("Error creating Dojo");
			return "dojoForm.jsp";
		} else {
			System.out.println("Success creating Dojo");
			dojoService.createDojo(dojo);
			return "redirect:/";
		}
	
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinjaForm(Model model) {
		
		// get all dojos for jsp drop down
		List<Dojo> allDojos = dojoService.findAll();
		model.addAttribute("allDojos",allDojos);
		
		// create a ninja instance for the model binding in the jsp
		Ninja ninja = new Ninja();
		model.addAttribute("ninja",ninja);
		
		return "ninjaForm.jsp";
	}
	@RequestMapping(value = "/processNewNinja", method = RequestMethod.POST)
	public String processNewNinja(Model model, @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result ) {

		if (result.hasErrors()) {
			model.addAttribute("ninja",ninja);
			System.out.println("Error creating Ninja");
			return "ninjaForm.jsp";
		} else {
			System.out.println("Success creating Ninja");
			ninjaService.createNinja(ninja);
			return "redirect:/";
		}
	
	}
}
