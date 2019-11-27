Spring Cloud Function with RSocket
==================================

Expose cloud function with REST API & RSocket

# Function signatures

* RPC: Function<String, Mono<String>>
* request/stream: Function<String, Flux<String>>
* fire_and_forget/metadataPush: Function<String, Void>
* channel: Function<Flux<String>>, Flux<String>

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
* Spring Cloud Function Docs: https://cloud.spring.io/spring-cloud-static/spring-cloud-function/3.0.0.RELEASE/reference/html/index.html
