package com.dto;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
@ToString(exclude="profile")
@EqualsAndHashCode
@Entity
public class Address {
	
	@GeneratedValue
	@Id
	private Integer addressId;
	
	@NotBlank
	private String street;
	
	private String apt;
	@NotBlank
	private String city;
	@NotBlank
	private String state;
	@NotBlank
	private String zip;
	@NotBlank
	private String country;
	private String phone;
	
	@ManyToMany(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	private List<UserProfile> profile = new ArrayList<>();
	
	
	
	public List<UserProfile> getProfile() {
		return profile;
	}
	public void setProfile(UserProfile profile) {
		this.profile.add(profile);
	}
	
	
	
}
