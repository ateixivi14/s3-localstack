# Getting Started

### Commands
This project is a sample of  how to interact with the Amazon S3 (Simple Storage Service) storage system programmatically from Java.

S3 has a very simple structure; each bucket can store any number of objects, which can be accessed using either a SOAP interface or a REST-style API.

```aws --endpoint-url=http://localhost:4566 s3 ls bucket-test```

```aws s3api --endpoint-url=http://localhost:4566 list-buckets```

```aws s3api --endpoint-url=http://localhost:4566 create-bucket --bucket bucket-test --region eu-west-1  --create-bucket-configuration LocationConstraint=eu-west-1```

