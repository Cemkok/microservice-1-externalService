/**
 * Spring Boot version 2.4.5
 * Build Automation Tool is Maven.
 * Java version 1.8
 */
package com.Bit.microservice1externalService.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



/**
 * @author Cem Kok
 * @Date   10 Tem 2022
 * @Time   17:23:14
 */
@Data
@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	@Column(name = "customer_name", length = 100, nullable = false)
	private String customerName;

	@Column(name = "company_name", nullable = false, length = 100)
	private String companyName;

	@Column(name = "create_time", nullable = false)
	private LocalDateTime createTime;

}
