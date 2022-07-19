/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.core.mapping;

import org.modelmapper.ModelMapper;

/**
 * This is an interface of ModelMapperManager class 
 * @author Cem Kok
 * @Date   15 Tem 2022
 * @Time   17:22:27
 * @see  <p>
 *      This interface provides us with a template to implement,
 *      <strong>dependency injection </strong> for the concrete class, and
 *      communication among layers.
 *    
 * 
 */
public interface ModelMapperService {

	/**
	 * @return dto for response.
	 */
	ModelMapper forDto();

	/**
	 * @return dto for request.
	 */
	ModelMapper forRequest();


}
