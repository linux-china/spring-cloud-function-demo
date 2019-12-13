package org.mvnsearch.cloud.function.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.catalog.BeanFactoryAwareFunctionRegistry;

/**
 * function signature test
 *
 * @author linux_china
 */
public class FunctionSignatureTest extends SpringBootBaseTestCase {
    @Autowired
    @Qualifier("greeter")
    private Object greeter;

    @Autowired
    @Qualifier("accountFindByNick")
    private Object accountFindByNick;

    @Autowired
    private FunctionCatalog catalog;

    @Test
    public void testSignature() {
        Class<?> clazz = greeter.getClass();
        System.out.println(clazz);
        BeanFactoryAwareFunctionRegistry.FunctionInvocationWrapper function1 = catalog.lookup("greeter");
        System.out.println(function1.apply("Jackie"));
    }

    @Test
    public void testAccountFindByNick() {
        Class<?> clazz = accountFindByNick.getClass();
        System.out.println(clazz);
        BeanFactoryAwareFunctionRegistry.FunctionInvocationWrapper function1 = catalog.lookup("accountFindByNick");
        System.out.println(function1.apply("linux_china"));
    }
}
