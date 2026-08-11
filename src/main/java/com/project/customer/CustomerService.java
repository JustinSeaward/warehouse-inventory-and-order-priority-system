package com.project.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return  customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if( existingCustomer.isPresent()){
            return existingCustomer.get();
        }
        return null;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);

        if(existingCustomer.isPresent()){
            Customer newCustomer = existingCustomer.get();
            newCustomer.setName(customer.getName());
            newCustomer.setEmail(customer.getEmail());
            return customerRepository.save(newCustomer);
        } else {
            return null;
        }
    }

    public void deleteCustomerById(Long id) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if(existingCustomer.isPresent()){
            customerRepository.deleteById(id);
        }
    }
}
