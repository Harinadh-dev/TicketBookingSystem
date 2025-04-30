package com.apexon.coustmerservice.com.coustmerservice.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CustomerDTO {
    private UUID customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private Integer age;
    private String gender;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
