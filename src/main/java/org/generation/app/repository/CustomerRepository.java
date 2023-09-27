package org.generation.app.repository;


import java.util.List;
//import java.util.Optional;

import org.generation.app.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findByLastName(String lastName);

  //Optional<Customer> findById(long id);
  Customer findById(long id);
  
}