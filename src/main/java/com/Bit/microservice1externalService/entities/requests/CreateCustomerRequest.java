/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.entities.requests;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Cem Kok
 * @Date   15 Tem 2022
 * @Time   17:43:00
 * @See
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

	@NotEmpty
	@Size(min=0, max=50)
	private String customerName;
	
	@NotEmpty
    @Size(min=0, max=50)
	private String companyName;

}
