Spring Cloud Function with RSocket
==================================

Expose cloud function with REST API & RSocket

# Function signatures

* Function<String, Mono<String>>， Function<Mono<String>, Mono<Void>>
* Supplier<Mono<String>>, Supplier<Flux<String>>

# Demo function

```java
@Qualifier(NAME)
public class Greeter implements Function<String, Mono<String>> {
    public final static String NAME = "greeter";

    @Override
    @MessageMapping(NAME)
    public Mono<String> apply(String s) {
        return Mono.just("Hello " + s);
    }
}
```

# References

* Spring Cloud Function: https://spring.io/projects/spring-cloud-function