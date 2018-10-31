package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dto.Order;
import com.dto.Product;
import com.exception.DBException;
import com.repository.OrderRepository;
import com.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired OrderRepository orep;
	@Autowired ProductRepository ps;
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
	@Transactional
	public int addOrder(Order o) throws DBException {
		for(Map.Entry<Product, Integer> entry: o.getProductList().entrySet()) {
			
			Product product=ps.getProductById(entry.getKey().getId());
			if(product.getQuantity()-entry.getValue()<0) {
				throw new DBException("Product not available"+entry.getKey().getName());
			}
			product.setQuantity(product.getQuantity()-entry.getValue());
			ps.updateProduct(product);
		}
		return orep.addOrder(o);
	}

}
