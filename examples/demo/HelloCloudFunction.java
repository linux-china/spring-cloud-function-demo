///usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 17
//DEPS org.springframework.boot:spring-boot-dependencies:2.6.3@pom
//DEPS org.springframework.boot:spring-boot-starter-rsocket
//DEPS org.springframework.cloud:spring-cloud-starter-function-webflux:3.2.2
//DEPS org.springframework.cloud:spring-cloud-function-grpc:3.2.2
//DEPS org.mvnsearch:jbang-spring-native:2.6.3-1
//JAVA_OPTIONS -Dspring.rsocket.server.transport=websocket -Dspring.rsocket.server.mapping-path=/rsocket

package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@SpringBootApplication
public class HelloCloudFunction {

    public static void main(String... args) {
        SpringApplication.run(HelloCloudFunction.class, args);
    }


    @Controller("greeter")
    public static class Greeter implements Function<String, Mono<String>> {

        @Override
        @MessageMapping("greeter")
        public Mono<String> apply(String name) {
            return Mono.just("Hello " + name);
        }
    }
}