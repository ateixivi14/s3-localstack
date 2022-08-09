package com.training.s3localstack.service;

import com.training.s3localstack.domain.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class CustomerService {
    
    private final StorageService storageService;
    
    public void registerCustomer(CustomerDto customerDto)  {
        LocalDateTime timestamp = LocalDateTime.now(ZoneOffset.UTC);
            String pdf = "Name " + customerDto.getName();
        String key =   customerDto.getCustomerId() + "_" + timestamp.format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")) + ".pdf";
        storageService.processAndStoreFile(pdf, key);
    }
    
}
