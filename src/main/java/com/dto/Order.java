package com.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
@Table(name="OrderTable")
public class Order {
	
	@GeneratedValue
	@Id
	private int orderId;

	
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	
	@OneToOne(cascade=CascadeType.ALL)
	private CreditCard card;
	
	
	@ElementCollection(fetch=FetchType.EAGER)
	private Map<Product, Integer> productList =new LinkedHashMap<>();;
	private double totalAmt;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	@ManyToOne
	private User user;
	
//	private Timestamp orderDateTime;

//	private Date expDate;
	
	
	
	
	
	
}
