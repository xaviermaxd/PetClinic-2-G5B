package com.tecsup.petclinic.webs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.tecsup.petclinic.domain.PetTO;
import com.tecsup.petclinic.domain.VetTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;


@AutoConfigureMockMvc
@SpringBootTest
@Slf4j
class VetControllerTest {

	private static final ObjectMapper om = new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;

	
	/**
	 * 
	 * @author Mamani Xavier
	 *
	 */
	@Test
	void testFindAll() throws Exception {
		//int NRO_RECORD = 73;
				int ID_FIRST_RECORD = 1;

				this.mockMvc.perform(get("/vets"))
						.andExpect(status().isOk())
						.andExpect(content()
								.contentType(MediaType.APPLICATION_JSON_VALUE))
						//		    .andExpect(jsonPath("$", hasSize(NRO_RECORD)))
						.andExpect(jsonPath("$[0].id", is(ID_FIRST_RECORD)));
	}

	
	/**
	 * 
	 * @author Aysa yerly
	 *
	 */
	@Test
	public void testDeleteVet() throws Exception {

		String first_name = "Maria";
		String last_name = "Posada";

		VetTO newVetTO = new VetTO();
		newVetTO.setFirst_name(first_name);
		newVetTO.setLast_name(last_name);


		ResultActions mvcActions = mockMvc.perform(post("/vets")
						.content(om.writeValueAsString(newVetTO))
						.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isCreated());

		String response = mvcActions.andReturn().getResponse().getContentAsString();

		Integer id = JsonPath.parse(response).read("$.id");

		mockMvc.perform(delete("/vets/" + id ))
				/*.andDo(print())*/
				.andExpect(status().isOk());
	}
	
	/**
	 * 
	 * @author Perez Treyci
	 *
	 */
	@Test
	public void testFindById() throws Exception {
		
		int ID_VET = 1;
      

		this.mockMvc.perform(get("/vets"))
		.andExpect(status().isOk())
		.andExpect(content()
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		//		    .andExpect(jsonPath("$", hasSize(NRO_RECORD)))
		.andExpect(jsonPath("$[0].id", is(ID_VET)));
    }
	
	
	
	
	/**
	 * 
	 * @author Choque Vanessa
	 *
	 */
	@Test
	public void testFindvetOK() throws Exception {	

		String NAME_VET = "James";
		String LAST_NAME_VET = "Carter";

		mockMvc.perform(get("/vets/James"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andDo(print()) 
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].firstName").is(NAME_VET))
				.andExpect(jsonPath("$[0].lastName").value(LAST_NAME_VET));
	}
	
	

}
