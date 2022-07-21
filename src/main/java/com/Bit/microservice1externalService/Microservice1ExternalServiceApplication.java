package com.Bit.microservice1externalService;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




/**
 *  This class is the main class of the project, project runs from this class
 * @author Cem Kok
 * @Date 10 Tem 2022
 * @Time 18:11:46
 * @see This class is the main class of the project, project runs from this class
 */


@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
@EnableSwagger2
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
	 * A builder which is intended to be the primary interface into the Springfox framework.
	 * Provides sensible defaults and convenience methods for configuration.
	 * 
	 * @return
	 */
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.Bit.microservice1externalService"))              
                                
          .build();                  
        
    }
	
	/**
	 * Creates a new ModelMapper.
	 * @return  ModelMapper();
	 */
	@Bean 
	public ModelMapper getModelMapper() {
		return new ModelMapper(); }

}
