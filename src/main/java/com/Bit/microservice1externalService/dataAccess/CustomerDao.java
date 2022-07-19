/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bit.microservice1externalService.entities.Customer;

/**
 * This interface acts as the data access layer
 * 
 * @author Cem Kok
 * @Date 11 Tem 2022
 * @Time 13:36:28
 * @see 
 * <p>This interface acts as the data access layer . It is a structural pattern that
 *      allows us to isolate the application/business layer from the persistence
 *      layer (usually a relational database but could be any other persistence
 *      mechanism) using an abstract API.
 * 
 *      The API hides from the application all the complexity of performing CRUD
 *      operations in the underlying storage mechanism. This permits both layers
 *      to evolve separately without knowing anything about each other.</p>
 */

public interface CustomerDao extends JpaRepository<Customer, Long> {

	/**
	 * This method checks if the company name exists in the database.
	 * @param companyName
	 * @return boolean
	 */
	boolean existsByCompanyName(String companyName);

}
