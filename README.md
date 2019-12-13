Spring Cloud Function with RSocket
==================================

Expose cloud function with REST API & RSocket with R2DBC as backend.

# Function signatures

* RPC: Function<String, Mono<String>>
* request/stream: Function<String, Flux<String>>
* fire_and_forget/metadataPush: Function<String, Void>
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
* Spring Data R2DBC: https://spring.io/projects/spring-data-r2dbc
