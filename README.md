# Getting Started

### Commands


```aws --endpoint-url=http://localhost:4566 s3 ls bucket-test```

```aws s3api --endpoint-url=http://localhost:4566 list-buckets```

```aws s3api --endpoint-url=http://localhost:4566 create-bucket --bucket bucket-test --region eu-west-1  --create-bucket-configuration LocationConstraint=eu-west-1```

