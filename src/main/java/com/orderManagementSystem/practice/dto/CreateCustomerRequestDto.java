package com.orderManagementSystem.practice.dto;

import lombok.Data;

@Data
public class CreateCustomerRequestDto {
    private final String registrationCode;
    private final String fullName;
    private final String email;
    private final String telephone;
}
