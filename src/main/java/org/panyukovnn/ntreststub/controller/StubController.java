package org.panyukovnn.ntreststub.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.panyukovnn.ntreststub.property.StubProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StubController {

    private final byte[] defaultResponse;
    private final StubProperty stubProperty;

    /**
     * Общий эндпоинт для любого типа запросов, возвращающий заготовленный ответ с заданной задержкой.
     *
     * @return заготовленный ответ
     */
    @RequestMapping(value = "/mock")
    public Mono<byte[]> mock() {
        log.debug("Request received.");

        return Mono.just(defaultResponse)
                .delaySubscription(Duration.ofMillis(stubProperty.getDelayMs()));
    }
}
