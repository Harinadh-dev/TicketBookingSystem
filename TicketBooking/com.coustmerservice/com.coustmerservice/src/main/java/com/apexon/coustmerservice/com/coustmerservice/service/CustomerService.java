package com.apexon.coustmerservice.com.coustmerservice.service;

import com.apexon.coustmerservice.com.coustmerservice.dao.CustomerRepository;
import com.apexon.coustmerservice.com.coustmerservice.entity.Customer;
import com.apexon.coustmerservice.com.coustmerservice.enums.CustomerStatus;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomer(){
        return  customerRepository.findAll();
    }
    public Optional<Customer> getCustomerById(UUID customerId) {
        return customerRepository.findById(customerId);
    }
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    public void softDeleteCustomer(UUID customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        customer.setStatus(CustomerStatus.INACTIVE);
        customer.setUpdatedAt(LocalDateTime.now());
        customerRepository.save(customer);
    }
}
