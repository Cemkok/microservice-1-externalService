/**
 * abstract package of business layer.
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
 * This is an interface of CustomerManager class.
 * 
 * @author Cem Kok
 * @Date 17 Tem 2022
 * @Time 23:29:14
 * @see
 *      <p>
 *      This interface provides us with a template to implement,
 *      <strong>dependency injection </strong> for the concrete class, and
 *      communication between the data <strong>access</strong> layer and the
 *      <strong>presentation</strong> layer.
 */
public interface CustomerService {

	/**
	 * This method deletes the customer based on the given id if it exists.
	 * 
	 * @param customerId
	 * @return Result Object {success status, message}
	 */
	Result deleteCustomer(Long customerId);

	/**
	 * This method adds customers according to the given createCustomerRequest
	 * {customerName, companyName} values.
	 * 
	 * @param createCustomerRequest is a customer dto for requests.
	 * @return Result Object {data, success status, message}
	 */
	Result addCustomer(CreateCustomerRequest createCustomerRequest);

	/**
	 * This method gets by paginating all customers in the database.
	 * 
	 * @param pageNo  shows which page it is.			 
	 * @param pageSize is the size of the page.
	 * @return  DataResult {list of data, success status, message}
	 */
	DataResult<List<CustomerListDto>> getAllCustomers(int pageNo, int pageSize);

	/**
	 * This method sorts alphabetically descending by customer name
	 * 
	 * @return DataResult { a list sorted by customer name, message, success status}
	 *         
	 */
	DataResult<List<Customer>> getAllSortedByCustomerName();

	/**
	 *  This method implements a filter by using companyName parameter;
	 *  
	 * @param companyName
	 * @return  DataResult { a list filtered by customer name, message, success status}
	 */
	DataResult<List<CustomerListDto>> findAllFilteredByCompanyName(String companyName);

	/**
	 * This method gets customer object by using customer id.
	 * @param id is a customer id
	 *  @return  DataResult { optional data, message, success status}
	 */
	DataResult<Optional<Customer>> getByCustomerId(Long customerId);

}
