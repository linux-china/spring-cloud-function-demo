package org.mvnsearch.cloud.function.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;


@FunctionalSpringBootTest
public class FunctionalTests {
    @Autowired
    private FunctionCatalog catalog;

    @Test
    void testFunctionCatalog() {
        final Object greeter = catalog.lookup("greeter");
        System.out.println(greeter.getClass());
    }
}
