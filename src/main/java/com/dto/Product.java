package com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.validator.ConfirmPassword;

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
@Inheritance(strategy=InheritanceType.JOINED)
public class Product {
	
	
	@GeneratedValue
	@Id
	private int id;
	@NotBlank
	private String name;
	@NotBlank
	private String companyName;
	@Pattern(regexp="\\d*\\.?\\d+")
	private double price;
	private String image;
	@Pattern(regexp="\\d+")
	private int quantity;
	@NotBlank
	private String category;
	
	
	
}
