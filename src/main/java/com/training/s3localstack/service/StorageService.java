package com.training.s3localstack.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.training.s3localstack.domain.FileDetails;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageService.class);
    
    @Value("${cloud.aws.s3.bucket-name}")
    private String s3BucketName;

    private final AmazonS3 amazonS3;
    
    public void processAndStoreFile(String rawFile, String key) {
        if (rawFile == null || rawFile.isEmpty())
            throw new RuntimeException("File empty");
        
        FileDetails fileDetails = FileDetails.builder()
                .key(key)
                .file(rawFile)
                .contentType("application/pdf")
                .build();
        storeFile(fileDetails);
    }

    private void storeFile(FileDetails fileDetails) {
        try (InputStream inputStream = new ByteArrayInputStream(Base64.getEncoder().encode(fileDetails.getFile().getBytes()))) {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(fileDetails.getContentType());
            amazonS3.putObject(s3BucketName, fileDetails.getKey(), inputStream, objectMetadata);
        } catch (IOException e) {
            LOGGER.error("Error storing file to " + s3BucketName , e);
        }
    }
    

}
