package com.dto;

import java.util.Map;

public class Cart {
	private int cartId;
	private int userId;
	private Map<Product,Integer> cartList;
	public Cart() {
		super();
	}
	public Cart(int cartId, int userId, Map<Product, Integer> cartList) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.cartList = cartList;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Map<Product, Integer> getCartList() {
		return cartList;
	}
	public void setCartList(Map<Product, Integer> cartList) {
		this.cartList = cartList;
	}
	
	
	
}
