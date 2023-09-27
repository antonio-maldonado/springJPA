package org.generation.app.repository;


import org.generation.app.entity.Customer;
import org.generation.app.entity.OrderProduct;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderProduct, Long> {


  //Optional<Customer> findById(long id);
  Customer findById(long id);
  
}