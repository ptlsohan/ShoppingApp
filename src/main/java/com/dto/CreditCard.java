package com.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
public class CreditCard {

	@GeneratedValue
	@Id
	private int id;
	
	@OneToOne
	private Order order;
	
	@NotBlank
	private String fullName;
	@NotBlank
	@Size(min=15,max=15)
	private String cardNum;
	

	@DateTimeFormat(iso=ISO.DATE)
	private Date expDate;

	
	
}
