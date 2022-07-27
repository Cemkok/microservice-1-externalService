/**
 * Presentation layer
 */
package com.Bit.microservice1externalService.controller;

import java.util.HashMap;

import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.Bit.microservice1externalService.business.abstracts.CustomerService;
import com.Bit.microservice1externalService.core.constants.Logging;
import com.Bit.microservice1externalService.core.results.ErrorDataResult;
import com.Bit.microservice1externalService.core.results.Result;
import com.Bit.microservice1externalService.entities.requests.CreateCustomerRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * This CustomerController class is a RestController.
 * 
 * @author Cem Kok
 * @Date 11 Tem 2022
 * @Time 14:53:32
 * 
 * @see
 *      <p>
 *      This CustomerController class is a RestController. RestController is
 *      used for making restful web services with the help of
 *      the @RestController annotation. This annotation is used at the class
 *      level and allows the class to handle the requests made by the client.
 *      </p>
 *      <table border="1">
 *      <body>
 *      <tr>
 *      <td><strong>Annotations </strong></td>
 *      <td></td>
 *      </tr>
 *      <tr>
 *      <td>@RestController</td>
 *      <td>A convenience annotation that is itself annotated with
 *      {@link Controller @Controller} and {@link ResponseBody @ResponseBody}.
 *      <p>
 *      Types that carry this annotation are treated as controllers where
 *      {@link RequestMapping @RequestMapping} methods assume
 *      {@link ResponseBody @ResponseBody} semantics by default.
 *
 *      <p>
 *      <b>NOTE:</b> {@code @RestController} is processed if an appropriate
 *      {@code HandlerMapping}-{@code HandlerAdapter} pair is configured such as
 *      the
 *      {@code RequestMappingHandlerMapping}-{@code RequestMappingHandlerAdapter}
 *      pair which are the default in the MVC Java config and the MVC namespace.
 *      <p>
 *      </td>
 *      </tr>
 *      <tr>
 *      <td>@RequestMapping</td>
 *      <td>Annotation for mapping web requests onto methods in request-handling
 *      classes with flexible method signatures.
 *      <p>
 *      <strong>Note:</strong> This annotation can be used both at the class and
 *      at the method level. In most cases, at the method level applications
 *      will prefer to use one of the HTTP method specific variants
 *      {@link GetMapping @GetMapping}, {@link PostMapping @PostMapping},
 *      {@link PutMapping @PutMapping}, {@link DeleteMapping @DeleteMapping}, or
 *      {@link PatchMapping @PatchMapping}.
 *      </p>
 *      </td>
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
 *      <td>@PostMapping</td>
 *      <td>* Annotation for mapping HTTP {@code POST} requests onto specific
 *      handler methods.
 *
 *      <p>
 *      Specifically, {@code @PostMapping} is a <em>composed annotation</em>
 *      that acts as a shortcut for
 *      {@code @RequestMapping(method = RequestMethod.POST)}.</td>
 * 
 *      </tr>
 *      <tr>
 *      <td>@DeleteMapping</td>
 *      <td>* Annotation for mapping HTTP {@code DELETE} requests onto specific
 *      handler methods.
 *
 *      <p>
 *      Specifically, {@code @DeleteMapping} is a <em>composed annotation</em>
 *      that acts as a shortcut for
 *      {@code @RequestMapping(method = RequestMethod.DELETE)}.</td>
 * 
 *      </tr>
 *      *
 *      <tr>
 *      <td>@GetMapping</td>
 *      <td>Annotation for mapping HTTP {@code GET} requests onto specific
 *      handler methods.
 *
 *      <p>
 *      Specifically, {@code @GetMapping} is a <em>composed annotation</em> that
 *      acts as a shortcut for
 *      {@code @RequestMapping(method = RequestMethod.GET)}.</td>
 * 
 *      </tr>
 *      *
 *      <tr>
 *      <td>@Valid</td>
 *      <td>Marks a property, method parameter or method return type for
 *      validation cascading.
 *      <p>
 *      Constraints defined on the object and its properties are be validated
 *      when the property, method parameter or method return type is validated.
 *      <p>
 *      This behavior is applied recursively.</td>
 * 
 *      </tr>
 * 
 *      <tr>
 *      <td>@RequestBody</td>
 *      <td>* Annotation indicating a method parameter should be bound to the
 *      body of the web request. The body of the request is passed through an
 *      {@link HttpMessageConverter} to resolve the method argument depending on
 *      the content type of the request. Optionally, automatic validation can be
 *      applied by annotating the argument with {@code @Valid}.
 *
 *      <p>
 *      Supported for annotated handler methods.</td>
 * 
 *      </tr>
 *      <tr>
 *      <td>@PathVariable</td>
 *      <td>* Annotation which indicates that a method parameter should be bound
 *      to a URI template variable. Supported for {@link RequestMapping}
 *      annotated handler methods.
 *
 *      <p>
 *      If the method parameter is {@link java.util.Map Map&lt;String,
 *      String&gt;} then the map is populated with all path variable names and
 *      values.</td>
 * 
 * 
 * 
 *      </tr>
 *      <tr>
 *      <td>@ExceptionHandler</td>
 *      <td>* Annotation for handling exceptions in specific handler classes
 *      and/or handler methods.
 *
 *      <p>
 *      Handler methods which are annotated with this annotation are allowed to
 *      have very flexible signatures. They may have parameters of the following
 *      types, in arbitrary order:
 *      <ul>
 *      <li>An exception argument: declared as a general Exception or as a more
 *      specific exception. This also serves as a mapping hint if the annotation
 *      itself does not narrow the exception types through its {@link #value()}.
 *      You may refer to a top-level exception being propagated or to a nested
 *      cause within a wrapper exception. As of 5.3, any cause level is being
 *      exposed, whereas previously only an immediate cause was considered.
 *      <li>Request and/or response objects (typically from the Servlet API).
 *      You may choose any specific request/response type, e.g.
 *      {@link javax.servlet.ServletRequest} /
 *      {@link javax.servlet.http.HttpServletRequest}.
 *      <li>Session object: typically {@link javax.servlet.http.HttpSession}. An
 *      argument of this type will enforce the presence of a corresponding
 *      session. As a consequence, such an argument will never be {@code null}.
 *      <i>Note that session access may not be thread-safe, in particular in a
 *      Servlet environment: Consider switching the
 *      {@link org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter#setSynchronizeOnSession
 *      "synchronizeOnSession"} flag to "true" if multiple requests are allowed
 *      to access a session concurrently.</i>
 *      <li>{@link org.springframework.web.context.request.WebRequest} or
 *      {@link org.springframework.web.context.request.NativeWebRequest}. Allows
 *      for generic request parameter access as well as request/session
 *      attribute access, without ties to the native Servlet API.
 *      <li>{@link java.util.Locale} for the current request locale (determined
 *      by the most specific locale resolver available, i.e. the configured
 *      {@link org.springframework.web.servlet.LocaleResolver} in a Servlet
 *      environment).
 *      <li>{@link java.io.InputStream} / {@link java.io.Reader} for access to
 *      the request's content. This will be the raw InputStream/Reader as
 *      exposed by the Servlet API.
 *      <li>{@link java.io.OutputStream} / {@link java.io.Writer} for generating
 *      the response's content. This will be the raw OutputStream/Writer as
 *      exposed by the Servlet API.
 *      <li>{@link org.springframework.ui.Model} as an alternative to returning
 *      a model map from the handler method. Note that the provided model is not
 *      pre-populated with regular model attributes and therefore always empty,
 *      as a convenience for preparing the model for an exception-specific view.
 *      </ul>
 *      </td>
 * 
 * 
 * 
 *      </tr>
 *      <tr>
 *      <td>@ResponseStatus</td>
 *      <td>* Marks a method or exception class with the status {@link #code}
 *      and {@link #reason} that should be returned.
 *
 *      <p>
 *      The status code is applied to the HTTP response when the handler method
 *      is invoked and overrides status information set by other means, like
 *      {@code ResponseEntity} or {@code "redirect:"}.
 *
 *      <p>
 *      <strong>Warning</strong>: when using this annotation on an exception
 *      class, or when setting the {@code reason} attribute of this annotation,
 *      the {@code HttpServletResponse.sendError} method will be used.
 *
 *      <p>
 *      With {@code HttpServletResponse.sendError}, the response is considered
 *      complete and should not be written to any further. Furthermore, the
 *      Servlet container will typically write an HTML error page therefore
 *      making the use of a {@code reason} unsuitable for REST APIs. For such
 *      cases it is preferable to use a
 *      {@link org.springframework.http.ResponseEntity} as a return type and
 *      avoid the use of {@code @ResponseStatus} altogether.
 *
 *      <p>
 *      Note that a controller class may also be annotated with
 *      {@code @ResponseStatus} and is then inherited by all
 *      {@code @RequestMapping} methods.</td>
 * 
 * 
 * 
 *      </tr>
 *      </body>
 *      </table>
 *      <br>
 * 
 * 
 */

@Slf4j
@RestController
@RequestMapping("api/customer") 
public class CustomerController {

	private CustomerService customerService;

	/**
	 * This method is a constructor method to implement dependency injection to use
	 * an object.
	 * 
	 * @param customerService is a interface of customerManager object
	 */
	@Autowired
	public CustomerController(CustomerService customerService) {

		this.customerService = customerService;

	}

	/**
	 * This method adds a new customer object
	 * 
	 * @param createCustomerRequest is a dto for request.
	 * @return if successful; added customer, message, boolean success status,
	 *         HttpStatus code. if not successful; message, boolean success status,
	 *         HttpStatus code.
	 */
	@PostMapping("/add")
	public ResponseEntity<?> addCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest)

	{
		Result response = this.customerService.addCustomer(createCustomerRequest);
		String resultForLogging = ToStringBuilder.reflectionToString(response);
		log.info("[addCustomer method is called ]--" + "[input parameter = " + createCustomerRequest
				+ "]-- [output parameter = " + resultForLogging + "]");

		Logging.internalLogDetail();

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	/**
	 * This method deletes by using customer id
	 * 
	 * @param customerId
	 * @return message, boolean success status, HttpStatus code.
	 */

	@DeleteMapping("/deleteById/{customerId}")
	public ResponseEntity<?> deleteByCustomerId(@PathVariable Long customerId) {

		Result response = this.customerService.deleteCustomer(customerId);
		String resultForLogging = ToStringBuilder.reflectionToString(response);
		log.debug("[deleteByCustomerId method is called ]--" + "[input parameter = " + customerId + "]--"
				+ "[output parameter = " + resultForLogging + "]");
		;
		Logging.internalLogDetail();

		return ResponseEntity.ok(response);

	}

	/**
	 * This method gets customer object by using customer id.
	 * 
	 * @param id is a customer id
	 * @return if successful; a customer based on the requested id, message, boolean
	 *         success status, HttpStatus code. if not successful; message, boolean
	 *         success status, HttpStatus code.
	 */
	@GetMapping("/getById/{id}")

	public ResponseEntity<?> getByCustomerId(@PathVariable Long id) {
			
		Result response  =this.customerService.getByCustomerId(id);
		String resultForLogging = ToStringBuilder.reflectionToString(response);
		log.debug("[getByCustomerId method is called ]--" + "[input parameter = " + id + "]--" 
		+ "[output parameter = "+resultForLogging
				+  "]");
		;
		Logging.internalLogDetail();

		return ResponseEntity.ok(response);

	}

	/**
	 * 
	 * This method implements a filter by using companyName parameter;
	 * 
	 * @param companyName is a customer company name.
	 * @return if successful; a list of customers by requested company name,
	 *         message, boolean success status, HttpStatus code. if not successful;
	 *         message, boolean success status, HttpStatus code.
	 */

	@GetMapping("findAllFilteredByCompanyName/{companyName}")

	public ResponseEntity<?> findAllFilteredByCompanyName(@PathVariable String companyName) {
		Result response  =this.customerService.findAllFilteredByCompanyName(companyName);
		String resultForLogging = ToStringBuilder.reflectionToString(response);
		log.info(
				"[findAllFilteredByCompanyName method is called ]--"
						+ "[input parameter = " + companyName + "]--"
						+"[output parameter = " + resultForLogging
						+ "]");
		;
		Logging.internalLogDetail();

		return ResponseEntity.ok(response);
	}

	/**
	 * This method gets all customers by paginating
	 * 
	 * @param pageNo   shows which page it is.
	 * @param pageSize is the size of the page.
	 * @return all customers paginated, message, boolean success status, HttpStatus
	 *         code.
	 */
	@GetMapping("/getAllByPage/{pageNo}/{pageSize}")
	public ResponseEntity<?> getAllCustomersByPage(@PathVariable int pageNo, @PathVariable int pageSize) {
		Result response  =customerService.getAllCustomers(pageNo, pageSize);
		String resultForLogging = ToStringBuilder.reflectionToString(response);
		
		log.info("[getAllCustomersByPage method is called ]--" + "[input parameter = { pageNo-pageSize}" + pageNo
				+ " , " + pageSize + "]--" + "[output parameter = "+resultForLogging
				+  "]");
		;
		Logging.internalLogDetail();

		return ResponseEntity.ok(response);

	}

	/**
	 * This method sorts alphabetically descending by customer name
	 * 
	 * @return a list sorted by customer name, message, boolean success status,
	 *         HttpStatus code.
	 */
	@GetMapping("/getAllSortedByCompanyName")

	public ResponseEntity<?> getAllSortedByCustomerName() {
		Result response  =this.customerService.getAllSortedByCustomerName();
		String resultForLogging = ToStringBuilder.reflectionToString(response);
		
		log.info("[getAllSortedByCustomerName() method is called ]--" + "[input parameter = no arg]--"
				+ "[output parameter = "+resultForLogging+
				"]");
		Logging.internalLogDetail();

		return ResponseEntity.ok(response);
	}

	/**
	 * This method provides global validation exception catching.
	 * 
	 * @param exceptions specify any exception to be thrown when validation on an
	 *                   argument annotated with {@code @Valid} fails.
	 * @return validation errors and message.
	 */

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {

			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "validation errors");

		log.debug("[handleValidationException method is called ]--" + "[input parameter = { exceptions}" + exceptions
				+ "]--" + "[output parameter = " + ToStringBuilder.reflectionToString(errors) + "]");
		;
		Logging.internalLogDetail();
		return errors;

	}

}
