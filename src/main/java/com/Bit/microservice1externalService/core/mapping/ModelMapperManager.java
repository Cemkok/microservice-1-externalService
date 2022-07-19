/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.core.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * This class is an adapter class for modelMapper implementation.
 * 
 * @author Cem Kok
 * @Date 15 Tem 2022
 * @Time 17:22:00
 * @see
 *      <table border="1">
 *      <body>
 *      <tr>
 *      
 *      <td><strong>ModelMapper</strong></td>
 *      <td>Performs object mapping, maintains {@link Configuration} and stores
 *      {@link TypeMap TypeMaps}.
 * 
 *      <p>
 *      <ul>
 *      <li>To perform object mapping use {@link #map(Object, Class) map}.</li>
 *      <li>To configure the mapping of one type to another use
 *      {@link #createTypeMap(Class, Class) createTypeMap}.</li>
 *      <li>To add mappings for specific properties use
 *      {@link #addMappings(PropertyMap) addMappings} supplying a
 *      {@link PropertyMap}.</li>
 *      <li>To configure ModelMapper use {@link #getConfiguration}.
 *      <li>To validate mappings use {@link #validate}.
 *      </ul>
 *      <p></td>
 *      </tr>
 *       <tr>
 *     	<td></td>
 *      <td><strong>-- Annotations --</strong></td>
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

@Service

public class ModelMapperManager implements ModelMapperService {

	private ModelMapper modelMapper;

	/**
	 * This method is a constructor method to implement dependency injection to use
	 * an object.
	 * 
	 * @param modelMapper
	 */
	@Autowired
	public ModelMapperManager(ModelMapper modelMapper) {

		this.modelMapper = modelMapper;
	}

	@Override
	public ModelMapper forDto() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);

		return modelMapper;
	}

	@Override
	public ModelMapper forRequest() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);

		return modelMapper;

	}

}
