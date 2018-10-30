package com.dto;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CacheConcurrencyStrategy;


import javax.persistence.Version;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy=InheritanceType.JOINED)
public class Product {
	
	
	@GeneratedValue
	@Id
	private int id;
	@NotBlank
	private String name;
	@NotBlank
	private String companyName;
	//@Pattern(regexp="\\d*\\.?\\d+")
	private double price;
	private String image;
//	@Pattern(regexp="\\d+")
	private int quantity;
	@NotBlank
	private String category;
	
	@Version
	private int version;
	
	
	
}
