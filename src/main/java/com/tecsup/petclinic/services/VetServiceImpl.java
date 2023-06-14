package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;
import com.tecsup.petclinic.repositories.VetRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VetServiceImpl implements VetService{
	
	@Autowired
	VetRepository vetRepository;

	
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
		Optional<Vet> vet = vetRepository.findById(id);

		if ( !vet.isPresent())
			throw new VetNotFoundException("Record not found...!");
			
		return vet.get();
	}

	@Override
	public List<Vet> findByFirstName(String first_name) {
		List<Vet> vets = vetRepository.findByLastName(first_name);

		vets.stream().forEach(vet -> log.info("" + vet));

		return vets;
	}

	@Override
	public List<Vet> findByLastName(String last_name) {
		List<Vet> vets = vetRepository.findByLastName(last_name);

		vets.stream().forEach(vet -> log.info("" + vet));

		return vets;
	}

	@Override
	public List<Vet> findAll() {
		return vetRepository.findAll();
	}
	
	

}
