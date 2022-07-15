/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bit.microservice1externalService.entities.Customer;

/**
 * @author Cem Kok
 * @Date   11 Tem 2022
 * @Time   13:36:28
 * @See
 */

public interface CustomerDao extends JpaRepository<Customer, Long> {
	
	

}
