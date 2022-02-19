package org.mvnsearch.cloud.function.demo.functions;

import org.mvnsearch.cloud.function.demo.domain.Account;
import org.mvnsearch.cloud.function.demo.domain.AccountReactiveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.function.Function;


/**
 * Account findByNick Function
 *
 * @author linux_china
 */
@Controller
@Qualifier("accountFindByNick")
public class AccountFindByNick implements Function<String, Mono<Account>> {
    @Autowired
    private AccountReactiveRepo accountRepo;

    @Override
    @MessageMapping("accountFindByNick")
    public Mono<Account> apply(String nick) {
        return accountRepo.findByNick(nick);
    }
}
