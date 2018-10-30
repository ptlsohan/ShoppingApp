package com.repository;

import java.util.List;

import com.dto.Order;
import com.exception.DBException;


public interface OrderRepository {
	Order getOrder();
	List<Order> getOrderByUserId(int id);
	int updateOrder(Order o) throws DBException;
	int deleteOrder(int id) throws DBException;
	int addOrder(Order o) throws DBException;
}
