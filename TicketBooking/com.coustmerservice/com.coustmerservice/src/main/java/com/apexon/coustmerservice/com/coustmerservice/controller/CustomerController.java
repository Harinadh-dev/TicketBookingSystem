package com.apexon.coustmerservice.com.coustmerservice.controller;

import com.apexon.coustmerservice.com.coustmerservice.entity.Customer;
import com.apexon.coustmerservice.com.coustmerservice.enums.CustomerStatus;
import com.apexon.coustmerservice.com.coustmerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        if (customer.getEmail() == null) {
            return ResponseEntity.badRequest().body(null);  // Handle email null error
        }
        Customer saved=service.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(service.getAllCustomers());
    }
    @DeleteMapping("/customerId/{uuid}")
    public ResponseEntity<String> softDeleteCustomer(@PathVariable UUID uuid) {
        service.softDeleteCustomer(uuid);
        return ResponseEntity.ok("Customer marked as INACTIVE successfully.");
    }
}
