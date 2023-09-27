package org.generation.app.controller;

import java.util.List;

import org.generation.app.entity.OrderProduct;
import org.generation.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "*")
@RestController // @Controller @ResponseBody
@RequestMapping("api/v1/orders") // localhost:8080/api/v1/orders

public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping
	public  ResponseEntity< OrderProduct > createOrder(@RequestBody OrderProduct order) {
		OrderProduct newOrder = orderService.createOrder(order);
		return new ResponseEntity<>(newOrder, HttpStatus.CREATED); // Status 201
	}
	
	@GetMapping("{id}")
	public ResponseEntity< OrderProduct > getOrderById(@PathVariable Long id){
		OrderProduct order = orderService.getOrderById(id);
		return new ResponseEntity<>(order, HttpStatus.OK); // Status 200
	}
	
	@GetMapping
	public ResponseEntity< List<OrderProduct> > getAllOrders(){
		List<OrderProduct> orders = orderService.getAllOrders();
		return new ResponseEntity<>( orders, HttpStatus.OK );
	}
	

	
}
