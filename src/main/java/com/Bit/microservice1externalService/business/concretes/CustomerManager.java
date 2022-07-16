/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Bit.microservice1externalService.business.abstracts.CustomerService;
import com.Bit.microservice1externalService.core.constants.Messages;
import com.Bit.microservice1externalService.core.mapping.ModelMapperService;
import com.Bit.microservice1externalService.core.results.DataResult;
import com.Bit.microservice1externalService.core.results.ErrorDataResult;
import com.Bit.microservice1externalService.core.results.ErrorResult;
import com.Bit.microservice1externalService.core.results.Result;
import com.Bit.microservice1externalService.core.results.SuccessDataResult;
import com.Bit.microservice1externalService.core.results.SuccessResult;
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
	public Result addCustomer(CreateCustomerRequest createCustomerRequest) {
		Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
		customer.setCreateTime(LocalDateTime.now());
		customerDao.save(customer);
		
		return new SuccessDataResult<Customer>(customer,Messages.customerAdded );
	}
	
	
	@Override
	public Result deleteCustomer(Long customerId) {
		if(customerDao.existsById(customerId)){
			customerDao.deleteById(customerId);
			return new SuccessResult(Messages.customerDeletedById +customerId);}
		
		else return new ErrorResult(Messages.noCustomer);
	}
	
	
	
	

	

	@Override
	public DataResult<Optional<Customer>> getByCustomerId(Long id) {
			if(customerDao.existsById(id))
			{return new SuccessDataResult<Optional<Customer>>(this.customerDao.findById(id), id+"Id'li müşteri getirildi");
			}
		
			else return new ErrorDataResult<>(Messages.noCustomer);
	}
	
	
	
	@Override
	public DataResult<List<CustomerListDto>> getAllCustomers(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		List<Customer> customerList = this.customerDao.findAll(pageable).getContent();
		List<CustomerListDto> response = customerList.stream()
				.map(customer -> modelMapperService.forDto()
						.map(customer, CustomerListDto.class))
				.collect(Collectors.toList());
		return  new SuccessDataResult<List<CustomerListDto>>(response, "oldu");
	}
	

	@Override 
	public  DataResult<List<Customer>> getAllSortedByCustomerName() {
		Sort sort = Sort.by(Sort.Direction.DESC, "customerName");

		return new SuccessDataResult<List<Customer>>(this.customerDao.findAll(sort),Messages.descSorted);
	}

	
	@Override
	
	public DataResult<List<CustomerListDto>> findAllFilteredByCompanyName(String companyName) {
	
		List<CustomerListDto> response = this.customerDao.findAll().stream().filter(customer->
				companyName.equals(customer.getCompanyName()))
				.map(customer -> modelMapperService.forDto()
						.map(customer, CustomerListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<CustomerListDto>>(response, Messages.getAllByCompanyName);
	}
	




	
		
	}


