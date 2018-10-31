package com.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

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
public class UserProfile {
	@GeneratedValue
	@Id
	private int profileId;
	
	@Length(min=2)
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@Min(value = 18,message="User must be above 18")
	@Max(value=100)
	private int age;
	
	private Gender gender;
	@ManyToMany(mappedBy="profile",fetch=FetchType.EAGER)
	private List<Address> address=new ArrayList<>();
	
	@OneToOne
	private User user;
	
	
	
	
	
	
	
	
}
