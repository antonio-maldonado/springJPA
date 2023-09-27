package org.generation.app.service;

import java.util.List;

import org.generation.app.entity.Customer;


public interface CustomerService {
	Customer createCustomer(Customer customer);
	
	Customer getCustomerById(Long id);
	
	List<Customer> getAllCustomers();
	
	Customer updateCustomer(Customer customer, Long id);
	
	void deleteCustomer(Long id);
}
