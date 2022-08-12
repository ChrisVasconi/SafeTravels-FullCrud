package com.chrisvasconi.safetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisvasconi.safetravels.models.Travels;

@Repository
public interface TravelsRepository extends CrudRepository< Travels, Long >{
	List<Travels> findAll();
	
	
}
