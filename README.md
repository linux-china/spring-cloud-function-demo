Spring Cloud Function with RSocket
==================================

Expose cloud function with REST API & RSocket with R2DBC as backend.

# Function signatures

* RPC: Function<String, Mono<String>>, Function<Mono<User>, Mono<Greeting>>
```

public Function<String, String> uppercase() {
   return value -> value.toUpperCase();
}

public Function<Flux<String>, Flux<String>> reactiveUpperCase() {
	return flux -> flux.map(val -> val.toUpperCase());
}
```
* request/stream: Function<String, Flux<String>>
* fire_and_forget/metadataPush: Function<String, Void>

```
public Consumer<Person> log() {
    return person -> {
        System.out.println("Received: " + person);
    };
}
	
public Function<Flux<?>, Mono<Void>> log() {
	return flux -> flux.map(..).filter(..).then();
}
```

* channel: Function<Flux<String>>, Flux<String>

# Demo function

```java
@Controller
public class Greeter implements Function<String, Mono<String>> {

    @Override
    @MessageMapping("greeter")
    public Mono<String> apply(String name) {
        return Mono.just("Hello " + name);
    }
}
```

# References

* Spring Cloud Function: https://spring.io/projects/spring-cloud-function
* Spring Cloud Function Docs: https://cloud.spring.io/spring-cloud-static/spring-cloud-function/3.0.0.RELEASE/reference/html/index.html
* spring-cloud-function-rsocket: https://github.com/spring-cloud/spring-cloud-function/tree/master/spring-cloud-function-rsocket
* Spring Data R2DBC: https://spring.io/projects/spring-data-r2dbc
* Event-Driven with Spring Cloud Function and Spring Cloud Stream: https://learning.oreilly.com/videos/event-driven-with-spring/10000MNLV2021128/
* spring-cloud-function-grpc: https://github.com/spring-cloud/spring-cloud-function/tree/main/spring-cloud-function-adapters/spring-cloud-function-grpc
* Functions and Spring Cloud Stream Applications for data driven microservices: https://github.com/spring-cloud/stream-applications
