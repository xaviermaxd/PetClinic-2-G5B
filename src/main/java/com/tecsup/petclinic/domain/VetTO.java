package com.tecsup.petclinic.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author G5B
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VetTO {

	private Integer id;
	
	private String first_name;
	
	private String last_name;
	
}
