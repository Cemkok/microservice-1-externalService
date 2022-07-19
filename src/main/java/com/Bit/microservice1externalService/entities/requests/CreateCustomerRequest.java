/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.entities.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is a request DTO.
 * 
 * @author Cem Kok
 * @Date 15 Tem 2022
 * @Time 17:43:00
 * @see
 * 	<Strong>When to Use It </Strong>
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
 * 
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
 *      <tr>
 *      <td>@NotEmpty</td>
 *      <td>The annotated element must not be {@code null} nor empty.</td>
 *      </tr>
 * 
 *      <td>@Size</td>
 *      <td>The annotated element size must be between the specified boundaries
 *      (included).</td>
 *      </tr>
 *      </body>
 *      </table>
 *      <br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

	@NotEmpty
	@Size(min = 0, max = 50)
	private String customerName;

	@NotEmpty
	@Size(min = 0, max = 50)
	private String companyName;

}
