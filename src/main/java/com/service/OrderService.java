package com.service;

import java.util.List;

import com.dto.Order;

public interface OrderService {
	Order getOrder();
	List<String> getProductByUsername(String uname);
	int updateOrder(int id);
	int deleteOrder(int id);
	int addOrder(Order o);
}
