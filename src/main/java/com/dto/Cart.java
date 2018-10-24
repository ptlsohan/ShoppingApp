package com.dto;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToOne;

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
public class Cart {
	@GeneratedValue
	@Id
	private int cartId;
	private int userId;
	
	@CollectionTable(name="cartItems",
			joinColumns=@JoinColumn(name="cartId"))
	//@MapKeyJoinColumn(name="productId")
	//@Column(name="quantity", columnDefinition="NUMBER")
	@ElementCollection(fetch=FetchType.EAGER)
	private Map<Product,Integer> cartList=new LinkedHashMap<>();
	@OneToOne(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	private User user;
	
	
	
	
}
