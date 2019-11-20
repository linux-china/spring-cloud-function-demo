package org.mvnsearch.cloud.function.demo;

import io.rsocket.metadata.WellKnownMimeType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;
import org.springframework.http.codec.cbor.Jackson2CborEncoder;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.util.MimeType;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * RSocket Client test
 *
 * @author linux_china
 */
public class RSocketClientTest {
    private static RSocketRequester requester;

    @BeforeAll
    public static void setUp() {
        RSocketStrategies rSocketStrategies = RSocketStrategies.builder()
                .encoder(new Jackson2CborEncoder(), new Jackson2JsonEncoder())
                .decoder(new Jackson2CborDecoder(), new Jackson2JsonDecoder())
                .build();
        requester = RSocketRequester.builder()
                .dataMimeType(MediaType.APPLICATION_CBOR)
                .metadataMimeType(MimeType.valueOf(WellKnownMimeType.MESSAGE_RSOCKET_COMPOSITE_METADATA.getString()))
                .rsocketStrategies(rSocketStrategies)
                .connectWebSocket(URI.create("ws://localhost:8080/rsocket"))
                .block();
    }

    @AfterAll
    public static void tearDown() {
        requester.rsocket().dispose();
    }

    @Test
    public void testOperation() throws Exception {
        Mono<String> user = requester.route("greeter").data("Jackie").retrieveMono(String.class);
        System.out.println(user.block());
    }
}
