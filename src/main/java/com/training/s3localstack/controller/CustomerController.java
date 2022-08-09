package com.training.s3localstack.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.training.s3localstack.domain.CustomerDto;
import com.training.s3localstack.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    
    private final CustomerService customerService;
    
    @PostMapping
    public void registerCustomer(@RequestBody CustomerDto customerDto) throws JsonProcessingException {
        customerService.registerCustomer(customerDto);
    }
    
}
