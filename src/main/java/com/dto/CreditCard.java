package com.dto;

import java.sql.Date;

public class CreditCard {

	private int id;
	private int userId;
	
	private String fullName;
	private Integer cardNum;
	private Date expDate;
	private Address billAddr;
	public CreditCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreditCard(int userId, String fullName, Integer cardNum, Date expDate,  Address billAddr) {
		super();
		this.userId = userId;
		this.billAddr = billAddr;
		this.fullName = fullName;
		this.cardNum = cardNum;
		this.expDate = expDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Integer getCardNum() {
		return cardNum;
	}
	public void setCardNum(Integer cardNum) {
		this.cardNum = cardNum;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public Address getBillAddr() {
		return billAddr;
	}
	public void setBillAddr(Address billAddr) {
		this.billAddr = billAddr;
	}
	
	
	
	
	
}
