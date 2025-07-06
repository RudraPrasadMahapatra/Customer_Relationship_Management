package com.customer.relation.demo.service;


import com.customer.relation.demo.model.Customer;
import com.customer.relation.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImplementation implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getCustomerByStatus(String status) {
        return customerRepository.findByStatus(status);
    }

    @Override
    public Customer update(Integer id, Customer update) {
        return customerRepository.findById(id).map(customer -> {
            customer.setName(update.getName());
            customer.setId(update.getId());
            customer.setEmail(update.getEmail());
            customer.setPhone(update.getPhone());
            customer.setStatus(update.getStatus());
           return customerRepository.save(customer);
        }).orElseThrow(()-> new RuntimeException("Customer not found with the id"+id));
    }

    @Override
    public void deleteById(Integer id) {
     customerRepository.deleteById(id);
    }
}
