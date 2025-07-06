package com.customer.relation.demo.controller;


import com.customer.relation.demo.service.CustomerService;
import com.customer.relation.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
      return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Integer id){
        return customerService.getCustomerById(id)
                .orElseThrow(()-> new RuntimeException("Customer not found with id"+id));
    }
    @GetMapping("/status/{status}")
    public List<Customer> getCustomersByStatus(@PathVariable String status) {
        return customerService.getCustomerByStatus(status);
    }

    // Update customer
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        return customerService.update(id, customer);
    }

    // Delete customer
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        customerService.deleteById(id);
        return "Customer deleted with ID: " + id;
    }

}
