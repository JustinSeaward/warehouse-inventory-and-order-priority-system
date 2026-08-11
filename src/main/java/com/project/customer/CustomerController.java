package com.project.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getall")
    public ResponseEntity<Customer> getAllCustomer() {
        List<Customer> customer = customerService.getAllCustomers();
        if (customer.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok((Customer) customer);
    }

    @GetMapping("/findby/id/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id) {
        Customer customerToReturn = customerService.getCustomerById(id);
        if(customerToReturn == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerToReturn);
    }

    @PostMapping("/createnew")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer newCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
    }

    @PutMapping("/update/id/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
        Customer existingCustomer = customerService.getCustomerById(id);
        if(existingCustomer == null){
            return ResponseEntity.notFound().build();
        }
        Customer updatedCustomer = customerService.updateCustomer(id, customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable long id) {
        Customer customerToDelete =  customerService.getCustomerById(id);
        if(customerToDelete == null){
            return ResponseEntity.notFound().build();
        }
        customerService.deleteCustomerById(id);
        return ResponseEntity.noContent().build();
    }
}
