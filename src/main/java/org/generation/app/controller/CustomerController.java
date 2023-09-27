package org.generation.app.controller;

import java.util.List;


import org.generation.app.entity.Customer;

import org.generation.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController // @Controller @ResponseBody
@RequestMapping("api/v1/customers") // localhost:8080/api/vi/customers

public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping // localhost:8080/api/vi/customers
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers = customerService.getAllCustomers();
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
	
	@GetMapping("{id}") // localhost:8080/api/vi/customers/2
	public ResponseEntity<Customer> getCustomerById(@PathVariable long id) {
		Customer customer = customerService.getCustomerById(id);
		return new ResponseEntity<>(customer , HttpStatus.OK);
	}
	
	@PostMapping  // localhost:8080/api/vi/customers
	public ResponseEntity<Customer> setCustomer(@RequestBody Customer customer) {
		Customer newCustomer = customerService.createCustomer(customer);
		return new ResponseEntity<>(newCustomer , HttpStatus.CREATED);
		
	}
	
	@PutMapping("{id}")  // localhost:8080/api/vi/customers/2
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable long id) {
		Customer existingCustomer = customerService.updateCustomer(customer, id);
		return new ResponseEntity<>(existingCustomer,HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}") // localhost:8080/api/vi/customers/2
	public String deleteCustomer(@PathVariable Long id) {
		
		customerService.deleteCustomer(id);
		return "Cliente Eliminado";
		
		/*
		Optional<Customer> optionalCustomer = customerRepository.findById(id); // Objeto de la clase Optional
		
		
		if ( optionalCustomer.isPresent() ) {
		    Customer existingCustomer = optionalCustomer.get();
		    customerRepository.delete(existingCustomer);
		    return "Cliente eliminado";
		}
			
		throw new IllegalStateException("User does not exist");
		*/
	}
	
	
	
	
}
