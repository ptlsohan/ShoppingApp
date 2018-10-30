package com.dto;

import java.sql.Date;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
	private String cardNum;
	//@Pattern(regexp="^([12]\\d)?(\\d\\d)[\\.\\/\\-](0?[1-9]|1[012])[\\.\\/\\-](0?[1-9]|[12]\\d|3[01])$",message="Invalid date format")
	@DateTimeFormat(iso=ISO.DATE)
	private Date expDate;
//	private Address billAddr;
	
	
}
