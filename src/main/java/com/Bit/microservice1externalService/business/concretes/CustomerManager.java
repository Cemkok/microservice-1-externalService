/**
 * concrete package of business layer.
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Component;

import org.springframework.stereotype.Service;
import com.Bit.microservice1externalService.business.abstracts.CustomerService;
import com.Bit.microservice1externalService.core.constants.Logging;
import com.Bit.microservice1externalService.core.constants.Messages;
import com.Bit.microservice1externalService.core.mapping.ModelMapperService;
import com.Bit.microservice1externalService.core.results.DataResult;
import com.Bit.microservice1externalService.core.results.ErrorDataResult;
import com.Bit.microservice1externalService.core.results.ErrorResult;
import com.Bit.microservice1externalService.core.results.Result;
import com.Bit.microservice1externalService.core.results.SuccessDataResult;

import com.Bit.microservice1externalService.dataAccess.CustomerDao;
import com.Bit.microservice1externalService.entities.Customer;
import com.Bit.microservice1externalService.entities.dtos.CustomerListDto;
import com.Bit.microservice1externalService.entities.requests.CreateCustomerRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * This class is the concrete class of the business layer that provides
 * communication between the data access layer and the presentation layer, where
 * business rules-logic are applied.
 * 
 * @author Cem Kok
 * @Date 11 Tem 2022
 * @Time 13:53:23
 * @see
 * 
 *      <table border="1">
 *      <body>
 *      <tr>
 *      <td><strong>Annotations </strong></td>
 *      <td></td>
 *      </tr>
 * 
 *      <tr>
 *      <td>@Slf4j</td>
 *      <td>* Causes lombok to generate a logger field.
 *      <p>
 *      Complete documentation is found at
 *      <a href="https://projectlombok.org/features/Log">the project lombok
 *      features page for lombok log annotations</a>.
 *      <p>
 *      </td>
 * 
 *      </tr>
 * 
 *      <tr>
 *      <td>@Autowired</td>
 *      <td>Marks a constructor, field, setter method, or config method as to be
 *      autowired by Spring's dependency injection facilities. This is an
 *      alternative to the JSR-330 {@link javax.inject.Inject} annotation,
 *      adding required-vs-optional semantics. *
 *      <h3>Autowired Constructors</h3>
 *      <p>
 *      Only one constructor of any given bean class may declare this annotation
 *      with the {@link #required} attribute set to {@code true}, indicating
 *      <i>the</i> constructor to autowire when used as a Spring bean.
 *      Furthermore, if the {@code required} attribute is set to {@code true},
 *      only a single constructor may be annotated with {@code @Autowired}. If
 *      multiple <i>non-required</i> constructors declare the annotation, they
 *      will be considered as candidates for autowiring. The constructor with
 *      the greatest number of dependencies that can be satisfied by matching
 *      beans in the Spring container will be chosen. If none of the candidates
 *      can be satisfied, then a primary/default constructor (if present) will
 *      be used. Similarly, if a class declares multiple constructors but none
 *      of them is annotated with {@code @Autowired}, then a primary/default
 *      constructor (if present) will be used. If a class only declares a single
 *      constructor to begin with, it will always be used, even if not
 *      annotated. An annotated constructor does not have to be public.
 *
 *      </td>
 * 
 *      </tr>
 *      <tr>
 *      <td>@Service</td>
 *      <td>* Indicates that an annotated class is a "Service", originally
 *      defined by Domain-Driven Design (Evans, 2003) as "an operation offered
 *      as an interface that stands alone in the model, with no encapsulated
 *      state."
 *
 *      <p>
 *      May also indicate that a class is a "Business Service Facade" (in the
 *      Core J2EE patterns sense), or something similar. This annotation is a
 *      general-purpose stereotype and individual teams may narrow their
 *      semantics and use as appropriate.
 *
 *      <p>
 *      This annotation serves as a specialization of
 *      {@link Component @Component}, allowing for implementation classes to be
 *      autodetected through classpath scanning.</td>
 * 
 *      </tr>
 *      <tr>
 *      <td>@Override</td>
 *      <td>Indicates that a method declaration is intended to override a method
 *      declaration in a supertype. If a method is annotated with this
 *      annotation type compilers are required to generate an error message
 *      unless at least one of the following conditions hold:
 *
 *      <ul>
 *      <li>The method does override or implement a method declared in a
 *      supertype.</li>
 *      <li>The method has a signature that is override-equivalent to that of
 *      any public method declared in {@linkplain Object}.</li>
 *      </ul>
 *      </td>
 *      </tr>
 * 
 *      </body>
 *      </table>
 *      <br>
 * 
 * 
 */
@Slf4j
@Service
public class CustomerManager implements CustomerService {

	private CustomerDao customerDao;
	private ModelMapperService modelMapperService;

	/**
	 * This method is a constructor method to implement dependency injection to use
	 * an object.
	 * 
	 * @param CustomerDao is a data access layer, ModelMapperService is an interface
	 *                    of ModelMapperManager
	 */

	@Autowired
	public CustomerManager(CustomerDao customerDao, ModelMapperService modelMapperService) {

		this.customerDao = customerDao;
		this.modelMapperService = modelMapperService;
	}

	@Override

	public Result addCustomer(CreateCustomerRequest createCustomerRequest) {
		Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
		customer.setCreateTime(LocalDateTime.now());
		customerDao.save(customer);
		log.info("[addCustomer method is called ]--" + "[input parameter = " + createCustomerRequest + "]--"
				+ "[output parameter = "
				+ ToStringBuilder.reflectionToString(new SuccessDataResult<Customer>(customer, Messages.customerAdded))
				+ "]");
		;
		Logging.internalLogDetail();

		return new SuccessDataResult<Customer>(customer, Messages.customerAdded);
	}

	@Override
	public Result deleteCustomer(Long customerId) {
		if (customerDao.existsById(customerId)) {
		
			
			log.info("[deleteCustomer method is called ]--" + "[input parameter = " + "id :" + customerId + "]--"
					+ "[output parameter = "
					+ ToStringBuilder.reflectionToString(new SuccessDataResult<Optional<Customer>>(	customerDao.findById(customerId),Messages.customerDeletedById ))
					+ "]");
			Logging.internalLogDetail();
			customerDao.deleteById(customerId);
			return new SuccessDataResult<Optional<Customer>>(customerDao.findById(customerId),Messages.customerDeletedById + customerId);
		}

		else
			log.info("[deleteCustomer method is called ]--" + "[input parameter = " + "id :" + customerId + "]--"
					+ "[output parameter = " + ToStringBuilder.reflectionToString(new ErrorResult(Messages.noCustomer))
					+ "]");
		Logging.internalLogDetail();
		return new ErrorResult(Messages.noCustomer);
	}

	@Override
	public DataResult<Optional<Customer>> getByCustomerId(Long customerId) {
		if (customerDao.existsById(customerId)) {
			log.info("[getByCustomerId method is called ]--" + "[input parameter = " + "id :" + customerId + "]--"
					+ "[output parameter = "
					+ ToStringBuilder.reflectionToString(new SuccessDataResult<Optional<Customer>>(
							this.customerDao.findById(customerId), Messages.getCustomerById))
					+ "]");
			Logging.internalLogDetail();

			return new SuccessDataResult<Optional<Customer>>(this.customerDao.findById(customerId),
					Messages.getCustomerById);
		}

		else
			log.info("[getByCustomerId method is called ]--" + "[input parameter = " + "id :" + customerId + "]--"
					+ "[output parameter = "
					+ ToStringBuilder.reflectionToString(new ErrorDataResult<>(Messages.noCustomer)) + "]");
		Logging.internalLogDetail();
		return new ErrorDataResult<>(Messages.noCustomer);
	}

	@Override
	public DataResult<List<CustomerListDto>> getAllCustomers(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		List<Customer> customerList = this.customerDao.findAll(pageable).getContent();
		List<CustomerListDto> response = customerList.stream()
				.map(customer -> modelMapperService.forDto().map(customer, CustomerListDto.class))
				.collect(Collectors.toList());
		log.info("[getAllCustomers method is called ]--" + "[input parameter = " + "pageNo-pageSize :" + pageNo+
				" , "+ pageSize +  "]--" + "[output parameter = "
						+ ToStringBuilder.reflectionToString(
								new SuccessDataResult<List<CustomerListDto>>(response, "All customers have listed"))
						+ "]");
		Logging.internalLogDetail();
		return new SuccessDataResult<List<CustomerListDto>>(response, "All customers have listed");
	}

	@Override
	public DataResult<List<Customer>> getAllSortedByCustomerName() {
		Sort sort = Sort.by(Sort.Direction.DESC, "customerName");
		DataResult<List<Customer>> response = new SuccessDataResult<List<Customer>>(this.customerDao.findAll(sort), Messages.descSorted);
		
		String resultForLogging = ToStringBuilder.reflectionToString(response);
		log.info("[getAllSortedByCustomerName method is called ]--" + "[input parameter = no args:" + "]--"
				+ "[output parameter = "
				+ resultForLogging + "]");
						
		Logging.internalLogDetail();

		return response;
		
	}

	@Override

	public DataResult<List<CustomerListDto>> findAllFilteredByCompanyName(String companyName) {
		if (customerDao.existsByCompanyName(companyName))

		{
			List<CustomerListDto> response = this.customerDao.findAll().stream()
					.filter(customer -> companyName.equals(customer.getCompanyName()))
					.map(customer -> modelMapperService.forDto().map(customer, CustomerListDto.class))
					.collect(Collectors.toList());
			log.info("[findAllFilteredByCompanyName method is called ]--" + "[input parameter = " + companyName + "]--"
					+ "[output parameter = "
					+ ToStringBuilder.reflectionToString(
							new SuccessDataResult<List<CustomerListDto>>(response, Messages.getAllByCompanyName))
					+ "]");
			Logging.internalLogDetail();
			return new SuccessDataResult<List<CustomerListDto>>(response, Messages.getAllByCompanyName);
		} else
			log.info("[findAllFilteredByCompanyName method is called ]--" + "[input parameter = " + companyName + "]--"
					+ "[output parameter = "
					+ ToStringBuilder.reflectionToString(new ErrorDataResult<>(Messages.noCustomer)) + "]");
		Logging.internalLogDetail();
		return new ErrorDataResult<>(Messages.noCustomer);
	}

}
