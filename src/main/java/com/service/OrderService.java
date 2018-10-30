package com.service;

import java.util.List;

import com.dto.Order;
import com.exception.DBException;

public interface OrderService {
	Order getOrder();
	List<Order> getProductByUserId(int id);
	int updateOrder(Order o) throws DBException;
	int deleteOrder(int id) throws DBException;
	int addOrder(Order o) throws DBException;
}
