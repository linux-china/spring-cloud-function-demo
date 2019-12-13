package org.mvnsearch.cloud.function.demo.functions;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Greeter function
 *
 * @author linux_china
 */
@Controller
public class Greeter implements Function<String, Mono<String>> {

    @Override
    @MessageMapping("greeter")
    public Mono<String> apply(String name) {
        return Mono.just("Hello " + name);
    }
}
