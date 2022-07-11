/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bit.microservice1externalService.business.abstracts.CustomerService;
import com.Bit.microservice1externalService.entities.Customer;

/**
 * @author Cem Kok
 * @Date   11 Tem 2022
 * @Time   14:53:32
 * @See
 */

@RestController
@RequestMapping("api/customer")
public class CustomerController {
	
	
	private CustomerService customerService;

	/**
	 * @param customerService
	 */
	@Autowired
	public CustomerController(CustomerService customerService) {
		
		this.customerService = customerService;
	}
	
	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer)
	
	{
		return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}
	
	@DeleteMapping("{customerId}")
	public ResponseEntity<?> deleteByCustomerId(@PathVariable Long customerId){
		
		customerService.deleteCustomer(customerId);
		 return  new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<?> getAllProducts()
	{
		return ResponseEntity.ok(customerService.getAllCustomers());
		
	}
	
	

}
