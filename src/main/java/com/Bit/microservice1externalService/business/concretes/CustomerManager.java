/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bit.microservice1externalService.business.abstracts.CustomerService;
import com.Bit.microservice1externalService.dataAccess.CustomerDao;
import com.Bit.microservice1externalService.entities.Customer;

/**
 * @author Cem Kok
 * @Date   11 Tem 2022
 * @Time   13:53:23
 * @See
 */
@Service
public class CustomerManager implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	
	@Override
	public Customer addCustomer(Customer customer) {
		customer.setCreateTime(LocalDateTime.now());
		return customerDao.save(customer);
	}
	
	@Override
	public void	deleteCustomer (Long customerId) {
		
		customerDao.deleteById(customerId);
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		return this.customerDao.findAll();
	}
		
	}


