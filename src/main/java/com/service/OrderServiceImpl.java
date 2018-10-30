package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Order;
import com.exception.DBException;
import com.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired OrderRepository orep;
	@Override
	public Order getOrder() {
		// TODO Auto-generated method stub
		return orep.getOrder();
	}

	@Override
	public List<Order> getProductByUserId(int id) {
		// TODO Auto-generated method stub
		return orep.getOrderByUserId(id);
	}

	@Override
	public int updateOrder(Order o) throws DBException {
		// TODO Auto-generated method stub
		return orep.updateOrder(o);
	}

	@Override
	public int deleteOrder(int id) throws DBException {
		// TODO Auto-generated method stub
		return orep.deleteOrder(id);
	}

	@Override
	public int addOrder(Order o) throws DBException {
		// TODO Auto-generated method stub
		return orep.addOrder(o);
	}

}
