/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Cem Kok
 * @Date   15 Tem 2022
 * @Time   17:42:31
 * @See
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerListDto {
	
	
	private Long id;
	private String customerName;
	private String companyName;
}
