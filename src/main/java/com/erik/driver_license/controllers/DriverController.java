package com.erik.driver_license.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erik.driver_license.models.License;
import com.erik.driver_license.models.Person;
import com.erik.driver_license.services.LicenseService;
import com.erik.driver_license.services.PeopleService;

@Controller
public class DriverController {
	private final PeopleService pplService;
	private final LicenseService licService;
	public DriverController(PeopleService pplService, LicenseService liceService) {
		this.pplService = pplService;
		this.licService = liceService;
	}
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/person/new";
	}
	@GetMapping("/person/new")
	public String renderPerson() {
		return "new.jsp";
	}
	@PostMapping("/person/new")
	public String postPerson(@Valid @ModelAttribute("person") Person person,BindingResult result){
		if(result.hasErrors()) {
			System.out.println("invalid person");
		}
		else {
			//create
			pplService.createPerson(person);
		}
		return "new.jsp";
	}
	@GetMapping("/license/new")
	public String renderLicense(Model model) {
		List<Person> allPersons = pplService.allPeople();
		model.addAttribute("allPersons", allPersons);
		return "license.jsp";
	}
	@PostMapping("/license/new")
	public String postLicense(@Valid @ModelAttribute("license") License lic,BindingResult result, Model model){
		List<Person> allPersons = pplService.allPeople();
		model.addAttribute("allPersons", allPersons);
		if(result.hasErrors()) {
			System.out.println("invalid license");
		}
		else {
			//create
			licService.createLicense(lic);
		}
		return "license.jsp";
	}
	@RequestMapping("/person/{person_id}")
	public String show(Model model, @PathVariable("person_id") Long id) {
		Person subject = pplService.findPerson(id);
		if (subject == null) {
			return "redirect:/person/new";
		}
		model.addAttribute("person", subject);
		model.addAttribute("license", subject.getLicense());
		return "person.jsp";
	}
}
