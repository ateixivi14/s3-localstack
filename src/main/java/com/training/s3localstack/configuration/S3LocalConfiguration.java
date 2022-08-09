package com.training.s3localstack.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3LocalConfiguration {
    
    @Bean
    public AmazonS3 amazonS3(@Value("${cloud.aws.endpoint.url}") final String url,
                             @Value("${cloud.aws.region.static}") final String region) {
        return AmazonS3ClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(url, region))
                .withCredentials(getCredentialsProvider())
                .build();
    }

    private AWSStaticCredentialsProvider getCredentialsProvider() {
        return new AWSStaticCredentialsProvider(
                new AWSCredentials() {
                    @Override
                    public String getAWSAccessKeyId() {
                        return "test";
                    }

                    @Override
                    public String getAWSSecretKey() {
                        return "test";
                    }
                });
    }

}
