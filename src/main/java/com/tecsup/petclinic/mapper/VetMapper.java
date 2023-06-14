package com.tecsup.petclinic.mapper;


import com.tecsup.petclinic.domain.VetTO;
import com.tecsup.petclinic.entities.Vet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;
import java.text.ParseException;
import java.util.List;

@Mapper(componentModel = "spring",  nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface VetMapper {

	VetMapper INSTANCE = Mappers.getMapper(VetMapper.class);
	
	List<VetTO> toVetTOList(List<Vet> vetList);

	List<Vet> toVetList(List<VetTO> vetTOList);

	Vet toVet(VetTO vetTO);
	VetTO toVetTO(Vet vet);
	
			
}
