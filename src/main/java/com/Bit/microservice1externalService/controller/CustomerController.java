/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Bit.microservice1externalService.business.abstracts.CustomerService;
import com.Bit.microservice1externalService.core.results.ErrorDataResult;
import com.Bit.microservice1externalService.entities.requests.CreateCustomerRequest;

/**
 * @author Cem Kok
 * @Date 11 Tem 2022
 * @Time 14:53:32
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

	@PostMapping("/add")
	public ResponseEntity<?> addCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest)

	{
		return new ResponseEntity<>(customerService.addCustomer(createCustomerRequest), HttpStatus.CREATED);
	}

	// done
	@DeleteMapping("/deleteById/{customerId}")
	public ResponseEntity<?> deleteByCustomerId(@PathVariable Long customerId) {

		return ResponseEntity.ok(this.customerService.deleteCustomer(customerId));

	}

	@GetMapping("/getById/{id}")

	public ResponseEntity<?> getByCustomerId(@PathVariable Long id) {

		return ResponseEntity.ok(this.customerService.getByCustomerId(id));

	}

	

	@GetMapping("findAllFilteredByCompanyName/{companyName}")

	public ResponseEntity<?> findAllFilteredByCompanyName(@PathVariable String companyName) {

		return ResponseEntity.ok(this.customerService.findAllFilteredByCompanyName(companyName));
	}

	@GetMapping("/getAllByPage/{pageNo}/{pageSize}")
	public ResponseEntity<?> getAllCustomers(@PathVariable int pageNo, @PathVariable int pageSize) {
		return ResponseEntity.ok(customerService.getAllCustomers(pageNo, pageSize));

	}

	@GetMapping("/getAllSortedByCustomerName")

	public ResponseEntity<?> getAllSortedByCustomerName() {

		return ResponseEntity.ok(this.customerService.getAllSortedByCustomerName());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {

			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");

		return errors;

	}

}
