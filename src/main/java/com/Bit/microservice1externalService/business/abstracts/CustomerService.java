/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.business.abstracts;

import java.util.List;

import com.Bit.microservice1externalService.entities.Customer;
import com.Bit.microservice1externalService.entities.dtos.CustomerListDto;
import com.Bit.microservice1externalService.entities.requests.CreateCustomerRequest;

/**
 * @author Cem Kok
 * @Date   11 Tem 2022
 * @Time   13:53:41
 * @See
 */
public interface CustomerService {

	
	

	/**
	 * @param customerId
	 */
	void deleteCustomer(Long customerId);



	/**
	 * @param createCustomerRequest
	 * @return
	 */
	Customer addCustomer(CreateCustomerRequest createCustomerRequest);



	/**
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<CustomerListDto> getAllCustomers(int pageNo, int pageSize);



	/**
	 * @param id
	 * @return
	 */
	String deleteById(Long id);



	/**
	 * @param id
	 * @return
	 */
	Object getByCustomerId(Long id);



	/**
	 * @return
	 */
	List<Customer> getAllSortedByCustomerName();



	/**
	 * @param companyName
	 * @return
	 */
	Object findAllFilteredByCompanyName(String companyName);
	
	


}
