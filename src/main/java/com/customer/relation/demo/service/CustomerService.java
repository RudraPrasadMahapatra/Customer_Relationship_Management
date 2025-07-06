package com.customer.relation.demo.service;

import com.customer.relation.demo.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(Integer id);
    List<Customer> getCustomerByStatus(String status);
    Customer update(Integer id,Customer update);
    void deleteById(Integer id);
}
