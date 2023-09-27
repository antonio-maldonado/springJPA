package org.generation.app.implementation;

import java.util.List;

import org.generation.app.entity.Customer;
import org.generation.app.repository.CustomerRepository;
import org.generation.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer createCustomer(Customer customer) {
		return saveOrder(customer);
	}
	
	public Customer saveOrder(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id).orElseThrow( ()-> new IllegalStateException("Order does not exist with id "+ id) );
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = (List<Customer>) customerRepository.findAll();
		return customers;
	}

	@Override
	public Customer updateCustomer(Customer customer, Long id) {
		customer.setId(null);
		Customer existingCustomer = customerRepository.save(customer);
		existingCustomer.setFirstName( customer.getFirstName() );
		existingCustomer.setLastName( customer.getLastName() );		
		return existingCustomer;
	}

	@Override
	public void deleteCustomer(Long id) {
		customerRepository.delete( customerRepository.findById(id)
				.orElseThrow(()-> new IllegalStateException("User Does not Exist") ));
		
	}

}
