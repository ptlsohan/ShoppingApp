package com.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Map;

public class Order {

	private int orderId;
	private int userId;
	private int addrId;
	private int cardId;
	private Map<Product, Integer> productList;
	private double totalAmt;
	private Timestamp orderDateTime;

	private Date expDate;
	public Order() {
		super();
	}
	public Order(int userId, int addrId, int cardId,
			Map<Product, Integer> productList, double totalAmt,Timestamp orderDateTime, Date expDate) {
		super();
		
		
		this.userId = userId;
		this.addrId = addrId;
		this.cardId = cardId;
		this.productList = productList;
		this.totalAmt = totalAmt;
		this.orderDateTime = orderDateTime;
		this.expDate = expDate;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAddrId() {
		return addrId;
	}
	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public Map<Product, Integer> getProductList() {
		return productList;
	}
	public void setProductList(Map<Product, Integer> productList) {
		this.productList = productList;
	}
	public double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public Timestamp getOrderDateTime() {
		return orderDateTime;
	}
	public void setOrderDateTime(Timestamp orderDateTime) {
		this.orderDateTime = orderDateTime;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	
	
	
	
	
	
}
