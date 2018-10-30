package com.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

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
@ToString(exclude= {"userProfile","orders","cart"})
@EqualsAndHashCode
@Entity
@ConfirmPassword
public class User {
	
	@Id
	@GeneratedValue
	private int userId;
	
	@Column(unique = true)
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToOne(mappedBy="user")
	private UserProfile userProfile;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Cart cart;
	
	@OneToMany
	private List<Order> orders=new ArrayList<>();
	
	
	
}
