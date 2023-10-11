package com.orderManagementSystem.com.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCustomerRequestDto {
    private final String registrationCode;
    private final String fullName;
    private final String email;
    private final String telephone;
}
