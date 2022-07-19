package com.Bit.microservice1externalService;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 * @author Cem Kok
 * @Date 10 Tem 2022
 * @Time 18:11:46
 * @see This class is the main class of the project, project runs from this class
 */

@SpringBootApplication
public class Microservice1ExternalServiceApplication {

	/**
	 * This method provides us to run the project.
	 * 
	 *  <p>Class that can be used to bootstrap and launch a Spring
	 *                      application from a Java main method. Static helper that
	 *                      can be used to run a {@link SpringApplication} from the
	 *                      specified source using default settings. </p>
	 * 
	 * 
	 * @param args          the application arguments (usually passed from a Java
	 *                      main method)
	 * 
	 *                     
	
	 */

	public static void main(String[] args) {

		SpringApplication.run(Microservice1ExternalServiceApplication.class, args);
	}
	
	/**
	 * 
	 * @return
	 */
	@Bean 
	public ModelMapper getModelMapper() {
		return new ModelMapper(); }

}
