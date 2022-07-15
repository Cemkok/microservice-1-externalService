/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Bit.microservice1externalService.business.abstracts.CustomerService;
import com.Bit.microservice1externalService.core.mapping.ModelMapperService;
import com.Bit.microservice1externalService.dataAccess.CustomerDao;
import com.Bit.microservice1externalService.entities.Customer;
import com.Bit.microservice1externalService.entities.dtos.CustomerListDto;
import com.Bit.microservice1externalService.entities.requests.CreateCustomerRequest;

/**
 * @author Cem Kok
 * @Date   11 Tem 2022
 * @Time   13:53:23
 * @See
 */
@Service
public class CustomerManager implements CustomerService {
	
	private CustomerDao customerDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public CustomerManager(CustomerDao customerDao, ModelMapperService modelMapperService) {

		this.customerDao = customerDao;
		this.modelMapperService=modelMapperService;
		
	}
	
	
	
	
	
	@Override
	public Customer addCustomer(CreateCustomerRequest createCustomerRequest) {
		Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
		customer.setCreateTime(LocalDateTime.now());
		return customerDao.save(customer);
	}
	
	
	@Override
	public void	deleteCustomer (Long customerId) {
		
		customerDao.deleteById(customerId);
	}
	
	
	
	
	@Override
	public List<CustomerListDto> getAllCustomers(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		List<Customer> customerList = this.customerDao.findAll(pageable).getContent();
		List<CustomerListDto> response = customerList.stream()
				.map(customer -> modelMapperService.forDto()
						.map(customer, CustomerListDto.class))
				.collect(Collectors.toList());
		return response;
	}
		
	}


