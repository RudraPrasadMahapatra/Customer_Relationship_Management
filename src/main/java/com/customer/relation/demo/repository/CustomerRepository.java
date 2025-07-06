package com.customer.relation.demo.repository;

import com.customer.relation.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
  List<Customer> findByStatus(String status);
}
