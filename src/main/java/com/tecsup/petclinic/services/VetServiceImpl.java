package com.tecsup.petclinic.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;
import com.tecsup.petclinic.repositories.VetRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VetServiceImpl implements VetService{
	
	VetRepository vetRepository;

	public VetServiceImpl (VetRepository VetRepository) {
	this. vetRepository = VetRepository;
}
	
	public Vet create(Vet vet) {
		return vetRepository.save(vet);
	}

	@Override
	public Vet update(Vet vet) {
		return vetRepository.save(vet);
	}

	@Override
	public void delete(Integer id) throws VetNotFoundException {
		Vet vet = findById(id);
		vetRepository.delete(vet);
		
	}

	@Override
	public Vet findById(Integer id) throws VetNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vet> findByFirstName(String first_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vet> findByLastName(String last_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vet> findAll() {
		return vetRepository.findAll();
	}
	
	

}
