/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.entities.dtos;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is a response DTO.
 * 
 * @author Cem Kok
 * @Date 15 Tem 2022
 * @Time 17:42:31
 * @see 
 * <Strong>When to Use It </Strong>
 *      <p>
 *      DTOs come in handy in systems with remote calls, as they help to reduce
 *      the number of them.
 * 
 *      DTOs also help when the domain model is composed of many different
 *      objects and the presentation model needs all their data at once, or they
 *      can even reduce roundtrip between client and server.
 * 
 *      With DTOs, we can build different views from our domain models, allowing
 *      us to create other representations of the same domain but optimizing
 *      them to the clients' needs without affecting our domain design. Such
 *      flexibility is a powerful tool to solve complex problems.
 * 
 *      </p>
 *      <table border="1">
 *      <body>
 *      <tr>
 *      <td><strong>Annotations </strong></td>
 *      <td></td>
 * 
 * 
 *      </tr>
 *      <tr>
 *      <td>@Data</td>
 *      <td>Generates getters for all fields, a useful toString method, and
 *      hashCode and equals implementations that check all non-transient fields.
 *      Will also generate setters for all non-final fields, as well as a
 *      constructor.
 *      <p>
 *      Equivalent to
 *      {@code @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode}.
 *      <p>
 *      Complete documentation is found at
 *      <a href="https://projectlombok.org/features/Data">the project lombok
 *      features page for &#64;Data</a>.</td>
 *      </tr>
 *      <tr>
 *      <td>@Entity</td>
 *      <td>Specifies that the class is an entity. This annotation is applied to
 *      the entity class. <a>@since 1.0</a>
 *      <p>
 *      Complete documentation is found at
 *      <a href="https://www.baeldung.com/jpa-entities">the project jpa-entities
 *      features page for &#64;Entity</a>.</td>
 *      <tr>
 *      <td>@Table</td>
 *      <td>Specifies the primary table for the annotated entity. Additional
 *      tables may be specified using {@link SecondaryTable} or
 *      {@link SecondaryTables} annotation.
 *      <p>
 *      If no <code>Table</code> annotation is specified for an entity class,
 *      the default values apply. Complete documentation is found at
 *      <a href="https://www.baeldung.com/jpa-entities">the project jpa-entities
 *      features page for &#64;Table</a>.</td>
 * 
 *      </tr>
 *      <tr>
 *      <td>@Column</td>
 *      <td>* Specifies the mapped column for a persistent property or field. If
 *      no <code>Column</code> annotation is specified, the default values
 *      apply. Complete documentation is found at
 *      <a href="https://www.baeldung.com/jpa-entities">the project jpa-entities
 *      features page for &#64;Column</a>.</td>
 * 
 *      </tr>
 *      <tr>
 *      <td>@Id</td>
 *      <td>Specifies the primary table for the annotated entity. Additional
 *      tables may be specified using {@link SecondaryTable} or
 *      {@link SecondaryTables} annotation.
 *      <p>
 *      If no <code>Table</code> annotation is specified for an entity class,
 *      the default values apply. Complete documentation is found at
 *      <a href="https://www.baeldung.com/jpa-entities">the project jpa-entities
 *      features page for &#64;Id</a>.</td>
 * 
 *      </tr>
 *      <tr>
 *      <td>@GeneratedValue</td>
 *      <td>Provides for the specification of generation strategies for the
 *      values of primary keys. The <code>GeneratedValue</code> annotation may
 *      be applied to a primary key property or field of an entity or mapped
 *      superclass in conjunction with the {@link Id} annotation. The use of the
 *      <code>GeneratedValue</code> annotation is only required to be supported
 *      for simple primary keys. Use of the <code>GeneratedValue</code>
 *      annotation is not supported for derived primary keys. Complete
 *      documentation is found at
 *      <a href="https://www.baeldung.com/jpa-entities">the project jpa-entities
 *      features page for &#64;GeneratedValue</a>.</td>
 *        </tr>
 *      <tr>
 *      <td>@Data</td>
 *      <td>Generates getters for all fields, a useful toString method, and
 *      hashCode and equals implementations that check all non-transient fields.
 *      Will also generate setters for all non-final fields, as well as a
 *      constructor.
 *      <p>
 *      Equivalent to
 *      {@code @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode}.
 *      <p>
 *      Complete documentation is found at
 *      <a href="https://projectlombok.org/features/Data">the project lombok
 *      features page for &#64;Data</a>.</td>
 *      </tr>
 *      <tr>
 *      <td>@AllArgsConstructor</td>
 *      <td>* Generates an all-args constructor. An all-args constructor
 *      requires one argument for every field in the class.
 *      <p>
 *      Complete documentation is found at
 *      <a href="https://projectlombok.org/features/Constructor">the project
 *      lombok features page for &#64;Constructor</a>.
 *      <p>
 *      Even though it is not listed, this annotation also has the
 *      {@code onConstructor} parameter. See the full documentation for more
 *      details.</td>
 *      </tr>
 *      <tr>
 *      <td>@NoArgsConstructor</td>
 *      <td>Generates a no-args constructor. Will generate an error message if
 *      such a constructor cannot be written due to the existence of final
 *      fields.
 *      <p>
 *      Complete documentation is found at
 *      <a href="https://projectlombok.org/features/Constructor">the project
 *      lombok features page for &#64;Constructor</a>.
 *      <p>
 *      Even though it is not listed, this annotation also has the
 *      {@code onConstructor} parameter. See the full documentation for more
 *      details.
 *      <p>
 *      NB: Fields with constraints such as {@code @NonNull} will <em>NOT</em>
 *      be checked in a {@code @NoArgsConstructor} constructor, of course!</td>
 *      </tr>
 *      </body>
 *      </table>
 *      <br>
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerListDto {

	private Long id;
	private String customerName;
	private String companyName;
}
