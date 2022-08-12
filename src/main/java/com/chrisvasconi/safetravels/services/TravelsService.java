package com.chrisvasconi.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chrisvasconi.safetravels.models.Travels;
import com.chrisvasconi.safetravels.repositories.TravelsRepository;

@Service 
public class TravelsService {
	
	
	
	private final TravelsRepository travelsRepo;
	
	public TravelsService(TravelsRepository travelsRepo) {
		this.travelsRepo = travelsRepo;
	}
	
	//find all
	public List<Travels> allTravels(){
		return travelsRepo.findAll();
	}
	
	//create 
	public Travels createTravels(Travels travel) {
		return travelsRepo.save(travel);
	}
	//============Find one======
	public Travels oneTravels(Long id) {
		Optional<Travels> optionalTravels = travelsRepo.findById(id);
		if(optionalTravels.isPresent()) { //If travels is present, true
			return optionalTravels.get();
		}else { //The travels of that id is not avaliable
			return null;
		}
	
	
	}
	//update one
	public Travels updateTravels(Travels travels) {
		return travelsRepo.save(travels);
	}
	
	//delete
	public void deleteTravels(Long id) {
		travelsRepo.deleteById(id);
	}

	public Travels updateTravels(Long id, String expense, String vendor, Double amount, String description) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
