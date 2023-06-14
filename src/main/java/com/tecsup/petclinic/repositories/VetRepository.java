package com.tecsup.petclinic.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tecsup.petclinic.entities.Vet;


@Repository
public interface VetRepository 
	extends CrudRepository<Vet, Integer>{
	
	List<Vet> findByFirstName(String first_name);
	
	List<Vet> findByLastName(String last_name);
	
	@Override
	List<Vet> findAll();

}
