package org.mvnsearch.cloud.function.demo.functions;

import org.junit.jupiter.api.Test;
import org.mvnsearch.cloud.function.demo.SpringBootBaseTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * Account Reactive Repo test
 *
 * @author linux_china
 */
public class AccountReactiveRepoTest extends SpringBootBaseTestCase {

    @Autowired
    private AccountReactiveRepo accountRepo;

    @Test
    public void testFindById() {
        Mono<Account> account = accountRepo.findById(1);
        StepVerifier.create(account).expectNextCount(1).verifyComplete();
    }

    @Test
    public void testFindByNick() {
        Mono<Account> account = accountRepo.findByNick("linux_china");
        StepVerifier.create(account).expectNextCount(1).verifyComplete();
    }


    @Test
    public void testAuth() {
        Mono<Account> account = accountRepo.auth("linux_china", "123456");
        StepVerifier.create(account).expectNextCount(1).verifyComplete();
    }
}
