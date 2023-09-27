package org.generation.app.service;

import java.util.List;

import org.generation.app.entity.OrderProduct;

public interface OrderService {

	OrderProduct createOrder(OrderProduct order);
	
	OrderProduct getOrderById(Long id);
	
	List<OrderProduct> getAllOrders();
	
	OrderProduct updateOrder(OrderProduct order, Long id);
	
	void deleteOrder(Long id);
}
