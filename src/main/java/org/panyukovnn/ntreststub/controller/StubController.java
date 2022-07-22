package org.panyukovnn.ntreststub.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
public class StubController {

    @Value("${stub.delayMs:false}")
    private int delayMs;

    @PostMapping(value = "/**", consumes = APPLICATION_JSON_VALUE)
    public Mono<byte[]> post(@RequestBody byte[] body) {
        log.debug("Request received.");

        return Mono.just(body)
                .delaySubscription(Duration.ofMillis(delayMs));
    }
}
