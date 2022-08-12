package com.chrisvasconi.safetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chrisvasconi.safetravels.models.Travels;
import com.chrisvasconi.safetravels.services.TravelsService;

@Controller
public class HomeController {
	@Autowired
	private TravelsService travelsService;
	
//==========Dashboard============
	
	@GetMapping("/travels")
	public String dashboard(Model model) {
		//get the DB info
		List<Travels> travels = travelsService.allTravels();
		//add the list to the jsp (Model model)
		model.addAttribute("newTravel", new Travels());
		model.addAttribute("travelsList", travels);
		return "travels.jsp";
	}
//===========Details=========
	@GetMapping("/travels/{id}")
	public String oneTravels(@PathVariable("id") Long id, Model model) {
		//1. get specific travels from service from db
		Travels foundTravels = travelsService.oneTravels(id);
		//2. Add the info to the jsp (Model model)
		model.addAttribute("oneTravels", foundTravels);
		return "details.jsp";
	}
//==========Create==========	
	@GetMapping("/travels/add")
	public String renderCreateTravels(Model model) {
		Travels travels = new Travels();
		model.addAttribute("travels", travels);
		return "travels.jsp";
	}
	
//=======Process the form===========
	@PostMapping("/travels")
	public String processCreate(
			@RequestParam("expense") String expense,
			@RequestParam("vendor") String vendor,
			@RequestParam("amount") Double amount
			) {
		Travels newTravels = new Travels(expense, vendor, amount);
		travelsService.createTravels(newTravels);
			return "redirect:/travels";
	}


//================EDIT,MOTHER F**KER===============
	//Render the form(use the id from the path to that travels)
	@GetMapping("/travels/edit/{id}")
	public String renderEditTravels(@PathVariable("id") Long id, Model model) {
		Travels foundTravels = travelsService.oneTravels(id);
		model.addAttribute("travels", foundTravels);
		return "edit.jsp";
	}
	//Process the form == need {id} otherwise it will make putmapping into post mapping
	@PutMapping("/travels/edit/{id}")
	public String processEdit(@Valid @ModelAttribute("travels")Travels travels, BindingResult result) {
	if(result.hasErrors()) {
		return "edit.jsp";
			}else {
				travelsService.updateTravels(travels);
				return "redirect:/travels";
			}
	}
	
	//========Delete=======
	@DeleteMapping("/travels/{id}")
	public String processDelete(@PathVariable("id")Long id) {
		travelsService.deleteTravels(id);
		return "redirect:/travels";
	}
	
	
}
