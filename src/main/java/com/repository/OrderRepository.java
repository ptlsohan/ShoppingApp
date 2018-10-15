package com.repository;

import java.util.List;

import com.dto.Order;


public interface OrderRepository {
	Order getOrder();
	List<String> getProductByUsername(String uname);
	int updateOrder(int id);
	int deleteOrder(int id);
	int addOrder(Order o);
}
