package com.training.s3localstack.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FileDetails {
    private String key;
    private String file;
    private String contentType;

}
