package org.mvnsearch.cloud.function.demo.functions;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import java.util.function.Function;

/**
 * Greeter function
 *
 * @author linux_china
 */
@Controller
public class Greeter implements Function<String, String> {

    @Override
    @MessageMapping("greeter")
    public String apply(String name) {
        return "Hello " + name;
    }
}
