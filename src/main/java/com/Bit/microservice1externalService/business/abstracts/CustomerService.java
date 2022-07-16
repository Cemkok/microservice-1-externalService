/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.business.abstracts;

import java.util.List;
import java.util.Optional;

import com.Bit.microservice1externalService.core.results.DataResult;
import com.Bit.microservice1externalService.core.results.Result;
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
	Result deleteCustomer(Long customerId);



	/**
	 * @param createCustomerRequest
	 * @return
	 */
	Result addCustomer(CreateCustomerRequest createCustomerRequest);



	/**
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataResult<List<CustomerListDto>> getAllCustomers(int pageNo, int pageSize);	

	/**
	 * @return
	 */
	DataResult<List<Customer>> getAllSortedByCustomerName();



	/**
	 * @param companyName
	 * @return
	 */
	 DataResult<List<CustomerListDto>> findAllFilteredByCompanyName(String companyName);



	/**
	 * @param id
	 * @return
	 */
	DataResult<Optional<Customer>> getByCustomerId(Long id);
	
	


}
