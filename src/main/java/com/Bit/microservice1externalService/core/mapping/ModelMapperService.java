/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.core.mapping;

import org.modelmapper.ModelMapper;

/**
 * @author Cem Kok
 * @Date   15 Tem 2022
 * @Time   17:22:27
 * @See
 */
public interface ModelMapperService {

	/**
	 * @return
	 */
	ModelMapper forDto();

	/**
	 * @return
	 */
	ModelMapper forRequest();


}
