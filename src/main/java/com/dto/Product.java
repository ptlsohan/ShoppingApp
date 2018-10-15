package com.dto;

public class Product {
	
	private int id;
	private String name;
	private double price;
	private String image;
	private int quantity;
	private String category;
	
	
	
	
	public Product() {
	
	}


	public Product(String name, double price, String image, int quantity, String category) {
		super();
		this.name = name;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.category = category;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}




	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public String getCategory() {
		return category;
	}




	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
