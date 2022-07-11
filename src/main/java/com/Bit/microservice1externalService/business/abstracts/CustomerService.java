/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.business.abstracts;

import java.util.List;

import com.Bit.microservice1externalService.entities.Customer;

/**
 * @author Cem Kok
 * @Date   11 Tem 2022
 * @Time   13:53:41
 * @See
 */
public interface CustomerService {

	/**
	 * @param customer
	 * @return
	 */
	Customer addCustomer(Customer customer);

	/**
	 * @param customerId
	 */
	void deleteCustomer(Long customerId);

	/**
	 * @return
	 */
	List<Customer> getAllCustomers();

}
