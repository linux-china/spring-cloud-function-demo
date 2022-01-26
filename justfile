#!/usr/bin/env just --justfile

# rsocket test
rsocket-test:
   rsc ws://localhost:8080/rsocket --request --route greeter -d Foo --debug

# grpc test
grpc-test:
   grpcurl -plaintext -d '{"payload": "aGVsbG8=", "headers": {"spring.cloud.function.definition":"greeter"}}' localhost:6048 org.springframework.cloud.function.grpc.MessagingService/requestReply

# grpc server reflection to list services
grpc-server-reflection-services:
   grpcurl -plaintext -d '{"list_services": ""}' localhost:6048 grpc.reflection.v1alpha.ServerReflection/ServerReflectionInfo

# list grpc services
grpc-services:
   grpcurl -plaintext localhost:6048 list