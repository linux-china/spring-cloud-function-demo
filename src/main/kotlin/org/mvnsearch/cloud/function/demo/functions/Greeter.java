package org.mvnsearch.cloud.function.demo.functions;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.mvnsearch.cloud.function.demo.functions.Greeter.NAME;

/**
 * Greeter function
 *
 * @author linux_china
 */
@Controller
@Qualifier(NAME)
public class Greeter implements Function<String, Mono<String>> {
    public final static String NAME = "greeter";

    @Override
    @MessageMapping(NAME)
    public Mono<String> apply(String s) {
        return Mono.just("Hello " + s);
    }
}
