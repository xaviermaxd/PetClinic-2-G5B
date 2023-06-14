package com.tecsup.petclinic.webs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tecsup.petclinic.domain.VetTO;
import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.PetNotFoundException;
import com.tecsup.petclinic.exception.VetNotFoundException;
import com.tecsup.petclinic.mapper.VetMapper;
import com.tecsup.petclinic.services.VetService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class VetController {
	
	@Autowired
    private VetService vetService;
	private VetMapper mapper;
	
	@GetMapping("/vets")
	public List<Vet> findAll(){
		return vetService.findAll();
	}

	@GetMapping("vets/{id}")
	public ResponseEntity<Vet> findById(@PathVariable int id) throws VetNotFoundException{
		Vet vet_id = vetService.findById(id);
		return ResponseEntity.ok(vet_id);
	}
	
	@DeleteMapping(value = "/vets/{id}")
	ResponseEntity<String> delete(@PathVariable Integer id) {

		try {
			vetService.delete(id);
			return ResponseEntity.ok(" Delete ID :" + id);
		} catch (VetNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping(value = "/vets/{first_name}")
	ResponseEntity<List<Vet>> findByName(@PathVariable String first_name) throws VetNotFoundException {
		
		List<Vet> vet = vetService.findByFirstName(first_name);
		return ResponseEntity.ok(vet);
	}
	
	

}
