package com.training.s3localstack.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    
    private String name;
    private String surname;
    private String email;
    private String phone;
    private long customerId;
    
}
