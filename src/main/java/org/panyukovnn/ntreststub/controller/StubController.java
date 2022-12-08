package org.panyukovnn.ntreststub.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.panyukovnn.ntreststub.property.StubProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StubController {

    private final byte[] defaultResponse;
    private final StubProperty stubProperty;

    private final AtomicLong messagesCount = new AtomicLong();

    /**
     * Общий эндпоинт для любого типа запросов, возвращающий заготовленный ответ с заданной задержкой.
     *
     * @return заготовленный ответ
     */
    @RequestMapping(value = "/**")
    public Mono<byte[]> mock() {
        messagesCount.incrementAndGet();

        log.debug("Request received.");

        return Mono.just(defaultResponse)
                .delaySubscription(Duration.ofMillis(stubProperty.getDelayMs()));
    }

    @Scheduled(fixedDelay = 5000)
    public void scheduled() {
        if (messagesCount.get() == 0L) {
            return;
        }

        log.info("Messages per seconds: " + messagesCount.get() / 5d);

        messagesCount.set(0);
    }
}
