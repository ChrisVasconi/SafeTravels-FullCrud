package com.chrisvasconi.safetravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chrisvasconi.safetravels.models.Travels;
import com.chrisvasconi.safetravels.services.TravelsService;

@RestController
@RequestMapping("/api")
public class TravelsApi {
	
	@Autowired
	private TravelsService travelsService;
	//======Get All=========
	@RequestMapping("/travels")
	public List<Travels>findAllTravels(){
		return travelsService.allTravels();
	}
	//-----Create----------
	@PostMapping("/travels")
	public Travels createTravel(
			@RequestParam("expense") String expense,
			@RequestParam("vendor") String vendor,
			@RequestParam("amount") Double amount
			) {
		Travels newTravel = new Travels(expense, vendor, amount);
		return travelsService.createTravels(newTravel);
}
	//-------Find One (/travels/<id>)---------
	@GetMapping("/travels/{id}")
	public Travels oneTravels(@PathVariable("id") Long id) {
		return travelsService.oneTravels(id);
	}
	
	//===========Edit (Find one + Create)=========
	//1. ID from path variables
	//2. Info from the RequestParam /body
	@PutMapping("/travels/{id}") //Needs to be called ID, not userID 
	public Travels editTravels(
			@PathVariable("id") Long id,
			@RequestParam("expense") String expense,
			@RequestParam("vendor") String vendor,
			@RequestParam("amount") Double amount,
			@RequestParam("Description") String description
			//The edit did not work until I put in the description Params
			){
		return travelsService.updateTravels(id, expense, vendor, amount, description);
	}
	
	//==============DELETE ===================
	@DeleteMapping("/travels/{id}")
	public void removeTravels(@PathVariable("id") Long id) {
		travelsService.deleteTravels(id);
	}


}