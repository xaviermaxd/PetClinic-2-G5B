package com.tecsup.petclinic.services;

import java.util.List;
import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;



public interface VetService {
	
	Vet create(Vet vet);
	
	Vet update(Vet vet);
	
	void delete(Integer id) throws VetNotFoundException;

	Vet findById(Integer id) throws VetNotFoundException;

	List<Vet> findByFirstName(String first_name);
	
	List<Vet> findByLastName(String last_name);
	
	List<Vet> findAll();
}
