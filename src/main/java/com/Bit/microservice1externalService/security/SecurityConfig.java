/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.security;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * This class is the security configuration class. Extended with web security
 * configurer adapter to customize our security configuration.
 * 
 * @author Cem Kok
 * @Date 11 Tem 2022
 * @Time 15:31:40
 * @see This class was created to prevent anonymous access to endpoints. Spring
 *      Security provides this with Authentication Manager.Authentication
 *      Manager checks whether there is a basic authentication header by default
 *      in incoming http requests. Spring Security provides default
 *      configurations and these configurations can be extended with the
 *      WebSecurityConfigurerAdapter class. Also, WebSecurityConfigurerAdapter
 *      provides us with different authorizations for different roles.
 * 
 * 
 *      <table border="1">
 *      <body>
 *      <tr>
 *      <td><strong>Annotations </strong></td>
 *      <td></td>
 *      </tr>
 * 
 *      <tr>
 *      <td>@EnableWebSecurity</td>
 *      <td>* Add this annotation to an {@code @Configuration} class to have the
 *      Spring Security configuration defined in any
 *      {@link WebSecurityConfigurer} or more likely by extending the
 *      {@link WebSecurityConfigurerAdapter} base class and overriding
 *      individual methods:
 *
 *      <pre class="code">
 *      &#064;Configuration &#064;EnableWebSecurity public class
 *      MyWebSecurityConfiguration extends WebSecurityConfigurerAdapter {
 *
 *      &#064;Override public void configure(WebSecurity web) throws Exception {
 *      web.ignoring() // Spring Security should completely ignore URLs starting
 *      with /resources/ .antMatchers(&quot;/resources/**&quot;); }
 *
 *      &#064;Override protected void configure(HttpSecurity http) throws
 *      Exception {
 *      http.authorizeRequests().antMatchers(&quot;/public/**&quot;).permitAll().anyRequest()
 *      .hasRole(&quot;USER&quot;).and() // Possibly more configuration ...
 *      .formLogin() // enable form based log in // set permitAll for all URLs
 *      associated with Form Login .permitAll(); }
 *
 *      &#064;Override protected void configure(AuthenticationManagerBuilder
 *      auth) throws Exception { auth // enable in memory based authentication
 *      with a user named &quot;user&quot; and &quot;admin&quot;
 *      .inMemoryAuthentication().withUser(&quot;user&quot;).password(&quot;password&quot;).roles(&quot;USER&quot;)
 *      .and().withUser(&quot;admin&quot;).password(&quot;password&quot;).roles(&quot;USER&quot;,
 *      &quot;ADMIN&quot;); }</td>
 *      </tr>
 * 
 *      <td>@Value</td>
 *      <td>Annotation used at the field or method/constructor parameter level
 *      that indicates a default value expression for the annotated element.
 *
 *      <p>
 *      Typically used for expression-driven or property-driven dependency
 *      injection. Also supported for dynamic resolution of handler method
 *      arguments &mdash; for example, in Spring MVC.
 *
 *      <p>
 *      A common use case is to inject values using
 *      <code>#{systemProperties.myProp}</code> style SpEL (Spring Expression
 *      Language) expressions. Alternatively, values may be injected using
 *      <code>${my.app.myProp}</code> style property placeholders.
 *
 *      <p>
 *      Note that actual processing of the {@code @Value} annotation is
 *      performed by a
 *      {@link org.springframework.beans.factory.config.BeanPostProcessor
 *      BeanPostProcessor} which in turn means that you <em>cannot</em> use
 *      {@code @Value} within
 *      {@link org.springframework.beans.factory.config.BeanPostProcessor
 *      BeanPostProcessor} or
 *      {@link org.springframework.beans.factory.config.BeanFactoryPostProcessor
 *      BeanFactoryPostProcessor} types. Please consult the javadoc for the
 *      {@link AutowiredAnnotationBeanPostProcessor} class (which, by default,
 *      checks for the presence of this annotation).</td>
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
 *      </body>
 *      </table>
 *      <br>
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * The values of the following fields are drawn from the application.properties
	 * file with the @Value annotation.
	 */
	@Value("${service.security.secure-key-username}")
	private String SECURE_KEY_USERNAME;

	@Value("${service.security.secure-key-password}")
	private String SECURE_KEY_PASSWORD;

	/**
	 * This configuration method takes a parameter of type
	 * AuthenticationManagerBuilder and assigns the role according to the default
	 * authentication.It also hashes the password with the BCrypt algorithm using
	 * passwordEncode
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder encoder = new BCryptPasswordEncoder();

		auth.inMemoryAuthentication().passwordEncoder(encoder).withUser(SECURE_KEY_USERNAME)
				.password(encoder.encode(SECURE_KEY_PASSWORD)).roles("USER");
	}

	/**
	 * This method configures the authorization, we can restrict different paths for
	 * different roles. 
	 * Authentication will not be done with session.
	 * That's why csrf is disabled to prevent attacks with session value.
	 * 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		super.configure(http);
		http.csrf().disable();
	}

}
