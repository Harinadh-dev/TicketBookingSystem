package com.apexon.coustmerservice.com.coustmerservice.dao;

import com.apexon.coustmerservice.com.coustmerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
